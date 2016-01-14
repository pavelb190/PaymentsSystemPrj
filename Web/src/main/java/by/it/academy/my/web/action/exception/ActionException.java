package by.it.academy.my.web.action.exception;

import by.it.academy.my.web.action.request.exception.RequestException;

public class ActionException extends RequestException {
	
	public ActionException(String message) {
		
		super(message);
	}
}
