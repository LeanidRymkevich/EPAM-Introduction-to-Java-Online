package by.epam.javaonline.basic.branch;

// Найти max{min(a, b), min(c, d)}

public class Task2 {

	public static void main(String[] args) {

		double a;
		double b;
		double c;
		double d;
		double rez;

		a = 1;
		b = 2;
		c = 3;
		d = 4;

		double minab;
		double mincd;

		if (a > b) {
			minab = b;
		} else {
			minab = a;
		}

		if (c > d) {
			mincd = d;
		} else {
			mincd = c;
		}

		if (minab > mincd) {
			rez = minab;
		} else {
			rez = mincd;
		}

		System.out.printf("max{min(%.1f, %.1f), min(%.1f, %.1f) = %.1f", a, b, c, d, rez);
	}

}
