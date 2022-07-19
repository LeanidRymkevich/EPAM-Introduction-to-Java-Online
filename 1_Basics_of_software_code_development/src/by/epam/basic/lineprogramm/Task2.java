package by.epam.javaonline.basic.lineprogramm;

import java.util.Scanner;

/*
 * Вычислить значение выражения по формуле (все переменные принимают действительные значения): 
 * ((𝑏 + √(𝑏^2 + 4*𝑎*𝑐))/2*𝑎 - (𝑎^3)*𝑐 + 𝑏^(−2)
*/

public class Task2 {

	public static void main(String[] args) {

		double a;
		double b;
		double c;
		double rez;
		
		a = enterNumber("a");
		b = enterNumber("b");
		c = enterNumber("c");
		
		double root;
		root = Math.sqrt(Math.pow(b,2) + 4 * a * c);
		
		rez = (b + root) / (2 * a) - Math.pow(a, 3) * c + Math.pow(b, (-2));
		
		System.out.println("Expression rezult: " + rez);

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
