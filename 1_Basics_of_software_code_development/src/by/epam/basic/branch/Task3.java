package by.epam.javaonline.basic.branch;

//  Даны три точки А(х1,у1), В(х2,у2) и С(х3,у3). Определить, будут ли они расположены на одной прямой

public class Task3 {

	public static void main(String[] args) {

		double x1;
		double y1;
		double x2;
		double y2;
		double x3;
		double y3;
		boolean layOrNot;

		x1 = 1;
		y1 = 1;
		x2 = 1;
		y2 = 2;
		x3 = 1;
		y3 = 3;

		// прямая линия - это линейная функция вида у = k * х + b, тогда имея координаты
		// 2 точек можно найти коэффициенты k и b для прямой проходящей через 2 точки
		// у1 = k * х1 + b
		// у2 = k * х2 + b
		// тогда k = (y1 - y2) / (x1 - x2)
		// a b = y2 - k * x2

		double k;
		double b;
		
		if(x1 - x2 == 0){
			layOrNot = x3 == x1;
		} else {
			k = (y1 - y2) / (x1 - x2);
			b = y2 - k * x2;
			
			layOrNot = y3 == k * x3 + b;
		}
		
		if (layOrNot) {
			System.out.printf("Точки: А(%.1f,%.1f), В(%.1f,%.1f) и С(%.1f,%.1f) находятся на одной прямой", x1, y1, x2,
					y2, x3, y3);
		} else {
			System.out.printf("Точки: А(%.1f,%.1f), В(%.1f,%.1f) и С(%.1f,%.1f) не находятся на одной прямой", x1, y1,
					x2, y2, x3, y3);
		}

	}
}
