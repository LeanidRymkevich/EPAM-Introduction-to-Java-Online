package by.epam.javaonline.task5_5.builder.impl;

import by.epam.javaonline.task5_5.bean.Candy;
import by.epam.javaonline.task5_5.builder.CandyBuilder;

public class CandyBuilderImpl extends SweetBuilderImpl implements CandyBuilder{

	@Override
	public Candy getResult() {
		return new Candy(getName(), getCost(), getWeight());
	}

	
}
