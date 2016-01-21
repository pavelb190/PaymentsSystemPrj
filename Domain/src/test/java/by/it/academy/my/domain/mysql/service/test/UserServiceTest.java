package by.it.academy.my.domain.mysql.service.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import by.it.academy.my.domain.mysql.service.application.UserService;
import by.it.academy.my.domain.service.exception.ServiceException;
import by.it.academy.my.model.entity.User;

public class UserServiceTest {
	
	@Test
	public void testGettingUserById() throws ServiceException {
		
		UserService userService = new UserService();
		
		final long id = 1;
		
		User user = userService.getUserById(id);
		
		System.out.println("User : " + user);
		
		assertNotNull( "User with id '" + id + "' doesn't exist.", user );
	}
}
