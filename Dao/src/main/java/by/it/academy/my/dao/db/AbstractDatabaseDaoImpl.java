package by.it.academy.my.dao.db;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import by.it.academy.my.dao.GenericDao;
import by.it.academy.my.model.entity.Entity;

public abstract class AbstractDatabaseDaoImpl<T extends Entity, PK extends Serializable> implements GenericDao<T, PK> {
	
	private Connection connection;
	
	public AbstractDatabaseDaoImpl(Connection connection) {
		
		this.connection = connection;
	}
	
	public Connection getConnection() {
		
		return this.connection;
	}
}
