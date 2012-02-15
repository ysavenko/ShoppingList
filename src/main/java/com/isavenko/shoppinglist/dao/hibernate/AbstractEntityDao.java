package com.isavenko.shoppinglist.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.isavenko.shoppinglist.dao.EntityDao;

public abstract class AbstractEntityDao<T, K extends Serializable> extends HibernateDaoSupport implements
        EntityDao<T, K> {

    protected abstract Class<T> getEntityClass();

    @Override
    public void insert(T entity) throws Exception {
	// FIXME ysavenko: use apache validator
	if (entity == null) {
	    throw new IllegalArgumentException("Entity cannot be null");
	}

	getHibernateTemplate().saveOrUpdate(entity);
    }

    @Override
    public T get(K entityKey) throws Exception {
	// FIXME ysavenko: use apache validator
	if (entityKey == null) {
	    throw new IllegalArgumentException("Entity key cannot be null");
	}
	final T shoppingItem = getHibernateTemplate().get(getEntityClass(), entityKey);
	if (shoppingItem != null) {
	    return shoppingItem;
	}
	throw new Exception("Could not find entity by key: " + entityKey);
    }

    @Override
    public void remove(K entityKey) throws Exception {
	// FIXME ysavenko: use apache validator
	if (entityKey == null) {
	    throw new IllegalArgumentException("Entity key cannot be null");
	}
	final T entity = get(entityKey);
	getHibernateTemplate().delete(entity);
    }

    @Override
    public List<T> select() throws Exception {
	return getHibernateTemplate().loadAll(getEntityClass());
    }

    @Override
    public void update(T entity) throws Exception {
	// FIXME ysavenko: use apache validator
	if (entity == null) {
	    throw new IllegalArgumentException("Entity cannot be null");
	}
	getHibernateTemplate().saveOrUpdate(entity);
    };

}
