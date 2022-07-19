package by.epam.javaonline.task4_1_6;

public class Main {

	public static void main(String[] args) {
		
		Time time_1 = new Time();
		Time time_2 = new Time(14,05);
		Time time_3 = new Time(19, 45, 20);
		Time time_4 = new Time(48, 45, 20);
		
		System.out.println("Initial Time objects:");
		System.out.println("1: " + time_1);
		System.out.println("2: " + time_2);
		System.out.println("3: " + time_3);
		System.out.println("4: " + time_4);
		
		time_1.setTime(7, 20, 55);
		time_2.setHours(48);
		time_3.setMinutes(70);
		time_4.setSeconds(85);
		
		System.out.println("\nTime objects changed :");
		System.out.println("1: " + time_1);
		System.out.println("2: " + time_2);
		System.out.println("3: " + time_3);
		System.out.println("4: " + time_4);
		
		time_1.changeHours(22); // +22 hours
		time_2.changeMinutes(-15); // -15 minutes
		time_3.changeSeconds(-40); // -40 seconds 
		time_4.changeTime(true, 6, 15, 20); // +6:15:20
		
		System.out.println("\nTime objects changed again :");
		System.out.println("1: " + time_1);
		System.out.println("2: " + time_2);
		System.out.println("3: " + time_3);
		System.out.println("4: " + time_4);
		
		time_4.changeTime(false, 9, 0, 20); // -9:00:20
		
		System.out.println("\nTime object changed second time :");
		System.out.println("4: " + time_4);
	}

}
