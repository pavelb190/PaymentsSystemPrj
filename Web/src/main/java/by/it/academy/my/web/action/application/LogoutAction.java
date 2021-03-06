package by.it.academy.my.web.action.application;

import by.it.academy.my.web.action.WebAction;
import by.it.academy.my.web.action.exception.ActionException;

public class LogoutAction extends WebAction {

	@Override
	protected String doAction() throws ActionException {
		
		System.out.println("[LogoutAction is triggered!]");
		
		this.getSession().removeAttribute("user");
		
		return "login";
	}

}
