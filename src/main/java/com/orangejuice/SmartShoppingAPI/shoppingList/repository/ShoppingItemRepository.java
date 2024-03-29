package com.orangejuice.SmartShoppingAPI.shoppingList.repository;

import com.orangejuice.SmartShoppingAPI.shoppingList.models.ShoppingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShoppingItemRepository extends CrudRepository<ShoppingItem, Long> {
    List<ShoppingItem> findAll() ;
    ShoppingItem save(ShoppingItem shoppingItem);
}
