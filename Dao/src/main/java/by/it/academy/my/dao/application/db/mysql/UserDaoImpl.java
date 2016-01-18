package by.it.academy.my.dao.application.db.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.it.academy.my.dao.application.UserDao;
import by.it.academy.my.dao.application.UserRoleDao;
import by.it.academy.my.dao.db.AbstractDatabaseDaoImpl;
import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.model.entity.application.User;
import by.it.academy.my.model.entity.application.UserRole;

public class UserDaoImpl extends AbstractDatabaseDaoImpl<User, Long> implements UserDao {
	
	private UserRoleDao userRoleDao;
	
	public UserDaoImpl(Connection connection) {
		
		super(connection);
		
		this.userRoleDao = new UserRoleDaoImpl(connection); 
	}
	
	public User get(Long id) throws DaoException {
		
		final String SQL_QUERY_STR = "SELECT * from Users WHERE id=?";
		
		Connection conn = this.getConnection();
		
		// ... Some SQL-code ...
		
		User user = null;
		
		if (conn != null) {
			
			try {
				
				PreparedStatement stmt = conn.prepareStatement(SQL_QUERY_STR);
				
				stmt.setLong(1, id);
				
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
					
					user = new User();
					
					user.setId(rs.getLong("id"));
					
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					
					user.setEmail(rs.getString("email"));
					
					UserRole userRole = this.userRoleDao.get(rs.getLong("role_id"));
					
					user.setUserRole(userRole);
					
					user.setPassword(rs.getString("password"));
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				
				throw new DaoException(e.getMessage());
				
			} finally {
				
				try {
					
					conn.close();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
					
					throw new DaoException(e.getMessage());
				}
			}
		}
		
		/*
		try {
			
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			throw new DaoException(e.getMessage());
		}
		*/
		
		return user;
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
