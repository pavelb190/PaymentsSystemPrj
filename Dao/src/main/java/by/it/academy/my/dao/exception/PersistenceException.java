package by.it.academy.my.dao.exception;

public class PersistenceException extends Exception {
	
	private static final String message = "Some error occured in Persistence layer!..";
	
	public PersistenceException() {
		
		super(message);
	}
	
	public PersistenceException(final String message) {
		
		super(message);
	}
}
