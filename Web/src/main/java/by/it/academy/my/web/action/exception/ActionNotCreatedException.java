package by.it.academy.my.web.action.exception;

public class ActionNotCreatedException extends ActionException {
	
	private static final String message = "Couldn't to create this Action!";
	
	public ActionNotCreatedException() {
		
		super(message);
	}
	
	public ActionNotCreatedException(final String message) {
		
		super(message);
	}
}
