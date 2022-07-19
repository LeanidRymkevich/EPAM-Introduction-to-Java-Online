package by.epam.javaonline.algorithm.onedimentionarray;

import java.util.Arrays;

// Дана последовательность действительных чисел а1 ,а2 ,..., ап.
// Заменить все ее члены, большие данного Z, этим числом.
// Подсчитать количество замен.

public class Task2 {

	public static void main(String[] args) {

		double[] a;
		double z;

		a = new double[] { -10.5, 4, 0.5, 15.3, -4.9, 7.3, -2, 11.4 };
		z = -1;

		System.out.printf("Исходная последовательность A[%d] = [ ", a.length);

		for (double num : a) {
			System.out.print(num + " ");
		}
		System.out.println("].");

		int counter;
		counter = 0;

		for (int i = 0; i < a.length; i++) {

			if (a[i] > z) {

				a[i] = z;
				counter++;
			}
		}

		System.out.printf("Полученная последовательность A[%d] = %s.\n"
						+ "Количество замен на число '%.1f': %d.",
						a.length, Arrays.toString(a), z, counter);
	}
}
