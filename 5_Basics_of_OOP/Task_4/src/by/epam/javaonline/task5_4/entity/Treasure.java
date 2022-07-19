package by.epam.javaonline.task5_4.entity;

import java.util.Objects;

public abstract class Treasure {
	
	private String name;
	private double cost;
	
	public Treasure() {
	}
	
	public Treasure(String name) {
		this.name = name;
	}
	
	public Treasure(String name, double cost) {
		this.name = name;
		this.cost = cost;
	}
	
	public String getName() {
		return name;
	}
	public double getCost() {
		return cost;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treasure other = (Treasure) obj;
		return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + getName() + ", cost=" + getCost() + ", name=" + name + ", cost=" + cost + "]";
	}
}
