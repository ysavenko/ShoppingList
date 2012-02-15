package com.isavenko.shoppinglist.service;

import com.isavenko.shoppinglist.dao.UserDao;
import com.isavenko.shoppinglist.entity.User;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
	this.userDao = userDao;
    }

    @Override
    public Long createUser(User user) throws Exception {
	userDao.insert(user);
	return user.getId();
    }

}
