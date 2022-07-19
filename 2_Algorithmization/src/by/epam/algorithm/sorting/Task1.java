package by.epam.javaonline.algorithm.sorting;

import java.util.Arrays;

/*
  Заданы два одномерных массива с различным количеством элементов и натуральное число k. Объединить их в
  один массив, включив второй массив между k-м и (k+1) - м элементами первого, при этом не используя
  дополнительный массив.
*/

public class Task1 {

	public static void main(String[] args) {
		
		// раз нельзя использовать дополнительный массив кроме исходных а и b
		// то результат выведу в консоль
		
		int[] a;
		int[] b;
		int k;
		
		a = new int[] {0, 1, 2, 3, 4, 5, 6};
		b = new int[] {7,8,9};
		k = 2;
		
		System.out.printf("Исходный массив a[%d] = %s.\n", a.length, Arrays.toString(a));
		System.out.printf("Исходный массив b[%d] = %s.\n", b.length, Arrays.toString(b));
		
		System.out.printf("Объедененный массив ab[%d] = [ ", a.length + b.length);
		
		for(int i = 0; i < a.length; i++) {
			
			if(i < k || i >= k + 1) {
				System.out.print(a[i] + " ");
			} else {
				
				System.out.print(a[k] + " ");
				
				for (int j = 0; j < b.length; j++) {
					System.out.print(b[j] + " ");
				}
				
			}
		}
		System.out.println("].");
		
		// или если все-таки массив с результатом создать можно и это
		// не считается как "дополнительный массив", то решение код ниже
		
		int[] rez = new int[a.length + b.length];
		int n_a = 0; // начальное значение для перебора индексов массива а
		int n_b = 0; // начальное значение для перебора индексов массива b
		
		for (int i = 0; i < a.length + b.length; i++) {
			
			if(i <= k || i > k + b.length) {
				
				rez[i] = a[n_a];
				n_a++;
				
			} else  {
				
				rez[i] = b[n_b];
				n_b++;
			}
		}
		
		System.out.printf("\nРезультир. массив rez[%d] = %s.\n", rez.length, Arrays.toString(rez));
	}

}
