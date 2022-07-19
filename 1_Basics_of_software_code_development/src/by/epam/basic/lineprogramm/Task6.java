package by.epam.javaonline.basic.lineprogramm;

/* Для данной области составить линейную программу, которая печатает true, если точка с координатами (х, у)
 * принадлежит закрашенной области, и false — в противном случае.
 * Вершины многоугольника:(2,0), (2,4), (-2,4), (-2,0), (-4,0), (-4,-3), (4,-3), (4,0) 
*/

public class Task6 {

	public static void main(String[] args) {

		boolean rez; // результат
		double x; // исходная координата х
		double y; // исходная координата у

		x = 1.5;
		y = 2.5;

		boolean up; // верхний прямоугольник
		up = (x <= 2) && (x >= -2) && (y >= 0) && (y <= 4);

		boolean down; // нижний прямоугольник
		down = (x <= 4) && (x >= -4) && (y <= 0) && (y >= -3);

		rez = up || down;

		System.out.println("Rezult = " + rez);
	}

}
