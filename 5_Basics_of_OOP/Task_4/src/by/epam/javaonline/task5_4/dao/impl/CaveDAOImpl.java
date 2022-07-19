package by.epam.javaonline.task5_4.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.epam.javaonline.task5_4.dao.*;
import by.epam.javaonline.task5_4.entity.Dragon;
import by.epam.javaonline.task5_4.entity.Treasure;

public class CaveDAOImpl implements CaveDAO{

	private final String DEFAULT_PATH;
	private final TreasureCreator creator;
	
	public CaveDAOImpl() {}
	
	{
		DEFAULT_PATH = new StringBuilder(new File("").getAbsolutePath()).
				  			append("\\source\\").toString();
		
		creator = new TreasureCreatorImpl();
	}

	@Override
	public File getCaveFile(Dragon dragon) throws DAOException{
		
		String searchFile = dragon.getName()+"'s cave" + ".txt";
		File file = new File(DEFAULT_PATH + searchFile);
		
		if(file.exists()) {
			return file;
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				throw new DAOException(e);
			}
			return file;
		}
	}

	@Override
	public File addTreasuresToCave(Dragon dragon, List<Treasure> treasures) throws DAOException {
		
		File cave = getCaveFile(dragon);
		
		try(FileWriter stream = new FileWriter(cave, true)) {
			
			for(Treasure treasure : treasures) {
				stream.write(treasure.toString() + "\n");
			}
			
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}
		return cave;
	}

	@Override
	public List<Treasure> getAllTreasures(Dragon dragon) throws DAOException {
		
		File cave;
		List<Treasure> treasures;
		String line;
		Treasure treasure;
		
		cave = getCaveFile(dragon);
		treasures= new ArrayList<>();
		line = null;
		treasure = null;
		
		try(FileReader str = new FileReader(cave);
				BufferedReader stream = new BufferedReader(str)) {
			
			for(;;) {				
				line = stream.readLine();
				if(line != null) {
					treasure = creator.createTreasure(line);
					treasures.add(treasure);
				} else {
					break;
				}
			}
			
		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}
		
		if(treasures.isEmpty()) {
			return null;
		} else {
			return treasures;
		}
	}

	@Override
	public List<Treasure> getMostExpensiveTreasures(Dragon dragon) throws DAOException {
		
		List<Treasure> treasures;
		List<Treasure> mostExpensiveTreasures;
		Treasure mostExpensive;
		
		treasures = getAllTreasures(dragon);
		
		if(treasures == null) {
			return null;
		}
		
		mostExpensiveTreasures = new ArrayList<>();
		
		treasures.sort((a,b) -> Double.compare(a.getCost(),b.getCost()));
		mostExpensive = treasures.get(treasures.size() - 1); 
		
		for(int i = 0; i < treasures.size(); i++) {
			
			if(treasures.get(i).getCost() == mostExpensive.getCost()) {
				mostExpensiveTreasures.add(treasures.get(i));
			}
		}
		return mostExpensiveTreasures;
	}

	@Override
	public List<Treasure> getTreasuresOnSetSum(Dragon dragon, double lowerBorder, double upperBorder)
			throws DAOException {
		
		List<Treasure> treasures;
		List<Treasure> result;
		double currentCost;
		Treasure currentTreasure;
		
		treasures = getAllTreasures(dragon);
		
		if(treasures == null) {
			return null;
		}
		
		result = new ArrayList<>();
		currentCost = 0;
		currentTreasure = null;
		
		for(int i = 0; i < treasures.size(); i++) {
			
			currentTreasure = treasures.get(i);
			currentCost = treasures.get(i).getCost();
			
			if( currentCost >= lowerBorder && currentCost <= upperBorder) {
				result.add(currentTreasure);
			}
		}
		return result;
	}

	@Override
	public Treasure removeTreasure(Dragon dragon, Treasure removedTreasure, boolean removeAllMatches)
			throws DAOException {
		// if removeAllMatches == true - all matches are being deleted
		// if removeAllMatches == false - first one only
		
		List<Treasure> treasures;
		Treasure currentTreasure;
		int counter;
		File currentFile;
		
		treasures = getAllTreasures(dragon);
		currentTreasure = null;
		counter = 0;
		
		for(int i = 0; i < treasures.size(); i++) {
			
			currentTreasure = treasures.get(i);
			
			if(currentTreasure.equals(removedTreasure)) {
				treasures.remove(i);
				counter++;
				
				if(removeAllMatches) {
					continue;
				} else {
					break;
				}
			}
		}
		
		if(counter == 0) {
			return null;
		}
		
		currentFile = getCaveFile(dragon);
		currentFile.delete();
		
		addTreasuresToCave(dragon, treasures);
		
		return removedTreasure;
	}

	@Override
	public int isDragonsCaveContain(Dragon dragon, Treasure searchedTreasure) throws DAOException {
		
		// method returns number of matches 
	
		File cave = getCaveFile(dragon);
		int matches = 0;
		
		try(FileReader str = new FileReader(cave);
				BufferedReader stream = new BufferedReader(str)) {
			
			for(;;) {
				String line = stream.readLine();
				if(line != null) {
					if(searchedTreasure.toString().equals(line)) {
						matches++;
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
		return matches;
	}
}
