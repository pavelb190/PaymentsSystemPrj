package by.it.academy.my.dal.db.manager;

import java.sql.Connection;
import java.sql.SQLException;

import by.it.academy.my.dal.exception.DalException;


public interface DBConnectionManager {
	
	public Connection getConnection() throws DalException;
}
