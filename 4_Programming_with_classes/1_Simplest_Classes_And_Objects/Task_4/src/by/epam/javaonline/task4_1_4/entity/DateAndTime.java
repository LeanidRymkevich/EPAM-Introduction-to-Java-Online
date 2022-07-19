package by.epam.javaonline.task4_1_4.entity;

import java.util.Objects;

import by.epam.javaonline.task4_1_4.logic.DateAndTimeLogic;

public class DateAndTime {
	
	private int year;
	private String month;
	private int date;
	private String dayOfWeek;
	private int hours;
	private int minutes;
	
	{
		year = 2022;
		month = "January";
		date = 1;
		dayOfWeek = "Monday";
		hours = 0;
		minutes = 0;
	}
	
	public DateAndTime() {
		
	}
	
	public DateAndTime(int hours, int minutes) {
		this.hours = DateAndTimeLogic.checkHours(hours);
		this.minutes = DateAndTimeLogic.checkMinutes(minutes);
	}
	
	public DateAndTime(int year, String month, int date) {
		this.year =  DateAndTimeLogic.checkYear(year);
		this.month = DateAndTimeLogic.checkMonth(month);
		this.date = DateAndTimeLogic.checkDate(date, year, month);
		dayOfWeek = DateAndTimeLogic.findWeekDay(this.date, this.year, this.month);
	}
	
	public DateAndTime(int year, String month, int date, int hours, int minutes) {
		this.year =  DateAndTimeLogic.checkYear(year);
		this.month = DateAndTimeLogic.checkMonth(month);
		this.date = DateAndTimeLogic.checkDate(date, year, month);
		this.hours = DateAndTimeLogic.checkHours(hours);
		this.minutes = DateAndTimeLogic.checkMinutes(minutes);
		dayOfWeek = DateAndTimeLogic.findWeekDay(this.date, this.year, this.month);
	}

	public int getYear() {
		return year;
	}

	public String getMonth() {
		return month;
	}

	public int getDate() {
		return date;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public int getHours() {
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setYear(int year) {
		this.year =  DateAndTimeLogic.checkYear(year);
	}

	public void setMonth(String month) {
		this.month = DateAndTimeLogic.checkMonth(month);
	}

	public void setDate(int date) {
		this.date = DateAndTimeLogic.checkDate(date, year, month);
	}

	public void setHours(int hours) {
		this.hours = DateAndTimeLogic.checkHours(hours);
	}

	public void setMinutes(int minutes) {
		this.minutes = DateAndTimeLogic.checkMinutes(minutes);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(date, dayOfWeek, hours, minutes, month, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateAndTime other = (DateAndTime) obj;
		return date == other.date && Objects.equals(dayOfWeek, other.dayOfWeek) && hours == other.hours
				&& minutes == other.minutes && Objects.equals(month, other.month) && year == other.year;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [year=" + year + ", month=" + month + ", date=" + date + ", dayOfWeek=" + dayOfWeek + ", hours="
				+ hours + ", minutes=" + minutes + "]";
	}
	
	
	
}
