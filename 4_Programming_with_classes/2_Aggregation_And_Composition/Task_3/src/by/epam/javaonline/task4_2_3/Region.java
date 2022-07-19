package by.epam.javaonline.task4_2_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Region {
	
	private String name;
	private City regionCenter;
	private final List<District> districts = new ArrayList<>();
	
	public Region() {
		
	}

	public Region(String name, City regionCenter) {
		this.name = name;
		this.regionCenter = regionCenter;
	}
	
	public Region(String name, City regionCenter, District...districts) {
		this.name = name;
		this.regionCenter = regionCenter;
		this.districts.addAll(Arrays.asList(districts));
	}

	public String getName() {
		return name;
	}

	public City getRegionCenter() {
		return regionCenter;
	}

	public List<District> getDistricts() {
		return districts;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRegionCenter(City regionCenter) {
		this.regionCenter = regionCenter;
	}
	
	public boolean addDistrict(District disctrict) {
		districts.add(disctrict);
		return true;
	}
	
	public boolean removeDistrict(String name) {
		
		for(int i = 0; i < districts.size(); i++) {
			
			if(districts.get(i).getName().equalsIgnoreCase(name)) {
				districts.remove(i);
				return true;
			}
		}
		return false;
	}

	public District getDistrictByName(String name) {

		for(int i = 0; i < districts.size(); i++) {
			
			if(districts.get(i).getName().equalsIgnoreCase(name)) {
				return districts.get(i); 
			}
		}
		return null;
	}
	
	public long getPopulation() {
		
		long sum = 0;
		for(District district: districts) {
			sum += district.getPopulation();
		}
		return sum;
	}
	
	public int getArea() {
		
		int sum = 0;
		for(District district: districts) {
			sum += district.getArea();
		}
		return sum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(districts, name, regionCenter);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Region other = (Region) obj;
		return Objects.equals(districts, other.districts) && Objects.equals(name, other.name)
				&& Objects.equals(regionCenter, other.regionCenter);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + name + ", regionCenter=" + regionCenter + ", districts=" + districts + "]";
	}
	
	
}
