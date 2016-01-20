package by.it.academy.my.web.action;

import javax.servlet.http.HttpServletRequest;

public interface WebActionResolver {
	
	public WebAction resolve(HttpServletRequest req);
}
