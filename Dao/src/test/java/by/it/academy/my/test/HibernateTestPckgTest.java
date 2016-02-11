package by.it.academy.my.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Ignore;
import org.junit.Test;

import by.it.academy.my.dal.db.hibernate.HibernateUtil;
import by.it.academy.my.model.entity.hib.test.Address;
import by.it.academy.my.model.entity.hib.test.Order;
import by.it.academy.my.model.entity.hib.test.User;

public class HibernateTestPckgTest {

	private Session session = HibernateUtil.getSession();
	
	@Ignore
	@Test
	public void testUser_selectAll() {
		
		List<User> users = (List<User>) session.createCriteria(User.class).list();
		
		System.out.println("Users are : " + users);
	}
	
	@Ignore
	@Test
	public void testUser_save() {
		
		User user = new User();
		
		user.setName("TEST_USER");
		user.setEmail("test@example.com");
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			Long id = (Long) session.save(user);
			
			tx.commit();
			
			System.out.println("Saved user is: " + id);
			
		} catch (HibernateException e) {
			
			System.out.println("Some error Occured! (" + e.getMessage() + ")");
			
			System.out.println("Not Saved.");
			
			tx.rollback();
			
		} finally {
			
			session.close();
		}
		
	}
	
	@Ignore
	@Test
	public void testAddress_selectAll() {
		
		List<Address> addresses = (List<Address>) session.createCriteria(Address.class).list();
		
		System.out.println("All Addresses are : " + addresses);
	}
	
	@Ignore
	@Test
	public void testAddress_save() {
		
		Address address = new Address();
		
		address.setCountry("BELARUS");
		address.setCity("Minsk");
		address.setPostalCode("220025");
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			User user = (User) session.get(User.class, 5L);
			
			address.setUser(user);
			
			Long id = (Long) session.save(address);
			
			tx.commit();
			
			System.out.println("Address's id is : " + id);
			
		} catch (HibernateException e) {
			
			System.out.println("Some error Occured! (" + e.getMessage() + ")");
			
			System.out.println("Not Saved.");
			
			tx.rollback();
			
		} finally {
			
			session.close();
		}
		
	}
	
	@Ignore
	@Test
	public void testOrder_selectAll() {
		
		List<Order> orders = (List<Order>) session.createCriteria(Order.class).list();
		
		System.out.println("All Orders are : " + orders);
	}
	
	@Ignore
	@Test
	public void testOrder_save() {
		
		Order order = new Order();
		
		order.setItem("ITEM_2");
		
		order.setCount(4);
		order.setAmount(450);
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			User user = (User) session.get(User.class, 5L);
			
			order.setUser(user);
			
			Long id = (Long) session.save(order);
			
			tx.commit();
			
			System.out.println("Order's id is : " + id);
			
		} catch (HibernateException e) {
			
			System.out.println("Some error Occured! (" + e.getMessage() + ")");
			
			System.out.println("Not Saved.");
			
			tx.rollback();
			
		} finally {
			
			session.close();
		}
		
	}
	
}
