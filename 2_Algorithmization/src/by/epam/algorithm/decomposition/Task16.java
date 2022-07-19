package by.epam.javaonline.algorithm.decomposition;

import java.util.Arrays;

/* Написать программу, определяющую сумму n - значных чисел, содержащих
 * только нечетные цифры. Определить также, сколько четных цифр в найденной сумме.
 * Для решения задачи использовать декомпозицию.*/

public class Task16 {

	public static void main(String[] args) {
		
		int n;
		int sum;
		int evenNumAmount;
		int[] onlyOddNumearls;
		
		n = 2;
		onlyOddNumearls = onlyOddNumerals(n);
		sum = arraySum(onlyOddNumearls);
		evenNumAmount = evenNumerals(sum);
		
		System.out.printf("Для массива %d-кратных чисел содержащих только нечетные цифры:\n%s\n",
				n, Arrays.toString(onlyOddNumearls));
		System.out.printf("Сумма чисел равна - %,d, в ней количество четных цифр - %d.",
				sum, evenNumAmount);
		
		
	}
	
	
	// метод определяющий содержит ли число только нечетные цифры
	public static boolean isOnlyOddNumerals(int number) {
		
		int digit;
		boolean isOnlyOddNumerals;
		
		digit = 0;
		isOnlyOddNumerals = false;
		
		if (number == 0) {
			return false;
		}
		
		while (number !=0) {
			
			digit = number % 10;
			
			if (digit % 2 != 0) { 
				isOnlyOddNumerals = true;
			} else {
				isOnlyOddNumerals = false;
				break;
			}
			
			number /= 10;
		}
		return isOnlyOddNumerals;
	}
	
	
	// метод нахождения всех n-значных чисел, у которых все цифры нечетные
	public static int[] onlyOddNumerals(int n) {
		
		int boarder;
		int numberAmount;
		
		boarder = (int) Math.pow(10, n);
		numberAmount = 0;
		
		// подсчет количества таких чисел
		for(int i = 1; i < boarder; i++) {
			
			if (isOnlyOddNumerals(i)) {
				numberAmount++;
			}
		}
		
		// заполнение ими массива
		int[] numberArray;
		int ind;
		
		numberArray = new int[numberAmount];
		ind = 0;
		
		for(int i = 1; i < boarder; i++) {
			
			if (isOnlyOddNumerals(i)) {
				numberArray[ind] = i;
				ind++;
			}
		}
		
		return numberArray;
	}
	
	
	// метод нахождения суммы элементов одномерного массива
	public static int arraySum(int[] a) {
		
		int sum = 0;
		
		for (int num : a) {
			sum += num;
		}
		
		return sum;
	}
	
	
	// метод определения количества четных цифр в числе
	public static int evenNumerals(int num) {
		
		int numeral;
		int evenNumCounter;
		
		numeral = 0;
		evenNumCounter = 0;
		
		while(num != 0) {
			
			numeral = num % 10;
			
			if (numeral % 2 == 0 && numeral != 0) { // 0 - не четное число
				evenNumCounter++;
			}
			
			num /= 10; 
		}
		return evenNumCounter;
	}

}
