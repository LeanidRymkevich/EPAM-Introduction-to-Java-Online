package by.epam.javaonline.basic.loop;

// Даны два числа. Определить цифры, входящие в запись как первого так и второго числа

public class Task8 {

	public static void main(String[] args) {

		// исходные числа
		long num_1;
		long num_2;

		num_1 = -2304597;
		num_2 = 120698;

		// вспомогательные переменные
		int counter;
		long n_1;
		long n_2;

		n_1 = Math.abs(num_1);
		n_2 = Math.abs(num_2);
		counter = 0;

		System.out.printf("Общие цифры в числах %d и %d это: ", num_1, num_2);

		do { // удобно использовать цикл do-while на случай если одно из исходных чисел 0

			long num = n_1 % 10;

			long a = n_2;

			do {

				long match = a % 10;

				if (num == match) {
					System.out.print(match + " ");
					counter++;
				}
				a = a / 10;

			} while (a != 0);

			n_1 = n_1 / 10;

		} while (n_1 != 0);

		if (counter == 0) {
			System.out.print("у этих чисел нет общих цифер");
		}

		// для случая когда исходными числами могут быть числа с точкой

		double num_3;
		double num_4;

		num_3 = -134.56;
		num_4 = 84.1;

		String str_1;
		String str_2;
		int count;

		str_1 = Double.toString(Math.abs(num_3));
		str_2 = Double.toString(Math.abs(num_4));
		count = 0;

		System.out.printf("\n\nОбщие цифры в числах %s и %s это: ", str_1, str_2);

		for (int i = 0; i < str_1.length(); i++) {

			for (int j = 0; j < str_2.length(); j++) {

				if (str_1.charAt(i) == str_2.charAt(j) && str_2.charAt(j) != '.') {

					System.out.printf("%c ", str_1.charAt(i));
					count++;
				}
			}
		}

		if (count == 0) {
			System.out.print("у чисел нет общих цифр");
		}

	}
}
