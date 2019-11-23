package com.orangejuice.SmartShoppingAPI.shoppingList.service;

import com.orangejuice.SmartShoppingAPI.shoppingList.models.ShoppingItem;
import org.springframework.beans.factory.annotation.Autowired;
import com.orangejuice.SmartShoppingAPI.shoppingList.repository.ShoppingItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingItemsServiceImpl implements IShoppingItemsService {
    @Autowired
    private ShoppingItemRepository repository;

    @Override
    public List<ShoppingItem> findAllShoppingItems() {

        List<ShoppingItem> shoppingItems = repository.findAll();

        return shoppingItems;
    }

    @Override
    public void saveShoppingList(List<ShoppingItem> shoppingItems) {
        shoppingItems.forEach(shoppingItem -> repository.save(shoppingItem));
    }

    @Override
    public ShoppingItem saveShoppingItem(ShoppingItem shoppingItem) {
        return repository.save(shoppingItem);
    }
}
