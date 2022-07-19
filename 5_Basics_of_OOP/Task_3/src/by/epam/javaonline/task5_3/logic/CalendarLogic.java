package by.epam.javaonline.task5_3.logic;

import java.util.List;

import by.epam.javaonline.task5_3.entity.Calendar;
import by.epam.javaonline.task5_3.entity.Calendar.FreeDay;
import by.epam.javaonline.task5_3.entity.Calendar.WorkDay;
import by.epam.javaonline.task5_3.entity.Day;
import by.epam.javaonline.task5_3.entity.FreeDayCause;
import by.epam.javaonline.task5_3.entity.Month;

public interface CalendarLogic {

	List<Calendar.FreeDay> getFreeDaysList(Calendar calendar);
	
	List<Calendar.WorkDay> getWorkDaysList(Calendar calendar);
	
	Calendar sortCalendar(Calendar calendar);
	
	FreeDay addFreeDay(FreeDay freeDay, Calendar calendar);
	
	FreeDay addFreeDay(int date, Month month, int year, Calendar calendar);
	
	FreeDay addFreeDay(int date, Month month, int year, FreeDayCause cause, Calendar calendar);
	
	WorkDay addWorkDay(WorkDay workDay, Calendar calendar);
	
	WorkDay addWorkDay(int date, Month month, int year, Calendar calendar);
    
    Day removeDay(int date, Month month, int year, Calendar calendar);
    
    Day getDay(int date, Month month, int year, Calendar calendar);
	
}
