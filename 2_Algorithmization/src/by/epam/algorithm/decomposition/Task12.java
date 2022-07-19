package by.epam.javaonline.algorithm.decomposition;

import java.util.Arrays;

/* Даны натуральные числа К и N. Написать метод(методы) формирования массива А,
 * элементами которого являются числа, сумма цифр которых равна К и которые не большее N
*/

public class Task12 {

	public static void main(String[] args) {
		
		int k;
		int n;
		int[] a;
		
		k = 8;
		n = 100;
		a = getArray(k,n);
		
		System.out.printf("Для заданных k = %d и n = %d итоговый массив равен: a[%d] = %s.",
				k, n, a.length, Arrays.toString(a));
	}
	
	
	// метод подсчета суммы цифр в числе
	public static int numeralSum(int number) {
		
		int sum = 0;
		
		while (number != 0) {
			sum += number % 10;
			number /= 10;
		}
		
		return sum;
	}
	
	// метод создания массива согласно условию
	public static int[] getArray(int k, int n) {
		
		int numberAmount = 0;
		
		// подсчет количества элементов создаваемого массива
        // удовлетворяющих условию
		for (int i = 0; i <= n; i++) {
			
			if (numeralSum(i) == k) {
				 numberAmount++;
			}
		}
		
		int[] array;
		int ind;
		
		array = new int[numberAmount];
		ind = 0;
		
		// заполнение массива элементами удовлетворяющими условию
		for (int i = 0; i <= n; i++) {
			
			if (numeralSum(i) == k) {
				array[ind] = i;
				ind++;
			}
		}
		
		return array;
	}

}
