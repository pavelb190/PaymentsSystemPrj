package by.it.academy.my.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import by.it.academy.my.dal.db.manager.DBConnectionManager;
import by.it.academy.my.dal.db.manager.DatabaseManagerFactory;
import by.it.academy.my.dal.db.util.jolbox.DatabaseConnectionManager;
import by.it.academy.my.dal.exception.DalException;
import by.it.academy.my.dao.UserDao;
import by.it.academy.my.dao.application.db.mysql.UserDaoImpl;
import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.model.entity.User;

public class UserDaoTest {
	
	@Test
	public void testGettingUserById() throws DalException, DaoException {
		
		DatabaseManagerFactory dbManagerFactory = new DatabaseManagerFactory();
		
		DBConnectionManager dbConnMngr = dbManagerFactory.getDatabaseConnectionManager(DatabaseConnectionManager.class);
		
		UserDao userDao = UserDaoImpl.getInstance().useConnection(dbConnMngr.getConnection());
		
		final long id = 1;
		
		User user = userDao.get(id);
		
		System.out.println("User : " + user);
		
		assertNotNull( "User with id '" + id + "' doesn't exist.", user );
	}
}
