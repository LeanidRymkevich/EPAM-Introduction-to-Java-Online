package by.epam.javaonline.algorithm.decomposition;

import java.util.Arrays;

/* Найти все натуральные n-значные числа, цифры в которых образуют
 * строго возрастающую последовательность (например, 1234, 5789).
 * Для решения задачи использовать декомпозицию. */

public class Task15 {

	public static void main(String[] args) {
		
		int n;
		int[] numbers;
		
		n = 2; // n > 1
		numbers = findAllIncreaseNum(n);
		
		System.out.printf("Натуральные %d-значные числа, цифры в которых"
				+ " образуют строго возрастающую последовательность: \n%s",
				n, Arrays.toString(numbers));
		
	}
	
	
	// метод определяющий возрастают ли цифры в числе
	public static boolean isIncrease(int number) {
		
		// если правильно понимаю понятие СТРОГО возрастающая, и
		// это когда следующая цифра на 1 больше предыдущей, то решение ниже
		// если подходят и цифры типа '17' то в местах необходимых правок
		// изменения закоментированы
		
		boolean isIncrease;
		int digit; // цифра на шаге i
		int digit_1; // цифра на шаге i-1
		
		isIncrease = false;
		digit = 0;
		digit_1 = number % 10 + 1; // digit_1 = 10;
		
		while(number != 0) {
			
			digit = number % 10;
			
			if (digit  == digit_1 - 1) { // if (digit < digit_1)
				isIncrease = true;
			} else {
				isIncrease = false;
				break;
			}
			
			digit_1 = digit;
			number /= 10; 
		}
		return isIncrease;
	}
	
	
	// метод нахождения все n-значных чисел согласно условию
	public static int[] findAllIncreaseNum(int n) {
		
		int boarder;
		int numberAmount;
		
		boarder = (int) Math.pow(10, n);
		numberAmount = 0;
		
		// от 10 т.к. о однозначных числах нельзя сказать возрастают ли в них цифры или нет
		for(int i = 10; i < boarder; i++) { 
			
			if (isIncrease(i)) {
				numberAmount++;
			}
		}
		
		int[] numberArray;
		int ind;
		
		numberArray = new int[numberAmount];
		ind = 0;
		
		for(int i = 10; i < boarder; i++) {
			
			if (isIncrease(i)) {
				numberArray[ind] = i;
				ind++;
			}
		}
		return numberArray;
	}
}
