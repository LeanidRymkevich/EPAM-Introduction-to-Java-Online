package by.epam.javaonline.task5_4.entity;

import java.io.Serializable;
import java.util.Objects;

public class Bullion extends Treasure implements Serializable{

	private static final long serialVersionUID = 8025028012745591003L;

	private static final String NAME = "Bullion";
	
	private String material;
	private double weight;
	
	public Bullion() {
	}
	
	public Bullion(double cost) {
		super(NAME, cost);
	}
	
	public Bullion(double cost, String material, double weight) {
		super(NAME, cost);
		this.material = material;
		this.weight = weight;
	}

	public String getMaterial() {
		return material;
	}

	public double getWeight() {
		return weight;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(material, weight);
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
		Bullion other = (Bullion) obj;
		return Objects.equals(material, other.material)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + getName() + ", cost=" + getCost() + ", material=" + material + ", weight=" + weight + "]";
	}
}
