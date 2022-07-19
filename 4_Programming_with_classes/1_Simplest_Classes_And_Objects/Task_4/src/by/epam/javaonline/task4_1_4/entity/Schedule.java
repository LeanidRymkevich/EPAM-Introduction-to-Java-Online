package by.epam.javaonline.task4_1_4.entity;

import java.util.Arrays;
import java.util.Objects;

public class Schedule {
	
	private final int trainAmount = 5;
	private final Train[] trains = new Train[trainAmount];
	
	{
		trains[0] = new Train("Moscow", "672A", new DateAndTime(2022, "July", 26, 14, 5));
		trains[1] = new Train("Moscow", "653A", new DateAndTime(2022, "September", 3, 22, 45));
		trains[2] = new Train("Minsk", "439C", new DateAndTime(2022, "April", 10, 18, 25));
		trains[3] = new Train("Minsk", "462C", new DateAndTime(2022, "April", 10, 07, 25));
		trains[4] = new Train("Warsaw", "189B", new DateAndTime(2024, "February", 29, 13, 00));		
	}
	
	public Schedule() {
		
	}
	
	public int getTrainAmount() {
		return trainAmount;
	}

	public Train[] getTrains() {
		return trains;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(trains);
		result = prime * result + Objects.hash(trainAmount);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		return trainAmount == other.trainAmount && Arrays.equals(trains, other.trains);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [trainAmount=" + trainAmount + ", trains=" + Arrays.toString(trains) + "]";
	}
}
