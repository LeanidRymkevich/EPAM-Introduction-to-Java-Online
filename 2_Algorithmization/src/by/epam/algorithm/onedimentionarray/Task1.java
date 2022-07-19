package by.epam.javaonline.algorithm.onedimentionarray;

import java.util.Arrays;

// В массив A [N] занесены натуральные числа.
// Найти сумму тех элементов, которые кратны данному К

public class Task1 {

	public static void main(String[] args) {

		int[] a;
		int k;
		int sum;
		
		k = 2;
		a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		sum = 0;

		for (int i = 0; i < a.length; i++) {

			if (a[i] % k == 0) {
				sum += a[i];
			}
		}

		System.out.printf("Сумма членов массива А[%d] = %s кратных %d равна: %d", a.length, Arrays.toString(a), k, sum);
	}
}
