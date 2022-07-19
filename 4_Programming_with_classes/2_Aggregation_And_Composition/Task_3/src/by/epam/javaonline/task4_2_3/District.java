package by.epam.javaonline.task4_2_3;

import java.util.Objects;

public class District {

	private String name;
	private City distictCenter;
	private long population;
	private int area;
	
	public District() {
		
	}

	public District(String name, City distictCenter) {
		this.name = name;
		this.distictCenter = distictCenter;
	}
	
	public District(String name, City distictCenter, long population) {
		this.name = name;
		this.distictCenter = distictCenter;
		this.population = population;
	}

	public District(String name, City distictCenter, long population, int area) {
		this.name = name;
		this.distictCenter = distictCenter;
		this.population = population;
		this.area = area;
	}



	public City getDistictCenter() {
		return distictCenter;
	}

	public long getPopulation() {
		return population;
	}

	public int getArea() {
		return area;
	}

	public void setDistictCenter(City distictCenter) {
		this.distictCenter = distictCenter;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(area, distictCenter, name, population);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		District other = (District) obj;
		return area == other.area && Objects.equals(distictCenter, other.distictCenter)
				&& Objects.equals(name, other.name) && population == other.population;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + name + ", distictCenter=" + distictCenter + ", population=" + population + ", area="
				+ area + "]";
	}

	
	
}
