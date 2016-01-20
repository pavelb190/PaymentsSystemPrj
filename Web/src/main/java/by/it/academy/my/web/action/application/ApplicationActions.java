package by.it.academy.my.web.action.application;

import by.it.academy.my.web.action.WebAction;
import by.it.academy.my.web.action.exception.ActionException;
import by.it.academy.my.web.action.exception.ActionNotCreatedException;
import by.it.academy.my.web.action.request.RequestTypes;

public enum ApplicationActions {
	
	LOGIN_FORM(
		"loginForm", RequestTypes.GET, LoginFormAction.class
	),
	LOGIN(
		"login", RequestTypes.POST, LoginAction.class
	),
	INDEX(
		"index", RequestTypes.GET, IndexAction.class
	),
	DEFAULT(
		"default", RequestTypes.GET, DefaultAction.class
	),
	ERROR(
		"error", RequestTypes.GET, ErrorAction.class
	),
	LOGOUT(
		"logout", RequestTypes.GET, LogoutAction.class
	);
	
	private String command;
	
	WebAction action;
	
	private RequestTypes requestType;
	
	ApplicationActions(final String command, RequestTypes requestType, Class<? extends WebAction> action) {
		
		this.command = command;
		
		this.requestType = requestType;
		
		try {
			
			this.action = action.newInstance();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			try {
				
				throw new ActionNotCreatedException("Action '" + action.getName() + "' not Created!");
				
			} catch (ActionNotCreatedException ex) {

				ex.printStackTrace();
				
				// ...
			}
		}
	}
	
	public String getCommand() {
		
		return this.command;
	}
	
	public WebAction getCurrentAction() {
		
		return this.action;
	}
	
	public RequestTypes getRequestType() {
		
		return this.requestType;
	}
}
