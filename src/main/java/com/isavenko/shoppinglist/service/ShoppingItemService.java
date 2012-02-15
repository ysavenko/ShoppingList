package com.isavenko.shoppinglist.service;

import com.isavenko.shoppinglist.entity.ShoppingItem;

public interface ShoppingItemService {
    Long createShoppingItem(ShoppingItem shoppingItem) throws Exception;
}
