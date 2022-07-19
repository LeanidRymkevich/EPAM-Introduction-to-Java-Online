package by.epam.javaonline.task5_5.builder.impl;

import by.epam.javaonline.task5_5.bean.Wrap;
import by.epam.javaonline.task5_5.builder.WrapBuilder;

public class WrapBuilderImpl implements WrapBuilder {
	
	private String type;
	private double cost;
	private double weight;

	@Override
	public WrapBuilder setType(String type) {
		this.type = type;
		return this;
	}

	@Override
	public WrapBuilder setCost(double cost) {
		this.cost = cost;
		return this;
	}

	@Override
	public WrapBuilder setWeight(double weight) {
		this.weight = weight;
		return this;
	}

	@Override
	public Wrap getResult() {
		return new Wrap(type, cost, weight);
	}

}
