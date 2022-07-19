package by.epam.javaonline.task5_5.logic.impl;

import java.util.List;

import by.epam.javaonline.task5_5.bean.Client;
import by.epam.javaonline.task5_5.bean.Person;
import by.epam.javaonline.task5_5.bean.Present;
import by.epam.javaonline.task5_5.bean.Sweet;
import by.epam.javaonline.task5_5.bean.Wrap;
import by.epam.javaonline.task5_5.builder.PresentBuilder;
import by.epam.javaonline.task5_5.builder.impl.PresentBuilderImpl;
import by.epam.javaonline.task5_5.dao.DAOException;
import by.epam.javaonline.task5_5.dao.DAOProvider;
import by.epam.javaonline.task5_5.dao.PersonDAO;
import by.epam.javaonline.task5_5.dao.PresentsDAO;
import by.epam.javaonline.task5_5.dao.SweetsDAO;
import by.epam.javaonline.task5_5.dao.WrapsDAO;
import by.epam.javaonline.task5_5.logic.ClientLogic;
import by.epam.javaonline.task5_5.logic.LogicException;

public class ClientLogicImpl implements ClientLogic{
	
	private final DAOProvider provider = DAOProvider.getInstance();
	private final SweetsDAO sweetsDAO = provider.getSweetsDAO();
	private final WrapsDAO wrapsDAO = provider.getWrapsDAO();
	private final PresentsDAO presentsDAO = provider.getPresentsDAO();
	private final PersonDAO personDAO = provider.getPersonDAO();

	@Override
	public Present addPresent(Client client, String name, int numberOfWrap, int... numbersOfSweets) throws LogicException {
		
		
		Present present = null;
		PresentBuilder builder  = new PresentBuilderImpl();
		Wrap wrap = null;
		Sweet sweet = null;
		int index = 0;
		List<Wrap> wraps  = null;
		List<Sweet> sweets  = null;
		
		try {
			
			wraps = wrapsDAO.getAllWraps();
			sweets = sweetsDAO.getAllSweets();
			wrap = wraps.get(numberOfWrap);
			
			builder.setName(name).setWrap(wrap);
			
			for(int i = 0; i < numbersOfSweets.length; i++) {
				index = numbersOfSweets[i];
				sweet = sweets.get(index);
				builder.addSweet(sweet);
			}
			present = builder.getResult();
			presentsDAO.addAllPresents(client, List.of(present));
			
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return present;
	}

	@Override
	public List<Present> getAllPresents(Client client) throws LogicException {
		
		List<Present> result = null;
		
		try {
			result = presentsDAO.getAllPresents(client);
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public Present getPresent(Client client, String name) throws LogicException {
		
		Present result = null;
		
		try {
			result = presentsDAO.getPresent(client, name);
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public Present removePresent(Client client, String name) throws LogicException {
		
		Present result = null;
		
		try {
			result = presentsDAO.removePresent(client, name);
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public double getCostOfPresent(Client client, String presentName) throws LogicException {
		
		Present present = getPresent(client, presentName);
		return presentCost(present);
	}
	
	private double presentCost(Present present) {
		
		double result = 0;
		List<Sweet> sweets = present.getSweets();
		
		result += present.getWrap().getCost();
		
		for(Sweet sweet: sweets) {
			result += sweet.getCost();
		}
		
		return result;
	}

	@Override
	public double getCostOfAllPresents(Client client) throws LogicException {
		
		List<Present> presents = getAllPresents(client);
		double result = 0;
		
		for(Present present: presents) {
			result += presentCost(present);
		}
		return result;
	}

	@Override
	public Client removeCurrentClient(Client client) throws LogicException {
		
		Client result = null;
		List<Person> persons = null;
		Person person = null;
		String className = "Client";
		
		try {
			
			persons = personDAO.getAllPersons();
			
			for(int i = 0; i < persons.size(); i++) {
				person = persons.get(i);
				if(person.getClass().getSimpleName().equals(className) &&
						person.getName().equals(client.getName())) {
					result = (Client) personDAO.removePerson(client.getName());
				}
			}
			
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public List<Sweet> getSweetAssortment() throws LogicException {
		
		List<Sweet> result = null;
		
		try {
			result = sweetsDAO.getAllSweets();
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public List<Wrap> getWrapAssortment() throws LogicException {
		
		List<Wrap> result = null;
		
		try {
			result = wrapsDAO.getAllWraps();
		}catch(DAOException ex) {
			throw new LogicException(ex);
		}
		return result;
	}

	@Override
	public double getWeightOfPresent(Client client, String presentName) throws LogicException {
		
		Present present = getPresent(client, presentName);
		double result = 0;
		
		List<Sweet> sweets = present.getSweets();
		
		result += present.getWrap().getWeight();
		
		for(Sweet sweet: sweets) {
			result += sweet.getWeight();
		}
		
		return result;
	}
}
