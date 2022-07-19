package by.epam.javaonline.algorithm.onedimentionarray;

import java.util.Arrays;

/**
 * В массиве целых чисел с количеством элементов n найти наиболее часто
 * встречающееся число. Если таких чисел несколько, то определить наименьшее из
 * них.
 */

public class Task9 {

	public static void main(String[] args) {

		int[] a = { 1, 1, 2, 2, 1, 3, 3, 3, 4, 4 };
		
		boolean isAllEqual;
		int n;
		int ind;
		
		isAllEqual = false;
		n = 0;
		ind = 0;
		
		for(int i = 0; i < a.length; i++) {
			
			int n_1 = 1;
			
			for(int j = i + 1; j < a.length; j++) {
				
				if(a[i] == a[j]) {
					n_1++;
				}
			}
			
			// проверка на то, одинаковы ли все члены массива, если да, то смысла крутить цикл дальше нет
			if (n_1 == a.length) {
				
				isAllEqual = true;
				break;
			}
			
			// определение наибольшего числа повторений
			if (n_1 > n) {
				
				n = n_1;
				ind = i;
				
			}else if(n_1 == n) { // и если чисел встречающихся наиболее часто несколько, то выбор наименьшего из них 
				
				if(a[i] < a[ind]) {
					
					n = n_1;
					ind = i;
				}
			}
		}
		
		System.out.printf("В исходном массиве a[%d] = %s:\n", a.length, Arrays.toString(a));
		if(isAllEqual) {
			System.out.println("Все элементы массива одинаковы!!!");
		}else {
			System.out.printf("Наибольшее колличество повторений - %d, \n"
					+ "Наименьшее из чисел имеющих наибольшее колличество повторений - %d.", n, a[ind]);
		}
	}
}
