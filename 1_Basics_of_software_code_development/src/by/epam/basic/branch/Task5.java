package by.epam.javaonline.basic.branch;

// Вычислить значение функции: F(x) = 
// x^2 - 3 * x + 9, если x <= 3;
// 1 / (x^3 + 6), если x > 3.

public class Task5 {

	public static void main(String[] args) {

		double y;

		// цикл просто для перебора разных значений аргумента х
		for (double x = -2; x < 6; x++) {

			// вычисление значения функции
			if (x <= 3) {
				y = Math.pow(x, 2) - 3 * x + 9;
			} else {
				y = 1 / (Math.pow(x, 3) + 6);
			}

			// вывод каждой точки цикла в консоль
			System.out.printf("F(%f) = %f\n", x, y);
		}

	}
}
