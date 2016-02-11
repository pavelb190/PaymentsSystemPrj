package by.it.academy.my.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import by.it.academy.my.dal.db.manager.DBConnectionManager;
import by.it.academy.my.dal.db.manager.DatabaseManagerFactory;
import by.it.academy.my.dal.db.util.jolbox.DatabaseConnectionManager;
import by.it.academy.my.dal.exception.DalException;
import by.it.academy.my.dao.BankAccountDao;
import by.it.academy.my.dao.UserRoleDao;
import by.it.academy.my.dao.application.db.mysql.BankAccountDaoImpl;
import by.it.academy.my.dao.application.db.mysql.UserRoleDaoImpl;
import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.model.entity.BankAccount;
import by.it.academy.my.model.entity.User;
import by.it.academy.my.model.entity.UserRole;

public class BankAccountDaoTest {
	
	@Ignore
	@Test
	public void testGettingBankAccountsForUser() throws DalException, DaoException {
		
		DatabaseManagerFactory dbManagerFactory = new DatabaseManagerFactory();
		
		DBConnectionManager dbConnMngr = dbManagerFactory.getDatabaseConnectionManager(DatabaseConnectionManager.class);
		
		BankAccountDao bankAccountDao = BankAccountDaoImpl.getInstance().useConnection(dbConnMngr.getConnection());
		
		User user = new User();
		
		final long id = 123;
		
		user.setId(id);
		
		// ...
		
		List<BankAccount> userBankAccounts = bankAccountDao.getForUser(user);
		
		System.out.println("User's bank accounts: " + userBankAccounts + " (" + userBankAccounts.size() + ").");
		
		assertTrue( "User with id '" + id + "' has no bank accounts.", userBankAccounts.size() > 0 );
	}
	
}
