package by.epam.javaonline.algorithm.arayofarray;

// Отсортировать столбцы матрицы по возрастанию и убыванию значений элементов

public class Task13 {

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
		
		for (int j = 0; j < a[0].length; j++) {
			
			for (int i = 0; i < a.length; i++) {
				
				int max = i;
				for (int k = i; k < a.length; k++) {
					if (a[k][j] > a[max][j]) {
						max = k;
					}
				}
				
				int t = a[max][j];
				a[max][j] = a[i][j];
				a[i][j] = t;
				
			}
		}
		
		System.out.println("\nОтсортированые по убыванию столбцы:");
		printArray(a);
		
		for (int j = 0; j < a[0].length; j++) {
			
			for (int i = 0; i < a.length; i++) {
				
				int min = i;
				for (int k = i; k < a.length; k++) {
					if (a[k][j] < a[min][j]) {
						min = k;
					}
				}
				
				int t = a[min][j];
				a[min][j] = a[i][j];
				a[i][j] = t;
				
			}
		}
		
		System.out.println("\nОтсортированыые по возрастанию столбцы:");
		printArray(a);
		

	}
	
	// вместо написания этого метода на протяжении всех задач на массивы массивов
	// можно было бы написать его в одном классе этого пакета и без импорта вызвать статику
	// по имени класса и метода, например Task12.printArray(a); , но так как предполагается
	// что при изучении массивов еще не известно о ООП, будем решать задачу по правилам
	
	public static void printArray(int a[][]) {
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf(" %4d ",a[i][j]);
			}
			System.out.println();
		}
	}	

}
