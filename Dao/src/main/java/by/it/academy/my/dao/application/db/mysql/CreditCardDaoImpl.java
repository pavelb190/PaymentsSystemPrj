package by.it.academy.my.dao.application.db.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.it.academy.my.dao.CreditCardDao;
import by.it.academy.my.dao.db.AbstractBaseDao;
import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.model.entity.BankAccount;
import by.it.academy.my.model.entity.CreditCard;

public class CreditCardDaoImpl extends AbstractBaseDao<CreditCard, Long> implements CreditCardDao {

	private static CreditCardDaoImpl instance;
	
	private CreditCardDaoImpl() {
		
		super();
		
		// ...
	}
	
	public static CreditCardDaoImpl getInstance() {
		
		if (instance == null) {
			
			instance = new CreditCardDaoImpl();
		}
		
		return instance;
	}
	
	@Override
	public CreditCardDaoImpl useConnection(Connection connection) {
		
		return (CreditCardDaoImpl) super.useConnection(connection);
	}
	
	@Override
	public CreditCard get(Long id) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(CreditCard entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(CreditCard entity) throws DaoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<CreditCard> getCreditCardsByBankAccountId(long id) throws DaoException {

		final String SQL_QUERY_STR = "SELECT * FROM CreditCards WHERE account_id=?";
		
		Connection conn = this.getConnection();
		
		Set<CreditCard> accountCreditCards = null;
		
		if (conn != null) {
			
			try {
				
				PreparedStatement stmt = conn.prepareStatement(SQL_QUERY_STR);
				
				stmt.setLong(1, id);
				
				ResultSet rs = stmt.executeQuery();
				
				accountCreditCards = new HashSet<>();
				
				while (rs.next()) {
					
					CreditCard creditCard = new CreditCard();
					
					creditCard.setId(rs.getLong("id"));
					
					creditCard.setBankAccountId(rs.getLong("account_id"));
					
					accountCreditCards.add(creditCard);
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
		
		return accountCreditCards;
	}
	
}
