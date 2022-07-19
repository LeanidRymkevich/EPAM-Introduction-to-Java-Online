package by.epam.javaonline.task5_3.view;

import java.util.List;

import by.epam.javaonline.task5_3.entity.Calendar;
import by.epam.javaonline.task5_3.entity.Calendar.FreeDay;
import by.epam.javaonline.task5_3.entity.Calendar.WorkDay;
import by.epam.javaonline.task5_3.entity.Day;

public class View {
	
	public View() {
		
	}
	
	public void showDay(Day day) {
		 
		if(day.getClass() == WorkDay.class) {
			System.out.printf("[%s %dth %d - %s]\n", day.getMonth(), day.getDate(),
							  day.getYear(), day.getDayOfTheWeek());
		} else if (day.getClass() == FreeDay.class) {
			System.out.printf("[%s %dth %d - %s, %s]\n", ((FreeDay) day).getMonth(), ((FreeDay) day).getDate(),
					((FreeDay) day).getYear(), ((FreeDay) day).getDayOfTheWeek(), ((FreeDay) day).getCause());
		} 
	}
	
	public void showWorkDaysOnly(List<WorkDay> days) {
		
		System.out.println("WORKDAYS ONLY:");
		for(int i = 0; i < days.size(); i++) {
			showDay(days.get(i));
		}
	}
	
	public void showFreeDaysOnly(List<FreeDay> days) {
		
		System.out.println("FREEDAYS ONLY:");
		for(int i = 0; i < days.size(); i++) {
			showDay(days.get(i));
		}
	}
	
	public void showCalendar(Calendar calendar) {
		
		System.out.println("CURRENT CALENDAR:");
		
		if(calendar.getDays().isEmpty()) {
			System.out.println("Calendar is empty");
		}
		
		for(int i = 0; i < calendar.getDays().size(); i++) {
			showDay(calendar.getDays().get(i));
		}
	}
}
