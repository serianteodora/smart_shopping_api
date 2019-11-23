package com.orangejuice.SmartShoppingAPI;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class ShoppingController {

    private List<ShoppingItem> shoppingList = new ArrayList<>();

    @GetMapping("/shoppingList")
    public ShoppingListVO getShoppingList() {
        ShoppingListVO.ShoppingListVOBuilder builder = ShoppingListVO.builder();
        shoppingList.stream().forEach(shoppingItem -> builder.shoppingItem(DomainToVOMappers.toShoppingItemVO(shoppingItem)));
        return builder.build();
    }

    @PostMapping("/shoppingList")
    public void addToShoppingList(@RequestBody ShoppingItemVO shoppingItemVO) {
        shoppingList.add(VOToDomainMappers.toShoppingItem(shoppingItemVO));
    }

    @DeleteMapping("/shoppingList/{id}")
    public void deleteFromShoppingList(@PathVariable UUID id) {
        Optional<ShoppingItem> foundShoppingItem =
                shoppingList.stream().filter(shoppingItem -> shoppingItem.getId().equals(id)).findFirst();
        if (foundShoppingItem.isPresent()) {
            shoppingList.remove(foundShoppingItem.get());
        }
    }
}
