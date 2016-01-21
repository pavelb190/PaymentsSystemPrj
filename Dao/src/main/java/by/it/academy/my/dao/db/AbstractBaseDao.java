package by.it.academy.my.dao.db;

import java.io.Serializable;
import java.sql.Connection;

import by.it.academy.my.dao.GenericDao;
import by.it.academy.my.model.entity.Entity;

public abstract class AbstractBaseDao<T extends Entity, PK extends Serializable> implements GenericDao<T, PK> {
	
	private ThreadLocal<Connection> connection = new ThreadLocal<>();
	
	public AbstractBaseDao() {
		
		// ...
	}
	
	@Deprecated
	public AbstractBaseDao(Connection connection) {
		
		this.setConnection(connection);
	}
	
	public AbstractBaseDao<T, PK> useConnection(Connection connection) {
		
		this.setConnection(connection);
		
		return this;
	}
	
	public Connection getConnection() {
		
		return this.connection.get();
	}
	
	public void setConnection(Connection connection) {
		
		this.connection.set(connection);
	}
}
