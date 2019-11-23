package com.orangejuice.SmartShoppingAPI;

public class DomainToVOMappers {

    static ShoppingItemVO toShoppingItemVO(ShoppingItem shoppingItem) {
        return ShoppingItemVO.builder()
                .id(shoppingItem.getId())
                .name(shoppingItem.getName())
                .description(shoppingItem.getDescription())
                .build();
    }
}
