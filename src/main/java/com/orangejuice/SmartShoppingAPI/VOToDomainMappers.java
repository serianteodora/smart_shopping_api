package com.orangejuice.SmartShoppingAPI;

import java.util.UUID;

public class VOToDomainMappers {

    static ShoppingItem toShoppingItem(ShoppingItemVO shoppingItemVO) {
        return ShoppingItem.builder()
                .id(UUID.randomUUID())
                .name(shoppingItemVO.getName())
                .description(shoppingItemVO.getDescription())
                .build();
    }
}
