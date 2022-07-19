package by.epam.javaonline.task5_5.dao;

public class DAOException extends Exception{

	private static final long serialVersionUID = -5577920243016183961L;

	public DAOException() {
		
	}
	
	public DAOException(String message) {
		super(message);
	}

	public DAOException(Exception ex) {
		super(ex);
	}
	
	public DAOException(String message, Exception ex) {
		super(message, ex);
	}
}
