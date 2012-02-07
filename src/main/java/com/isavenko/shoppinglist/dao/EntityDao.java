package com.isavenko.shoppinglist.dao;

import java.io.Serializable;

public interface EntityDao<T, K extends Serializable> {

	void insert(T entity) throws Exception;

	T get(K entityKey) throws Exception;
}
