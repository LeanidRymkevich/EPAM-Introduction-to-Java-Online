package by.epam.javaonline.algorithm.arayofarray;

import java.util.Arrays;
import java.util.Scanner;

/*
 * В числовой матрице поменять местами два столбца любых столбца,
 * т. е. все элементы одного столбца поставить на соответствующие
 * им позиции другого, а его элементы второго переместить в первый.
 * Номера столбцов вводит пользователь с клавиатуры.
*/

public class Task8 {

	public static void main(String[] args) {
		
		int n; // количество строк матрицы
		int m; // количество столбцов матрицы
		int k_1; // номер первого заменяемого столбца
		int k_2; // номер второго заменяемого столбца
		int[][] a;
		
		n = 4;
		m = 5;
		a = createAndFill(n,m);
		
		System.out.printf("Исходная матрица a[%d][%d]: \n", n, m);
		printArray(a);
		
		k_1 = enterNumber("Номер 1-го заменяемого столбца начиная с 1") - 1;
		k_2 = enterNumber("Номер 2-го заменяемого столбца начиная с 1") - 1;
		
		// замена столбцов
		for (int i = 0; i < a.length; i++) {
			
			int t = a[i][k_1];
			a[i][k_1] = a[i][k_2];
			a[i][k_2] = t;
		}
		
		System.out.printf("Итоговая матрица a[%d][%d]: \n", n, m);
		printArray(a);

	}
	
	@SuppressWarnings("resource")
	public static int enterNumber(String massage) {
		
		int num;
		Scanner sc;
		
		sc = new Scanner(System.in);

		System.out.print(massage + " >> ");

		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print("Введено не целое число число. Введите целое число >> ");
		}
		
		num = sc.nextInt();
		
		while (num <= 0) {
			
			System.out.print("Введено отрицательное целое число. Введите положительное целое число >> ");
			while (!sc.hasNextInt()) {
				sc.next();
				System.out.print("Введено не целое число число. Введите целое число >> ");
			}
			num = sc.nextInt();
		}
		return num;
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
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
	}
}
