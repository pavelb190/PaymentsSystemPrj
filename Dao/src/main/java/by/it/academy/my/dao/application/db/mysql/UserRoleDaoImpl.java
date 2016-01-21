package by.it.academy.my.dao.application.db.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import by.it.academy.my.dao.UserRoleDao;
import by.it.academy.my.dao.db.AbstractBaseDao;
import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.model.entity.UserRole;

public class UserRoleDaoImpl extends AbstractBaseDao<UserRole, Long> implements UserRoleDao {
	
	private static UserRoleDaoImpl instance;
	
	private UserRoleDaoImpl() {
		
		super();
		
		// ...
	}
	
	public static UserRoleDaoImpl getInstance() {
		
		if (instance == null) {
			
			instance = new UserRoleDaoImpl();
		}
		
		return instance;
	}
	
	@Override
	public UserRoleDaoImpl useConnection(Connection connection) {
		
		return (UserRoleDaoImpl) super.useConnection(connection);
	}
	
	@Override
	public UserRole get(Long id) throws DaoException {
		
		final String SQL_QUERY_STR = "SELECT * FROM User_roles WHERE id = ?";
		
		Connection conn = this.getConnection();
		
		UserRole userRole = null;
		
		if (conn != null) {
			
			try {
				
				PreparedStatement stmt = conn.prepareStatement(SQL_QUERY_STR);
				
				stmt.setLong(1, id);
				
				ResultSet rs = stmt.executeQuery();
				
				if (rs.next()) {
					
					userRole = new UserRole();
					
					userRole.setId(id);
					
					userRole.setRole(rs.getString("role"));
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
		
		return userRole;
	}

	@Override
	public void add(UserRole entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(UserRole entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UserRole> getRolesAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
