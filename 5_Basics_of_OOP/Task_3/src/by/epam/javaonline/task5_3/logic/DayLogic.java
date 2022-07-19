package by.epam.javaonline.task5_3.logic;

import by.epam.javaonline.task5_3.entity.DayOfTheWeek;
import by.epam.javaonline.task5_3.entity.Month;

public interface DayLogic {

	int yearVerification(int year);
	
	int dateVerification(int date, Month month, int year);
	
	boolean isLeapYear(int year);
	
	DayOfTheWeek findWeekDay(int date, int year, Month month);
	
}
