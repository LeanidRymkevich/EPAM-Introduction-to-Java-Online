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

import by.epam.javaonline.task5_5.bean.Sweet;
import by.epam.javaonline.task5_5.dao.DAOException;
import by.epam.javaonline.task5_5.dao.SweetConverter;
import by.epam.javaonline.task5_5.dao.SweetsDAO;

public class SweetsDAOImpl implements SweetsDAO{
	
	private final String stroragePath;
	private final String fileName;
	private final SweetConverter sweetConverter;
	
	{
		fileName = "SweetsStorage.txt";
		
		stroragePath = new StringBuilder(new File("").getAbsolutePath()).
					     append("\\source\\").
					     append(fileName).toString();
		
		sweetConverter = new SweetConverterImpl();
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
	public List<Sweet> getAllSweets() throws DAOException {
		
		File storage;
		List<Sweet> result;
		String line;
		Sweet sweet;
		
		storage = getStrorageFile();
		result = new ArrayList<>();
		line = null;
		sweet = null;
		
		try(FileReader stream = new FileReader(storage);
				BufferedReader reader = new BufferedReader(stream)){
			
			for(;;) {
				
				line = reader.readLine();
				if(line != null) {
					sweet = sweetConverter.stringToSweet(line);
					result.add(sweet);
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
	public List<Sweet> addSweets(List<Sweet> list) throws DAOException {
		
		File storage;
		String line;
		Sweet sweet;
		
		storage = getStrorageFile();
		line = null;
		sweet = null;
		
		try(FileWriter stream = new FileWriter(storage, true);
				PrintWriter writer= new PrintWriter(stream)) {
			
			for(int i = 0; i < list.size(); i++) {
				sweet = list.get(i);
				line = sweetConverter.sweetToString(sweet);
				writer.write(line);
			}
			
		} catch (IOException e) {
			throw new DAOException(e);
		} 
		return list;
	}

	@Override
	public Sweet removeSweet(String className, String name) throws DAOException {
		
		List<Sweet> sweets;
		Sweet currentSweet;
		int counter;
		File currentFile;
		
		sweets = getAllSweets();
		currentSweet = null;
		counter = 0;
		
		for(int i = 0; i < sweets.size(); i++) {
			
			currentSweet = sweets.get(i);
			
			if(currentSweet.getClass().getSimpleName().equals(className) &&
					currentSweet.getName().equals(name)) {
				sweets.remove(i);
				counter++;
				break;
			}
		}
		
		if(counter == 0) {
			return null;
		}
		
		currentFile = getStrorageFile();
		currentFile.delete();
		addSweets(sweets);
		
		return currentSweet;
	}

}
