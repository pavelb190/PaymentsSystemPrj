package by.it.academy.my.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import by.it.academy.my.dal.db.util.jndi.DatabaseConnectionManager;
import by.it.academy.my.dao.exception.DaoException;

public class DatabaseConnectionManagerTest {
	
	@Ignore
	@Test
	public void testInstantiatingOf() throws Exception {
			
		DatabaseConnectionManager dbConnMngr = DatabaseConnectionManager.getInstance();
		
		assertNotNull( "Couldn't instantiate a DatabaseConnectionManager.", dbConnMngr );
	}
	
	@Ignore
	@Test
	public void testGettingConnection() throws Exception {
		
		DatabaseConnectionManager dbConnMngr = DatabaseConnectionManager.getInstance();
		
		Connection connection = dbConnMngr.getConnection();
		
		assertNotNull( "Couldn't get a database connection from the DatabaseConnectionManager.", connection );
	}
	
}
