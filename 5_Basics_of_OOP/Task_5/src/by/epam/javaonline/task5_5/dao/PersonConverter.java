package by.epam.javaonline.task5_5.dao;

import by.epam.javaonline.task5_5.bean.Person;

public interface PersonConverter {

	String personToString(Person person);
	Person stringToPerson(String line);
}
