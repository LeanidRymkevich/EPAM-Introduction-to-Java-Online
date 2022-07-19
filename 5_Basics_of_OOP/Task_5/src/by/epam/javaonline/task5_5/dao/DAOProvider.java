package by.epam.javaonline.task5_5.dao;

import by.epam.javaonline.task5_5.dao.impl.PresentsDAOImpl;
import by.epam.javaonline.task5_5.dao.impl.PersonDAOImpl;
import by.epam.javaonline.task5_5.dao.impl.SweetsDAOImpl;
import by.epam.javaonline.task5_5.dao.impl.WrapsDAOImpl;

public final class DAOProvider {

	private static final DAOProvider INSTANCE = new DAOProvider();
	
	private final SweetsDAO sweetsDAO = new SweetsDAOImpl();
	private final WrapsDAO wrapsDAO = new WrapsDAOImpl();
	private final PresentsDAO presentsDAO = new PresentsDAOImpl(); 
	private final PersonDAO personDAO = new PersonDAOImpl();
	
	private DAOProvider() {}
	
	public static DAOProvider getInstance() {
		return INSTANCE;
	}

	public SweetsDAO getSweetsDAO() {
		return sweetsDAO;
	}

	public WrapsDAO getWrapsDAO() {
		return wrapsDAO;
	}

	public PresentsDAO getClientDAO() {
		return presentsDAO;
	}

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	public PresentsDAO getPresentsDAO() {
		return presentsDAO;
	}
}
