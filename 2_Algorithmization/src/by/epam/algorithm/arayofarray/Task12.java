package by.epam.javaonline.algorithm.arayofarray;

// Отсортировать строки матрицы по возрастанию и убыванию значений элементов

public class Task12 {

	public static void main(String[] args) {
		
		int[][] a = new int[][] {
			{ 3, 2,-1, 6, 5, 4},
			{ 5, 3,-2, 5, 6,-4},
			{ 1,-5, 6, 4, 2, 3},
			{ 4, 2, 4, 3, 1, 6},
			{ 6,-4, 5,-2, 3, 1},
			{-1, 2, 3, 4, 5,-6}};
			
		System.out.printf("Исходная матрица a[%d][%d]: \n", a.length, a[0].length);
		printArray(a);
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
				
				int max = j;
				for (int k = j; k < a[i].length; k++) {
					if (a[i][k] > a[i][max]) {
						max = k;
					}
				}
				
				int t = a[i][max];
				a[i][max] = a[i][j];
				a[i][j] = t;
				
			}
		}
		
		System.out.println("\nОтсортированые по убыванию строки:");
		printArray(a);
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
				
				int min = j;
				for (int k = j; k < a[i].length; k++) {
					if (a[i][k] < a[i][min]) {
						min = k;
					}
				}
				
				int t = a[i][min];
				a[i][min] = a[i][j];
				a[i][j] = t;
				
			}
		}
		
		System.out.println("\nОтсортированые по возрастанию строки:");
		printArray(a);

	}

	public static void printArray(int a[][]) {
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf(" %3d ",a[i][j]);
			}
			System.out.println();
		}
	}	
}
