package by.it.academy.my.web.action.application;

import java.util.HashMap;

import by.it.academy.my.domain.mysql.service.application.UserService;
import by.it.academy.my.domain.service.exception.ServiceException;
import by.it.academy.my.model.entity.application.User;
import by.it.academy.my.web.action.WebAction;
import by.it.academy.my.web.action.exception.ActionException;

public class LoginAction extends WebAction {
	
	UserService userService;
	
	public LoginAction() throws ActionException {
		
		try {
			
			this.userService = new UserService();
			
		} catch (ServiceException e) {
			
			e.printStackTrace();
			
			throw new ActionException(e.getMessage());
		}
	}
	
	@Override
	protected String doAction() throws ActionException {
		
		final String login = (String) getActionParam("login");
		final String pass = (String) getActionParam("pswd");
		
		User user = null;
		
		try {
			
			user = userService.getUserById(1);
			
		} catch (ServiceException e) {
			
			e.printStackTrace();
			
			throw new ActionException(e.getMessage());
		}
		
		/*
		if (!user.checkPassword(pass)) {
			
			throw new Exception("Passowrd mismatch!");
		}
		*/
		
		HashMap<String, Object> session = new HashMap<String, Object>();
		
		session.put("user", user);
		
		this.setSessionParams(session);
		
		HashMap<String, Object> viewModel = new HashMap<String, Object>();
		
		viewModel.put("user", user);
		viewModel.put("test", "TEST");
		viewModel.put("aaa", "BBB");
		
		this.setViewParams(viewModel);
		
		log.debug("[LoginAction triggered!]");
		
		return "index";
	}

}
