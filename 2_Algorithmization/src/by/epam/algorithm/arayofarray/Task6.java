package by.epam.javaonline.algorithm.arayofarray;

import java.util.Arrays;

/*Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * { 1 1 1 ... 1 1 1}
 * { 0 1 1 ... 1 1 0}
 * { 0 0 1 ... 1 0 0}
 * { .............. }
 * { 0 0 1 ... 1 0 0}
 * { 0 1 1 ... 1 1 0}
 * { 1 1 1 ... 1 1 1}
*/

public class Task6 {

	public static void main(String[] args) {
		
		int n;
		int[][] a;
		
		n = 8;
		a = new int[n][n];
		
		// нулями заполняется по-умолчанию, в цикле заполняем 1-ми
		for (int i = 0; i < a.length; i++) {
			
			if (i < a.length /2) {
				
				for(int j = i; j < a[i].length - i; j++) {
					a[i][j] = 1;
				}
			} else {
				
				for(int j = a[i].length - i - 1; j < i + 1; j++) {
					a[i][j] = 1;
				}
			}
		}
		
		System.out.printf("Получившийся массив a[%d][%d]: \n", n,n);
		printArray(a);
		
		/*
		 * или еще один способ
		 * 
		 * for (int i = 0; i < a.length; i++) {
						
				for(int j = 0; j < a[i].length; j++) {
					
					if ((j >= i && j <= n - 1 - i ) || (j >= n - 1 - i && j <= i)){
						a[i][j] = 1;
					}
					
				}
		    }  
		*/
	}
	
	public static void printArray (int[][] a) {
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
	}
}
