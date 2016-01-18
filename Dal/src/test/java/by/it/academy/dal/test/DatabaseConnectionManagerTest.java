package by.it.academy.dal.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import by.it.academy.my.dal.db.manager.DBConnectionManager;
import by.it.academy.my.dal.db.manager.DatabaseManagerFactory;
import by.it.academy.my.dal.db.util.jolbox.DatabaseConnectionManager;
import by.it.academy.my.dal.exception.DalException;

public class DatabaseConnectionManagerTest {
	
	@Test
	public void testGettingDatabaseConnection() throws DalException, SQLException {
		
		DatabaseManagerFactory dbManagerFactory = new DatabaseManagerFactory();
		
		DBConnectionManager dbConnMngr = dbManagerFactory.getDatabaseConnectionManager(DatabaseConnectionManager.class);
		
		Connection conn = dbConnMngr.getConnection();
		
		assertNotNull( "Couldn't to get a connection from DBConnectionManager.", conn );
	}
}
