package com.isavenko.shoppinglist.service;

import com.isavenko.shoppinglist.entity.ShoppingItem;
import com.isavenko.shoppinglist.entity.ShoppingList;

public interface ShoppingListService {
    Long createShoppingList(ShoppingList shoppingList) throws Exception;

    void addShoppingItems(Long shoppingListId, ShoppingItem... shoppingItems) throws Exception;
}
