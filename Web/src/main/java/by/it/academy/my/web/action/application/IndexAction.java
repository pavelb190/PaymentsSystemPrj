package by.it.academy.my.web.action.application;

import by.it.academy.my.web.action.WebAction;

public class IndexAction extends WebAction {

	@Override
	protected String doAction() {
		
		log.debug("[IndexAction triggered!]");
		
		return "index";
	}

}
