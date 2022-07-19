package by.epam.javaonline.task5_4.dao.impl;

import by.epam.javaonline.task5_4.dao.TreasureCreator;
import by.epam.javaonline.task5_4.entity.Bullion;
import by.epam.javaonline.task5_4.entity.Coin;
import by.epam.javaonline.task5_4.entity.Gem;
import by.epam.javaonline.task5_4.entity.Ring;
import by.epam.javaonline.task5_4.entity.Treasure;


public class TreasureCreatorImpl  implements TreasureCreator{
	
	// the class containing a method for transforming a string from
	// cave-txt-file to a Treasure object
	
	public TreasureCreatorImpl() {}
	
	@Override
	public Treasure createTreasure(String line) {
		
		String[] strings;
		String subString;
		String className;
		String name;
		String cost;
		String material;
		String currency;
		String weight;
		String diameter;
		
		strings = line.split("\\s+");
		
		className = strings[0];
		
		subString = strings[1].split("=")[1];
		name = subString.substring(0, subString.length() - 1);
		
		subString = strings[2].split("=")[1];
		cost = subString.substring(0, subString.length() - 1);
		
		switch(className) {
		
		case "Bullion":
			
			subString = strings[3].split("=")[1];
			material = subString.substring(0, subString.length() - 1);
			
			subString = strings[4].split("=")[1];
			weight = subString.substring(0, subString.length() - 1);
			
			return new Bullion(Double.valueOf(cost), material, Double.valueOf(weight));
			
		case "Coin":
			
			subString = strings[3].split("=")[1];
			currency = subString.substring(0, subString.length() - 1);
			
			subString = strings[4].split("=")[1];
			material = subString.substring(0, subString.length() - 1);
			
			return new Coin(Double.valueOf(cost), currency, material);
			
		case "Gem":
			
			subString = strings[3].split("=")[1];
			weight = subString.substring(0, subString.length() - 1);
			
			return new Gem(name, Double.valueOf(cost), Double.valueOf(weight));
			
		case "Ring":
			
			subString = strings[3].split("=")[1];
			diameter = subString.substring(0, subString.length() - 1);
			
			subString = strings[4].split("=")[1];
			material = subString.substring(0, subString.length() - 1);
			
			return new Ring(Double.valueOf(cost), Double.valueOf(diameter), material);
			
		default: 
			return null;
		}
	}
}
