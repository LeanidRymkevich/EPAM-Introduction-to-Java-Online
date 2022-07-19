package by.epam.javaonline.task5_5.builder.impl;

import by.epam.javaonline.task5_5.bean.Chocolate;
import by.epam.javaonline.task5_5.builder.ChocolateBuilder;

public class ChocolateBuilderImpl extends SweetBuilderImpl implements ChocolateBuilder{

	@Override
	public Chocolate getResult() {
		return new Chocolate(getName(), getCost(), getWeight());
	}

}
