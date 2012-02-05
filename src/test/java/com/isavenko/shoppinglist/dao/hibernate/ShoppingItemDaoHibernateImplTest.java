package com.isavenko.shoppinglist.dao.hibernate;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.isavenko.shoppinglist.entity.ShoppingItem;

public class ShoppingItemDaoHibernateImplTest {

    private ShoppingItemDaoHibernateImpl shoppingItemDao;
    private HibernateTemplate hibernateTemplate;

    @Before
    public void setUp() throws Exception {
	hibernateTemplate = EasyMock.createStrictMock(HibernateTemplate.class);
	shoppingItemDao = new ShoppingItemDaoHibernateImpl();
	shoppingItemDao.setHibernateTemplate(hibernateTemplate);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInsert_nullObject() throws Exception {
	shoppingItemDao.insert(null);
    }

    @Test
    public void testInsert() throws Exception {
	final ShoppingItem entity = new ShoppingItem();
	hibernateTemplate.saveOrUpdate(entity);
	EasyMock.expectLastCall();
	EasyMock.replay(hibernateTemplate);

	shoppingItemDao.insert(entity);
	EasyMock.verify(hibernateTemplate);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGet_nullKey() throws Exception {
	shoppingItemDao.get(null);
    }

    @Test(expected = Exception.class)
    public void testGet_inexistentKey() throws Exception {
	shoppingItemDao.get(1L);
    }

    @Test
    public void testGet() throws Exception {
	final ShoppingItem expectedShoppingItem = new ShoppingItem();
	expectedShoppingItem.setId(1L);

	EasyMock.expect(hibernateTemplate.get(ShoppingItem.class, 1L))
		.andReturn(expectedShoppingItem);
	EasyMock.replay(hibernateTemplate);

	final ShoppingItem shoppingItem = shoppingItemDao.get(1L);

	Assert.assertEquals(expectedShoppingItem, shoppingItem);
	EasyMock.verify(hibernateTemplate);
    }

}
