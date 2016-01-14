package by.it.academy.my.web.action.exception;

public class ActionIsNotExistsException extends ActionException {
	
	private static final String message = "This Action doesn't exists!";
	
	public ActionIsNotExistsException() {
		
		super(message);
	}
}
