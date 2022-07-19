package by.epam.javaonline.algorithm.sorting;

/* Даны дроби p(1)/q(1), p(2)/q(2), ..., p(n)/q(n)
 * (p(i), q(i) - натуральные). Составить программу,
 * которая приводит эти дроби к общему знаменателю и
 * упорядочивает их в порядке возрастания.
*/

public class Task8 {

	public static void main(String[] args) {
		
		int[] p = {3, 7, 5, 2, 4, 8, 1};
		//         =  =  =  =  =  =  =
		int[] q = {4, 8, 7, 3, 5, 9, 2};
		
		int dinom = lcmForArray(q); // общий знаменатель
		
		// приведение числителей к общему знаменателю
		for (int i = 0; i < p.length; i++) {
			p[i] = ( dinom / q[i]) * p[i];	
		}
		
		printFractionArray("Массив дробей приведенных к общему знаменателю", p,dinom);
		
		sorting(p);
		
		System.out.println();
		printFractionArray("Массив отсортированных дробей", p,dinom);
	}
	
	
	// функция нахождения НОК для количества чисел больше 2-х
	// при использовании теоремы о том, что НОК(к) = НОК( НОК(к-1), а(к) )
	public static int lcmForArray(int[] a) {
		
		if (a.length > 1) { // для массивов длинной 2 и больше
			
			int lcm = lcmForTwoNumbers(a[0],a[1]);
			for (int i = 2; i < a.length; i++) {
				
				lcm = lcmForTwoNumbers(lcm,a[i]);
			}
			return lcm;
			
		} else {
			return -1; // иначе возвращаю -1
		}
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
	
	
	// функция нахождения НОК для 2-х чисел с использованием их НОД
	public static int lcmForTwoNumbers(int a, int b) {
		
		return a * b / euclid(a,b);
	}
	
	
	// функция вывода в консоль массива дробей приведенных к общему знаменателю 
	public static void printFractionArray(String message, int[] numerator, int dinomenator) {
		
		System.out.printf("%s fract[%d] = [ ",message, numerator.length);
		for (int i = 0; i < numerator.length; i++) {
			
			System.out.printf("%d/%d ", numerator[i], dinomenator);
		}
		System.out.println("].");
	}
	
	
	// челночная сортировка
	// движемся слева направо, при этом при выполнении перестановки элементов
	// выполняем проверку всех остальных элементов, которые остались позади,
	// не нужно ли повторить перестановку
	public static int[] sorting(int[] a) {
		
		for (int i = 1; i < a.length; i++) {
			
			if (a[i] < a[i - 1]) {
				
				swap(a, i, i - 1);
				
				for (int z = i - 1; z >= 1; z--) {
					
					if (a[z] < a[z - 1]) {
						swap(a, z, z - 1);
					} else {
						break;
					}
				}
			}
		}
		
		return a;
	}
	
	
	// функция перестановки значений в массиве
	public static void swap (int[] a, int first, int second) {
		
		int temp = a[first];
		a[first] = a[second];
		a[second] = temp;
	}

}
