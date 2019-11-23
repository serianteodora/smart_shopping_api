package com.orangejuice.SmartShoppingAPI.shoppingList;

import com.orangejuice.SmartShoppingAPI.shoppingList.models.ShoppingItem;

import java.util.UUID;

public class VOToDomainMappers {

    public static ShoppingItem toShoppingItem(ShoppingItemVO shoppingItemVO) {
        return ShoppingItem.builder()
                .id(UUID.randomUUID())
                .name(shoppingItemVO.getName())
                .amount(shoppingItemVO.getAmount())
                .build();
    }
}
