package by.epam.javaonline.algorithm.arayofarray;

// Дана квадратная матрица. Вывести на экран элементы, стоящие на диагонали

public class Task2 {

	public static void main(String[] args) {
		
		int n;
		int[][] a;
		
		n = 5;
		a = new int[n][n];
		
		// заполнение и вывод исходной матрицы
		System.out.printf("Исходная матрица a[%d][%d]: \n", n,n);
		for (int i = 0; i < a.length; i++) {
			
			for(int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) (Math.random()*10);
				System.out.print(a[i][j] + " ");
			}
			
			System.out.println();
		}
		
		// вывод элементов стоящих по диагонали
		System.out.print("Элементы, стоящие по диагонали исходной матрцы: ");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i][i] + " ");
		}
	}
}
