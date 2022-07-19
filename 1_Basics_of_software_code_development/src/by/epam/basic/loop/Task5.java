package by.epam.javaonline.basic.loop;

// Даны числовой ряд и некоторое число е. Найти сумму тех членов ряда, модуль которых больше или равен
// заданному е. Общий член ряда имеет вид: a(n) = (1 / 2^n) + (1 / 3^n).

public class Task5 {

	public static void main(String[] args) {

		double a;
		double e;
		double sum;

		e = 0.025;
		sum = 0;

		for (int n = 0;; n++) {

			a = (double) ((1 / Math.pow(2, n)) + (1 / Math.pow(3, n)));

			if (Math.abs(a) >= e) {
				sum += a;
			} else {
				break;
			}
		}
		
		System.out.printf("Sum = %f", sum);

	}
}
