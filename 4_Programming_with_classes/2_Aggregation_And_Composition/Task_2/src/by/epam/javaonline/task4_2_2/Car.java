package by.epam.javaonline.task4_2_2;

import java.util.Arrays;
import java.util.Objects;

public class Car {
	
	private String manufactureMark;
	private int manufactureYear;
	private Engine engine;
	private Wheel[] wheels;
	private int fuelAmount;
	private long milage;
	
	private final static int NUMBER_OF_WHEELS = 4;
	
	public Car() {
		
	}
	
	public Car(String manufactureMark) {
		this.manufactureMark = manufactureMark;
	}
	
	public Car(String manufactureMark, int manufactureYear) {
		this.manufactureMark = manufactureMark;
		this.manufactureYear = manufactureYear;
	}
	
	public Car(String manufactureMark, int manufactureYear, Engine engine) {
		this.manufactureMark = manufactureMark;
		this.manufactureYear = manufactureYear;
		this.engine = engine;
	}
	
	public Car(String manufactureMark, int manufactureYear, Engine engine, Wheel[] wheels) {
		this.manufactureMark = manufactureMark;
		this.manufactureYear = manufactureYear;
		this.engine = engine;
		this.wheels = addWheels(wheels);
	}
	
	public Car(String manufactureMark, int manufactureYear, Engine engine, Wheel[] wheels, int fuelAmount) {
		this.manufactureMark = manufactureMark;
		this.manufactureYear = manufactureYear;
		this.engine = engine;
		this.wheels = addWheels(wheels);
		this.fuelAmount = fuelAmount;
	}
	
	public Car(String manufactureMark, int manufactureYear, Engine engine, Wheel[] wheels, int fuelAmount, long milage) {
		this.manufactureMark = manufactureMark;
		this.manufactureYear = manufactureYear;
		this.engine = engine;
		this.wheels = addWheels(wheels);
		this.fuelAmount = fuelAmount;
		this.milage = milage;
	}
	
	public String getManufactureMark() {
		return manufactureMark;
	}

	public int getManufactureYear() {
		return manufactureYear;
	}

	public Engine getEngine() {
		return engine;
	}

	public Wheel[] getWheels() {
		return wheels;
	}

	public int getFuelAmount() {
		return fuelAmount;
	}

	public void setManufactureMark(String manufactureMark) {
		this.manufactureMark = manufactureMark;
	}

	public void setManufactureYear(int manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void setWheels(Wheel[] wheels) {
		this.wheels = wheels;
	}

	public void setFuelAmount(int fuelAmount) {
		this.fuelAmount = fuelAmount;
	}

	public long getMilage() {
		return milage;
	}

	public void setMilage(long milage) {
		this.milage = milage;
	}

	public long go(int distance) {
		milage += distance;
		return milage;
	}
	
	public int fillUp(int amount) {
		fuelAmount += amount;
		return fuelAmount; 
	}
	
	public boolean changeWheel(Wheel newWheel, int numberOfWheel) {
		
		if (numberOfWheel > 4 || numberOfWheel < 1) {
			System.out.println("Error!!!! Wrong number of wheel!!!");
			return false;
		}
		
		numberOfWheel--;
		
		wheels[numberOfWheel] = newWheel;
		return true;
	}
	
	private static Wheel[] addWheels(Wheel[] source) {
		
		Wheel[] result = new Wheel[NUMBER_OF_WHEELS];
		
		if(source.length == 0) {
			return result;
		}
		
		int counter = 0;
		for(int i = 0; i < source.length; i++) {
			
			counter++;
			if (counter > NUMBER_OF_WHEELS) {
				break;
			}
			
			result[i] = source[i];
		}
		return result;
	}
	
	public String showManufactureMark() {
		System.out.println(manufactureMark);
		return manufactureMark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(wheels);
		result = prime * result + Objects.hash(engine, fuelAmount, manufactureMark, manufactureYear, milage);
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
		Car other = (Car) obj;
		return Objects.equals(engine, other.engine) && fuelAmount == other.fuelAmount
				&& Objects.equals(manufactureMark, other.manufactureMark) && manufactureYear == other.manufactureYear
				&& milage == other.milage && Arrays.equals(wheels, other.wheels);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() +  " [manufactureMark=" + manufactureMark + ", manufactureYear=" + manufactureYear + ", engine=" + engine
				+ ", wheels=" + Arrays.toString(wheels) + ", fuelAmount=" + fuelAmount + ", milage=" + milage + "]";
	}
	
	
	
}
