package com.isavenko.shoppinglist.dao;

import java.io.Serializable;
import java.util.List;

public interface EntityDao<T, K extends Serializable> {

    void insert(T entity) throws Exception;

    void update(T entity) throws Exception;

    T get(K entityKey) throws Exception;

    void remove(K entityKey) throws Exception;

    List<T> select() throws Exception;

}
