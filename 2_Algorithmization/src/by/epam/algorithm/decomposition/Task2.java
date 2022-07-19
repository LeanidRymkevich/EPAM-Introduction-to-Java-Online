package by.epam.javaonline.algorithm.decomposition;

// Написать метод(методы) для нахождения наибольшего общего делителя четырех натуральных чисел

public class Task2 {

	public static void main(String[] args) {
		
		int a = 12;
		int b = 36;
		int c = 28;
		int d = 16;
		
		System.out.printf("Для чисел {%d, %d, %d, %d} НОД равен - %d.",
				a, b, c, d, gcdForManyNumbers(a, b, c, d));
	}
	
	// функция нахождения НОД для двух чисел по алгоритму Евклида
	public static int euclid(int a, int b) {
		
		// на место аргумента 'a' ставим всегда большее из чисел
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
		}
		
		if (b == 0) { 
			return a;
		} else {
			return euclid (a%b, b); 
		}
	}
	
	
	// функция нахождения НОД для количества чисел больше 2-х
	// при использовании теоремы о том, что НОД(к) = НОД( НОД(к-1), а(к) )
	public static int gcdForManyNumbers(int...values) {
		
		if (values.length > 1) { 
			
			int gcd = euclid(values[0],values[1]);
			
			for (int i = 2; i < values.length; i++) {
				
				gcd = euclid(gcd, values[i]);
			}
			return gcd;
	
		} else {
			return -1;
		}	
	}
}
