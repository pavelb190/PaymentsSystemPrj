package by.it.academy.my.dao.application.db.mysql;

import java.sql.Connection;
import java.sql.SQLException;

import by.it.academy.my.dao.application.UserDao;
import by.it.academy.my.dao.db.AbstractDatabaseDaoImpl;
import by.it.academy.my.dao.exception.PersistenceException;
import by.it.academy.my.entity.application.User;

public class UserDaoImpl extends AbstractDatabaseDaoImpl<User, Long> implements UserDao {
	
	public UserDaoImpl(Connection connection) {
		
		super(connection);
	}
	
	public User get(Long id) throws PersistenceException {
		
		Connection conn = this.getConnection();
		
		// ... Some SQL-code ...
		
		try {
			
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			throw new PersistenceException(e.getMessage());
		}
		
		return null;
	}

	public void add(User entity) {
		// TODO Auto-generated method stub
		
	}

	public void update(User entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public User getByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
