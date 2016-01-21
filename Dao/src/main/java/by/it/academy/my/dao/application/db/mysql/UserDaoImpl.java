package by.it.academy.my.dao.application.db.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.it.academy.my.dao.UserDao;
import by.it.academy.my.dao.UserRoleDao;
import by.it.academy.my.dao.db.AbstractBaseDao;
import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.model.entity.User;
import by.it.academy.my.model.entity.UserRole;

public class UserDaoImpl extends AbstractBaseDao<User, Long> implements UserDao {
	
	private static UserDaoImpl instance;
	
	private UserDaoImpl() {
		
		super();
		
		// ...
	}
	
	public static UserDaoImpl getInstance() {
		
		if (instance == null) {
			
			instance = new UserDaoImpl();
		}
		
		return instance;
	}
	
	@Override
	public UserDaoImpl useConnection(Connection connection) {
		
		return (UserDaoImpl) super.useConnection(connection);
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
					
					// Get UserRole for this User ...
					UserRole userRole =
							
							// Using UserRoleDao implement. ...
							UserRoleDaoImpl
								// (*for the same database-connection).
								.getInstance().useConnection(conn)
									// by his 'role_id'-field ...
									.get(rs.getLong("role_id"));
					
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

	@Override
	public User getByLogin() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
