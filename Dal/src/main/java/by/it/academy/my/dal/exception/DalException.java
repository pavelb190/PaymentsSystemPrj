package by.it.academy.my.dal.exception;

public class DalException extends Exception {
	
	private static final String message = "Some error occured on DAL-level!..";
	
	public DalException() {
		
		super(message);
	}
	
	public DalException(final String message) {
		
		super(message);
	}
}
