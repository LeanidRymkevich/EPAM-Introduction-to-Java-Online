package by.epam.javaonline.algorithm.decomposition;

import java.util.Arrays;

/* Задан массив D. Определить следующие суммы: D[l] + D[2] + D[3];
 * D[3] + D[4] + D[5]; D[4] +D[5] +D[6]. Пояснение. Составить метод(методы)
 * для вычисления суммы трех последовательно расположенных элементов массива
 * с номерами от k до m.*/

public class Task8 {

	public static void main(String[] args) {

		int n;
		int[] d;
		
		n = 8;
		d = fillArray(n);
		
		System.out.printf("Для массива D[%d] = %s искомые суммы равны:\n",
				d.length, Arrays.toString(d));
		System.out.println("D[l] + D[2] + D[3] = " + intervalSum(d, 1, 3));
		System.out.println("D[3] + D[4] + D[5] = " + intervalSum(d, 3, 5));
		System.out.println("D[4] + D[5] + D[6] = " + intervalSum(d, 4, 6));
	}
	
	
	// метод заполнения массива случайными целыми числами
	public static int[] fillArray(int n) {

		int[] a = new int[n];

		for (int i = 0; i < a.length; i++) {

			a[i] = (int) (Math.random() * 201 - 100); // [-100,100]
		}

		return a;
	}

	
	// метод для вычисления суммы трех последовательно расположенных элементов массива
	// с номерами от k до m
	public static int intervalSum(int[] a, int k, int m) {

		int sum = 0;

		for (int i = k; i <= m; i++) {
			sum += a[i];
		}

		return sum;
	}

}
