package by.epam.javaonline.task5_5.bean;

import java.util.Objects;

public abstract class Sweet {

	private String name;
	private double cost;
	private double weight;
	
	public Sweet() {
		super();
	}
	
	public Sweet(String name, double cost, double weight) {
		super();
		this.name = name;
		this.cost = cost;
		this.weight = weight;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, name, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sweet other = (Sweet) obj;
		return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + name + ", cost=" + cost + ", weight=" + weight + "]";
	}
}
