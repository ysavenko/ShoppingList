package com.isavenko.shoppinglist.dao.hibernate;

import com.isavenko.shoppinglist.dao.ShoppingItemDao;
import com.isavenko.shoppinglist.entity.ShoppingItem;

public class ShoppingItemDaoHibernateImpl extends AbstractEntityDao<ShoppingItem, Long> implements ShoppingItemDao {

    @Override
    protected Class<ShoppingItem> getEntityClass() {
	return ShoppingItem.class;
    }

}
