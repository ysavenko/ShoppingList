package com.isavenko.shoppinglist.dao.hibernate;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.isavenko.shoppinglist.entity.User;

public class UserDaoHibernateImplTest {

    private UserDaoHibernateImpl userDao;
    private HibernateTemplate hibernateTemplate;

    @Before
    public void setUp() throws Exception {
	hibernateTemplate = EasyMock.createStrictMock(HibernateTemplate.class);
	userDao = new UserDaoHibernateImpl();
	userDao.setHibernateTemplate(hibernateTemplate);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsert_nullObject() throws Exception {
	userDao.insert(null);
    }

    @Test
    public void testInsert() throws Exception {
	final User entity = new User();
	hibernateTemplate.saveOrUpdate(entity);
	EasyMock.expectLastCall();
	EasyMock.replay(hibernateTemplate);

	userDao.insert(entity);
	EasyMock.verify(hibernateTemplate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGet_nullKey() throws Exception {
	userDao.get(null);
    }

    @Test(expected = Exception.class)
    public void testGet_inexistentKey() throws Exception {
	userDao.get(1L);
    }

    @Test
    public void testGet() throws Exception {
	final User expectedUser = new User();
	expectedUser.setId(1L);

	EasyMock.expect(hibernateTemplate.get(User.class, 1L)).andReturn(expectedUser);
	EasyMock.replay(hibernateTemplate);

	final User user = userDao.get(1L);

	Assert.assertEquals(expectedUser, user);
	EasyMock.verify(hibernateTemplate);
    }

}
