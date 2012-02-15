package integration.com.isavenko.shoppinglist.dao.hibernate;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.isavenko.shoppinglist.dao.hibernate.ShoppingListDaoHibernateImpl;
import com.isavenko.shoppinglist.entity.ShoppingList;
import com.isavenko.shoppinglist.entity.User;

public class ShoppingListDaoHibernateImplTest extends
        AbstractDaoHibernateImplTest<ShoppingListDaoHibernateImpl, ShoppingList, Long> {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    @Ignore
    public void testInsert() throws Exception {
	final ShoppingList entity = new ShoppingList();
	final User user = new User();
	entity.setUser(user);
	getEntityDao().insert(entity);
    }

    @Test(expected = Exception.class)
    public void testInsert_noUser() throws Exception {
	final ShoppingList entity = new ShoppingList();
	getEntityDao().insert(entity);
    }

    @Test(expected = Exception.class)
    public void testGet_inexistentObject() throws Exception {
	getEntityDao().get(11L);
    }

    @Test
    @Ignore
    public void testGet() throws Exception {
	final ShoppingList expectredEntity = new ShoppingList();
	final User expectedUser = new User();
	expectedUser.setName("user");
	expectredEntity.setUser(expectedUser);
	getEntityDao().insert(expectredEntity);

	final ShoppingList shoppingList = getEntityDao().get(expectredEntity.getId());
	Assert.assertEquals(expectedUser.getName(), shoppingList.getUser().getName());
    }

    @Override
    protected ShoppingListDaoHibernateImpl createDao() {
	return new ShoppingListDaoHibernateImpl();
    }

}
