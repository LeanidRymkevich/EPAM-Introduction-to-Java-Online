package by.epam.javaonline.algorithm.onedimentionarray;

import java.util.Arrays;

// Даны целые числа а1 ,а2 ,..., аn.
// Вывести на печать только те числа, для которых аi > i.

public class Task5 {

	public static void main(String[] args) {
		
		int[] a = {9,8,7,6,5,4,3,2,1};
		
		System.out.printf("Исходный массив a[%d] = %s.\n", a.length, Arrays.toString(a));
		
		System.out.print("Из этого массива числа для которых a[i] > i: ");
		
		for (int i = 0; i < a.length; i++) {
			
			if (a[i] > i) {
				System.out.print(a[i] + " ");
			}
		}
		
	}
}
