package by.epam.javaonline.task5_3.main;

import java.util.List;

import by.epam.javaonline.task5_3.entity.Calendar;
import by.epam.javaonline.task5_3.entity.Calendar.FreeDay;
import by.epam.javaonline.task5_3.entity.Calendar.WorkDay;
import by.epam.javaonline.task5_3.entity.Day;
import by.epam.javaonline.task5_3.entity.FreeDayCause;
import by.epam.javaonline.task5_3.entity.Month;
import by.epam.javaonline.task5_3.logic.CalendarLogic;
import by.epam.javaonline.task5_3.logic.impl.CalendarLogicImpl;
import by.epam.javaonline.task5_3.view.View;

/* Задача 3.
 * Создать класс Календарь с внутренним классом, с помощью объектов которого
 * можно хранить информацию о выходных и праздничных днях.
*/

public class Main {

	public static void main(String[] args) {
		
		Calendar calendar = new Calendar();
		CalendarLogic logic = new CalendarLogicImpl();
		View view = new View();
		
		//______________________________________________
		
		Day day_1 = new Calendar.WorkDay(8, Month.JULY, 2022);
		Calendar.WorkDay day_2 = new Calendar.WorkDay(29, Month.FEBRUARY, 2024);
		Day day_3 = new Calendar.FreeDay(25, Month.DECEMBER, 1993, FreeDayCause.CHRISTMAS);
		Calendar.FreeDay day_4 = new Calendar.FreeDay(9, Month.MAY, 1967, FreeDayCause.VICTORY_DAY);
		
		logic.addWorkDay((WorkDay)day_1, calendar);
		logic.addWorkDay(day_2, calendar);
		logic.addFreeDay((FreeDay) day_3, calendar);
		logic.addFreeDay(day_4, calendar);
		
		logic.addWorkDay(26, Month.APRIL, 1993, calendar);
		logic.addFreeDay(1, Month.JANUARY, 2022, FreeDayCause.NEW_YEAR, calendar);
		logic.addFreeDay(30, Month.OCTOBER, 2022, FreeDayCause.JUST_WEEKEND, calendar);
		
		//_______________________________
		
		view.showCalendar(calendar);

		//________________________________
		
		List<WorkDay> workDaysOnly = logic.getWorkDaysList(calendar);
		List<FreeDay> freeDaysOnly = logic.getFreeDaysList(calendar);
		
		System.out.println();
		view.showWorkDaysOnly(workDaysOnly);
		System.out.println();
		view.showFreeDaysOnly(freeDaysOnly);
		
		//___________________________________
		
		logic.removeDay(1, Month.JANUARY, 2022, calendar);
		logic.removeDay(25, Month.DECEMBER, 1993, calendar);
		
		logic.sortCalendar(calendar);
		
		System.out.println();
		view.showCalendar(calendar);
	}

}
