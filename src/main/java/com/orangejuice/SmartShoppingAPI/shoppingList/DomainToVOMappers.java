package com.orangejuice.SmartShoppingAPI.shoppingList;

import com.orangejuice.SmartShoppingAPI.shoppingList.models.ShoppingItem;

public class DomainToVOMappers {

    public static ShoppingItemVO toShoppingItemVO(ShoppingItem shoppingItem) {
        return ShoppingItemVO.builder()
                .name(shoppingItem.getName())
                .amount(shoppingItem.getAmount())
                .build();
    }
}
