package com.isavenko.shoppinglist.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.isavenko.shoppinglist.dao.EntityDao;
import com.isavenko.shoppinglist.entity.ShoppingItem;

public class ShoppingItemDaoHibernateImpl extends HibernateDaoSupport implements
	EntityDao<ShoppingItem, Long> {

    @Override
    public void insert(ShoppingItem entity) throws Exception {
	// FIXME ysavenko: use apache validator
	if (entity == null) {
	    throw new IllegalArgumentException("Entity cannot be null");
	}

	getHibernateTemplate().saveOrUpdate(entity);
    }

    @Override
    public ShoppingItem get(Long entityKey) throws Exception {
	// FIXME ysavenko: use apache validator
	if (entityKey == null) {
	    throw new IllegalArgumentException("Entity key cannot be null");
	}
	final ShoppingItem shoppingItem = getHibernateTemplate().get(
		ShoppingItem.class, entityKey);
	if (shoppingItem != null) {
	    return shoppingItem;
	}
	throw new Exception();
    }

}
