package by.epam.javaonline.task4_1_4.entity;

import java.util.Objects;

import by.epam.javaonline.task4_1_4.logic.TrainLogic;

/* 4. Создайте класс Train, содержащий поля: название пункта назначения,
 * номер поезда, время отправления. Создайте данные в массив из пяти элементов
 * типа Train, добавьте возможность сортировки элементов массива по номерам поездов.
 * Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
 * Добавьте возможность сортировки массив по пункту назначения, причем поезда с одинаковыми
 * пунктами назначения должны быть упорядочены по времени отправления.*/

public class Train {
	
	private String destStation;
	private String trainNum;
	private DateAndTime dipartureTime;
	
	{
		destStation = "Undefined";
		trainNum = "Undefined";
		dipartureTime = new DateAndTime();
	}
	
	public Train() {
		
	}
	
	public Train(String destStation) {
		this.destStation = TrainLogic.checkStringField(destStation);
 	}
	
	public Train(String destStation, String trainNum) {
		this.destStation = TrainLogic.checkStringField(destStation);
		this.trainNum = TrainLogic.checkStringField(trainNum);
 	}
	
	public Train(String destStation, String trainNum, DateAndTime dipartureTime) {
		this.destStation = TrainLogic.checkStringField(destStation);
		this.trainNum = TrainLogic.checkStringField(trainNum);
		this.dipartureTime = dipartureTime;
 	}

	public String getDestStation() {
		return destStation;
	}

	public String getTrainNum() {
		return trainNum;
	}

	public DateAndTime getDipartureTime() {
		return dipartureTime;
	}

	public void setDestStation(String destStation) {
		this.destStation = TrainLogic.checkStringField(destStation);
	}

	public void setTrainNum(String trainNum) {
		this.trainNum = TrainLogic.checkStringField(trainNum);
	}

	public void setDipartureTime(DateAndTime dipartureTime) {
		this.dipartureTime = dipartureTime;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(destStation, dipartureTime, trainNum);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		return Objects.equals(destStation, other.destStation) && Objects.equals(dipartureTime, other.dipartureTime)
				&& Objects.equals(trainNum, other.trainNum);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [destStation=" + destStation + ", trainNum=" + trainNum + ", dipartureTime=" + dipartureTime
				+ "]";
	}
}
