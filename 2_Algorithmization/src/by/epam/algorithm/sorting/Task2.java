package by.epam.javaonline.algorithm.sorting;

import java.util.Arrays;

/*
  Даны две последовательности a(1) <= a(2) <=...<= a(n) и b(1) <= b(2) <=...<= b(m).
  Образовать из них новую последовательность чисел так, чтобы она тоже была
  неубывающей. Примечание. Дополнительный массив не использовать. 
*/

public class Task2 {

	public static void main(String[] args) {

		// раз нельзя использовать дополнительный массив кроме исходных а и b
		// то результат выведу в консоль

		int[] a;
		int[] b;

		a = new int[] { -2, 0, 8, 20, 21, 30 };
		b = new int[] { -4, 0, 3, 19, 21 };

		System.out.printf("Исходный массив a[%d] = %s.\n", a.length, Arrays.toString(a));
		System.out.printf("Исходный массив b[%d] = %s.\n", b.length, Arrays.toString(b));

		System.out.printf("Объедененный массив ab[%d] = [ ", a.length + b.length);

		int ind; // начальный индекс минимума
		int min; // начальное значение минимума
		boolean isA = true; // находится ли минимум 2-х массивов в массиве а[]
		int start = 0; // индекс отсчета массива b[], после того как закончится массив а[]

		// для решения задачи представил два массива как один идущие друг за другом
		// и осуществил в них сортировку по возрастанию

		for (int k = 0; k < a.length + b.length; k++) { // цикл перебора воображаемого объединенного массива

			ind = k;

			for (int i = k; i < a.length; i++) { // цикл перебора массива а[] и поиска в нем мин.знач.
				if (a[i] < a[ind]) {
					ind = i;

				}
			}

			// объявление начальных данных на входе в перебор массива b[]
			if (k < a.length) { // в случае если массив а[] не закончен
				min = a[ind];

			} else { // если массив а[] пройден поэлементно полностью
				min = b[k - a.length];
				start = k - a.length;
				ind = k - a.length;
			}

			for (int j = start; j < b.length; j++) {
				if (b[j] < min) {
					ind = j;
					min = b[j];
					isA = false;
				}
			}

			// условный оператор перестановки (сортировки) в воображаемом объединенном
			// массиве
			if (isA && k < a.length) {

				int temp = a[k];
				a[k] = a[ind];
				a[ind] = temp;

			} else if (!isA && k < a.length) {

				int temp = a[k];
				a[k] = b[ind];
				b[ind] = temp;

			} else {

				int temp = b[k - a.length];
				b[k - a.length] = b[ind];
				b[ind] = temp;

			}

		}

		// печать отсортированных массивов один за другим имитируя объединенный массив
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		for (int j = 0; j < b.length; j++) {
			System.out.print(b[j] + " ");
		}

		System.out.println("].");

		// или если все-таки массив с результатом создать можно и это
		// не считается как "дополнительный массив", то

		int[] rez = new int[a.length + b.length];
		int n_a = 0; // начальное значение для перебора индексов массива а
		int n_b = 0; // начальное значение для перебора индексов массива b

		for (int i = 0; i < a.length + b.length; i++) {

			if (i < a.length) {

				rez[i] = a[n_a];
				n_a++;

			} else {

				rez[i] = b[n_b];
				n_b++;
			}
		}

		System.out.printf("\nРезультир. массив rez[%d] = %s.\n", rez.length, Arrays.toString(rez));
	}

}
