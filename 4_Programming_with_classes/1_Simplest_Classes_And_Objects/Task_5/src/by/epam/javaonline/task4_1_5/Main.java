package by.epam.javaonline.task4_1_5;

public class Main {
	
	public static void main(String[] args) {
		
		Counter counter_1 = new Counter();
		Counter counter_2 = new Counter(10, 50, 20);
		Counter counter_3 = new Counter();
		
		counter_3.randomInit();
		
		System.out.println("Initial counters:");
		System.out.println("1: " + counter_1);
		System.out.println("2: " + counter_2);
		System.out.println("3: " + counter_3);
		
		for (int i = 1; i <= 60; i++) {
			
			counter_1.increase();
			counter_2.increase();
			counter_3.increase();
		}
		
		System.out.println("\nIncreased counters:");
		System.out.println("1: " + counter_1);
		System.out.println("2: " + counter_2);
		System.out.println("3: " + counter_3);
		
		for (int i = 1; i <= 30; i++) {
			
			counter_1.decrease();
			counter_2.decrease();
			counter_3.decrease();
		}
		
		System.out.println("\nDecreased counters:");
		System.out.println("1: " + counter_1);
		System.out.println("2: " + counter_2);
		System.out.println("3: " + counter_3);
	}
}
