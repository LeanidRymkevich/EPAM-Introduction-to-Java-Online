package by.epam.javaonline.algorithm.arayofarray;

import java.util.Arrays;

/*Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):
 * {  1     1    1... 1  1}
 * {  2     2    2... 2  0}
 * {  3     3... 3    0  0}
 * {......................}
 * {(n-1) (n-1)  0... 0  0}
 * {  n     0    0    0  0}
*/

public class Task5 {

	public static void main(String[] args) {
		
		int n; 
		int[][] a;
		
		n = 8;
		a = new int[n][n];
		
		for (int i = 0; i < a.length; i++) {
			
			// заполняем ячейки массива числами согласно условию,
			// не заполненные ячейки в цикле заполнятся 0-ми по-умолчанию
			for (int j = 0; j < a[i].length - i; j++) {
				a[i][j] = i + 1;
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
