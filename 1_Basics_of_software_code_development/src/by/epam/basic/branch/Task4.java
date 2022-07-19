package by.epam.javaonline.basic.branch;

// Заданы размеры А, В прямоугольного отверстия и размеры х, у, z кирпича.
// Определить, пройдет ли кирпич через отверстие.

public class Task4 {

	public static void main(String[] args) {

		double a;
		double b;
		double x;
		double y;
		double z;

		a = 1;
		b = 2;
		x = 3;
		y = 4;
		z = 5;

		// кирпич может пройти одной из трех его сторон, если хотя бы одна
		// их площадей сторон меньше или равна площади прямоугольного отверстия

		double sqhole; // площадь отверстия
		sqhole = a * b;

		// площади сторон кирпича
		double sqbr1;
		double sqbr2;
		double sqbr3;

		sqbr1 = x * y;
		sqbr2 = x * z;
		sqbr3 = y * z;

		if (sqhole >= sqbr1 || sqhole >= sqbr2 || sqhole >= sqbr3) {
			System.out.printf("Кирпич с размерами %.1fх%.1fх%.1f пройдет через отверстие %.1fх%.1f", x, y, z, a, b);
		} else {
			System.out.printf("Кирпич с размерами %.1fх%.1fх%.1f не пройдет через отверстие %.1fх%.1f", x, y, z, a, b);
		}
	}

}
