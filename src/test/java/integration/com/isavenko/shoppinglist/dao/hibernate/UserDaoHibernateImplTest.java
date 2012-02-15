package integration.com.isavenko.shoppinglist.dao.hibernate;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.isavenko.shoppinglist.dao.hibernate.UserDaoHibernateImpl;
import com.isavenko.shoppinglist.entity.User;

public class UserDaoHibernateImplTest extends AbstractDaoHibernateImplTest<UserDaoHibernateImpl, User, Long> {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testInsert() throws Exception {
	final User entity = new User();
	entity.setName("name");
	getEntityDao().insert(entity);
    }

    @Test(expected = Exception.class)
    public void testGet_inexistentObject() throws Exception {
	getEntityDao().get(11L);
    }

    @Test
    public void testGet() throws Exception {
	final User entity = new User();
	entity.setName("name");
	getEntityDao().insert(entity);

	final User User = getEntityDao().get(entity.getId());

	Assert.assertEquals(entity.getName(), User.getName());
    }

    @Override
    protected UserDaoHibernateImpl createDao() {
	return new UserDaoHibernateImpl();
    }

}
