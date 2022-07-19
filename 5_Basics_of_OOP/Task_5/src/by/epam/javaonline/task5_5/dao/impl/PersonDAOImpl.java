package by.epam.javaonline.task5_5.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import by.epam.javaonline.task5_5.bean.Client;
import by.epam.javaonline.task5_5.bean.Person;
import by.epam.javaonline.task5_5.dao.DAOException;
import by.epam.javaonline.task5_5.dao.PersonConverter;
import by.epam.javaonline.task5_5.dao.PersonDAO;

public class PersonDAOImpl implements PersonDAO{
	
	private final String stroragePath;
	private final String fileName;
	private final PersonConverter personConverter;
	
	{
		fileName = "PersonsStorage.txt";
		
		stroragePath = new StringBuilder(new File("").getAbsolutePath()).
					     append("\\source\\").
					     append(fileName).toString();
		
		personConverter = new PersonConverterImpl();
	}
	
	private File getStrorageFile() {
		
		File storage = new File(stroragePath);
		
		if(storage.exists()) {
			return storage;
		} else {
			try {
				storage.createNewFile();
			} catch (IOException e) {
				return storage;
			}
			return storage;
		}
	}

	@Override
	public Person addPerson(Person person) throws DAOException {
		
		File storage;
		String line;
			
		storage = getStrorageFile();
		line = null;
			
		try(FileWriter stream = new FileWriter(storage, true);
				PrintWriter writer= new PrintWriter(stream)) {
			
			line = personConverter.personToString(person);
			writer.write(line);	
			
		} catch (IOException e) {
			throw new DAOException(e);
		} 
		return person;
		
	}
	

	
	@Override
	public Person getPerson(String name, String password) throws DAOException {
		
		File storage;
		String line;
		Person current;
		Person result;
			
		storage = getStrorageFile();
		line = null;
		current = null;
		result = null;
		
		try(FileReader stream = new FileReader(storage);
				BufferedReader reader = new BufferedReader(stream)){
			
			for(;;) {
				
				line = reader.readLine();
				if(line != null) {
					current = personConverter.stringToPerson(line);
					if(current.getName().equals(name) && current.getPassword().equals(password)) {
						result = current;
						break;
					}
				} else {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}
		return result;
	}
	
	

	@Override
	public Person removePerson(String name) throws DAOException {
		
		List<Person> persons;
		Person currentPerson;
		File currentFile;
		int counter;
		String clientClassName;
		File clientStorage;
		
		
		persons = getAllPersons();
		currentPerson = null;
		counter = 0;
		clientClassName = "Client";
		
		if(persons == null) {
			return null;
		}
		
		for(int i = 0; i < persons.size(); i++) {
			
			currentPerson = persons.get(i);
			
			if(currentPerson.getName().equals(name)) {
				
				if(currentPerson.getClass().getSimpleName().equals(clientClassName)) {
					clientStorage = new PresentsDAOImpl().getStrorageFile((Client) currentPerson);
					clientStorage.delete();
				}
				
				persons.remove(i);
				counter++;
				break;
			}
		}
		
		if(counter == 0) {
			return null;
		}
		
		currentFile = getStrorageFile();
		currentFile.delete();
		
		for(int i = 0; i < persons.size(); i++) {
			addPerson(persons.get(i));
		}
		
		return currentPerson;
	}

	@Override
	public List<Person> getAllPersons() throws DAOException {
		
		File storage;
		List<Person> result;
		String line;
		Person person;
		
		storage = getStrorageFile();
		result = new ArrayList<>();
		line = null;
		person = null;
		
		try(FileReader stream = new FileReader(storage);
				BufferedReader reader = new BufferedReader(stream)){
			
			for(;;) {
				
				line = reader.readLine();
				if(line != null) {
					person =personConverter.stringToPerson(line);
					result.add(person);
				} else {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}
		
		if(result.isEmpty()) {
			return null;
		} else {
			return result;
		}
	}

	@Override
	public boolean nameContain(String name) throws DAOException {
		
		File storage;
		String line;
		Person current;
		boolean result;
			
		storage = getStrorageFile();
		line = null;
		current = null;
		result = false;
		
		try(FileReader stream = new FileReader(storage);
				BufferedReader reader = new BufferedReader(stream)){
			
			for(;;) {
				
				line = reader.readLine();
				if(line != null) {
					current = personConverter.stringToPerson(line);
					if(current.getName().equals(name)) {
						result = true;
						break;
					}
				} else {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}
		return result;
	}
}
