package com.isavenko.shoppinglist.dao;

public interface EntityDao<T, K> {

    void insert(T entity) throws Exception;

    T get(K entityKey) throws Exception;
}
