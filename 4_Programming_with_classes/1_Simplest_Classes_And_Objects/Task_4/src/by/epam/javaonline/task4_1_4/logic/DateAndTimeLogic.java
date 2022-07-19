package by.epam.javaonline.task4_1_4.logic;

import by.epam.javaonline.task4_1_4.entity.DateAndTime;

public class DateAndTimeLogic {
	
	public DateAndTimeLogic() {
		
	}
	
	private static final int currentYear = 2022;
	private static final int maxYear = 2099;
	private static final String[] months = {"January",
											"February",
											"March",
											"April",
											"May",
											"June",
											"July",
											"August",
											"September",
											"October",
											"December"};
	
	private static final String[] daysOfWeek = {"Monday",
												"Tuesday",
												"Wednesday",
												"Thursday",
												"Friday",
												"Saturday",
												"Sunday",};
	
	public static int checkYear(int year) {
		
		if(year >= currentYear && year <= maxYear) {
			return year;
		} else {
			return currentYear;
		}
	}
	
	public static String checkMonth(String month) {
		
		boolean isCorrectMonth = false;
		
		for(String mon: months) {
			if(mon.equalsIgnoreCase(month)) {
				isCorrectMonth = true;
				break;
			}
		}
		
		if(isCorrectMonth) {
			return month;
		} else {
			return "January";
		}
	}
	
	public static int checkDate(int date, int year, String month) {
		
		if (month.equalsIgnoreCase("February")) {
			
			if (isLeapYear(year)) {
				
				if(date >=1 && date <= 29) {
					return date;
				} else {
					return 1;
				}
				
			} else {
				
				if(date >=1 && date <= 28) {
					return date;
				} else {
					return 1;
				}
			}
			
		} else if(month.equalsIgnoreCase("January") ||
				  month.equalsIgnoreCase("March") ||
				  month.equalsIgnoreCase("May") ||
				  month.equalsIgnoreCase("July") ||
				  month.equalsIgnoreCase("August") || 
				  month.equalsIgnoreCase("October") ||
				  month.equalsIgnoreCase("December")){
			
			if(date >=1 && date <= 31) {
				return date;
			} else {
				return 1;
			}
			
		} else {
			
			if(date >=1 && date <= 30) {
				return date;
			} else {
				return 1;
			}
		}
		
	}
	
	public static String checkDayOfWeek(String dayOfWeek) {
		
		boolean isWeekDay = false;
		
		for(String weekDay: daysOfWeek) {
			if(dayOfWeek.equalsIgnoreCase(weekDay)) {
				isWeekDay = true;
				break;
			}
		}
		
		if(isWeekDay) {
			return dayOfWeek;
		} else {
			return "Monday";
		}
	}
	
	public static int checkHours(int hours) {
		
		if (hours >=0 && hours <= 23) {
			return hours;
		} else if (hours < 0) {
			return 0;
		} else {
			return hours % 24;
		}
	}
	
	public static int checkMinutes(int minutes) {
		
		if (minutes >=0 && minutes <= 59) {
			return minutes;
		} else if (minutes < 0) {
			return 0;
		} else {
			return minutes % 60;
		}
	}
	
	private static boolean isLeapYear(int year) {
		
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
	
	// weekday search for 21th century
	public static String findWeekDay(int date, int year, String month) {
		
		int[] monthIndexes = {1,4,4,0,2,5,0,3,6,1,4,6};
		int monthIndex;
		int weekDay;
		int centuryIndex = 6; // for years in 21th century
		int leapYearIndex = 0;
		int twoLastDigitOfYear = year % 1000;
		int yearIndex;
		String[] daysOfWeek = {
				"Saturday",
				"Sunday",
				"Monday",
				"Tuesday",
				"Wednesday",
				"Thursday",
				"Friday"};
		
		int monthNum = findMonthNum(month);
		monthIndex = monthIndexes[monthNum];
		
		yearIndex = (centuryIndex + twoLastDigitOfYear + twoLastDigitOfYear / 4) % 7;
		
		if(isLeapYear(year)) {
			if (month.equalsIgnoreCase("January") || month.equalsIgnoreCase("February")) {
				leapYearIndex = 1;
			}
		} else {
			leapYearIndex = 0;
		}
		
		weekDay = (date + monthIndex + yearIndex - leapYearIndex) % 7;
		
		return daysOfWeek[weekDay];
	}
	
	public static int compare(DateAndTime first, DateAndTime second) {
		
		if (first.getYear() > second.getYear()) {
			return 1;
		} else if(first.getYear() < second.getYear()) {
			return -1;
		} else {
			
			int firstMonth = findMonthNum(first.getMonth());
			int secondMonth = findMonthNum(second.getMonth());
			
			if(firstMonth > secondMonth) {
				return 1;
			} else if(firstMonth < secondMonth) {
				return -1;
			} else {
				
				if(first.getDate() > second.getDate()) {
					return 1;
				} else if(first.getDate() < second.getDate()) {
					return -1;
				} else {
					
					if(first.getHours() > second.getHours()) {
						return 1;
					} else if (first.getHours() < second.getHours()) {
						return -1;
					} else {
						
						if(first.getMinutes() > second.getMinutes()) {
							return 1;
						} else if (first.getMinutes() < second.getMinutes()) {
							return -1;
						} else {
							return 0;
						}
					}
				}
			}
		}
	}
	
	private static int findMonthNum(String month) {
		
		int monthNum = 0;
		for (int i = 0; i < months.length; i++) {
			if(month.equalsIgnoreCase(months[i])) {
				monthNum = i;
			}
		}
		return monthNum;
	}
}
