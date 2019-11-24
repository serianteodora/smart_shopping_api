package com.orangejuice.SmartShoppingAPI.shoppingList.controller;

import com.orangejuice.SmartShoppingAPI.shoppingList.DomainToVOMappers;
import com.orangejuice.SmartShoppingAPI.shoppingList.ShoppingItemVO;
import com.orangejuice.SmartShoppingAPI.shoppingList.ShoppingListVO;
import com.orangejuice.SmartShoppingAPI.shoppingList.VOToDomainMappers;
import com.orangejuice.SmartShoppingAPI.shoppingList.models.ShoppingItem;
import com.orangejuice.SmartShoppingAPI.shoppingList.service.IShoppingItemsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class ShoppingItemsResource {

    @Autowired
    private IShoppingItemsService shoppingItemsService;

    @RequestMapping(value="/listShoppingItems", method = RequestMethod.GET)
    public ShoppingListVO findShoppingItems() {
        List<ShoppingItemVO> shoppingItemsList = shoppingItemsService.findAllShoppingItems()
                .stream()
                .map(shoppingItem -> DomainToVOMappers.toShoppingItemVO(shoppingItem))
                .collect(Collectors.toList());
        shoppingItemsList.forEach(shoppingItemVO ->
                log.info("shopping item:", shoppingItemVO));
        return ShoppingListVO.builder()
                .shoppingList(shoppingItemsList)
                .build();
    }

    @RequestMapping(value="/shoppingItems", method = RequestMethod.POST)
    public ResponseEntity<?> addShoppingItems(@RequestBody ShoppingListVO shoppingList) {
        List<ShoppingItem> shoppingItemsList = shoppingList.getShoppingList().stream()
                .map(shoppingItem -> VOToDomainMappers.toShoppingItem(shoppingItem))
                .collect(Collectors.toList());
        shoppingItemsService.saveShoppingList(shoppingItemsList);
        return new ResponseEntity<>(shoppingItemsList, HttpStatus.CREATED);
    }

    @RequestMapping(value="/shoppingItem", method = RequestMethod.POST)
    public ResponseEntity<?> addShoppingItem(@RequestBody ShoppingItemVO shoppingItemVO) {
        ShoppingItem shoppingItem = shoppingItemsService.saveShoppingItem(VOToDomainMappers.toShoppingItem(shoppingItemVO));
        return new ResponseEntity<>(shoppingItem, HttpStatus.CREATED);
    }
}
