package by.epam.javaonline.task5_5.logic.impl;

import by.epam.javaonline.task5_5.bean.Administrator;
import by.epam.javaonline.task5_5.bean.Client;
import by.epam.javaonline.task5_5.bean.Person;
import by.epam.javaonline.task5_5.dao.DAOException;
import by.epam.javaonline.task5_5.dao.DAOProvider;
import by.epam.javaonline.task5_5.dao.PersonDAO;
import by.epam.javaonline.task5_5.logic.LogicException;
import by.epam.javaonline.task5_5.logic.PersonLogic;
import by.epam.javaonline.task5_5.logic.PersonRole;

public class PersonLogicImpl implements PersonLogic{

	private final DAOProvider provider = DAOProvider.getInstance();
	private final PersonDAO dao = provider.getPersonDAO();
	
	@Override
	public Person addNewPerson(String name, String password, PersonRole role) throws LogicException {
		
		Person result = null;
		
		try {
			
			if(role.equals(PersonRole.Administrator)) {
				result = new Administrator(name, password);
				dao.addPerson(result);
			} else if(role.equals(PersonRole.Client)) {
				result = new Client(name, password);
				dao.addPerson(result);
			}
		
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public Person logination(String name, String password) throws LogicException {
		
		Person result = null;
		
		try {
			result = dao.getPerson(name, password);
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public Person removePerson(String name) throws LogicException {
		
		Person result = null;
		
		try {
			result = dao.removePerson(name);
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public Administrator addNewAdministrator(String name, String password) throws LogicException {	
		return (Administrator) addNewPerson(name, password, PersonRole.Administrator);
	}

	@Override
	public Client addNewClient(String name, String password) throws LogicException {
		return (Client) addNewPerson(name, password, PersonRole.Client);
	}
}
