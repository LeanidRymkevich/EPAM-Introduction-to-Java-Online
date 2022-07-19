package by.epam.javaonline.task5_5.bean;

import java.io.Serializable;
import java.util.Objects;

public class Wrap implements Serializable{
	
	private static final long serialVersionUID = -1785278989559035792L;
	
	private String type;
	private double cost;
	private double weight;
	
	public Wrap() {
		super();
	}
	
	public Wrap(String type, double cost, double weight) {
		super();
		this.type = type;
		this.cost = cost;
		this.weight = weight;
	}

	public String getType() {
		return type;
	}

	public double getCost() {
		return cost;
	}

	public double getWeight() {
		return weight;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, type, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wrap other = (Wrap) obj;
		return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost) && Objects.equals(type, other.type)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [type=" + type + ", cost=" + cost + ", weight=" + weight + "]";
	}
}
