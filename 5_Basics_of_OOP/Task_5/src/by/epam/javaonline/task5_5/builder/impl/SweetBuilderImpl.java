package by.epam.javaonline.task5_5.builder.impl;

import by.epam.javaonline.task5_5.builder.SweetBuilder;

public abstract class SweetBuilderImpl implements SweetBuilder{

	private String name;
	private double cost;
	private double weight;
	
	@Override
	public SweetBuilder setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public SweetBuilder setCost(double cost) {
		this.cost = cost;
		return this;
	}

	@Override
	public SweetBuilder setWeight(double weight) {
		this.weight = weight;
		return this;
	}

	public String getName() {
		return name;
	}

	public double getCost() {
		return cost;
	}

	public double getWeight() {
		return weight;
	}
}
