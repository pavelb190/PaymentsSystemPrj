package by.it.academy.my.web.action.application;

import java.util.HashMap;

import by.it.academy.my.domain.mysql.service.hibernate.application.UserDto;
import by.it.academy.my.domain.mysql.service.hibernate.application.UserService;
import by.it.academy.my.domain.service.exception.ServiceException;
import by.it.academy.my.model.entity.hib.Admin;
import by.it.academy.my.model.entity.hib.Client;
import by.it.academy.my.model.entity.hib.User;
import by.it.academy.my.web.action.WebAction;
import by.it.academy.my.web.action.exception.ActionException;

public class LoginAction extends WebAction {
	
	private UserService userService;
	
	public LoginAction() throws ActionException {
		
		//try {
			
			this.userService = new UserService();
			
		/*
		} catch (ServiceException e) {
			
			e.printStackTrace();
			
			throw new ActionException(e.getMessage());
		}
		*/
	}
	
	@Override
	protected String doAction() throws ActionException {
		
		final Long userId = (Long) getActionParam("userId");
		final String password = (String) getActionParam("pswd");
		
		//System.out.println("UserId: " + userId + ", password: " + password);
		
		UserDto userDto = new UserDto(userId, password);
		
		User userLogged = null;
		
		try {
			
			userLogged = userService.userLogin(userDto);
			
			/*
			if (user != null) {
				
				boolean userChecked = userService.checkUserPassword(user, password);
				
				if (userChecked) {
					
					HashMap<String, Object> session = new HashMap<String, Object>();
					
					session.put("user", user);
					
					this.setSessionParams(session);
					
					HashMap<String, Object> viewModel = new HashMap<String, Object>();
					
					viewModel.put("user", user);
					viewModel.put("test", "TEST");
					viewModel.put("aaa", "BBB");
					
					this.setViewParams(viewModel);
					
				} else {
					
					throw new ActionException("User's password Mismatch!");
				}
				
			} else {
				
				throw new ActionException("User with id '" + userId + "' not Found!");
			}
			*/
			
		} catch (ServiceException e) {
			
			e.printStackTrace();
			
			throw new ActionException(e.getMessage());
		}
		
		if (userLogged instanceof Client) {
			
			return "index";
			
		} else if (userLogged instanceof Admin) {
			
			return "admin";
			
		} else {
			
			return "default";
		}
	}

}
