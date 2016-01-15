package by.it.academy.my.web.action.exception;

import by.it.academy.my.web.action.request.exception.RequestException;

public class ActionException extends RequestException {
	
	private static final String message = "Some error occured in Action layer!";
	
	public ActionException() {
		
		super(message);
	}
	
	public ActionException(String message) {
		
		super(message);
	}
}
