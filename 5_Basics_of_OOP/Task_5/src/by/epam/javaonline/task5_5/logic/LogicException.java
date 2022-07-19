package by.epam.javaonline.task5_5.logic;

public class LogicException extends Exception{

	private static final long serialVersionUID = -4018868973370409420L;

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