package by.it.academy.my.dal.db.util.jndi;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import by.it.academy.my.dal.db.manager.DBConnectionManager;
import by.it.academy.my.dal.exception.DalException;


public final class DatabaseConnectionManager implements DBConnectionManager {
	
	private static DatabaseConnectionManager dbConnectionManager = null;
	
	private DataSource dataSource;
	
	private DatabaseConnectionManager(final String dbName) throws DalException {
		
		this.dataSource = buildDataSource(dbName);
	}
	
	public static DatabaseConnectionManager getInstance() throws DalException {
		
		if (dbConnectionManager == null) {
			
			//synchronized (dbConnectionManager) {
				
				dbConnectionManager = new DatabaseConnectionManager("DB_Payments");
			//}
		}
		
		return dbConnectionManager;
	}
	
	public Connection getConnection() throws DalException {
		
		Connection connection = null;
		
		try {
			
			connection = this.dataSource.getConnection();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			throw new DalException("Couldn't get the connection from DataSource!");
		}
		
		return connection;
	}
	
	private static final DataSource buildDataSource(final String dbName) throws DalException {
		
		DataSource dataSource = null;
		
		try {
			
			Context initCtxt = new InitialContext();
			
			dataSource = (DataSource) initCtxt.lookup("java:/comp/env/jdbc/" + dbName);
			
		} catch (NamingException e) {
			
			e.printStackTrace();
			
			throw new DalException(e.getMessage());
		}
		
		return dataSource;
	}
}
