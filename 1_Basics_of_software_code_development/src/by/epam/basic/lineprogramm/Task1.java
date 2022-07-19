package by.epam.javaonline.basic.lineprogramm;

import java.util.Scanner;

//Найдите значение функции: z = ( (a – 3 ) * b / 2) + c.

public class Task1 {

	public static void main(String[] args) {

		double a;
		double b;
		double c;
		double z;

		a = enterNumber("a");
		b = enterNumber("b");
		c = enterNumber("c");

		z = ((a - 3) * b / 2) + c;

		System.out.println("Expression rezult: z = " + z);

	}

	@SuppressWarnings("resource")
	public static double enterNumber(String variableName) {

		Scanner sc;

		sc = new Scanner(System.in);

		System.out.print("Enter value of variable '" + variableName + "' >> ");

		while (!sc.hasNextDouble()) {
			sc.next();
			System.out.print("Encorrect value! Enter correct value of variable '" + variableName + "' >> ");
		}

		return sc.nextDouble();
	}

}