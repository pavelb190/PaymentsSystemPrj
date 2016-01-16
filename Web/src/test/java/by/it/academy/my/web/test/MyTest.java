package by.it.academy.my.web.test;

import static org.junit.Assert.assertEquals;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Ignore;
import org.junit.Test;

import by.it.academy.my.web.action.application.ApplicationActions;

public class MyTest {
	
	@Ignore
	@Test
	public void testSomeCondition() throws NamingException {
		
		InitialContext initCtxt = new InitialContext();
		
		Context envCtxt = (Context) initCtxt.lookup("java:comp/env");
		
		System.out.println("EnvContext: " + envCtxt);
	}
}
