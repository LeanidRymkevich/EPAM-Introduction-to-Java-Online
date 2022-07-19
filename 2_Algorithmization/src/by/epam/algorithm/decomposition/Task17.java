package by.epam.javaonline.algorithm.decomposition;

/* Из заданного числа вычли сумму его цифр. Из результата вновь вычли
 * сумму его цифр и т.д. Сколько таких действий надо произвести, чтобы
 * получился нуль? Для решения задачи использовать декомпозицию*/

public class Task17 {

	public static void main(String[] args) {
		
		int num;
		int numOfSubtr;
		
		num = 123;
		numOfSubtr = numberOfSubtract(num);
		
		System.out.printf("\nNumber of subtractions equals - %d.", numOfSubtr);
	}
	
	
	// метод нахождения суммы цифр числа
	public static int digitSum(int num) {
		
		int sum;
		int digit;
		
		sum = 0;
		digit = 0;
		
		while (num != 0) {
			
			digit = num % 10;
			sum += digit;
			num /= 10;
		}
		
		return sum;
	}
	
	// метод подсчета возможных до 0 вычитаний
	public static int numberOfSubtract(int num) {
		
		int counter;
		
		counter = 0;
		
		while (num != 0) {
			
			int sum = digitSum(num);
			System.out.printf("%,d: number - digitSum = %,d - %,d = %,d.\n",
					counter + 1 , num, sum, num - sum);
			num -= sum;
			counter++;	
		}
		
		return counter;
	}
}
