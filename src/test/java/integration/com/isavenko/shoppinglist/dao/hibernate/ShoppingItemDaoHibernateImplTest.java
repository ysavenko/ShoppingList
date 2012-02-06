package integration.com.isavenko.shoppinglist.dao.hibernate;

import junit.framework.Assert;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.HSQLDialect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.isavenko.shoppinglist.dao.hibernate.ShoppingItemDaoHibernateImpl;
import com.isavenko.shoppinglist.entity.ShoppingItem;

public class ShoppingItemDaoHibernateImplTest {

	private ShoppingItemDaoHibernateImpl shoppingItemDao;

	@Before
	public void setUp() throws Exception {
		Configuration configuration = new Configuration();
		configuration.setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver");
		configuration.setProperty(Environment.URL, "jdbc:hsqldb:mem:Test");
		configuration.setProperty(Environment.USER, "sa");
		configuration.setProperty(Environment.DIALECT,
				HSQLDialect.class.getName());
		configuration.setProperty(Environment.SHOW_SQL, "true");
		configuration.setProperty(Environment.CACHE_PROVIDER_CONFIG,
				"org.hibernate.cache.NoCacheProvider");
		configuration.setProperty(Environment.HBM2DDL_AUTO, "create-drop");
		configuration.addAnnotatedClass(ShoppingItem.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		HibernateTemplate hibernateTemplate = new HibernateTemplate(
				sessionFactory);

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
		entity.setName("name");
		shoppingItemDao.insert(entity);
	}

	@Test
	public void testGet() throws Exception {
		final ShoppingItem entity = new ShoppingItem();
		entity.setName("name");
		shoppingItemDao.insert(entity);
		
		final ShoppingItem shoppingItem = shoppingItemDao.get(entity.getId());
		
		Assert.assertEquals(entity.getName(), shoppingItem.getName());
	}

}
