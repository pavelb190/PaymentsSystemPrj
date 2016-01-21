package by.it.academy.my.dao;

import by.it.academy.my.model.entity.User;

public interface UserDao extends GenericDao<User, Long> {
	
	// ...
	
	public User getByLogin();
}
