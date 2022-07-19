package by.epam.javaonline.basic.loop;

import java.util.Scanner;

// Для каждого натурального числа в промежутке от m до n вывести все делители, кроме единицы и самого числа.
// m и n вводятся с клавиатуры

public class Task7 {

	public static void main(String[] args) {

		long m;
		long n;

		m = enter("Введите натуральное число начала промежутка");
		n = enter("Введите натуральное число конца промежутка");
		
		if (m > n) {
			
			long t = m;
			m = n;
			n = t;
		}

		for (long i = m; i <= n; i++) {

			int counter = 0;

			System.out.printf("Натуральные делители числа %d это: ", i);

			if (i == 0) {
				System.out.println("у числа нет натуральных делителей");
				continue;
			}

			for (long j = 2; j < i; j++) {

				if (i % j == 0) {
					System.out.printf("%d ", j);
					counter++;
				}
			}

			if (counter == 0) {
				System.out.print("у числа нет натуральных делителей кроме 1 и самого числа");
			}

			System.out.println();
		}
	}

	@SuppressWarnings("resource")
	public static long enter(String massage) {

		Scanner sc;
		long num;

		sc = new Scanner(System.in);

		System.out.printf("%s >> ", massage);

		while (!sc.hasNextLong()) {
			sc.next();
			System.out.printf("Некорректный ввод! %s >> ", massage);
		}

		num = sc.nextLong();

		while (num < 0) {
			
			System.out.printf("Некорректный ввод! Отрицательное число! %s >> ", massage);
			while (!sc.hasNextLong()) {
				sc.next();
				System.out.printf("Некорректный ввод! %s >> ", massage);
			}
			num = sc.nextLong();
		}
		return num;
	}

}
