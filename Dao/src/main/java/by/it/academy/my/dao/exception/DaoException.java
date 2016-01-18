package by.it.academy.my.dao.exception;

public class DaoException extends Exception {
	
	private static final String message = "Some error occured in DAO-layer!..";
	
	public DaoException() {
		
		super(message);
	}
	
	public DaoException(final String message) {
		
		super(message);
	}
}
