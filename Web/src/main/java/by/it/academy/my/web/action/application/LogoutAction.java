package by.it.academy.my.web.action.application;

import by.it.academy.my.web.action.WebAction;

public class LogoutAction extends WebAction {

	@Override
	protected String doAction() {
		
		log.debug("[LogoutAction is triggered!]");
		
		return "login";
	}

}
