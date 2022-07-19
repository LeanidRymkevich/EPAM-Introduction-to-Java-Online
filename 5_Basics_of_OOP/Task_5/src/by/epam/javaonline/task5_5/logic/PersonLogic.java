package by.epam.javaonline.task5_5.logic;

import by.epam.javaonline.task5_5.bean.Administrator;
import by.epam.javaonline.task5_5.bean.Client;
import by.epam.javaonline.task5_5.bean.Person;

public interface PersonLogic {
	
	Person addNewPerson(String name, String password, PersonRole role) throws LogicException;
	
	Administrator addNewAdministrator(String name, String password) throws LogicException;
	
	Client addNewClient(String name, String password) throws LogicException;
	
	Person logination(String name, String password) throws LogicException;
	
	Person removePerson(String name) throws LogicException;

}
