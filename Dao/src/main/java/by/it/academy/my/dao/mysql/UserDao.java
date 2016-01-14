package by.it.academy.my.dao.mysql;

import by.it.academy.my.dao.Dao;
import by.it.academy.my.entity.application.User;

public class UserDao implements Dao<User> {

	public User findById(long id) {
		
		User user = new User();
		
		user.setId(1);
		
		user.setName("Admin");
		user.setPassword("12345");
		
		return user;
	}
	
}
