package by.epam.javaonline.task5_4.logic;

import java.util.List;

import by.epam.javaonline.task5_4.entity.Dragon;
import by.epam.javaonline.task5_4.entity.Treasure;

public interface DragonLogic {
	
	List<Treasure> addTreasures(Dragon dragon, Treasure...treasures) throws LogicException;
	
	List<Treasure> getAllTreasures(Dragon dragon) throws LogicException;
	
	List<Treasure> getMostExpensiveTreasures(Dragon dragon) throws LogicException;
	
	List<Treasure> getTreasuresOnSetSum(Dragon dragon, double lowerBorder, double upperBorder) throws LogicException;
	
	Treasure removeTreasure(Dragon dragon, Treasure removedTreasure, boolean removeAllMatches) throws LogicException;
	
	int isDragonsCaveContain(Dragon dragon, Treasure searchedTreasure) throws LogicException;
}
