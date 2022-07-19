package by.epam.javaonline.task5_5.logic.impl;

import java.util.List;

import by.epam.javaonline.task5_5.bean.Administrator;
import by.epam.javaonline.task5_5.bean.Person;
import by.epam.javaonline.task5_5.bean.Sweet;
import by.epam.javaonline.task5_5.bean.Wrap;
import by.epam.javaonline.task5_5.dao.DAOException;
import by.epam.javaonline.task5_5.dao.DAOProvider;
import by.epam.javaonline.task5_5.dao.PersonDAO;
import by.epam.javaonline.task5_5.dao.SweetsDAO;
import by.epam.javaonline.task5_5.dao.WrapsDAO;
import by.epam.javaonline.task5_5.logic.AdminLogic;
import by.epam.javaonline.task5_5.logic.LogicException;
import by.epam.javaonline.task5_5.logic.PersonLogic;

public class AdminLogicImpl implements AdminLogic{
	
	private final DAOProvider provider = DAOProvider.getInstance();
	private final SweetsDAO sweetsDAO = provider.getSweetsDAO();
	private final WrapsDAO wrapsDAO = provider.getWrapsDAO();
	private final PersonDAO personDAO = provider.getPersonDAO();
	private final PersonLogic personLogic = new PersonLogicImpl();

	@Override
	public List<Wrap> getAllWraps() throws LogicException {
	
		List<Wrap> result = null;
		
		try {
			result = wrapsDAO.getAllWraps();
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public List<Wrap> addWraps(List<Wrap> list) throws LogicException {
		
		List<Wrap> result = null;
		
		try {
			
			result = wrapsDAO.addWraps(list);
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public Wrap removeWrap(String type) throws LogicException {
		
		Wrap result = null;
		
		try {
			result = wrapsDAO.removeWrap(type);
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public List<Sweet> getAllSweets() throws LogicException {
		
		List<Sweet> result = null;
		
		try {
			result = sweetsDAO.getAllSweets();
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public List<Sweet> addSweets(List<Sweet> list) throws LogicException {
		
		List<Sweet> result = null;
		
		try {
			
			result = sweetsDAO.addSweets(list);
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public Sweet removeSweet(String className, String name) throws LogicException {
		
		Sweet result = null;
		
		try {
			result = sweetsDAO.removeSweet(className, name);
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public Person removePerson(String name) throws LogicException {
		
		Person result = null;
		
		try {
			result = personDAO.removePerson(name);
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public Administrator addNewAdmin(String name, String password) throws LogicException {
		return personLogic.addNewAdministrator(name, password);
	}
}
