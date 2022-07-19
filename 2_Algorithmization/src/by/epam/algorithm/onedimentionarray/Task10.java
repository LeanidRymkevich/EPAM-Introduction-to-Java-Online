package by.epam.javaonline.algorithm.onedimentionarray;

import java.util.Arrays;

/*
 * Дан целочисленный массив с количеством элементов п. 
 * Сжать массив, выбросив из него каждый второй элемент
 * (освободившиеся элементы заполнить нулями).
 * Примечание. Дополнительный массив не использовать.
*/

public class Task10 {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		System.out.printf("Исходный массив a[%d] = %s.\n", a.length, Arrays.toString(a));
		
		// заменяем каждый второй элемент нулем и считаем количество замен
		int counter = 0;
		for (int i = 0; i < a.length; i++) {

			if (i % 2 != 0) {
				a[i] = 0;
				counter++;
			}
		}
		
		// смещаем ненулевые элементы вперед, оставшиеся заменяем нулями
		int n = 0;
		for (int i = 0; i < a.length; i++) {

			if (i < a.length - counter) {
				a[i] = a[n];
				n = n + 2;
			} else {
				a[i] = 0;
			}
		}

		System.out.printf("Сжатый массив aс[%d] = %s.\n", a.length, Arrays.toString(a));
	}
}
