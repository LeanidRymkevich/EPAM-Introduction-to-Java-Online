package by.epam.javaonline.basic.branch;

/*
 * Даны два угла треугольника (в градусах). Определить, существует ли такой треугольник, и если да, то будет ли 
 * он прямоугольным.
*/

public class Task1 {

	public static void main(String[] args) {

		double angle_1; // угол 1
		double angle_2; // угол 2

		angle_1 = 30;
		angle_2 = 60;

		if ((180 - angle_1 - angle_2) < 0) {
			System.out.println("Треугольник с такими углами не существует");
		} else {
			System.out.println("Треугольник с такими углами существует");
		}

		if ((angle_1 + angle_2) == 90) {
			System.out.println("Треугольник с такими углами прямоугольный");
		} else {
			System.out.println("Треугольник с такими углами не прямоугольный");
		}
	}

}
