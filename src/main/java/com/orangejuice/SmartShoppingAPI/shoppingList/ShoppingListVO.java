package com.orangejuice.SmartShoppingAPI.shoppingList;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ShoppingListVO {
    List<ShoppingItemVO> shoppingList;
}
