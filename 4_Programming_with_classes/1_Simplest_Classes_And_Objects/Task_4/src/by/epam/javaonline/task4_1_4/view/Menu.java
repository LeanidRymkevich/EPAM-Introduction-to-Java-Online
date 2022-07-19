package by.epam.javaonline.task4_1_4.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.epam.javaonline.task4_1_4.entity.Schedule;
import by.epam.javaonline.task4_1_4.entity.Train;
import by.epam.javaonline.task4_1_4.logic.ScheduleLogic;

public class Menu {
	
	private final Schedule schedule = new Schedule();
	
	public Menu() {
		
	}
	
	public void menuInterface() {
		
		menuAppearance();
		int operationNum = enterNumOfOper();
		
		while (operationNum != 0) {
			
			switch(operationNum) {
			
			case 1:
				
				ScheduleView.showSchedule(schedule);
				
				menuAppearance();
				operationNum = enterNumOfOper();
				break;
				
			case 2:
				ScheduleLogic.sortByTrainNum(schedule);
				ScheduleView.showSchedule(schedule);
				
				menuAppearance();
				operationNum = enterNumOfOper();
				break;
				
			case 3:
				
				ScheduleLogic.sortByDestAndTime(schedule);
				ScheduleView.showSchedule(schedule);
				
				menuAppearance();
				operationNum = enterNumOfOper();
				break;
				
			case 4:
				
				System.out.println("CHOOSE FROM AVAILABLE TRAINS:");
				ScheduleView.showTrainNums(schedule);
				
				String trainDesiredNum = enterTrainNum();
				Train trainDesired = ScheduleLogic.findTrainByNum(trainDesiredNum,schedule);
				
				if(trainDesired != null) {
					ScheduleView.showTrain(trainDesired);
				} else {
					System.out.println("The train with this number doesn't exist!!!".toUpperCase());
				}
				
				menuAppearance();
				operationNum = enterNumOfOper();
				break;
			}
		}
		
		System.out.println("\nEND OF APP WORK!");
		
	}
	
	private void menuAppearance() {
		
		System.out.println(" _________________________________________________________________________\n"
						 + "|                WELCOME IN TRAIN SCHEDULE MENU!!!                        |\n"                    
						 + "|                                                                         |\n"
						 + "| FOR BEGINNING YOUR WORK WITH APP CHOOSE APPROPRIATE NUMBER OF OPERATION:|\n"
						 + "|                                                                         |\n"
						 + "| 1 - show schedule of available trains;                                  |\n"
						 + "| 2 - sort schedule on trains number;                                     |\n"
						 + "| 3 - sort schedule on train destination station and depature time;       |\n"
						 + "| 4 - show info about train on its number;                                |\n"
						 + "| 0 - to exit.                                                            |\n"
						 + "|_________________________________________________________________________|");
		System.out.println();
	}
	
	private int enterNumOfOper() {
		
		System.out.print("Enter number of operation >> ");
		
		@SuppressWarnings("resource")
		Scanner enter = new Scanner(System.in);
		String operationNum = enter.nextLine();
		
		for(;;) {
			
			Pattern pattern = Pattern.compile("[0-4]");
			Matcher matcher = pattern.matcher(operationNum);
			if(matcher.find()) {
				return Integer.valueOf(matcher.group());
			} else {
				System.out.print("INCORRECT ENTER!!! Enter correct number of operation >> ");
				operationNum = enter.nextLine();
			}
		}
	}
	
	private String enterTrainNum() {
		
		System.out.print("Enter number of train >> ");
		
		@SuppressWarnings("resource")
		Scanner enter = new Scanner(System.in);
		String trainNum = enter.nextLine();
		
		for(;;) {
			
			Pattern pattern = Pattern.compile("\\b([A-Za-z]|\\d){4}\\b");
			Matcher matcher = pattern.matcher(trainNum);
			
			if(matcher.find()) {
				return matcher.group();
			} else {
				System.out.print("INCORRECT ENTER!!! Enter correct number of train >> ");
				trainNum = enter.nextLine();
			}
		}
	}
}
