package by.epam.javaonline.algorithm.decomposition;

// Написать метод(методы), проверяющий, являются ли данные три числа взаимно простыми

public class Task6 {

	public static void main(String[] args) {

		// целые числа взаимно просты, если их наибольший общий делитель (НОД) равен 1
		
		int a;
		int b;
		int c;
		
		a = 12;
		b = 4;
		c = 6;
		
		if (isMutuallySimple(a,b,c)) {
			System.out.printf("Числа - %d, %d, %d являются взаимно простыми.", a, b, c);
		} else {
			System.out.printf("Числа - %d, %d, %d не являются взаимно простыми.", a, b, c);
		}

	}
	
	
	
	// функция нахождения НОД согласно алгоритму Евклида
	public static int gcd(int a, int b) {

		if (b == 0) { // на случай если одно из чисел 0
			return a;
		} else {

			while (a != 0) {

				// делим большее число на меньшее до тех пока остаток
				// от деления не будет равен 0
				// оставшийся в конце делитель и есть НОД
				if (a < b) {
					int t = a;
					a = b;
					b = t;
				}

				a = a % b;
			}

			return b;
		}
	}
	
	
	// функция нахождения НОД для количества чисел больше 2-х
	// при использовании теоремы о том, что НОД(к) = НОД( НОД(к-1), а(к) )
	public static int gcdForManyNumbers(int...values) {
			
		if (values.length > 1) { 
				
			int gcd = gcd(values[0],values[1]);
				
			for (int i = 2; i < values.length; i++) {
					
				gcd = gcd(gcd, values[i]);
			}
				
			return gcd;
				
		} else {
			return -1;
		}
					
	}
	
	
	// метод определяющий являются ли числа взаимно простыми 
	public static boolean isMutuallySimple(int ...values) {
		
		if (gcdForManyNumbers(values) == 1) {
			return true;
		} else {
			return false;
		}
	}
}
