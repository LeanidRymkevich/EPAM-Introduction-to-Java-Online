package by.epam.javaonline.task5_5.builder;

import by.epam.javaonline.task5_5.bean.Candy;

public interface CandyBuilder extends SweetBuilder{
	
	Candy getResult();
}
