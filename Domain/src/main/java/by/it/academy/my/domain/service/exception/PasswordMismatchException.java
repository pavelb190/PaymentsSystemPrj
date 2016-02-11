package by.it.academy.my.domain.service.exception;

public class PasswordMismatchException extends ServiceException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String message = "Password mismatch!";
	
	public PasswordMismatchException() {
		
		super(message);
	}
	
	public PasswordMismatchException(final String message) {
		
		super(message);
	}
	
	public PasswordMismatchException(final String message, Throwable e) {
		
		super(message, e);
	}
	
}
