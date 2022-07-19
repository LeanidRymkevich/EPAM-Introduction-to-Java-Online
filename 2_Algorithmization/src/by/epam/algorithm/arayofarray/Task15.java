package by.epam.javaonline.algorithm.arayofarray;

import java.util.Arrays;

// Найдите наибольший элемент матрицы и заменить все нечетные элементы на него

public class Task15 {

	public static void main(String[] args) {
		
		int n;
		int m;
		int[][] a;
		
		n = 6;
		m = 7;
		a = createAndFill(n,m);
		
		System.out.printf("В исходной матрице a[%d][%d]: \n", a.length, a[0].length);
		printArray(a);
		
		// поиск макс. значения матрицы
		
		int max = a[0][0];
		for (int i = 0; i < a.length; i++) {
			
			for(int j = 0; j < a[0].length; j++) {
				
				if(a[i][j] > max) {
					max = a[i][j];
				}
			}
		}
		
		// замена нечетных элементов т.е. a[i][j] % 2 != 0 на max
		
		for (int i = 0; i < a.length; i++) {
			
			for(int j = 0; j < a[0].length; j++) {
				
				if(a[i][j] % 2 != 0) {
					a[i][j] = max;
				}
			}
		}
		
		
		System.out.printf("Максимальное значение элементов: %d.\n", max);
		System.out.println("\nМатрица с замененными нечетными элементами на максимальный:");
		printArray(a);
	}
	
	
	public static int[][] createAndFill(int n, int m){
		
		int[][] a = new int[n][m];
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) (Math.random() * 10); 
			}
		}
		return a;
	}
	
	
	public static void printArray (int[][] a) {
		
		for (int[] array: a) {
			System.out.println(Arrays.toString(array));
		}	
	}
}
