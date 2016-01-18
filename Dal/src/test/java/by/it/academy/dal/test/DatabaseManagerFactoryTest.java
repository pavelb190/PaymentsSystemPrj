package by.it.academy.dal.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import by.it.academy.my.dal.db.manager.DBConnectionManager;
import by.it.academy.my.dal.db.manager.DatabaseManagerFactory;
import by.it.academy.my.dal.db.util.jolbox.DatabaseConnectionManager;
import by.it.academy.my.dal.exception.DalException;

public class DatabaseManagerFactoryTest {
	
	@Test
	public void testGettingDBConnectionManagerJolbox() throws DalException {
		
		DatabaseManagerFactory dbManagerFactory = new DatabaseManagerFactory();
		
		DBConnectionManager dbConnMngr = dbManagerFactory.getDatabaseConnectionManager(DatabaseConnectionManager.class);
		
		assertNotNull( "Couldn't to get the DatabaseConnectionManager (jolbox).", dbConnMngr );
	}
}
