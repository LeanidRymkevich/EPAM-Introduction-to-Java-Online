package by.epam.javaonline.basic.loop;

import java.util.Scanner;

// Напишите программу, где пользователь вводит любое целое положительное число.
// А программа суммирует все числа от 1 до введенного пользователем числа.

public class Task1 {

	public static void main(String[] args) {

		long num; // число пользователя
		long sum; // искомая сумма
		long sum_1; // сумма на шаге i-1
		long counter; // счетчик прохода циклов

		num = enterNumber();
		sum = 0;
		sum_1 = 0;
		counter = 0;

		for (long i = 1; i <= num; i++) {

			sum_1 = sum;
			sum += i;

			// окончание цикла при переходе суммы за пределы положительных
			// значений типа long
			if (sum <= 0) {
				break;
			}

			counter = i;
		}

		// вывод сообщения о результате или о том что был достигнут предел положительных
		// значений суммы типа long, вывод информации о последней положительной сумме
		// и соответствующему ей количеству прохода циклов т.е. максимально возможное
		// число для ввода (4294967295)
		if (counter < num) {
			System.out.println("Достигнут предел положительных значений типа long.\n"
					+ "Значение соотвествующего ему исходного числа num = " + counter
					+ "\nСумма чисел от одного до предела: " + sum_1);
		} else {
			System.out.println("Сумма чисел от одного до введенного равна: " + sum);
		}

	}

	@SuppressWarnings("resource")
	public static long enterNumber() {

		Scanner sc;
		long num;
		
		sc = new Scanner(System.in);

		System.out.print("Введите целое положительное число >> ");

		while (!sc.hasNextLong()) {
			sc.next();
			System.out.print("Некорректный ввод! Введите целое положительное число >> ");
		}
		
		num = sc.nextLong(); 
		
		while (num < 0) {
			
			System.out.print("Некорректный ввод! Введите целое ПОЛОЖИТЕЛЬНОЕ число >> ");
			while (!sc.hasNextLong()) {
				sc.next();
				System.out.print("Некорректный ввод! Введите целое положительное число >> ");
			}
			num = sc.nextLong(); 
		}

		return num;
	}
}
