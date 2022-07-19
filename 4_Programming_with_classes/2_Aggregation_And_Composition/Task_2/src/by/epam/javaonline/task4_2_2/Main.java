package by.epam.javaonline.task4_2_2;

/* 2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель. 
 * Методы: ехать, заправляться, менять колесо, вывести на консоль марку автомобиля.*/

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		
		Engine engine;
		Wheel wheel;
		Wheel[] wheels;
		Car car;
		
		engine = new Engine("Opel 20XE");
		wheel = new Wheel(15);
		wheels = new Wheel[]{wheel,wheel,wheel,wheel};
		car = new Car("Opel Astra", 2022, engine, wheels,20,0);
		
		car.showManufactureMark();
		car.go(150); // 150 kilometers
		car.fillUp(20); // 20 Liters
		car.go(250);
		car.changeWheel(new Wheel(17), 3);
		
		System.out.printf("Car's fuel amount is %d litres.\n", car.getFuelAmount());
		System.out.printf("Car's milage is %d kilometers.\n", car.getMilage());
		System.out.printf("Car's wheels: %s.\n", Arrays.toString(car.getWheels()));
		
	}

}
