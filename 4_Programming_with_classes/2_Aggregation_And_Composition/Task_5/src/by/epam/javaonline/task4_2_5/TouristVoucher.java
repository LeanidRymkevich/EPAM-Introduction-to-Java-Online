package by.epam.javaonline.task4_2_5;

import java.util.Objects;

public class TouristVoucher {

	private String country;
	private String location;
	private TourismType type;
	private Transport transport;
	private Nutrition nutrition;
	private int daysNumber;
	private double cost;
	
	public TouristVoucher() {
		
	}

	public TouristVoucher(String country, String location, TourismType type, Transport transport, Nutrition nutrition, int daysNumber, double cost) {
		this.country = country;
		this.location = location;
		this.type = type;
		this.transport = transport;
		this.nutrition = nutrition;
		this.daysNumber = daysNumber;
		this.cost = cost;
	}

	public String getCountry() {
		return country;
	}

	public String getLocation() {
		return location;
	}

	public TourismType getType() {
		return type;
	}

	public Transport getTransport() {
		return transport;
	}

	public Nutrition getNutrition() {
		return nutrition;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setType(TourismType type) {
		this.type = type;
	}

	public void setTransport(Transport transport) {
		this.transport = transport;
	}

	public void setNutrition(Nutrition nutrition) {
		this.nutrition = nutrition;
	}

	public int getDaysNumber() {
		return daysNumber;
	}

	public void setDaysNumber(int daysNumber) {
		this.daysNumber = daysNumber;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, country, daysNumber, location, nutrition, transport, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TouristVoucher other = (TouristVoucher) obj;
		return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost)
				&& Objects.equals(country, other.country) && daysNumber == other.daysNumber
				&& Objects.equals(location, other.location) && nutrition == other.nutrition
				&& transport == other.transport && type == other.type;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [country=" + country + ", location=" + location + ", type=" + type + ", transport="
				+ transport + ", nutrition=" + nutrition + ", daysNumber=" + daysNumber + ", cost=" + cost + "]";
	}
	
	
	
	
}
