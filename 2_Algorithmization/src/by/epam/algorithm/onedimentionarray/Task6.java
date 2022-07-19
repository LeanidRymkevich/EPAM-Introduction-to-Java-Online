package by.epam.javaonline.algorithm.onedimentionarray;

import java.util.Arrays;

// Задана последовательность N вещественных чисел.
// Вычислить сумму чисел, порядковые номера которых
// являются простыми числами

public class Task6 {

	public static void main(String[] args) {
		
		int[] a;
		int n;
		
		n = 30;
		a = new int[n];
		
		for (int i = 0; i < a.length; i++) {
			
			a[i] = (int) (Math.random() * 100);
			
		}
		
		System.out.printf("Исходный массив a[%d] = %s.\n", a.length, Arrays.toString(a));
		
		System.out.println("Члены массива с индексами - простыми числами:");
		
		for (int i = 2; i < a.length; i++) { // 0 и 1 - не простые числа, 2 - общеизвестное, первое простое число
			
			boolean print = true;
			
			for (int j = 2; j < i; j++) {
				
				if (i % j == 0) { // определение простое ли число индекс
					print = false;
					break;
				}	
			}
			
			if (print) {
				System.out.printf("a[%d] = %d \n", i, a[i]);
			}
		}
		
	}
}
