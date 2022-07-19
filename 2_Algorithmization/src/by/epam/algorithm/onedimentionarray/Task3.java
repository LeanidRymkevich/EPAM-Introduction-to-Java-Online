package by.epam.javaonline.algorithm.onedimentionarray;

// Дан массив действительных чисел, размерность которого N.
// Подсчитать, сколько в нем отрицательных, положительных и нулевых элементов.

public class Task3 {

	public static void main(String[] args) {

		double[] a;
		int n;
		int poz;
		int neg;
		int zero;
		
		n = 10;
		a = new double[n];
		poz = 0;
		neg = 0;
		zero = 0;
		
		System.out.printf("Исходный массив a[%d] = [ ",  a.length);

		for (int i = 0; i < a.length; i++) {

			a[i] = Math.random() * 100 - 50; // заполнение массива значениями в промежутке [-50;50]
			
			System.out.printf("%.2f ", a[i]);

			if (a[i] > 0) {

				poz++;

			} else if (a[i] < 0) {

				neg++;

			} else {

				zero++;

			}
		}
				
		System.out.printf("].\n"
				+ "В массиве колличество значений:\n"
				+ "положительных - %d; \n"
				+ "отрицательных - %d; \n"
				+ "нулевых - %d.", poz, neg, zero);
	}
}
