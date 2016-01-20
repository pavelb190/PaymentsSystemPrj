package by.it.academy.my.web.action.application;

import by.it.academy.my.web.action.WebAction;
import by.it.academy.my.web.action.request.RequestTypes;

public class ApplicationActionsFactory {
	
	public static WebAction getActionByCommand(final String command, RequestTypes requestType) {
		
		WebAction action = null;
		
		for(ApplicationActions currAction : ApplicationActions.values()) {
			
			if (currAction.getCommand().equals(command) && requestType == currAction.getRequestType()) {
				
				action = currAction.getCurrentAction();
			}
		}
		
		return action;
	}
}
