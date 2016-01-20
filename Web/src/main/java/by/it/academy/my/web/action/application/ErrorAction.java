package by.it.academy.my.web.action.application;

import by.it.academy.my.web.action.WebAction;
import by.it.academy.my.web.action.exception.ActionException;

public class ErrorAction extends WebAction {

	@Override
	protected String doAction() throws ActionException {
		
		log.debug("[ErrorAction is triggered!]");
		
		return "error";
	}

}
