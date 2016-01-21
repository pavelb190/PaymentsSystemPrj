package by.it.academy.my.dao.application.db.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.it.academy.my.dao.BankAccountDao;
import by.it.academy.my.dao.db.AbstractBaseDao;
import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.model.entity.BankAccount;
import by.it.academy.my.model.entity.User;
import by.it.academy.my.model.entity.UserRole;

public class BankAccountDaoImpl extends AbstractBaseDao<BankAccount, Long> implements BankAccountDao {

	private static BankAccountDaoImpl instance;
	
	private BankAccountDaoImpl() {
		
		super();
		
		// ...
	}
	
	public static BankAccountDaoImpl getInstance() {
		
		if (instance == null) {
			
			instance = new BankAccountDaoImpl();
		}
		
		return instance;
	}
	
	@Override
	public BankAccountDaoImpl useConnection(Connection connection) {
		
		return (BankAccountDaoImpl) super.useConnection(connection);
	}
	
	@Override
	public BankAccount get(Long id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(BankAccount entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(BankAccount entity) throws DaoException {
		
		final String SQL_QUERY_STR = "UPDATE BankAccounts " +
				"SET id=?, user_id=?, balance=?, is_available=? " +
					"WHERE id=?";

		Connection conn = this.getConnection();
		
		if (conn != null) {
			
			try {
				
				PreparedStatement stmt = conn.prepareStatement(SQL_QUERY_STR);
				
				stmt.setLong(1, entity.getId());
				
				stmt.setLong(2, entity.getUser().getId());
				
				stmt.setDouble(3, entity.getBalance());
				
				stmt.setBoolean(4, entity.isAvailable());
				
				stmt.setLong(5, entity.getId());
				
				stmt.executeUpdate();
				
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
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BankAccount> getForUser(User user) throws DaoException {

		final String SQL_QUERY_STR = "SELECT * FROM BankAccounts WHERE user_id=?";
		
		Connection conn = this.getConnection();
		
		List<BankAccount> userBankAccounts = null;
		
		if (conn != null) {
			
			try {
				
				PreparedStatement stmt = conn.prepareStatement(SQL_QUERY_STR);
				
				stmt.setLong(1, user.getId());
				
				ResultSet rs = stmt.executeQuery();
				
				userBankAccounts = new ArrayList<>();
				
				while (rs.next()) {
					
					BankAccount bankAccount = new BankAccount();
					
					final long accountId = rs.getLong("id"); 
					
					bankAccount.setId(accountId);
					
					bankAccount.setUser(user);
					
					bankAccount.setBalance(rs.getDouble("balance"));
					
					bankAccount.setAvailable(rs.getBoolean("is_available"));
					
					bankAccount.setCreditCards(
							
							CreditCardDaoImpl
								.getInstance().useConnection(conn)
									.getCreditCardsByBankAccountId(accountId)
							
							);
					
					userBankAccounts.add(bankAccount);
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
		
		return userBankAccounts;
	}

}
