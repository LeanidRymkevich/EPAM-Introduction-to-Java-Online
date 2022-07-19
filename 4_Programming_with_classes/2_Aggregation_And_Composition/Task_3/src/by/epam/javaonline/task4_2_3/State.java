package by.epam.javaonline.task4_2_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class State {

	private String name;
	private City capital;
	private final List<Region> regions = new ArrayList<>();
	
	public State() {
		
	}
	
	public State(String name, City capital) {
		this.name = name;
		this.capital = capital;
	}
	
	public State(String name, City capital, Region...regions) {
		this.name = name;
		this.capital = capital;
		this.regions.addAll(Arrays.asList(regions));
	}

	public String getName() {
		return name;
	}

	public City getCapital() {
		return capital;
	}

	public List<Region> getRegions() {
		return regions;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}
	
	public boolean addRegion(Region region) {
		regions.add(region);
		return true;
	}
	
	public boolean removeRegion(String name) {
		
		for(int i = 0; i < regions.size(); i++) {
			
			if(regions.get(i).getName().equalsIgnoreCase(name)) {
				regions.remove(i);
				return true;
			}
		}
		return false;
	}

	public Region getRegionByName(String name) {

		for(int i = 0; i < regions.size(); i++) {
			
			if(regions.get(i).getName().equalsIgnoreCase(name)) {
				return regions.get(i); 
			}
		}
		return null;
	}
	
	public long getPopulation() {
		
		long sum = 0;
		for(Region region: regions) {
			sum += region.getPopulation();
		}
		return sum;
	}
	
	public int getArea() {
		
		int sum = 0;
		for(Region region: regions) {
			sum += region.getArea();
		}
		return sum;
	}
	
	public void showCapital() {
		System.out.println("The capital 0f "+ name + " is " + capital.getName());
	}
	
	public void showRegionNumber() {
		System.out.println("The number of regions in "+ name + " is " + regions.size());
	}
	
	public void showArea() {
		System.out.println("The area of "+ name + " is " + getArea());
	}
	
	public void showRegionCenters() {
		System.out.println("In " + name + " region centers are:");
		for(Region region: regions) {
			System.out.println(region.getRegionCenter().getName());
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(capital, name, regions);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		return Objects.equals(capital, other.capital) && Objects.equals(name, other.name)
				&& Objects.equals(regions, other.regions);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + name + ", capital=" + capital + ", regions=" + regions + "]";
	}
	
	

}
