package by.it.academy.my.web.action.application;

import by.it.academy.my.web.action.WebAction;
import by.it.academy.my.web.action.exception.ActionException;

public class DefaultAction extends WebAction {

	@Override
	protected String doAction() throws ActionException {
		
		System.out.println("In Default-action!..");
		
		return "index";
	}

}
