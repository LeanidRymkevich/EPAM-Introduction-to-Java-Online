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
import by.epam.javaonline.task5_5.bean.Present;
import by.epam.javaonline.task5_5.dao.PresentConverter;
import by.epam.javaonline.task5_5.dao.PresentsDAO;
import by.epam.javaonline.task5_5.dao.DAOException;

public class PresentsDAOImpl implements PresentsDAO{
	
	private final String strorageDirectoryPath;
	private final PresentConverter presentConverter;
	
	{	
		strorageDirectoryPath = new StringBuilder(new File("").getAbsolutePath()).
					     append("\\source\\").
					     toString();
		
		presentConverter = new PresentConverterImpl();
	}
	
	public File getStrorageFile(Client client) {
		
		String clientStorageName;
		String path;
		File storage;
		
		clientStorageName = client.getName() + "'s Presents.txt";
		path = strorageDirectoryPath + clientStorageName;
		storage = new File(path);
		
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
	public List<Present> addAllPresents(Client client, List<Present> list) throws DAOException {
		
		File storage;
		String line;
		Present present;
		
		storage = getStrorageFile(client);
		line = null;
		present = null;
		
		try(FileWriter stream = new FileWriter(storage, true);
				PrintWriter writer= new PrintWriter(stream)) {
			
			for(int i = 0; i < list.size(); i++) {
				present = list.get(i);
				line = presentConverter.presentToString(present);
				writer.write(line);
			}
			
		} catch (IOException e) {
			throw new DAOException(e);
		} 
		return list;
	}

	@Override
	public List<Present> getAllPresents(Client client) throws DAOException {
		
		File storage;
		List<Present> result;
		String line;
		Present present;
		
		storage = getStrorageFile(client);
		result = new ArrayList<>();
		line = null;
		present = null;
		
		try(FileReader stream = new FileReader(storage);
				BufferedReader reader = new BufferedReader(stream)){
			
			for(;;) {
				
				line = reader.readLine();
				if(line != null) {
					present = presentConverter.stringToPresent(line);
					result.add(present);
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
	public Present getPresent(Client client, String name) throws DAOException {
		
		List<Present> allPresents;
		Present present;
		Present result;
		String currentName;
		
		allPresents = getAllPresents(client);
		present = null;
		result = null;
		currentName = null;
		
		for(int i = 0; i < allPresents.size(); i++) {
			
			present = allPresents.get(i);
			currentName = present.getName();
			if(currentName.equals(name)) {
				result = present;
				break;
			}
		}
		return result;
	}

	@Override
	public Present removePresent(Client client, String name) throws DAOException {
		
		List<Present> presents;
		Present currentPresent;
		int counter;
		File currentFile;
		
		presents = getAllPresents(client);
		currentPresent = null;
		counter = 0;
		
		for(int i = 0; i < presents.size(); i++) {
			
			currentPresent = presents.get(i);
			
			if(currentPresent.getName().equals(name)) {
				presents.remove(i);
				counter++;
				break;
			}
		}
		
		if(counter == 0) {
			return null;
		}
		
		currentFile = getStrorageFile(client);
		currentFile.delete();
		
		addAllPresents(client, presents);
		
		return currentPresent;
	}
}
