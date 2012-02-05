package integration.com.isavenko.shoppinglist.dao.hibernate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.isavenko.shoppinglist.dao.hibernate.ShoppingItemDaoHibernateImpl;
import com.isavenko.shoppinglist.entity.ShoppingItem;

public class ShoppingItemDaoHibernateImplTest {

	private ShoppingItemDaoHibernateImpl shoppingItemDao;

	@Before
	public void setUp() throws Exception {

		shoppingItemDao = new ShoppingItemDaoHibernateImpl();
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
		shoppingItemDao.insert(entity);
	}

	@Test
	public void testGet() throws Exception {
		final ShoppingItem shoppingItem = shoppingItemDao.get(1L);
	}

}
