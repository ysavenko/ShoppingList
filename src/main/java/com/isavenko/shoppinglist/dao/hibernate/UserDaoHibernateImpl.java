package com.isavenko.shoppinglist.dao.hibernate;

import com.isavenko.shoppinglist.dao.UserDao;
import com.isavenko.shoppinglist.entity.User;

public class UserDaoHibernateImpl extends AbstractEntityDao<User, Long> implements UserDao {

    @Override
    protected Class<User> getEntityClass() {
	return User.class;
    }

}
