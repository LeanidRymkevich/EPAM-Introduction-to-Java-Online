package by.epam.javaonline.task5_3.entity;

import java.io.Serializable;
import java.util.Objects;

import by.epam.javaonline.task5_3.logic.DayLogic;
import by.epam.javaonline.task5_3.logic.impl.DayLogicImpl;

public class Day implements Serializable{

	private static final long serialVersionUID = 3953268639479114578L;
	
	private final DayLogic dayLogic = new DayLogicImpl();
	
	private int year;
	private Month month;
	private int date;
	private boolean isFreeDay;
	
	public Day() {
		
	}
	
	public Day(int date, Month month, int year) {
		this.year = dayLogic.yearVerification(year);
		this.month = month;
		this.date = dayLogic.dateVerification(date, month, year);
	}

	public int getYear() {
		return year;
	}

	public Month getMonth() {
		return month;
	}

	public int getDate() {
		return date;
	}

	public void setYear(int year) {
		this.year = dayLogic.yearVerification(year);
		this.date = dayLogic.dateVerification(date, month, year);
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public void setDate(int date) {
		this.date = dayLogic.dateVerification(date, month, year);
	}
	
	public DayOfTheWeek getDayOfTheWeek() {
		return dayLogic.findWeekDay(date, year, month);
	}

	public boolean isFreeDay() {
		return isFreeDay;
	}

	public void setFreeDay(boolean isFreeDay) {
		this.isFreeDay = isFreeDay;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, isFreeDay, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Day other = (Day) obj;
		return date == other.date && isFreeDay == other.isFreeDay && month == other.month && year == other.year;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [year=" + year + ", month=" + month + ", date=" + date + ", isFreeDay=" + isFreeDay + "]";
	}
	
	
}
