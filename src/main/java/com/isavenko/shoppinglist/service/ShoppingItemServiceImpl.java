package com.isavenko.shoppinglist.service;

import com.isavenko.shoppinglist.dao.ShoppingItemDao;
import com.isavenko.shoppinglist.entity.ShoppingItem;

public class ShoppingItemServiceImpl implements ShoppingItemService {

    private final ShoppingItemDao shoppingItemDao;

    public ShoppingItemServiceImpl(ShoppingItemDao shoppingItemDao) {
	this.shoppingItemDao = shoppingItemDao;
    }

    @Override
    public Long createShoppingItem(ShoppingItem shoppingItem) throws Exception {
	shoppingItemDao.insert(shoppingItem);
	return shoppingItem.getId();
    }

}
