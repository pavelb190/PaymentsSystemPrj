package by.it.academy.my.dal.db.util.jolbox;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;
import com.jolbox.bonecp.BoneCPDataSource;

import by.it.academy.my.dal.db.manager.DBConnectionManager;
import by.it.academy.my.dal.exception.DalException;

public class DatabaseConnectionManager implements DBConnectionManager {
	
	private static final String CONFIG_FILENAME = "bonecp-config";
	
	private static DatabaseConnectionManager dbConnectionManager = null;
	
	private BoneCPDataSource dataSource;
	
	private Properties properties;
	
	private DatabaseConnectionManager() throws DalException {
		
		this.properties = getPropertiesFromClassPath();
		
		try {
			
			Class.forName(this.properties.getProperty("driverClass"));
			
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
			
			throw new DalException("Couldn't to load DriverClass '" + this.properties.getProperty("driverClass") + "'!");
		}
		
		this.dataSource = new BoneCPDataSource();
		
		try {
			
			this.dataSource.setProperties(this.properties);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			throw new DalException(e.getMessage());
		}
	}
	
	private static Properties getPropertiesFromClassPath() throws DalException {
		
		InputStream is = DatabaseConnectionManager.class.getClassLoader().getResourceAsStream(CONFIG_FILENAME + ".properties");
		
		Properties props = new Properties();
		
		try {
			
			props.load(is);
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
			throw new DalException(e.getMessage());
		}
		
		return props;
	}
	
	public static DBConnectionManager getInstance() throws DalException {
		
		if (dbConnectionManager == null) {
			
			try {
				
				dbConnectionManager = new DatabaseConnectionManager();
				
			} catch (DalException e) {
				
				e.printStackTrace();
				
				throw new DalException("Couldn't to create a BoneCP-instance!..");
			}
		}
		
		return dbConnectionManager;
	}
	
	public Connection getConnection() throws DalException {
		
		Connection conn = null;
		
		try {
			
			conn = this.dataSource.getConnection();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			throw new DalException(e.getMessage());
		}
		
		return conn;
	}

}
