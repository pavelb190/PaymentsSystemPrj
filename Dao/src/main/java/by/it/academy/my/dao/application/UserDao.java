package by.it.academy.my.dao.application;

import by.it.academy.my.dao.GenericDao;
import by.it.academy.my.model.entity.application.User;

public interface UserDao extends GenericDao<User, Long> {
	
	public User getByLogin(String login);
}
