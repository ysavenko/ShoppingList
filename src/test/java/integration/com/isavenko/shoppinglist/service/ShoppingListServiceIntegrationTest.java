package integration.com.isavenko.shoppinglist.service;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.orm.hibernate3.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.isavenko.shoppinglist.entity.ShoppingItem;
import com.isavenko.shoppinglist.entity.ShoppingList;
import com.isavenko.shoppinglist.entity.User;
import com.isavenko.shoppinglist.service.ShoppingListService;
import com.isavenko.shoppinglist.service.ShoppingListServiceImpl;

public class ShoppingListServiceIntegrationTest extends AbstractServiceHibernateDaoImplTest {

    private ShoppingListService shoppingListService;

    @Before
    public void setUpService() throws Exception {
	shoppingListService = new ShoppingListServiceImpl(shoppingListDao);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddListItems() throws Exception {

	Session session = SessionFactoryUtils.getSession(userDao.getHibernateTemplate().getSessionFactory(), true);
	TransactionSynchronizationManager.bindResource(userDao.getHibernateTemplate().getSessionFactory(),
	        new SessionHolder(session));
	Transaction transaction = session.beginTransaction();

	final User user = new User();
	user.setName("user");
	userDao.insert(user);

	final ShoppingItem shoppingItem1 = new ShoppingItem();
	shoppingItem1.setName("cheese");
	shoppingItemDao.insert(shoppingItem1);

	System.out.println(shoppingItemDao.select().size());

	final ShoppingItem shoppingItem = shoppingItemDao.get(shoppingItem1.getId());

	final ShoppingList shoppingList = new ShoppingList();
	shoppingList.setUser(user);
	shoppingList.setShoppingItems(Arrays.asList(shoppingItem));
	final Long shoppingListId = shoppingListService.createShoppingList(shoppingList);

	shoppingListService.addShoppingItems(shoppingListId, shoppingItem);

	transaction.commit();
	TransactionSynchronizationManager.unbindResource(userDao.getHibernateTemplate().getSessionFactory());
	SessionFactoryUtils.releaseSession(session, userDao.getHibernateTemplate().getSessionFactory());
    }

}
