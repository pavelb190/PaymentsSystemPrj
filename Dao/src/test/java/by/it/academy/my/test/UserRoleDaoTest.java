package by.it.academy.my.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;

import by.it.academy.my.dal.db.manager.DBConnectionManager;
import by.it.academy.my.dal.db.manager.DatabaseManagerFactory;
import by.it.academy.my.dal.db.util.jolbox.DatabaseConnectionManager;
import by.it.academy.my.dal.exception.DalException;
import by.it.academy.my.dao.UserRoleDao;
import by.it.academy.my.dao.application.db.mysql.UserRoleDaoImpl;
import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.model.entity.UserRole;

public class UserRoleDaoTest {
	
	@Ignore
	@Test
	public void testGettingUserRoleById() throws DalException, DaoException {
		
		DatabaseManagerFactory dbManagerFactory = new DatabaseManagerFactory();
		
		DBConnectionManager dbConnMngr = dbManagerFactory.getDatabaseConnectionManager(DatabaseConnectionManager.class);
		
		UserRoleDao userRoleDao = UserRoleDaoImpl.getInstance().useConnection(dbConnMngr.getConnection());
		
		final long id = 1;
		
		UserRole userRole = userRoleDao.get(id);
		
		System.out.println("UserRole : " + userRole);
		
		assertNotNull( "UserRole with id '" + id + "' doesn't exist.", userRole );
	}
	
}
