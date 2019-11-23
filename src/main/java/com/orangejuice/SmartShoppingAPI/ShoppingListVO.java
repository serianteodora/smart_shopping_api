package com.orangejuice.SmartShoppingAPI;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Getter
@Builder
public class ShoppingListVO {
    @Singular
    private List<ShoppingItemVO> shoppingItems;
}
