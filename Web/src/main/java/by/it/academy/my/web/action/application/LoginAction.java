package by.it.academy.my.web.action.application;

import java.util.HashMap;

import by.it.academy.my.entity.application.User;
import by.it.academy.my.service.UserService;
import by.it.academy.my.web.action.WebAction;

public class LoginAction extends WebAction {
	
	UserService userService = new UserService();
	
	@Override
	protected String doAction() {
		
		final String login = (String) getActionParam("login");
		final String pass = (String) getActionParam("pswd");
		
		User user = userService.getUserById(1);
		
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
