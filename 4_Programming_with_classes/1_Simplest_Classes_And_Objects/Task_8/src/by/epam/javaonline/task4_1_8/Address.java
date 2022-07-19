package by.epam.javaonline.task4_1_8;

import java.util.Objects;

public class Address {

	private String country;
	private String city;
	private String street;
	private String houseNum;
	private String flatNum;
	
	{
		country = "Undefined";
		city = "Undefined";
		street = "Undefined";
		houseNum = "Undefined";
		flatNum = "Undefined";
	}
	
	public Address() {
		
	}

	public Address(String country, String city, String street, String houseNum) {
		this.country = countryCheck(country);
		this.city = cityCheck(city);
		this.street = streetCheck(street);
		this.houseNum = houseNumCheck(houseNum);
	}

	public Address(String country, String city, String street, String houseNum, String flatNum) {
		this(country, city, street, houseNum);
		this.flatNum = flatNumCheck(flatNum);
	}

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public String getFlatNum() {
		return flatNum;
	}

	public void setCountry(String country) {
		this.country = countryCheck(country);
	}

	public void setCity(String city) {
		this.city = cityCheck(city);
	}

	public void setStreet(String street) {
		this.street = streetCheck(street);
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNumCheck(houseNum);
	}

	public void setFlatNum(String flatNum) {
		this.flatNum = flatNumCheck(flatNum);
	}

	public static String stringCheck(String line, String pattern, String elseReturn) {
		
		if(line == null || line == "") {
			return elseReturn;
		}
		
		if(line.matches(pattern)) {
			return line;
		} else {
			return elseReturn;
		}
	}
	
	private static String countryCheck(String country) {
		String pattern = "([A-Za-z]+\\s*)+";
		return stringCheck(country, pattern, "Undefined");
	}
	
	private static String cityCheck(String city) {
		String pattern = "([A-Za-z]+\\s*)+";
		return stringCheck(city, pattern, "Undefined");
	}
	
	private static String streetCheck(String street) {
		String pattern = "(\\w|'|\\.|\\s)+";
		return stringCheck(street, pattern, "Undefined");
	}
	
	private static String houseNumCheck(String houseNum) {
		String pattern = "\\d+\\/?\\d*[A-Za-z]?";
		return stringCheck(houseNum, pattern, "Undefined");
	}
	
	private static String flatNumCheck(String flatNum) {
		String pattern = "\\d+\\/?\\d*[A-Za-z]?";
		return stringCheck(flatNum, pattern, "Undefined");
	}

	@Override
	public int hashCode() {
		return Objects.hash(city, country, flatNum, houseNum, street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(flatNum, other.flatNum) && Objects.equals(houseNum, other.houseNum)
				&& Objects.equals(street, other.street);
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [country=" + country + ", city="
				+ city + ", street=" + street + ", houseNum=" + houseNum
				+ ", flatNum=" + flatNum + "]";
	}
}
