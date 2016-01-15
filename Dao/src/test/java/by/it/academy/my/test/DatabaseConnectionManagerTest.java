package by.it.academy.my.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Ignore;
import org.junit.Test;

import by.it.academy.my.dao.db.util.jndi.DatabaseConnectionManager;
import by.it.academy.my.dao.exception.PersistenceException;

public class DatabaseConnectionManagerTest {
	
	@Ignore
	@Test
	public void testInstantiatingOf() throws Exception {
		
		try {
			
			DatabaseConnectionManager dbConnMngr = DatabaseConnectionManager.getInstance();
			
			assertNotNull( "Couldn't instantiate a DatabaseConnectionManager.", dbConnMngr );
			
		} catch (PersistenceException e) {
			
			e.printStackTrace();
			
			throw new Exception(e.getMessage());
		}
	}
	
	@Ignore
	@Test
	public void testGettingConnection() throws Exception {
		
		try {
			
			DatabaseConnectionManager dbConnMngr = DatabaseConnectionManager.getInstance();
			
			Connection connection = dbConnMngr.getConnection();
			
			assertNotNull( "Couldn't get a database connection from the DatabaseConnectionManager.", connection );
			
		} catch (PersistenceException e) {
			
			e.printStackTrace();
			
			throw new Exception(e.getMessage());
		}
	}
}
