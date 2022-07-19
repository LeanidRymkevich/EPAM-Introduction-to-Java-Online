package by.epam.javaonline.algorithm.sorting;

import java.util.Arrays;

/* Сортировка вставками. Дана последовательность чисел a(1), a(2), ..., a(n).
 * Требуется переставить числа в порядке возрастания. Делается это следующим образом.
 * Пусть a(1), a(2), ..., a(n) - упорядоченная последовательность, т. е. 
 * a(1) <= a(2) <=...<= a(n). Берется следующее число a(i+1) и вставляется в
 * последовательность так, чтобы новая последовательность была тоже возрастающей.
 * Процесс производится до тех пор, пока все элементы от i +1 до n не будут перебраны.
 * Примечание. Место помещения очередного элемента в отсортированную часть производить 
 * с помощью двоичного поиска. Двоичный поиск оформить в виде отдельной функции.
*/

public class Task5 {

	public static void main(String[] args) {

		int[] a = { 13, 11, 18, 16, 12, 14 };

		System.out.printf("Исходный массив a[%d] = %s.\n", a.length, Arrays.toString(a));

		for (int i = 1; i < a.length; i++) {

			int buff = a[i]; // вынимаем i-й элемент и запоминаем в буфер
			int ind = binarySearch(a, 0, i, buff); // поиск места вставки

			for (int j = i; j > ind; j--) { // смещение остальных элементов относительно места вставки вправо
				a[j] = a[j - 1];
			}

			a[ind] = buff; // вставка i-го элемента
		}

		System.out.printf("Отсортированный массив a[%d] = %s.\n", a.length, Arrays.toString(a));
	}
	
	
	public static int binarySearch(int[] a, int leftBorder, int rightBorder, int searchElem) {

		while (leftBorder <= rightBorder) {

			int mid = (leftBorder + rightBorder) / 2;
			int midVal = a[mid];

			if (midVal < searchElem) {
				leftBorder = mid + 1;

			} else if (midVal > searchElem) {
				rightBorder = mid - 1;

			} else if (midVal == searchElem) {
				return mid; // нужно либо значение совпадения поиска
			}
		}

		return leftBorder; // либо левая граница
	}

}
