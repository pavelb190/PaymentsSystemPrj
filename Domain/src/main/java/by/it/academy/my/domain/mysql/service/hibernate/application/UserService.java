package by.it.academy.my.domain.mysql.service.hibernate.application;

import by.it.academy.my.dao.exception.DaoException;
import by.it.academy.my.dao.hibernate.AdminDao;
import by.it.academy.my.dao.hibernate.AdminDaoImpl;
import by.it.academy.my.dao.hibernate.ClientDao;
import by.it.academy.my.dao.hibernate.ClientDaoImpl;
import by.it.academy.my.domain.service.exception.PasswordMismatchException;
import by.it.academy.my.domain.service.exception.ServiceException;
import by.it.academy.my.domain.service.exception.UserNotFoundException;
import by.it.academy.my.model.entity.hib.User;

public class UserService {

	private ClientDao clientDao = new ClientDaoImpl();
	private AdminDao adminDao = new AdminDaoImpl();
	
	public User userLogin(UserDto userDto) throws ServiceException {
		
		User userWithRole = null;
		
		try {
			
			userWithRole = clientDao.find(userDto.getId());
			
			if (userWithRole == null) {
				
				userWithRole = adminDao.find(userDto.getId());
			}
			
			if (userWithRole == null) {
				
				throw new UserNotFoundException();
			}
			
			if (!userWithRole.getPassword().equals(userDto.getPassword())) {
				
				throw new PasswordMismatchException();
			}
			
		} catch (DaoException e) {
			
			// ...
			
			throw new ServiceException();
		}
		
		return userWithRole;
	}
}
