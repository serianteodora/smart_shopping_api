package com.orangejuice.SmartShoppingAPI.shoppingList.repository;

import com.orangejuice.SmartShoppingAPI.shoppingList.models.ShoppingItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingItemRepository extends CrudRepository<ShoppingItem, Long> {
    List<ShoppingItem> findAll() ;
}
