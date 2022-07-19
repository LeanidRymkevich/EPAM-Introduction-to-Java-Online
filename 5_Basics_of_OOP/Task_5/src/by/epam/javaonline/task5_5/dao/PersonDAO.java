package by.epam.javaonline.task5_5.dao;

import java.util.List;

import by.epam.javaonline.task5_5.bean.Person;

public interface PersonDAO {

	Person addPerson(Person person) throws DAOException;
	
	Person getPerson(String name, String password) throws DAOException;
	
	boolean nameContain(String name) throws DAOException;
	
	List<Person> getAllPersons() throws DAOException;
	
	Person removePerson(String name) throws DAOException;
}
