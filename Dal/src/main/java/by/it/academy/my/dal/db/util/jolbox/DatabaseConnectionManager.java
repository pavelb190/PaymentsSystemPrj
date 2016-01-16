package by.it.academy.my.dal.db.util.jolbox;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

import by.it.academy.my.dal.db.manager.DBConnectionManager;

public class DatabaseConnectionManager implements DBConnectionManager {
	
	private static DatabaseConnectionManager dbConnectionManager = null;
	
	private BoneCP connectionPool;
	
	private DatabaseConnectionManager() throws SQLException {
		
		BoneCPConfig config = new BoneCPConfig();
			
		this.connectionPool = new BoneCP(config);
	}
	
	public static DBConnectionManager getInstance() throws SQLException {
		
		if (dbConnectionManager == null) {
			
			try {
				
				dbConnectionManager = new DatabaseConnectionManager();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
				throw new SQLException("Couldn't to create a BoneCP-instance!..");
			}
		}
		
		return dbConnectionManager;
	}
	
	public Connection getConnection() throws SQLException {
		
		return this.connectionPool.getConnection();
	}

}
