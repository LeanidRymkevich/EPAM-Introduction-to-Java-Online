package by.epam.javaonline.algorithm.decomposition;

import java.util.Arrays;

/* Натуральное число, в записи которого n цифр, называется числом Армстронга,
 * если сумма его цифр, возведенная в степень n, равна самому числу. Найти все
 * числа Армстронга от 1 до k. Для решения задачи использовать декомпозицию.*/

public class Task14 {

	public static void main(String[] args) {
		
		int k;
		int[] armstr;
		
		k = 100_000;
		armstr = findArmstrNum(1, k);
		
		System.out.printf("Числа Армстронга в промежутке от 1 до %,d равны:\n%s.",
				k, Arrays.toString(armstr));
		
	}
	
	
	// метод проверки является ли число числом Армстронга
	public static boolean isArmstrNum(int number) {
		
		int n; // количество цифр
		int num; // переменная для хранения аргумента
		
		n = 0;
		num = number;
		
		// подсчет количества цифр
		if (num == 0) {
			n = 1;
		} else {
			
			while (num != 0) {
				num /= 10;
				n++;
			}
		}
		
		// собственно сама проверка
		long sum;
		int digit;
		
		num = number;
		sum = 0;
		digit = 0;
		
		while (num != 0) {
			
			digit = num % 10;
			sum += Math.pow(digit, n);
			num /= 10;
		}
		
		if (sum == number && number != 0) {
			return true;
		} else {
			return false;
		}		
	}
	
	
	// метод нахождения чисел Армстронга в промежутке
	public static int[] findArmstrNum(int start, int end) {
		
		// подсчет количества чисел Армстронга
		int armstrNumAmount = 0;
		
		for (int i = start; i <= end; i++) {
			
			if (isArmstrNum(i)) {
				armstrNumAmount++;
			}
		}
		
		// заполнение ими массива
		int[] armstrNum;
		int ind;
		
		armstrNum = new int[armstrNumAmount];
		ind = 0;
		
		for (int i = start; i <= end; i++) {
			
			if (isArmstrNum(i)) {
				armstrNum[ind] = i;
				ind++;
			}
		}
		
		return armstrNum;
	}
}
