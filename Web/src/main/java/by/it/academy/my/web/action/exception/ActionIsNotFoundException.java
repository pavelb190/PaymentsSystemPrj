package by.it.academy.my.web.action.exception;

public class ActionIsNotFoundException extends ActionException {
	
	private static final String message = "This Action is not Found!";
	
	public ActionIsNotFoundException() {
		
		super(message);
	}
}
