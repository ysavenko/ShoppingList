package com.isavenko.shoppinglist.dao.hibernate;

import com.isavenko.shoppinglist.entity.ShoppingItem;

public class ShoppingItemDaoHibernateImpl extends
		AbstractEntityDao<ShoppingItem, Long> {

	@Override
	protected Class<ShoppingItem> getEntityClass() {
		return ShoppingItem.class;
	}

}
