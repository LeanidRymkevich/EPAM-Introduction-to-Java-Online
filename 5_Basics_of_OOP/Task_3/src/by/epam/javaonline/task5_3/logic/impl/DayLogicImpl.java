package by.epam.javaonline.task5_3.logic.impl;

import by.epam.javaonline.task5_3.entity.DayOfTheWeek;
import by.epam.javaonline.task5_3.entity.Month;
import by.epam.javaonline.task5_3.logic.DayLogic;

public class DayLogicImpl implements DayLogic {
	
	private final int MIN_YEAR = 1600;
	private final int MAX_YEAR = 2199;
	private final int CURRENT_YEAR = 2022;
	
	public DayLogicImpl() {} 
	
	@Override
	public int yearVerification(int year) {
		if(year >= MIN_YEAR && year <= MAX_YEAR) {
			return year;
		} else {
			return CURRENT_YEAR;
		}
	}
	
	@Override
	public int dateVerification(int date, Month month, int year) {
		
		boolean isLeapYear = isLeapYear(year);
		
		if(isLeapYear) {
			if(date >= 1 && date <= month.getLeapYearDayNum()) {
				return date;
			} else {
				return 1;
			}
		} else {
			if(date >= 1 && date <= month.getNormalYearDayNum()) {
				return date;
			} else {
				return 1;
			}
		}
	}
	
	@Override
	public boolean isLeapYear(int year) {
		
		if (year % 4 == 0) {
			
			if(year % 100 == 0) {
				
				if (year % 400 == 0) {
					return true;
				} else {
					return false;
				}
				
			} else {
				return true;
			}
			
		} else {
			return false;
		}
	}
	
	@Override
	public DayOfTheWeek findWeekDay(int date, int year, Month month) {
		
		enum MonthIndex{
			
			FOR_JANUARY(Month.JANUARY, 1),
			FOR_FEBRUARY(Month.FEBRUARY, 4),
			FOR_MARCH(Month.MARCH, 4),
			FOR_APRIL(Month.APRIL, 0),
			FOR_MAY(Month.MAY, 2),
			FOR_JUNE(Month.JUNE, 5),
			FOR_JULY(Month.JULY, 0),
			FOR_AUGUST(Month.AUGUST, 3),
			FOR_SEPTEMBER(Month.SEPTEMBER, 6),
			FOR_OCTOBER(Month.OCTOBER, 1),
			FOR_NOVEMBER(Month.NOVEMBER, 4),
			FOR_DECEMBER(Month.DECEMBER, 6);
			
			final Month month;
			final int index;
			
			MonthIndex(Month month, int index){
				this.month = month;
				this.index = index;
			}
		}
		
		enum CenturyIndex{
			C_16TH(16,6),
			C_17TH(17,4),
			C_18TH(18,2),
			C_19TH(19,0),
			C_20TH(20,6),
			C_21TH(21,4);
			
			final int index;
			final int century;
			
			CenturyIndex(int century, int index){
				this.century = century;
				this.index = index;
			}
		}
	
		int monthIndex = 0;
		int weekDay;
		int centuryIndex = 0;
		int leapYearIndex = 0;
		int twoLastDigitOfYear = year % 1000;
		int yearIndex;
		
		int century = year/100;
		
		for(CenturyIndex cenInd: CenturyIndex.values()) {
			
			if(cenInd.century == century) {
				centuryIndex = cenInd.index;
			}
		}
		
		for(MonthIndex monInd: MonthIndex.values()) {
			
			if(monInd.month.equals(month)) {
				monthIndex = monInd.index;
			}
		}
		
		DayOfTheWeek[] days = { // special order of days for this method
				DayOfTheWeek.SATURDAY,
				DayOfTheWeek.SUNDAY,
				DayOfTheWeek.MONDAY,
				DayOfTheWeek.TUESDAY,
				DayOfTheWeek.WEDNESDAY,
				DayOfTheWeek.THURSDAY,
				DayOfTheWeek.FRIDAY};
		
		yearIndex = (centuryIndex + twoLastDigitOfYear + twoLastDigitOfYear / 4) % 7;
		
		if(isLeapYear(year)) {
			if (month.equals(Month.JANUARY) || month.equals(Month.FEBRUARY)) {
				leapYearIndex = 1;
			}
		} else {
			leapYearIndex = 0;
		}
		
		weekDay = (date + monthIndex + yearIndex - leapYearIndex) % 7;
		
		return days[weekDay];
	}
}
