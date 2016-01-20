package by.it.academy.my.web.action.application;

import by.it.academy.my.web.action.WebAction;
import by.it.academy.my.web.action.exception.ActionException;

public class LoginFormAction extends WebAction {

	@Override
	protected String doAction() throws ActionException {
		
		log.debug("[LoginFormAction triggered!]");
		
		return "login";
	}

}
