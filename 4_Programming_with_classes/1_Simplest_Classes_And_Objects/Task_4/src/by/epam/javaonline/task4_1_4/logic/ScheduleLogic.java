package by.epam.javaonline.task4_1_4.logic;

import by.epam.javaonline.task4_1_4.entity.Schedule;
import by.epam.javaonline.task4_1_4.entity.Train;

public class ScheduleLogic {
	
	public ScheduleLogic() {
		
	}
	
	public static Train findTrainByNum(String trainNum, Schedule schedule) {
		
		Train[] trains = schedule.getTrains();
		
		for(int i = 0; i < trains.length; i++) {
			
			if(trains[i].getTrainNum().equalsIgnoreCase(trainNum)) {
				return trains[i];
			}
		}
		return null;
	}
	
	public static String[] getAvailTrainNums(Schedule schedule) {
		
		int trainsAmount = schedule.getTrainAmount();
		String[] availTrainNums = new String[trainsAmount];
		
		for(int i = 0; i < trainsAmount; i++) {
			availTrainNums[i] = schedule.getTrains()[i].getTrainNum();
		}
		return availTrainNums;
	}
	
	public static void sortByTrainNum(Schedule schedule) {
		
		Train[] trains = schedule.getTrains();
		int min = 0;
		
		for(int i = 0; i < trains.length; i++) {
			
			min = i;
			for (int j = i; j < trains.length; j++) {
								
				if(TrainLogic.compareByTrainNum(trains[j], trains[min]) < 0) {
					min = j;
				}
			}
			swap(trains, min, i);
		}
	}
	
	public static void sortByDestAndTime(Schedule schedule) {
		
		Train[] trains = schedule.getTrains();
		int min = 0;
		
		for(int i = 0; i < trains.length; i++) {
			
			min = i;
			for (int j = i; j < trains.length; j++) {
								
				if(TrainLogic.compareByDestAndTime(trains[j], trains[min]) < 0) {
					min = j;
				}
			}
			swap(trains, min, i);
		}
	}
	
	private static void swap(Train[] trains, int first, int second) {
		
		Train temp = trains[first];
		trains[first] = trains[second];
		trains[second] = temp;
		
	}
}
