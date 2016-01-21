package by.it.academy.my.web.action;

import javax.servlet.http.HttpServletRequest;

import by.it.academy.my.web.action.exception.ActionIsNotExistsException;

public interface WebActionResolver {
	
	public WebAction resolve(HttpServletRequest req) throws ActionIsNotExistsException;
}
