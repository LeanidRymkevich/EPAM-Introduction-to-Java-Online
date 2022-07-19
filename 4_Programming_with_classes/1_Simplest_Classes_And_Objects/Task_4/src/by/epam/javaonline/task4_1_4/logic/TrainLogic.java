package by.epam.javaonline.task4_1_4.logic;

import by.epam.javaonline.task4_1_4.entity.Train;

public class TrainLogic {
	
	public TrainLogic() {
		
	}
	
	public static String checkStringField(String field) {
		
		if(field == null) {
			return "Undefined";
		}
		
		if(field.isEmpty()) {
			return "Undefined";
		} else {
			return field;
		}
	}
	
	private static int compareByTime(Train first, Train second) {
		
		return DateAndTimeLogic.compare(first.getDipartureTime(), second.getDipartureTime());
	}
	
	public static int compareByTrainNum(Train first, Train second) {
		
		return first.getTrainNum().compareToIgnoreCase(second.getTrainNum());
	}
	
	private static int compareByDestStation(Train first, Train second) {
		
		return first.getDestStation().compareToIgnoreCase(second.getDestStation());
	}
	
	public static int compareByDestAndTime(Train first, Train second) {
		
		if (compareByDestStation(first,second) > 0) {
			return 1;
		} else if (compareByDestStation(first,second) < 0) {
			return -1;
		} else {
			
			if (compareByTime(first, second) > 0) {
				return 1;
			} else if (compareByTime(first, second) < 0) {
				return -1;
			} else {
				return 0;
			}
		}
	}

}
