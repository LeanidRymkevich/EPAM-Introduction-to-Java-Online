package by.epam.javaonline.algorithm.decomposition;

// Написать метод(методы) для вычисления суммы факториалов всех нечетных чисел от 1 до 9

public class Task7 {

	public static void main(String[] args) {
		
		System.out.println("sum = " + factorialSum());
	}
	
	
	// метод вычисления факториала числа
	public static int factorial(int num){
		
		int result = 1;
		
		for (int i = 1; i <= num; i++) {
			result *= i;
		}
		return result;
	}
	
	
	// метод подсчета суммы факториалов всех нечетных чисел от 1 до 9
	public static int factorialSum() {
		
		int sum = 0;
		
		for (int i = 1; i <= 9; i++) {
			
			if (i % 2 == 0) {
				sum += factorial(i);
			}
		}
		return sum;
	}
}
