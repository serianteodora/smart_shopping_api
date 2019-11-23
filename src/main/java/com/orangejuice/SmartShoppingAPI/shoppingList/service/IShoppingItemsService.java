package com.orangejuice.SmartShoppingAPI.shoppingList.service;

import com.orangejuice.SmartShoppingAPI.shoppingList.models.ShoppingItem;

import java.util.List;

public interface IShoppingItemsService {
    List<ShoppingItem> findAllShoppingItems();
}
