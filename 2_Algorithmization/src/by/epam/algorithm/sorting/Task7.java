package by.epam.javaonline.algorithm.sorting;

import java.util.Arrays;

/* Пусть даны две неубывающие последовательности действительных чисел
 * a(1) <= a(2) <=...<= a(n) и b(1) <= b(2) <=...<= b(m). Требуется указать
 * те места, на которые нужно вставлять элементы последовательности
 * b(1) <= b(2) <=...<= b(m) в первую последовательность так, чтобы новая
 *  последовательность оставалась возрастающей.
*/

public class Task7 {

	public static void main(String[] args) {
		
		int[] a;
		int[] b;
		
		a = new int[] {2, 7, 11, 13, 18, 23, 32};
		b = new int[] {0, 7, 10, 14};
				
		System.out.printf("Исходный массив a[%d] = %s.\n", a.length, Arrays.toString(a));
		System.out.printf("Исходный массив b[%d] = %s.\n", b.length, Arrays.toString(b));
		System.out.println();
		
		// для определения места вставки воспользовался бинарным поиском
		
		// новый массив хранящий массив 'a' после каждого добавления в него
		// элемента из массива 'b'
		int[] rez = new int[a.length + b.length];
		
		for (int i = 0; i < a.length; i++) { // заполнение элементами массива 'a'
			
			rez[i] = a[i];
		}
				
				
		for(int i = 0; i < b.length; i++) { // перебор элементов массива 'b'
						
			int ind = binarySearch(rez, 0, a.length + i - 1, b[i]); // поиск места вставки
			
			System.out.printf("Для значения массива b[%d] = %d индекс места вставки в массив a[%d] равен %d. \n",
					i, b[i], a.length + i, ind); // печать в консоль места вставки в ТЕКУЩИЙ массив 'a'
			
			
			for (int j = a.length + i; j > ind; j--) { // вставка элемента массива 'b' в ТЕКУЩИЙ массив 'a'
				rez[j] = rez[j-1];
			}
			rez[ind] = b[i];
			
			// печать в консоль ТЕКУЩЕГО массива 'a' после вставки элемента массива 'b' 
			System.out.printf("Получившийся новый массив a[%d] = [ ", a.length + i + 1);
			
			for (int k = 0; k <= a.length + i; k++) {
				System.out.print(rez[k] + " ");
			}
			System.out.println("].\n");
		}
	}
	
	
	public static int binarySearch(int[] mass, int low, int high, int search) {
		
		while (low <= high) {
			
			int mid = (low + high) / 2;
			int midVal = mass[mid];
			
			if (midVal > search) {
				high = mid - 1;
			} else if (midVal < search) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return low;
	}
	
}
