package by.it.academy.my.web.action.application;

import by.it.academy.my.web.action.WebAction;

public class LoginFormAction extends WebAction {

	@Override
	protected String doAction() throws Exception {
		
		log.debug("[LoginFormAction triggered!]");
		
		return "login";
	}

}
