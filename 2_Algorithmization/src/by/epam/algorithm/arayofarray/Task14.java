package by.epam.javaonline.algorithm.arayofarray;

import java.util.Arrays;
import java.util.Scanner;

// Сформировать случайную матрицу m x n, состоящую из нулей и единиц,
// причем в каждом столбце число единиц равно номеру столбца

public class Task14 {

	public static void main(String[] args) {
		
		int m;
		int n;
		int[][] a; 
		
		// для решения этой задачи должно быть n >= m, с целью возможности
		// выполнения условия "в каждом столбце число единиц равно номеру столбца"
		
		System.out.println("Для корректной работы программы введите n >= m ");
		
		n = enterNumber("Введиде число строк") ;
		m = enterNumber("Введиде число столбцов");
		while(n < m) {
			System.out.println("Для корректной работы программы должно быть n >= m");
			n = enterNumber("Введиде число строк") ;
			m = enterNumber("Введиде число столбцов");
		}
		
		a = new int[n][m];
		
		for (int j = 0; j < a[0].length; j++) {
			
			for (int i = 0; i <= j; i++) {
				
				// 1-ой заполняется случайный элемент в строке
				int k =(int) Math.round((Math.random() * (a.length - 1)));
				while(a[k][j] == 1) { // если вдруг k-элемент уже занят 1-ой
					k =(int) (int) Math.round((Math.random() * (a.length - 1)));
				}
				
				a[k][j] = 1;
				
			}
		}
		
		System.out.printf("Итоговая матрица a[%d][%d]:\n", a.length, a[0].length);
		printArray(a);
		
	}
	
	
	public static void printArray (int[][] a) {
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}
		
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
}
