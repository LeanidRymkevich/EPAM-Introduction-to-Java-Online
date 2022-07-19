package by.epam.javaonline.task4_2_3;

import java.util.Objects;

public class City {

	private String name;
	private long population;
	
	public City() {
		
	}
	
	public City(String name) {
		this.name = name;
	}
	
	public City(String name, long population) {
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public long getPopulation() {
		return population;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, population);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		return Objects.equals(name, other.name) && population == other.population;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + name + ", population=" + population + "]";
	}
	
	
	
}
