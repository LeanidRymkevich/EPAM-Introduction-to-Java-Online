package by.epam.javaonline.algorithm.arayofarray;

import java.util.Arrays;

/* Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * {1, 2,...,(n-1), n}
 * {n, (n-1),...,2, 1}
 * {.................}
 * {1, 2,...,(n-1), n}
 * {n, (n-1),...,2, 1}
*/


public class Task4 {

	public static void main(String[] args) {
		
		int n;
		int[][] a;
		
		n = 6;
		a = new int[n][n];
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
				
				if (i % 2 == 0) {
					a[i][j] = j + 1;
				} else {
					a[i][j] = a.length - j;
				}
			}
		}
		
		System.out.printf("Получившийся массив a[%d][%d]: \n", n,n);
		printArray(a);
	}
	
	public static void printArray (int[][] a) {
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
	}
}
