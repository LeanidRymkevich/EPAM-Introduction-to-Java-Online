package by.epam.javaonline.task5_4.view;

import java.util.List;

import by.epam.javaonline.task5_4.entity.Dragon;
import by.epam.javaonline.task5_4.entity.Treasure;
import by.epam.javaonline.task5_4.logic.LogicException;

public class View {
	
	public View() {}
	
	public void showAllTreasures(Dragon dragon) throws LogicException {
		
		List<Treasure> treasures = dragon.getAllTreasures();
		int counter = 0;
		
		System.out.println("The " + dragon.getName() + "'s treasury:");
		for(Treasure treasure: treasures) {
			counter++;
			System.out.println(counter + "\t" + treasure);
		}
		System.out.println();
	}
	
	public void showMostExpensiveTreasure(Dragon dragon) throws LogicException {
		
		List<Treasure> treasures = dragon.getMostExpensiveTreasures();
		
		if(treasures == null) {
			System.out.println("The " + dragon.getName() + "'s cave is EMPTY!");
		}
		
		System.out.println("The most expensive treasures in the " + dragon.getName() + "'s cave:");
		for(Treasure treasure: treasures) {
			System.out.println("\t" + treasure);
		}
		System.out.println();
	}
	
	public void showTreasuresOnSetSum(Dragon dragon, double lowerBorder, double upperBorder) throws LogicException{
		
		List<Treasure> treasures = dragon.getTreasuresOnSetSum(lowerBorder, upperBorder);
		
		if(treasures == null) {
			System.out.println("The " + dragon.getName() + "'s cave is EMPTY!");
		}
		
		if(treasures.isEmpty()) {
			System.out.println("Treasures on set sum in the " + dragon.getName() + "'s cave has not been found!");
		}
		
		System.out.println("Treasures in the " + dragon.getName() + "'s cave which cost between " 
							+ lowerBorder + " and "+ upperBorder + ":");
		for(Treasure treasure: treasures) {
			System.out.println("\t" + treasure);
		}
		System.out.println();
	}
}
