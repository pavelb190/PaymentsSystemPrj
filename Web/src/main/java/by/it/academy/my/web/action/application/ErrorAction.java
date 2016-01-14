package by.it.academy.my.web.action.application;

import by.it.academy.my.web.action.WebAction;

public class ErrorAction extends WebAction {

	@Override
	protected String doAction() {
		
		log.debug("[ErrorAction is triggered!]");
		
		return "error";
	}

}
