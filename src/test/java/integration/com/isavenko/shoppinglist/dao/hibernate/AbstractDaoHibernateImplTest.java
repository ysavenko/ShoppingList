package integration.com.isavenko.shoppinglist.dao.hibernate;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.HSQLDialect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.isavenko.shoppinglist.dao.hibernate.AbstractEntityDao;
import com.isavenko.shoppinglist.entity.ShoppingItem;

public abstract class AbstractDaoHibernateImplTest<D extends AbstractEntityDao<T, K>, T, K extends Serializable> {

	private D entityDao;

	protected abstract D createDao();

	@Before
	public void setUpDao() throws Exception {
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

		entityDao = createDao();
		getEntityDao().setHibernateTemplate(hibernateTemplate);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInsert_nullObject() throws Exception {
		entityDao.insert(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGet_nullObject() throws Exception {
		entityDao.get(null);
	}

	public D getEntityDao() {
		return entityDao;
	}

}
