package by.epam.javaonline.task5_5.logic.impl;

import by.epam.javaonline.task5_5.dao.DAOException;
import by.epam.javaonline.task5_5.dao.DAOProvider;
import by.epam.javaonline.task5_5.dao.PersonDAO;
import by.epam.javaonline.task5_5.logic.LogicException;
import by.epam.javaonline.task5_5.logic.Validator;

public class ValidatorImpl implements Validator{
	
	private final PersonDAO personDAO = DAOProvider.getInstance().getPersonDAO();

	@Override
	public String personNameCheck(String name) throws IllegalArgumentException{

		/* The name must contain only Latin letters and numbers.
		 * The number of symbols must be between 6 and 20.
		*/
		
		String pattern;
		boolean isFits;
		
		pattern = "[A-Za-z|0-9]{6,20}";
		isFits = name.matches(pattern);
		
		if(isFits) {
			return name;
		}else {
			throw new IllegalArgumentException("Incorrect name entered!!!");
		}
	}

	@Override
	public String personPasswordCheck(String password) throws IllegalArgumentException{
		
		/* The password must contain only Latin letters and numbers.
		 * The number of symbols must be between 7 and 15.
		*/
		
		String pattern;
		boolean isFits;
		
		pattern = "[A-Za-z|0-9]{7,15}";
		isFits = password.matches(pattern);
		
		if(isFits) {
			return password;
		}else {
			throw new IllegalArgumentException("Incorrect password entered!!!");
		}
	}

	@Override
	public String registrationNameCheck(String name) throws IllegalArgumentException, LogicException {
		
		String result = personNameCheck(name);
		boolean isAlreadyExists = false;
		
		try {
			isAlreadyExists = personDAO.nameContain(result);
		} catch (DAOException e) {
			throw new LogicException(e);
		}
		
		if(isAlreadyExists) {
			return null;
		} else {
			result = name;
			return result;
		}
	}
}
