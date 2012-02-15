package com.isavenko.shoppinglist.dao.hibernate;

import com.isavenko.shoppinglist.dao.ShoppingListDao;
import com.isavenko.shoppinglist.entity.ShoppingList;

public class ShoppingListDaoHibernateImpl extends AbstractEntityDao<ShoppingList, Long> implements ShoppingListDao {

    @Override
    protected Class<ShoppingList> getEntityClass() {
	return ShoppingList.class;
    }

}
