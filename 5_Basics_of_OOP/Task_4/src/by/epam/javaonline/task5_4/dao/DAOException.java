package by.epam.javaonline.task5_4.dao;

public class DAOException extends Exception{

	private static final long serialVersionUID = 6209372651599756786L;
	
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
