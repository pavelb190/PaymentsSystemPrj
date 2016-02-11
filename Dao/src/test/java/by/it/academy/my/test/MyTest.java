package by.it.academy.my.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import by.it.academy.my.dal.db.manager.DBConnectionManager;
import by.it.academy.my.dal.db.util.jolbox.DatabaseConnectionManager;
import by.it.academy.my.dal.exception.DalException;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class MyTest {
	
	@Ignore
	@Test
	public void testBoneCPInstantiating() throws SQLException {
		
		BoneCP connectionPool = getConnectionPool();
		
		System.out.println("ConnectionPool : " + connectionPool);
		
		assertNotNull( "BoneCP object instantiated.", connectionPool );
	}
	
	public static BoneCP getConnectionPool() throws SQLException {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return null;
		}
		
		BoneCPConfig config = new BoneCPConfig();
		
		config.setJdbcUrl("jdbc:mysql://localhost:3306/DB_Payments");
		
		config.setUsername("root");
		config.setPassword("123");
		
		config.setMinConnectionsPerPartition(5);
		config.setMaxConnectionsPerPartition(10);
		
		config.setPartitionCount(1);
		
		return new BoneCP(config);
	}
	
	@Ignore
	@Test
	public void testBoneCPGettingDBConnection() throws SQLException {
		
		Connection connection = getConnectionPool().getConnection();
		
		System.out.println("DBConnection : " + connection);
		
		assertNotNull( "[BoneCP] : DB Connection obtained.", getConnectionPool().getConnection() );
	}
	
	@Ignore
	@Test
	public void testDBConnectionManagerInstantiating() throws DalException {
		
		DBConnectionManager dbConnMngr = DatabaseConnectionManager.getInstance();
		
		System.out.println("BoneCP-instance created successfully : " + dbConnMngr);
		
		assertNotNull( "BoneCP-instance created successfully.", dbConnMngr );
	}
	
}
