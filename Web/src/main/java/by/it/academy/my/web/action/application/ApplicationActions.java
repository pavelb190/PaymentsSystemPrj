package by.it.academy.my.web.action.application;

import by.it.academy.my.web.action.WebAction;
import by.it.academy.my.web.action.request.RequestTypes;

public enum ApplicationActions {
	
	LOGIN_FORM("login/form", RequestTypes.GET) {
		{
			this.action = new LoginFormAction();
		}
	},
	LOGIN("login", RequestTypes.POST) {
		{
			this.action = new LoginAction();
		}
	},
	INDEX("", RequestTypes.GET) {
		{
			this.action = new IndexAction();
		}
	},
	ERROR("error", RequestTypes.GET) {
		{
			this.action = new ErrorAction();
		}
	},
	LOGOUT("logout", RequestTypes.GET) {
		{
			this.action = new LogoutAction();
		}
	};
	
	private String uri;
	
	WebAction action;
	
	private RequestTypes requestType;
	
	ApplicationActions(final String uri, RequestTypes requestType) {
		
		this.uri = uri;
		
		this.requestType = requestType;
	}
	
	public String getUri() {
		
		return this.uri;
	}
	
	public WebAction getCurrentAction() {
		
		return this.action;
	}
	
	public RequestTypes getRequestType() {
		
		return this.requestType;
	}
}
