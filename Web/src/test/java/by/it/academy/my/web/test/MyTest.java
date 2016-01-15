package by.it.academy.my.web.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import by.it.academy.my.dao.db.util.jndi.DatabaseConnectionManager;
import by.it.academy.my.web.action.application.ApplicationActions;

public class MyTest {
	
	@Test
	public void testSomeCondition() {
		
		System.out.println("Action URI: " + ApplicationActions.LOGIN.getUri());
		
		assertEquals( "Web Test Completed!", 1, 1 );
	}
}
