package com.orangejuice.SmartShoppingAPI.shoppingList.controller;

import com.orangejuice.SmartShoppingAPI.shoppingList.DomainToVOMappers;
import com.orangejuice.SmartShoppingAPI.shoppingList.ShoppingItemVO;
import com.orangejuice.SmartShoppingAPI.shoppingList.ShoppingListVO;
import com.orangejuice.SmartShoppingAPI.shoppingList.models.ShoppingItem;
import com.orangejuice.SmartShoppingAPI.shoppingList.service.IShoppingItemsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class ShoppingItemsResource {

    @Autowired
    private IShoppingItemsService shoppingItemsService;

    @GetMapping("/listShoppingItems")
    public ShoppingListVO findShoppingItems() {
        List<ShoppingItemVO> shoppingItemsList = shoppingItemsService.findAllShoppingItems()
                .stream()
                .map(shoppingItem -> DomainToVOMappers.toShoppingItemVO(shoppingItem))
                .collect(Collectors.toList());
        return ShoppingListVO.builder()
                .shoppingList(shoppingItemsList)
                .build();
    }

//    private List<ShoppingItem> shoppingList = new ArrayList<>();
//
//    @GetMapping("/shoppingList")
//    public ShoppingListVO getShoppingList() {
//        ShoppingListVO.ShoppingListVOBuilder builder = ShoppingListVO.builder();
//        shoppingList.stream().forEach(shoppingItem -> builder.shoppingItem(DomainToVOMappers.toShoppingItemVO(shoppingItem)));
//        return builder.build();
//    }
//
//    @PostMapping("/shoppingList")
//    public void addToShoppingList(@RequestBody ShoppingItemVO shoppingItemVO) {
//        shoppingList.add(VOToDomainMappers.toShoppingItem(shoppingItemVO));
//    }
//
//    @DeleteMapping("/shoppingList/{id}")
//    public void deleteFromShoppingList(@PathVariable UUID id) {
//        Optional<ShoppingItem> foundShoppingItem =
//                shoppingList.stream().filter(shoppingItem -> shoppingItem.getId().equals(id)).findFirst();
//        if (foundShoppingItem.isPresent()) {
//            shoppingList.remove(foundShoppingItem.get());
//        }
//    }
}
