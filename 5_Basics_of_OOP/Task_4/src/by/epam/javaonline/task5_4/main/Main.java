package by.epam.javaonline.task5_4.main;

import by.epam.javaonline.task5_4.entity.Dragon;
import by.epam.javaonline.task5_4.entity.Treasure;
import by.epam.javaonline.task5_4.logic.LogicException;
import by.epam.javaonline.task5_4.utility.RandomCaveFiller;
import by.epam.javaonline.task5_4.view.View;
import by.epam.javaonline.task5_4.utility.SourceFolderCleaner;

/* Задача 4. 
 * Создать консольное приложение, удовлетворяющее следующим требованиям: 
 * • Приложение должно быть объектно-, а не процедурно-ориентированным. 
 * • Каждый класс должен иметь отражающее смысл название и информативный состав.
 * • Наследование должно применяться только тогда, когда это имеет смысл.
 * • При кодировании должны быть использованы соглашения об оформлении кода java code convention.
 * • Классы должны быть грамотно разложены по пакетам.
 * • Консольное меню должно быть минимальным.
 * • Для хранения данных можно использовать файлы.
 * Дракон и его сокровища. Создать программу, позволяющую обрабатывать сведения о 100 сокровищах в пещере дракона.
 * Реализовать возможность просмотра сокровищ, выбора самого дорогого по стоимости сокровища и выбора сокровищ на заданную сумму.
*/

public class Main {
	
	private static final int TASK_NAMBER_OF_TREASURES = 100;

	public static void main(String[] args) {
		
		// the utility SourceFolderCleaner cleans the source folder before running
		// this main class
				
		new SourceFolderCleaner().clean();
				
		//_______________________________________________________________________
		
		// Using off-site utility let us create input massive of treasures for dragon
		
		RandomCaveFiller filler;
		Treasure[] inputData;

		filler = new RandomCaveFiller();
		inputData = filler.createTreasury(TASK_NAMBER_OF_TREASURES);
		
		//__________________________________________________________
		
		Dragon borch;
		String dragonName;
		View view;
		double lowerCostBorder;
		double upperCostBorder;
		
		view = new View();
		dragonName = "BorchThreeJackdaws"; // from The Witcher
		borch = new Dragon(dragonName);
		lowerCostBorder = 120;
		upperCostBorder = 130;
		
		try {
			
			borch.addTreasures(inputData);
			
			view.showAllTreasures(borch);
			view.showMostExpensiveTreasure(borch);
			view.showTreasuresOnSetSum(borch, lowerCostBorder, upperCostBorder);
			
			//________________________________________
			
			Treasure treasure_1 = inputData[0];
			Treasure treasure_2 = inputData[3];
			
			borch.removeTreasure(treasure_1, true); // true - remove all copies too
			borch.removeTreasure(treasure_2, false); // false - remove first match only
			
			view.showAllTreasures(borch);
			
		} catch (LogicException e) {
			System.out.println("Sorry! System failure in program occurred!");
		}
	}
}
