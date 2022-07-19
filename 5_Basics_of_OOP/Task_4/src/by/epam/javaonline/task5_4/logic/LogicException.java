package by.epam.javaonline.task5_4.logic;

public class LogicException extends Exception{

	private static final long serialVersionUID = 6209372651599756786L;
	
	public LogicException() {
		
	}
	
	public LogicException(String message) {
		super(message);
	}

	public LogicException(Exception ex) {
		super(ex);
	}
	
	public LogicException(String message, Exception ex) {
		super(message, ex);
	}
}