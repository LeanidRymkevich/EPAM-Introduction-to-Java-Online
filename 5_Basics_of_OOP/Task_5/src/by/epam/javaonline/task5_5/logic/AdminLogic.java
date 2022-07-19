package by.epam.javaonline.task5_5.logic;

import java.util.List;

import by.epam.javaonline.task5_5.bean.Administrator;
import by.epam.javaonline.task5_5.bean.Person;
import by.epam.javaonline.task5_5.bean.Sweet;
import by.epam.javaonline.task5_5.bean.Wrap;

public interface AdminLogic {

	List<Wrap> getAllWraps() throws LogicException;
	
	List<Wrap> addWraps(List<Wrap> list) throws LogicException;
	
	Wrap removeWrap(String type) throws LogicException;
	
	List<Sweet> getAllSweets() throws LogicException;
	
	List<Sweet> addSweets(List<Sweet> list) throws LogicException;
	
	Sweet removeSweet(String className, String name) throws LogicException;
	
	Person removePerson(String name) throws LogicException;
	
	Administrator addNewAdmin (String name, String password) throws LogicException;
}
