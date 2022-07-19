package by.epam.javaonline.task5_5.dao;

import by.epam.javaonline.task5_5.bean.Sweet;

public interface SweetConverter {

	String sweetToString(Sweet sweet);
	
	Sweet stringToSweet(String line);
}
