package by.epam.javaonline.task4_1_4.view;

import by.epam.javaonline.task4_1_4.entity.DateAndTime;
import by.epam.javaonline.task4_1_4.entity.Schedule;
import by.epam.javaonline.task4_1_4.entity.Train;
import by.epam.javaonline.task4_1_4.logic.ScheduleLogic;

public class ScheduleView {
	
	public ScheduleView() {
		
	}
	
	private static final String hat;
	private static final String lowLine;
	
	static {
		
	hat = " __________________________________________________________________________________\n"
		+ "| DESTINATION STATION | TRAIN NUMBER | DEPARTURE TIME                              |\n"
		+ "|                     |              | hh.mm |   Weekday |  Day |   Month   | Year |\n"
		+ "|_____________________|______________|_______|___________|______|___________|______|";
	
	lowLine = 
		  "|_____________________|______________|_______|___________|______|___________|______|";
	}
	
	
	public static void showSchedule(Schedule schedule) {
		
		System.out.println(hat);
		
		for (int i = 0; i < schedule.getTrains().length; i++) {
			
			Train train = schedule.getTrains()[i];
			DateAndTime date = train.getDipartureTime();
			
			System.out.printf("| %19.19s | %12s | %02d.%02d | %9s | %2dth | %9s | %4d |\n",train.getDestStation(),
					train.getTrainNum(),date.getHours(), date.getMinutes(), date.getDayOfWeek(),
					date.getDate(), date.getMonth(), date.getYear());
		}
			
		System.out.println(lowLine);
	}
	
	public static void showTrain(Train train) {
		
		DateAndTime date = train.getDipartureTime();
		
		System.out.println(hat);	
		System.out.printf("| %19.19s | %12s | %02d.%02d | %9s | %2dth | %9s | %4d |\n",train.getDestStation(),
				train.getTrainNum(),date.getHours(), date.getMinutes(), date.getDayOfWeek(),
				date.getDate(), date.getMonth(), date.getYear());
		System.out.println(lowLine);
	}
	
	public static void showTrainNums(Schedule schedule) {
		
		System.out.println(" ______________\n"
						 + "| TRAIN NUMBER |\n"
						 + "|______________|");
		
		String[] numbers = ScheduleLogic.getAvailTrainNums(schedule);
		
		for(String num: numbers) {
			System.out.printf("| %12s |\n", num);
		}
		System.out.println("|______________|");
	}
}
