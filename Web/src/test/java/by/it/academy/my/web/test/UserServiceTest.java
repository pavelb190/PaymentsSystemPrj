package by.it.academy.my.web.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import by.it.academy.my.domain.mysql.service.application.UserService;
import by.it.academy.my.domain.service.exception.ServiceException;
import by.it.academy.my.model.entity.application.User;

public class UserServiceTest {
	
	@Test
	public void testGetUserById() throws ServiceException {
		
		UserService userService = new UserService();
		
		final long id = 1;
		
		User user = userService.getUserById(id);
		
		System.out.println("User : " + user);
		
		assertNotNull( "Couldn't to get a User from UserService.", user );
	}
}
