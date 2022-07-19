package by.epam.javaonline.task5_4.entity;

import java.io.Serializable;
import java.util.Objects;

public class Ring extends Treasure implements Serializable{
	
	private static final long serialVersionUID = -4960213609644446914L;

	private static final String NAME = "Ring";
	
	private double diameter;
	private String material;

	public Ring() {
		
	}
	
	public Ring(double cost) {
		super(NAME, cost);
	}
	
	public Ring(double cost,double diameter, String material) {
		super(NAME, cost);
		this.diameter = diameter;
		this.material = material;
	}

	public double getDiameter() {
		return diameter;
	}

	public String getMaterial() {
		return material;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(diameter, material);
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
		Ring other = (Ring) obj;
		return Double.doubleToLongBits(diameter) == Double.doubleToLongBits(other.diameter)
				&& Objects.equals(material, other.material);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + getName() + ", cost=" + getCost() + ", diameter=" + diameter + ", material=" + material + "]";
	}
}
