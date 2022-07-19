package by.epam.javaonline.task5_4.entity;

import java.io.Serializable;
import java.util.Objects;

public class Gem extends Treasure implements Serializable{

	private static final long serialVersionUID = 6733695869187904386L;

	private double weight;
	
	public Gem() {
	}

	public Gem(String name, double cost) {
		super(name, cost);
	}
	
	public Gem(String name, double cost, double weight) {
		super(name, cost);
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(weight);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gem other = (Gem) obj;
		return Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + getName() + ", cost=" + getCost() + ", weight=" + weight + "]";
	}
}
