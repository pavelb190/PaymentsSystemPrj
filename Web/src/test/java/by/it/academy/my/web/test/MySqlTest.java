package by.it.academy.my.web.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import by.it.academy.my.dal.db.manager.DBConnectionManager;
import by.it.academy.my.dal.db.manager.DatabaseManagerFactory;
import by.it.academy.my.dal.db.util.jolbox.DatabaseConnectionManager;
import by.it.academy.my.dal.exception.DalException;

public class MySqlTest {
	
	@Ignore
	@Test
	public void testGettingMySqlConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_payments", "root", "123");
		
		System.out.println("Connection : " + conn);
		
		assertNotNull( "Couldn't to create a MySQL's database connection.", conn );
		
		if (conn != null) {
			
			conn.close();
		}
	}
	
	@Test
	public void testSmthng() throws DalException {
		
		DatabaseManagerFactory dbManagerFactory = new DatabaseManagerFactory();
		
		DBConnectionManager dbConnMngr = dbManagerFactory.getDatabaseConnectionManager(DatabaseConnectionManager.class);
		
		Connection conn = dbConnMngr.getConnection();
		
		System.out.println("Connection : " + conn);
		
		assertNotNull( "Connection not established.", conn );
	}
}
