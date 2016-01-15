package by.it.academy.my.web.action.request.exception;

public class RequestException extends Exception {
	
	private static final String message = "Some error occured on Request level!";
	
	public RequestException() {
		
		super(message);
	}
	
	public RequestException(String message) {
		
		super(message);
	}
}
