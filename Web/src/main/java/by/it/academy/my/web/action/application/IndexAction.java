package by.it.academy.my.web.action.application;

import by.it.academy.my.web.action.WebAction;
import by.it.academy.my.web.action.exception.ActionException;

public class IndexAction extends DefaultAction {

	@Override
	protected String doAction() throws ActionException {
		
		System.out.println("[IndexAction triggered!]");
		
		return "index";
	}

}
