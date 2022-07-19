package by.epam.javaonline.algorithm.sorting;

import java.util.Arrays;

/* Сортировка выбором. Дана последовательность чисел a(1) <= a(2) <=...<= a(n).
 * Требуется переставить элементы так, чтобы они были расположены по убыванию.
 * Для этого в массиве, начиная с первого, выбирается наибольший элемент и ставится
 * на первое место, а первый - на место наибольшего. Затем, начиная со второго, эта
 * процедура повторяется. Написать алгоритм сортировки выбором.
*/

public class Task3 {

	public static void main(String[] args) {
		
		int[] a;
		
		a = new int[] {-2, 0, 5, 9, 12, 21};
		
		System.out.printf("Исходный массив a[%d] = %s.\n", a.length, Arrays.toString(a));
		
		int max;
		for(int i = 0; i < a.length; i++) {
			
			max = i;
			for(int j = i; j < a.length; j++) {
				
				if(a[j] > a[max]) {
					max = j;
				}
			}
			
			int temp = a[i];
			a[i] = a[max];
			a[max] = temp;
		}
		
		System.out.printf("Отсортированный массив MaxToMin[%d] = %s.\n", a.length, Arrays.toString(a));
	}

}
