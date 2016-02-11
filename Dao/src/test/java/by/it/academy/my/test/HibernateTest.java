package by.it.academy.my.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import by.it.academy.my.dal.db.hibernate.HibernateUtil;
import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.dao.hibernate.ClientDao;
import by.it.academy.my.dao.hibernate.ClientDaoImpl;
import by.it.academy.my.dao.hibernate.CreditCardDao;
import by.it.academy.my.dao.hibernate.CreditCardDaoImpl;
import by.it.academy.my.model.entity.hib.Admin;
import by.it.academy.my.model.entity.hib.BankAccount;
import by.it.academy.my.model.entity.hib.Client;
import by.it.academy.my.model.entity.hib.CreditCard;
import by.it.academy.my.model.entity.hib.User;

public class HibernateTest {

	@Ignore
	@Test
	public void testHibernateInit() {
		
		System.out.println("Session is opened: " + HibernateUtil.getSession());
	}
	
	@Ignore
	@Test
	public void testUser_findMethod() {
		
		final long id = 1;
		
		User user = (User) HibernateUtil.getSession().get(User.class, id);
		
		System.out.println("User is : " + user);
	}
	
	@Ignore
	@Test
	public void testClient_findMethod() {
		
		final long id = 123;
		
		Client client = (Client) HibernateUtil.getSession().get(Client.class, id);
		
		System.out.println("Client is : " + client);
	}
	
	@Ignore
	@Test
	public void testAdmin_findMethod() {
		
		final long id = 1L;
		
		Admin admin = (Admin) HibernateUtil.getSession().get(Admin.class, id);
		
		System.out.println("Admin is : " + admin);
	}
	
	@Ignore
	@Test
	public void testBankAccount_findMethod() {
		
		final long id = 123000001;
		
		BankAccount bankAccount = (BankAccount) HibernateUtil.getSession().get(BankAccount.class, id);
		
		System.out.println("BankAccount is : " + bankAccount);
	}
	
	@Ignore
	@Test
	public void testCreditCard_findMethod() {
		
		final long id = 1230000001;
		
		CreditCard creditCard = (CreditCard) HibernateUtil.getSession().get(CreditCard.class, id);
		
		System.out.println("CreditCard is : " + creditCard);
	}
	
	@Ignore
	@Test
	public void testClientDao_findMethod() throws DaoException {
		
		final long id = 123;
		
		ClientDao clientDao = new ClientDaoImpl();
		
		Client client = clientDao.find(id);
		
		System.out.println("Client is : " + client);
	}
	
	@Ignore
	@Test
	public void testClientDao_findAllMethod() throws DaoException {
		
		ClientDao clientDao = new ClientDaoImpl();
		
		List<Client> clientList = clientDao.findAll();
		
		System.out.println("Client All are : " + clientList);
	}
	
	@Test
	public void testClientDao_BankAccounts_allMethod() throws DaoException {
		
		final long id = 123;
		
		ClientDao clientDao = new ClientDaoImpl();
		
		Client client = clientDao.find(id);
		
		System.out.println("Client is : " + client);
		
		System.out.println("Client's BankAccoutns are : " + client.getBankAccounts());
	}
	
	@Ignore
	@Test
	public void testCreditCardDao_findMethod() throws DaoException {
		
		final long id = 1230000001;
		
		CreditCardDao creditCardDao = new CreditCardDaoImpl();
		
		CreditCard creditCard = creditCardDao.find(id);
		
		System.out.println("CreditCard is : " + creditCard);
	}
	
	@Ignore
	@Test
	public void testCreditCardDao_findAllMethod() throws DaoException {
		
		CreditCardDao creditCardDao = new CreditCardDaoImpl();
		
		List<CreditCard> creditCardList = creditCardDao.findAll();
		
		System.out.println("CreditCard All are : " + creditCardList);
	}
	
}
