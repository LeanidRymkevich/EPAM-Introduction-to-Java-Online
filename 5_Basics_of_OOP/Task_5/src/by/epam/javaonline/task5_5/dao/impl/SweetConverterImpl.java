package by.epam.javaonline.task5_5.dao.impl;

import by.epam.javaonline.task5_5.bean.Candy;
import by.epam.javaonline.task5_5.bean.Chocolate;
import by.epam.javaonline.task5_5.bean.Cookie;
import by.epam.javaonline.task5_5.bean.Sweet;
import by.epam.javaonline.task5_5.bean.Waffle;
import by.epam.javaonline.task5_5.dao.SweetConverter;

public class SweetConverterImpl implements SweetConverter{

	// The object of Sweet-type in the data-file will be presented as a string below:
	// ClassName name="name" cost="cost" weight="weight"\n
	
	@Override
	public String sweetToString(Sweet sweet) {
		
		if(sweet == null) {
			return "null\n";
		}
		
		StringBuilder result = new StringBuilder();
		
		result.append(sweet.getClass().getSimpleName()).
			   append(" name=" + sweet.getName()).
			   append(" cost=" + sweet.getCost()).
			   append(" weight=" + sweet.getWeight()).
			   append("\n");
		return result.toString();
	}

	@Override
	public Sweet stringToSweet(String line) {
		
		if(line.equals("null")) {
			return null;
		}
		
		String[] params;
		String className;
		String name;
		String cost;
		String weight;
		

		params = line.split("\\s+");
		className = params[0];
		name = params[1].split("=")[1];
		cost = params[2].split("=")[1];
		weight = params[3].split("=")[1];
		
		if(className.equals("Candy")) {
			return new Candy(name, Double.valueOf(cost), Double.valueOf(weight));
		} else if(className.equals("Chocolate")) {
			return new Chocolate(name, Double.valueOf(cost), Double.valueOf(weight));
		} else if(className.equals("Cookie")) {
			return new Cookie(name, Double.valueOf(cost), Double.valueOf(weight));
		} else if(className.equals("Waffle")) {
			return new Waffle(name, Double.valueOf(cost), Double.valueOf(weight));		
		} else {
			return null;
		}
	}

}
