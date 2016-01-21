package by.it.academy.my.web.action.application;

import by.it.academy.my.web.action.WebAction;
import by.it.academy.my.web.action.exception.ActionException;

public class TestAction extends WebAction {

	@Override
	protected String doAction() throws ActionException {
		
		System.out.println("[In TestAction#doAction-method!..]");
		
		this.getViewParams().put("someMessage", "Hello, World (from TestAction)!!!");
		
		return "test";
	}

}
