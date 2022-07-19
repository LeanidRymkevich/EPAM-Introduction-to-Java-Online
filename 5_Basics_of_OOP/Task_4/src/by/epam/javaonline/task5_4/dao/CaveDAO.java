package by.epam.javaonline.task5_4.dao;

import java.io.File;
import java.util.List;

import by.epam.javaonline.task5_4.entity.Dragon;
import by.epam.javaonline.task5_4.entity.Treasure;

public interface CaveDAO {

	/* interface CaveDAO and its realization are presenting 
	 * abilities for work with dragon's cave - txt-file containing
	 * the information about dragon's treasures
	*/
	
	File getCaveFile(Dragon dragon) throws DAOException;
	
	File addTreasuresToCave(Dragon dragon, List<Treasure> treasures) throws DAOException;
	
	List<Treasure> getAllTreasures(Dragon dragon) throws DAOException;
	
	List<Treasure> getMostExpensiveTreasures(Dragon dragon) throws DAOException;
	
	List<Treasure> getTreasuresOnSetSum(Dragon dragon, double lowerBoader, double upperBorder) throws DAOException;
	
	Treasure removeTreasure(Dragon dragon, Treasure removedTreasure, boolean removeAllMatches) throws DAOException;
	
	int isDragonsCaveContain(Dragon dragon, Treasure searchedTreasure) throws DAOException;
	
}
