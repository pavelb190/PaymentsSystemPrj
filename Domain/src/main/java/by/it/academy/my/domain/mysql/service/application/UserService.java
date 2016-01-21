package by.it.academy.my.domain.mysql.service.application;

import java.sql.Connection;
import java.sql.SQLException;

import by.it.academy.my.dal.db.manager.DBConnectionManager;
import by.it.academy.my.dal.db.manager.DatabaseManagerFactory;
import by.it.academy.my.dal.db.util.jolbox.DatabaseConnectionManager;
import by.it.academy.my.dal.exception.DalException;
import by.it.academy.my.dao.UserDao;
import by.it.academy.my.dao.application.db.mysql.UserDaoImpl;
import by.it.academy.my.dao.db.AbstractBaseDao;
import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.domain.service.exception.ServiceException;
import by.it.academy.my.model.entity.User;

public class UserService {
	
	private DBConnectionManager dbConnectionManager;
	
	public UserService() throws ServiceException {
		
		DatabaseManagerFactory dbManagerFactory = new DatabaseManagerFactory();
		
		try {
			
			this.dbConnectionManager = dbManagerFactory.getDatabaseConnectionManager(DatabaseConnectionManager.class);
			
		} catch (DalException e) {
			
			e.printStackTrace();
			
			throw new ServiceException(e.getMessage());
		}
	}
	
	public User getUserById(long id) throws ServiceException {
		
		User user = null;
		
		try {
			
			Connection conn = this.dbConnectionManager.getConnection();
			
			UserDao userDao = UserDaoImpl.getInstance().useConnection(conn);
			
			user = userDao.get(id);
			
		} catch (DalException | DaoException e) {
			
			e.printStackTrace();
			
			throw new ServiceException(e.getMessage());
		}
		
		return user;
	}
	
	public boolean checkUserPasswordById(final long id, final String password) throws ServiceException {
		
		User user = this.getUserById(id);
		
		return user != null && user.getPassword().equals(password);
	}
	
	public boolean checkUserPassword(User user, final String password) {
		
		// ...
		
		return user.getPassword().equals(password);
	}
}
