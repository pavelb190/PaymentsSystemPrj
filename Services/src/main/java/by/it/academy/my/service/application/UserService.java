package by.it.academy.my.service.application;

import java.sql.Connection;

import by.it.academy.my.dao.application.UserDao;
import by.it.academy.my.dao.application.db.mysql.UserDaoImpl;
import by.it.academy.my.dao.db.util.jndi.DatabaseConnectionManager;
import by.it.academy.my.dao.exception.PersistenceException;
import by.it.academy.my.entity.application.User;
import by.it.academy.my.service.exception.ServiceException;

public class UserService {
	
	private DatabaseConnectionManager dbConnectionManager;
	
	public UserService() throws ServiceException {
		
		try {
			
			this.dbConnectionManager = DatabaseConnectionManager.getInstance();
			
		} catch (PersistenceException e) {
			
			e.printStackTrace();
			
			throw new ServiceException(e.getMessage());
		}
	}
	
	public User getUserById(long id) throws ServiceException {
		
		User user = null;
		
		try {
			
			Connection connection = this.dbConnectionManager.getConnection();
			
			UserDao userDao = new UserDaoImpl(connection);
			
			user = userDao.get(id);
			
		} catch (PersistenceException e) {
			
			e.printStackTrace();
			
			throw new ServiceException(e.getMessage());
		}
		
		return user;
	}
}
