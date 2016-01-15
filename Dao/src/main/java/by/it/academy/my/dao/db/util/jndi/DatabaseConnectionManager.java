package by.it.academy.my.dao.db.util.jndi;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import by.it.academy.my.dao.exception.PersistenceException;

public final class DatabaseConnectionManager {
	
	private static DatabaseConnectionManager dbConnectionManager = null;
	
	private DataSource dataSource;
	
	private DatabaseConnectionManager(final String dbName) throws PersistenceException {
		
		this.dataSource = buildDataSource(dbName);
	}
	
	public static DatabaseConnectionManager getInstance() throws PersistenceException {
		
		if (dbConnectionManager == null) {
			
			//synchronized (dbConnectionManager) {
				
				dbConnectionManager = new DatabaseConnectionManager("DB_Payments");
			//}
		}
		
		return dbConnectionManager;
	}
	
	public Connection getConnection() throws PersistenceException {
		
		Connection connection = null;
		
		try {
			
			connection = this.dataSource.getConnection();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			throw new PersistenceException("Couldn't get the connection from DataSource!");
		}
		
		return connection;
	}
	
	private static final DataSource buildDataSource(final String dbName) throws PersistenceException {
		
		DataSource dataSource = null;
		
		try {
			
			Context initCtxt = new InitialContext();
			
			dataSource = (DataSource) initCtxt.lookup("java:/comp/env/jdbc/" + dbName);
			
		} catch (NamingException e) {
			
			e.printStackTrace();
			
			throw new PersistenceException(e.getMessage());
		}
		
		return dataSource;
	}
}
