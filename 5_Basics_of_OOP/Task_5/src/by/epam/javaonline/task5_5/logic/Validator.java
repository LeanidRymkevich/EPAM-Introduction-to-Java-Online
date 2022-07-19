package by.epam.javaonline.task5_5.logic;

public interface Validator {
	
	String personNameCheck(String name) throws IllegalArgumentException;
	
	String personPasswordCheck(String password) throws IllegalArgumentException;

	String registrationNameCheck(String name) throws IllegalArgumentException, LogicException;
}
