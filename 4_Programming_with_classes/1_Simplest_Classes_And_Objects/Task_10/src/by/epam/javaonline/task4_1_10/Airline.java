package by.epam.javaonline.task4_1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* 10. Создать класс Airline, спецификация которого приведена ниже. 
 * Определить конструкторы, set- и get- методы и метод toString(). 
 * Создать второй класс, агрегирующий массив типа Airline, с подходящими
 * конструкторами и методами. Задать критерии выбора данных и вывести эти данные на консоль. 
 * Airline: пункт назначения, номер рейса, тип самолета, время вылета, дни недели.
 * Найти и вывести:
 * a) список рейсов для заданного пункта назначения;
 * b) список рейсов для заданного дня недели;
 * c) список рейсов для заданного дня недели, время вылета для которых больше заданного.*/

public class Airline {
	
	private String destination;
	private String flightNumber;
	private String planeType;
	private final List<DayAndTime> depatureTime = new ArrayList<>();
	
	
	{
		destination = "Undefined";
		flightNumber = "Undefined";
		planeType = "Undefined";
	}
	
	public Airline() {
		
	}
	
	public Airline(String destination, String flightNumber, String planeType, DayAndTime...dayTime) {
		
		this.destination = destinationCheck(destination);
		this.flightNumber = flightNumberCheck(flightNumber);
		this.planeType = planeTypeCheck(planeType);
		depatureTime.addAll(Arrays.asList(dayTime));	
	}

	public String getDestination() {
		return destination;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getPlaneType() {
		return planeType;
	}

	public List<DayAndTime> getDepatureTime() {
		return depatureTime;
	}

	public void setDestination(String destination) {
		this.destination = destinationCheck(destination);
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumberCheck(flightNumber);
	}

	public void setPlaneType(String planeType) {
		this.planeType = planeTypeCheck(planeType);
	}
	
	private static String destinationCheck(String destination) {
		String pattern = "[A-Za-z]+((|-|'|\\.| )?[A-Za-z]+)*";
		return DayAndTime.stringCheck(destination, pattern, "Undefined");
	}
	
	private static String flightNumberCheck(String flightNumber) {
		String pattern = "([A-Za-z]|\\d)+((\\\\|\\/|-|\\s)?([A-Za-z]|\\d)+)*";
		return DayAndTime.stringCheck(flightNumber, pattern, "Undefined");
	}
	
	private static String planeTypeCheck(String planeType) {
		String pattern = "([A-Za-z]|\\d)+((\\s|-|)([A-Za-z]|\\d)+)*";
		return DayAndTime.stringCheck(planeType, pattern, "Undefined");
	}

	@Override
	public int hashCode() {
		return Objects.hash(depatureTime, destination, flightNumber, planeType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airline other = (Airline) obj;
		return Objects.equals(depatureTime, other.depatureTime) && Objects.equals(destination, other.destination)
				&& Objects.equals(flightNumber, other.flightNumber) && Objects.equals(planeType, other.planeType);
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [destination=" + destination + ", flightNumber=" + flightNumber + ", planeType=" + planeType
				+ ", depatureTime=" + depatureTime + "]";
	}
}
