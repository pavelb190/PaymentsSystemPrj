package by.it.academy.my.web.action.application;

import javax.servlet.http.HttpServletRequest;

import by.it.academy.my.web.action.WebAction;
import by.it.academy.my.web.action.WebActionResolver;
import by.it.academy.my.web.action.request.RequestTypes;

public class HttpRequestActionResolver implements WebActionResolver {

	private static final String COMMAND_QUERY_STRING = "command";
	private static final String COMMAND_DEFAULT = "default";
	
	private static WebActionResolver instance;
	
	private HttpRequestActionResolver() {
		
		// ...
	}
	
	public static WebActionResolver getInstance() {
		
		if (instance == null) {
			
			instance = new HttpRequestActionResolver();
		}
		
		return instance;
	}
	
	@Override
	public WebAction resolve(HttpServletRequest req) {
		
		WebAction action = ApplicationActionsFactory.getActionByCommand(req.getParameter(COMMAND_QUERY_STRING), RequestTypes.valueOf(req.getMethod().toUpperCase()));
		
		if (action == null) {
			
			action = ApplicationActionsFactory.getActionByCommand(COMMAND_DEFAULT, RequestTypes.GET);
		}
		
		return action;
	}

}
