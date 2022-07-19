package by.epam.javaonline.algorithm.arayofarray;

/*Найти положительные элементы главной диагонали квадратной матрицы*/

public class Task10 {

	public static void main(String[] args) {
		
		int[][] a = new int[][] {
			{ 1, 2, 3, 4, 5, 6},
			{ 1,-2, 3, 4, 5, 6},
			{ 1, 2, 3, 4, 5, 6},
			{ 1, 2, 3,-4, 5, 6},
			{ 1, 2, 3, 4,-5, 6},
			{ 1, 2, 3, 4, 5, 6}};
			
		System.out.printf("В исходной матрице a[%d][%d]: \n", a.length, a[0].length);
		printArray(a);
		System.out.println("положительные элементы главной диагонали равны: ");
		
		int num = 0;
		for (int i = 0; i < a.length; i++) {
			
			if (a[i][i] > 0) {
				num++;
				System.out.printf("a[%d][%d] = %d \n", i, i, a[i][i]);
			}
		}
		
		if(num == 0) {
			System.out.print("таких элементов нет.");
		}
	}
	
	public static void printArray(int a[][]) {
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf(" %4d ",a[i][j]);
			}
			System.out.println();
		}
	}	
}
