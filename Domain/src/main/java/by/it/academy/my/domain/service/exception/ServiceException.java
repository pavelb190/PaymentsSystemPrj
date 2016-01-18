package by.it.academy.my.domain.service.exception;

public class ServiceException extends Exception {
	
	private static final String message = "Some error occured in Service layer!..";
	
	public ServiceException() {
		
		super(message);
	}
	
	public ServiceException(final String message) {
		
		super(message);
	}
}
