package by.epam.javaonline.task5_5.builder.impl;

import by.epam.javaonline.task5_5.bean.Waffle;
import by.epam.javaonline.task5_5.builder.WaffleBuilder;

public class WaffleBuilderImpl extends SweetBuilderImpl implements WaffleBuilder{

	@Override
	public Waffle getResult() {
		return new Waffle(getName(), getCost(), getWeight());
	}

}
