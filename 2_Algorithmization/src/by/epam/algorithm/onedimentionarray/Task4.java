package by.epam.javaonline.algorithm.onedimentionarray;

// Даны действительные числа а1 ,а2 ,..., аn.
// Поменять местами наибольший и наименьший элементы.

public class Task4 {

	public static void main(String[] args) {

		double[] a = { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9 };

		int min = 1;
		int max = 1;

		System.out.printf("Исходный массив a[%d] = [ ", a.length);
		for (double num : a) {
			System.out.printf("%.1f ", num);
		}
		System.out.println("].");

		for (int i = 0; i < a.length; i++) {

			if (a[i] > a[max]) {

				max = i;

			} else if (a[i] < a[min]) {

				min = i;
			}
		}

		double t;
		t = a[max];
		a[max] = a[min];
		a[min] = t;

		System.out.printf("Полученный массив a[%d] = [ ", a.length);
		for (double num : a) {
			System.out.printf("%.1f ", num);
		}
		System.out.println("].");

	}
}
