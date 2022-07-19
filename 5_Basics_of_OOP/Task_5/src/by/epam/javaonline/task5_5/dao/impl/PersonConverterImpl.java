package by.epam.javaonline.task5_5.dao.impl;

import by.epam.javaonline.task5_5.bean.Administrator;
import by.epam.javaonline.task5_5.bean.Client;
import by.epam.javaonline.task5_5.bean.Person;
import by.epam.javaonline.task5_5.dao.PersonConverter;

public class PersonConverterImpl implements PersonConverter{

	// The object of Person-type in the data-file will be presented as a string below:
	// ClassName name="name" password="password"\n
	
	@Override
	public String personToString(Person person) {
		
		if(person == null) {
			return "null\n";
		}
		
		StringBuilder result = new StringBuilder();
		
		result.append(person.getClass().getSimpleName()).
			   append(" name=" + person.getName()).
			   append(" password=" + person.getPassword()).
			   append("\n");
		return result.toString();
	}

	@Override
	public Person stringToPerson(String line) {
		
		if(line.equals("null")) {
			return null;
		}
		
		String[] params;
		String className;
		String name;
		String password;
		

		params = line.split("\\s+");
		className = params[0];
		name = params[1].split("=")[1];
		password = params[2].split("=")[1];
		
		if(className.equals("Client")) {
			return new Client(name, password);
		} else if(className.equals("Administrator")) {
			return new Administrator(name, password);
		} else {
			return null;
		}
	}

}
