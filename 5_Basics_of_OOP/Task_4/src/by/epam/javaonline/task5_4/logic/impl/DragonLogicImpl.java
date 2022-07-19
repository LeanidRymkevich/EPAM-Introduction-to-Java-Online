package by.epam.javaonline.task5_4.logic.impl;

import java.util.Arrays;
import java.util.List;

import by.epam.javaonline.task5_4.dao.CaveDAO;
import by.epam.javaonline.task5_4.dao.DAOException;
import by.epam.javaonline.task5_4.dao.DAOProvider;
import by.epam.javaonline.task5_4.entity.Dragon;
import by.epam.javaonline.task5_4.entity.Treasure;
import by.epam.javaonline.task5_4.logic.DragonLogic;
import by.epam.javaonline.task5_4.logic.LogicException;

public class DragonLogicImpl implements DragonLogic{

	private final DAOProvider provider = DAOProvider.getInstance(); 
	private final CaveDAO cave = provider.getCaveDAO();
	
	public DragonLogicImpl() {}

	@Override
	public List<Treasure> addTreasures(Dragon dragon, Treasure...treasures) throws LogicException {
		
		List<Treasure> add = Arrays.asList(treasures);
		
		try {
			cave.addTreasuresToCave(dragon, add);
		} catch (DAOException e) {
			throw new LogicException(e);
		}
		return add;
	}
	
	@Override
	public List<Treasure> getAllTreasures(Dragon dragon) throws LogicException{
		
		List<Treasure> result = null;
		try {
			result =  cave.getAllTreasures(dragon);
		} catch (DAOException e) {
			throw new LogicException(e);
		}
		return result;
	}

	@Override
	public Treasure removeTreasure(Dragon dragon, Treasure removedTreasure, boolean removeAllMatches) throws LogicException{
		
		Treasure result = null;
		try {
			result =  cave.removeTreasure(dragon, removedTreasure, removeAllMatches);
		} catch (DAOException e) {
			throw new LogicException(e);
		}
		return result;
	}


	@Override
	public List<Treasure> getMostExpensiveTreasures(Dragon dragon) throws LogicException{
		
		List<Treasure> result = null;
		try {
			result = cave.getMostExpensiveTreasures(dragon);
		} catch (DAOException e) {
			throw new LogicException(e);
		}
		return result;
	}

	@Override
	public List<Treasure> getTreasuresOnSetSum(Dragon dragon, double lowerBorder, double upperBorder)
			throws LogicException {
		
		List<Treasure> result = null;
		try {
			result = cave.getTreasuresOnSetSum(dragon, lowerBorder, upperBorder);
		} catch (DAOException e) {
			throw new LogicException(e);
		}
		return result;
	}

	@Override
	public int isDragonsCaveContain(Dragon dragon, Treasure searchedTreasure) throws LogicException {
		
		int result = 0;
		try {
			result = cave.isDragonsCaveContain(dragon, searchedTreasure);
		} catch (DAOException e) {
			throw new LogicException(e);
		}
		return result;
	}
}
