package by.epam.javaonline.algorithm.decomposition;

/* Написать метод(методы) для нахождения наибольшего общего делителя
 * и наименьшего общего кратного двух натуральных чисел:
 * НОК(А,В) = (А * В) / НОД(А,В)
*/

public class Task1 {

	public static void main(String[] args) {
		
		int a = 24;
		int b = 42;
		
		System.out.printf("Для чисел %d и %d НОД равен - %d, НОК равен - %d.",
				a, b, gcd(a,b), lcm(a,b));
	}
	
	// функция нахождения НОД согласно алгоритму Евклида
	public static int gcd(int a, int b) {
		
		if (b == 0){ // на случай если одно из чисел 0
		 	return a;
		 } else {
		 	
			while(a !=0) {
			
				// делим большее число на меньшее до тех пока остаток от деления не будет равен 0
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
	
	
	// функция нахождения НОК
	public static int lcm(int a, int b) {
		
		return a * b / gcd(a,b);
	}

}
