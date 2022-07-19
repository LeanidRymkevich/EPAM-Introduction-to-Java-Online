package by.epam.javaonline.basic.loop;

// Вычислить значения функции на отрезке [а,b] c шагом h: y = 
// x, если x > 2
// -x, если x <= 2.

public class Task2 {

	public static void main(String[] args) {

		double a;
		double b;
		double y;
		double h;

		a = -4;
		b = 6;
		h = 2;

		for (double x = a; x <= b; x += h) {

			if (x > 2) {
				y = x;
			} else {
				y = -x;
			}
			System.out.printf("y(%.1f) = %.1f\n", x, y);
		}

	}
}
