package by.it.academy.my.domain.service.exception;

public class UserNotFoundException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String message = "This User not Found!";
	
	public UserNotFoundException() {
		
		super(message);
	}
	
	public UserNotFoundException(final String message) {
		
		super(message);
	} 
	
	public UserNotFoundException(final String message, Throwable cause) {
		
		super(message, cause);
	}
	
}
