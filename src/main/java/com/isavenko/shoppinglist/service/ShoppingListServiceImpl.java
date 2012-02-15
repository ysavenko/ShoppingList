package com.isavenko.shoppinglist.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.isavenko.shoppinglist.dao.ShoppingListDao;
import com.isavenko.shoppinglist.entity.ShoppingItem;
import com.isavenko.shoppinglist.entity.ShoppingList;

public class ShoppingListServiceImpl implements ShoppingListService {

    private final ShoppingListDao shoppingListDao;

    public ShoppingListServiceImpl(ShoppingListDao shoppingListDao) {
	this.shoppingListDao = shoppingListDao;
    }

    @Override
    public Long createShoppingList(ShoppingList shoppingList) throws Exception {
	shoppingListDao.insert(shoppingList);
	return shoppingList.getId();
    }

    @Override
    public void addShoppingItems(Long shoppingListId, ShoppingItem... shoppingItems) throws Exception {
	final ShoppingList shoppingList = shoppingListDao.get(shoppingListId);
	final List<ShoppingItem> newShoppingItems = new ArrayList<ShoppingItem>(shoppingList.getShoppingItems());

	newShoppingItems.addAll(Arrays.asList(shoppingItems));
	shoppingList.setShoppingItems(newShoppingItems);

	shoppingListDao.update(shoppingList);
    }

}
