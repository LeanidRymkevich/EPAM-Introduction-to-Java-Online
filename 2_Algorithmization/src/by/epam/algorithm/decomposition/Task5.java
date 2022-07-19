package by.epam.javaonline.algorithm.decomposition;

import java.util.Arrays;

/* Составить программу, которая в массиве A[N] находит второе по величине число
 * (вывести на печать число, которое меньше максимального элемента массива, но
 * больше всех других элементов)*/

public class Task5 {

	public static void main(String[] args) {
		
		int n;
		int[] a;
		int lbom;
		
		n = 8;
		a = fillArray(n);
		lbom = lastButOneMax(a);
		
		System.out.printf("Для массива a[%d] = %s второе по величине число: %d.",
				a.length, Arrays.toString(a), lbom);
	}
	
	
	// метод заполнения массива случайными целыми числами
	public static int[] fillArray(int n) {
		
		int[] a = new int[n];
		
		for (int i = 0; i < a.length; i++) {
			
			a[i] = (int) (Math.random()*201 - 100); // [-100,100]
		}
		
		return a;
	}
	
	
	// метод нахождения второго по величине числа в массиве
	public static int lastButOneMax (int[] a) {
		
		int max = a[0];
		int lbom = a[0];
					
		for (int i = 0; i < a.length; i++) {
			
			if (a[i] > max) {
				lbom = max;
				max = a[i];
			}	
		}	
		return lbom;
	}
}
