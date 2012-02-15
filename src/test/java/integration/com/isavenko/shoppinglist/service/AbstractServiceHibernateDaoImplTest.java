package integration.com.isavenko.shoppinglist.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.dialect.HSQLDialect;
import org.junit.After;
import org.junit.Before;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.isavenko.shoppinglist.dao.hibernate.ShoppingItemDaoHibernateImpl;
import com.isavenko.shoppinglist.dao.hibernate.ShoppingListDaoHibernateImpl;
import com.isavenko.shoppinglist.dao.hibernate.UserDaoHibernateImpl;
import com.isavenko.shoppinglist.entity.ShoppingItem;
import com.isavenko.shoppinglist.entity.ShoppingList;
import com.isavenko.shoppinglist.entity.User;

public abstract class AbstractServiceHibernateDaoImplTest {

    protected ShoppingItemDaoHibernateImpl shoppingItemDao;
    protected ShoppingListDaoHibernateImpl shoppingListDao;
    protected UserDaoHibernateImpl userDao;

    @Before
    public void setUpDaos() throws Exception {
	final Configuration configuration = new Configuration();
	configuration.setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver");
	configuration.setProperty(Environment.URL, "jdbc:hsqldb:mem:Test");
	configuration.setProperty(Environment.USER, "sa");
	configuration.setProperty(Environment.DIALECT, HSQLDialect.class.getName());
	configuration.setProperty(Environment.SHOW_SQL, "true");
	configuration.setProperty(Environment.CACHE_PROVIDER_CONFIG, "org.hibernate.cache.NoCacheProvider");

	configuration.setProperty(Environment.HBM2DDL_AUTO, "create");
	configuration.addAnnotatedClass(ShoppingItem.class);
	configuration.addAnnotatedClass(ShoppingList.class);
	configuration.addAnnotatedClass(User.class);

	SessionFactory sessionFactory = configuration.buildSessionFactory();

	HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);

	shoppingItemDao = new ShoppingItemDaoHibernateImpl();
	shoppingItemDao.setHibernateTemplate(hibernateTemplate);

	shoppingListDao = new ShoppingListDaoHibernateImpl();
	shoppingListDao.setHibernateTemplate(hibernateTemplate);

	userDao = new UserDaoHibernateImpl();
	userDao.setHibernateTemplate(hibernateTemplate);
    }

    @After
    public void tearDown() throws Exception {
    }

}
