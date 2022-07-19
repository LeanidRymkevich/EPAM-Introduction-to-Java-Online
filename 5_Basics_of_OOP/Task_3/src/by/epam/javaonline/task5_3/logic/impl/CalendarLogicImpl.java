package by.epam.javaonline.task5_3.logic.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import by.epam.javaonline.task5_3.entity.Calendar;
import by.epam.javaonline.task5_3.entity.Calendar.FreeDay;
import by.epam.javaonline.task5_3.entity.Calendar.WorkDay;
import by.epam.javaonline.task5_3.entity.Day;
import by.epam.javaonline.task5_3.entity.FreeDayCause;
import by.epam.javaonline.task5_3.entity.Month;
import by.epam.javaonline.task5_3.logic.CalendarLogic;

public class CalendarLogicImpl implements CalendarLogic {
	
	public CalendarLogicImpl() {
		
	}

	@Override
	public List<FreeDay> getFreeDaysList(Calendar calendar) {
		
		List<FreeDay> freeDays = new ArrayList<>();
		List<Day> days = calendar.getDays();
		int counter = 0;
		
		for(int i = 0; i < days.size(); i++) {
			if(days.get(i).getClass() == FreeDay.class) {
				counter++;
				freeDays.add((FreeDay)days.get(i));
			}
		}
		
		if(counter == 0) {
			return null;
		} else {
			return freeDays;
		}
	}

	@Override
	public List<WorkDay> getWorkDaysList(Calendar calendar) {
		
		List<WorkDay> workDays = new ArrayList<>();
		List<Day> days = calendar.getDays();
		int counter = 0;
		
		for(int i = 0; i < days.size(); i++) {
			if(days.get(i).getClass() == WorkDay.class) {
				counter++;
				workDays.add((WorkDay)days.get(i));
			}
		}
		
		if(counter == 0) {
			return null;
		} else {
			return workDays;
		}
	}

	@Override
	public Calendar sortCalendar(Calendar calendar) {
		
		if(calendar.getDays().size() < 2) {
			return calendar;
		}
		
		Comparator<Day> byYear = (a, b) -> a.getYear() - b.getYear();
		Comparator<Day> byMonth = (a, b) -> a.getMonth().compareTo(b.getMonth());
		Comparator<Day> byDate = (a, b) -> a.getDate() - b.getDate();
		Comparator<Day> resComp = byYear.thenComparing(byMonth).thenComparing(byDate); 
				
		calendar.getDays().sort(resComp);		
		return calendar;
	}

	@Override
	public FreeDay addFreeDay(FreeDay freeDay, Calendar calendar) {
		calendar.getDays().add(freeDay);
		return freeDay;
	}
	
	@Override
	public FreeDay addFreeDay(int date, Month month, int year, Calendar calendar) {
		FreeDay day = new FreeDay(date, month, year);
		addFreeDay(day, calendar);
		return day;
	}
	
	@Override
	public FreeDay addFreeDay(int date, Month month, int year, FreeDayCause cause, Calendar calendar) {
		FreeDay day = new FreeDay(date, month, year, cause);
		addFreeDay(day, calendar);
		return day;
	}

	@Override
	public WorkDay addWorkDay(WorkDay workDay, Calendar calendar) {
		calendar.getDays().add(workDay);
		return null;
	}
	
	@Override
	public WorkDay addWorkDay(int date, Month month, int year, Calendar calendar) {
		WorkDay day = new WorkDay(date, month, year);
		addWorkDay(day, calendar);
		return day;
	}

	@Override
	public Day removeDay(int date, Month month, int year, Calendar calendar) {
		
		List<Day> days = calendar.getDays();
		Day removedDay = getDay(date, month, year, calendar);
		
		if ( removedDay != null){
			days.remove(removedDay);
			return removedDay;
		} else {
			return null;
		}
	}

	@Override
	public Day getDay(int date, Month month, int year, Calendar calendar) {
		
		List<Day> days = calendar.getDays();
		Day searchDay = null;
		
		for(int i = 0; i < days.size(); i++) {
			
			Day day = days.get(i);
			if(day.getYear() == year && day.getMonth().equals(month) && day.getDate() == date) {
				searchDay = day;
			}
		}
		return searchDay;
	}
}
