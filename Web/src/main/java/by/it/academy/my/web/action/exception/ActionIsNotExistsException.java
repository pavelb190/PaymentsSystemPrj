package by.it.academy.my.web.action.exception;

public class ActionIsNotExistsException extends ActionException {
	
	private static final String message = "This Action doesn't exists!";
	
	private String forCommand;
	
	public ActionIsNotExistsException() {
		
		super(message);
	}
	
	public ActionIsNotExistsException(final String message) {
		
		super(message);
	}
	
	public String getForCommand() {
		
		return this.forCommand;
	}
	
	public void setForCommand(final String forCommand) {
		
		this.forCommand = forCommand;
	}
}
