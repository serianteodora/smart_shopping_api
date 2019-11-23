package com.orangejuice.SmartShoppingAPI.shoppingList;

import lombok.Builder;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Builder
@Getter
public class ShoppingItemVO {
    private String name;
    private int amount;
}

