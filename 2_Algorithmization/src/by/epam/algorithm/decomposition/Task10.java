package by.epam.javaonline.algorithm.decomposition;

import java.util.Arrays;

/* Дано натуральное число N. Написать метод(методы) для формирования массива,
 * элементами которого являются цифры числа N.*/

public class Task10 {

	public static void main(String[] args) {
		
		int number;
		int[] numerals;
		
		number = 346285;
		numerals =  numberToArray(number);        
		
		System.out.printf("Для числа - %d, массив его цифр равен: numbers[%d] = %s.",
				number, numerals.length, Arrays.toString(numerals));
	}
	
	
	// метод преобразования числа в массив цифр
	public static int[] numberToArray(int number) {
		
		int numeralAmount; // количество цифр
		int[] numerals;
		
		numeralAmount = 0;
		int num = number;
		
		// подсчет количества цифр
		if (num == 0) {
			numeralAmount = 1;
		} else {
			
			while (num != 0) {
				num /= 10;
				numeralAmount++;
			}
		}
		
		numerals = new int[numeralAmount];
		
		int ind = 0;
		
		// заполнение массива цифр
		for (int i = numeralAmount - 1; i >= 0; i--) {
			
			numerals[ind] =  number / (int) Math.pow(10, i);
			number = number % (int) Math.pow(10, i);
			ind++;
		}	
		return numerals;
	}
}
