package by.epam.javaonline.algorithm.onedimentionarray;

import java.util.Arrays;

/* Дана последовательность целых чисел a[1], a[2],... a[n].
 * Образовать новую последовательность, выбросив из исходной те члены,
 * которые равны min(a[1], a[2],... a[n]).
*/

public class Task8 {

	public static void main(String[] args) {

		int[] a = { 1, -3, 2, -3, 3, -3, 4 };

		System.out.printf("Исходный массив a[%d] = %s.\n", a.length, Arrays.toString(a));
		
		// определение минимума
		int min = a[0];
		
		for (int i = 0; i < a.length; i++) {

			if (a[i] < min) {				
				min = a[i];
			}
		}
		
		// определение количества мин. значений
		int counter = 0;
		
		for (int i = 0; i < a.length; i++) {
			
			if ( a[i] == min) {
				counter++;				
			}
			
		}
		
		// создание нового массива или извещение о том, что все члены массива одинаковы
		if (counter == a.length) {
			System.out.println("Последовательность состоит из одикаковых числел!!!");
		}else {
			
			int len;
			int[] b;
			int ind;
			
			len = a.length - counter;
			b = new int[len];
			ind = 0;
			
			for (int i = 0; i < a.length; i++) {
				
				if(a[i] == min) {
					
					continue;
					
				} else {
					
					b[ind] = a[i];
					ind++;
				}
			}
			
			System.out.printf("Значение минимума min = %d; колличество мин.значений counter = %d.\n", min, counter);
			System.out.printf("Полученный массив b[%d] = %s.\n", b.length, Arrays.toString(b));
		}
	} 
}
