package by.epam.javaonline.algorithm.arayofarray;

import java.util.Scanner;

// Дана матрица. Вывести k-ю строку и p-й столбец матрицы.

public class Task3 {

	public static void main(String[] args) {
		
		int n;
		int m;
		int k;
		int p;
		int[][] a;
		
		n = enterNumber("Введите количество строк матрицы больше 0");
		m = enterNumber("Введите количество столбцов матрицы больше 0");
		k = enterNumber("Номер строки для вывода начиная с 1") - 1;
		p = enterNumber("Номер столбца для вывода начиная с 1") - 1;
		
		a = createAndFill(n, m);
		
		System.out.printf("\nИсходная матрциа a[%d][%d]: \n", n, m);
		printArray(a);
		
		System.out.printf("Печать %d-й строки: { ", k + 1);
		for (int j = 0; j < a[k].length; j++) {
			System.out.print(a[k][j] + " ");
		}
		System.out.print("}.\n");
		
		System.out.printf("Печать %d-й столбца: { ", p + 1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i][p] + " ");
		}
		System.out.print("}.\n");			

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
	
	public static void printArray(int a[][]) {
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}	
}
