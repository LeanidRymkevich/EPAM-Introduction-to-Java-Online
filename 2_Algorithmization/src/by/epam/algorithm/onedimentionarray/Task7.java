package by.epam.javaonline.algorithm.onedimentionarray;

import java.util.Arrays;

// Даны действительные числа a[1] ,a[2]....a[2n].
// Найти max(a[1] + a[2n], a[2] + a[2n -1 ].....,a[n] + a[n+1])

public class Task7 {

	public static void main(String[] args) {

		int n;
		double[] a;

		n = 5;
		a = new double[2 * n];

		for (int i = 0; i < a.length; i++) {

			a[i] = (int) (Math.random() * 20 - 10); // целые числа чтобы легче считать при проверке было

		}

		System.out.printf("Исходный массив a[%d] = %s.\n", a.length, Arrays.toString(a));

		int index;
		double max;

		max = a[0] + a[2 * n - 1];
		index = 0;

		for (int i = 0; i < n; i++) {

			if (a[i] + a[2 * n - i - 1] > max) {

				max = a[i] + a[2 * n - i - 1];
				index = i;
			}
		}

		System.out.printf("Искомый максимум равен: a[%d] + a[%d] = %.1f.", index, (2 * n - index - 1), max);
	}
}
