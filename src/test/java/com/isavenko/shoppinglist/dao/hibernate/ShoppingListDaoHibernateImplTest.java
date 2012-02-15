package com.isavenko.shoppinglist.dao.hibernate;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.isavenko.shoppinglist.entity.ShoppingList;

public class ShoppingListDaoHibernateImplTest {

    private ShoppingListDaoHibernateImpl shoppingListDao;
    private HibernateTemplate hibernateTemplate;

    @Before
    public void setUp() throws Exception {
	hibernateTemplate = EasyMock.createStrictMock(HibernateTemplate.class);
	shoppingListDao = new ShoppingListDaoHibernateImpl();
	shoppingListDao.setHibernateTemplate(hibernateTemplate);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsert_nullObject() throws Exception {
	shoppingListDao.insert(null);
    }

    @Test
    public void testInsert() throws Exception {
	final ShoppingList entity = new ShoppingList();
	hibernateTemplate.saveOrUpdate(entity);
	EasyMock.expectLastCall();
	EasyMock.replay(hibernateTemplate);

	shoppingListDao.insert(entity);
	EasyMock.verify(hibernateTemplate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGet_nullKey() throws Exception {
	shoppingListDao.get(null);
    }

    @Test(expected = Exception.class)
    public void testGet_inexistentKey() throws Exception {
	shoppingListDao.get(1L);
    }

    @Test
    public void testGet() throws Exception {
	final ShoppingList expectedShoppingList = new ShoppingList();
	expectedShoppingList.setId(1L);

	EasyMock.expect(hibernateTemplate.get(ShoppingList.class, 1L)).andReturn(expectedShoppingList);
	EasyMock.replay(hibernateTemplate);

	final ShoppingList shoppingList = shoppingListDao.get(1L);

	Assert.assertEquals(expectedShoppingList, shoppingList);
	EasyMock.verify(hibernateTemplate);
    }

}
