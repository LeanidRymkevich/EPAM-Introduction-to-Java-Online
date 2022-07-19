package by.epam.javaonline.algorithm.arayofarray;

import java.util.Arrays;

/* Задана матрица неотрицательных чисел.
 * Посчитать сумму элементов в каждом столбце.
 * Определить, какой столбец содержит максимальную сумму.
*/

public class Task9 {

	public static void main(String[] args) {
		
		int[][] a = new int[][] {
			{ 1, 2, 3, 4, 5, 6, 7},
			{ 2, 6, 5, 1, 0, 2, 1},
			{ 0, 3, 2, 8, 4, 7, 0},
			{ 9, 8, 8, 6, 1, 4, 3}};
			
		System.out.printf("Исходная матрица a[%d][%d]: \n", a.length, a[0].length);
		printArray(a);
		System.out.println();
		
		int sum = 0;
		
		for (int j = 0; j < a[0].length; j++) {
			
			int sum_1 = 0;
			
			for (int i = 0; i < a.length; i++) {
				sum_1 += a[i][j]; 
			}
			
			// номера столбцов печатаю начиная с 1, в отличие от начала нумерации элем.массивов
			System.out.printf("Сумма элементов в %d-м столбце равна: %d \n", j + 1, sum_1);
			
			if (sum_1 > sum) {
				sum = sum_1;				
			}
		}
		
		System.out.printf("\nМаксимальная сумма элементов - %d найдена в столбцах №: ", sum);
		
		// цикл на случай если столбцов с одинаковой суммой элементов несколько
		for (int j = 0; j < a[0].length; j++) {
			
			int sum_1 = 0;
			
			for (int i = 0; i < a.length; i++) {
				sum_1 += a[i][j]; 
			}
			
			if (sum_1 == sum) {
				System.out.printf("%d ", j +1 );
			}
		}		
	}
	
	public static void printArray (int[][] a) {
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
	}
}
