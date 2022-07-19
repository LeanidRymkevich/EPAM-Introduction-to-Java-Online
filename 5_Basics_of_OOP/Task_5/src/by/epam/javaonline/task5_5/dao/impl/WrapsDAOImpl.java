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

import by.epam.javaonline.task5_5.bean.Wrap;
import by.epam.javaonline.task5_5.dao.DAOException;
import by.epam.javaonline.task5_5.dao.WrapConverter;
import by.epam.javaonline.task5_5.dao.WrapsDAO;

public class WrapsDAOImpl implements WrapsDAO{
	
	private final String stroragePath;
	private final String fileName;
	private final WrapConverter wrapConverter;
	
	{
		fileName = "WrapsStorage.txt";
		
		stroragePath = new StringBuilder(new File("").getAbsolutePath()).
					     append("\\source\\").
					     append(fileName).toString();
		
		wrapConverter = new WrapConverterImpl();
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
	public List<Wrap> getAllWraps() throws DAOException {
		
		File storage;
		List<Wrap> result;
		String line;
		Wrap wrap;
		
		storage = getStrorageFile();
		result = new ArrayList<>();
		line = null;
		wrap = null;
		
		try(FileReader stream = new FileReader(storage);
				BufferedReader reader = new BufferedReader(stream)){
			
			for(;;) {
				
				line = reader.readLine();
				if(line != null) {
					wrap = wrapConverter.stringToWrap(line);
					result.add(wrap);
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
	public List<Wrap> addWraps(List<Wrap> list) throws DAOException {
		
		File storage;
		String line;
		Wrap wrap;
		
		storage = getStrorageFile();
		line = null;
		wrap = null;
		
		try(FileWriter stream = new FileWriter(storage, true);
				PrintWriter writer= new PrintWriter(stream)) {
			
			for(int i = 0; i < list.size(); i++) {
				wrap = list.get(i);
				line = wrapConverter.wrapToString(wrap);
				writer.write(line);
			}
			
		} catch (IOException e) {
			throw new DAOException(e);
		} 
		return list;
	}

	@Override
	public Wrap removeWrap(String type) throws DAOException {
		
		List<Wrap> wraps;
		Wrap currentWrap;
		int counter;
		File currentFile;
		
		wraps = getAllWraps();
		currentWrap = null;
		counter = 0;
		
		for(int i = 0; i < wraps.size(); i++) {
			
			currentWrap = wraps.get(i);
			
			if(currentWrap.getType().equals(type)) {
				wraps.remove(i);
				counter++;
				break;
			}
		}
		
		if(counter == 0) {
			return null;
		}
		
		currentFile = getStrorageFile();
		currentFile.delete();
		addWraps(wraps);
		
		return currentWrap;
	}
}
