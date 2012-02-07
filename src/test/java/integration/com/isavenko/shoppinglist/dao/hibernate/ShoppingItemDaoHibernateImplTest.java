package integration.com.isavenko.shoppinglist.dao.hibernate;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.isavenko.shoppinglist.dao.hibernate.ShoppingItemDaoHibernateImpl;
import com.isavenko.shoppinglist.entity.ShoppingItem;

public class ShoppingItemDaoHibernateImplTest
		extends
		AbstractDaoHibernateImplTest<ShoppingItemDaoHibernateImpl, ShoppingItem, Long> {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsert() throws Exception {
		final ShoppingItem entity = new ShoppingItem();
		entity.setName("name");
		getEntityDao().insert(entity);
	}

	@Test(expected = Exception.class)
	public void testGet_inexistentObject() throws Exception {
		getEntityDao().get(11L);
	}

	@Test
	public void testGet() throws Exception {
		final ShoppingItem entity = new ShoppingItem();
		entity.setName("name");
		getEntityDao().insert(entity);

		final ShoppingItem shoppingItem = getEntityDao().get(entity.getId());

		Assert.assertEquals(entity.getName(), shoppingItem.getName());
	}

	@Override
	protected ShoppingItemDaoHibernateImpl createDao() {
		return new ShoppingItemDaoHibernateImpl();
	}

}
