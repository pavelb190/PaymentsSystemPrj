package by.it.academy.my.service;

import by.it.academy.my.dao.mysql.UserDao;
import by.it.academy.my.entity.application.User;

public class UserService {
	
	UserDao userDao = new UserDao();
	
	public User getUserById(long id) {
		
		return userDao.findById(id);
	}
}
