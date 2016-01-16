package by.it.academy.my.dal.db.manager;

import java.sql.Connection;
import java.sql.SQLException;


public interface DBConnectionManager {
	
	public Connection getConnection() throws SQLException;
}
