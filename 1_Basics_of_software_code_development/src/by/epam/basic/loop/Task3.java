package by.epam.javaonline.basic.loop;

// Найти сумму квадратов первых ста чисел.

public class Task3 {

	public static void main(String[] args) {

		// int sum т.к. 100^2 = 10^4, значит сумма будет стремиться
		// к 100*10^4 = 10^6, а верхний предел int = 2_147_483_647
		int sum;  
		sum = 0;

		for (int i = 1; i <= 100; i++) {

			sum += Math.pow(i, 2);
		}

		System.out.printf("Sum = %d.", sum);
	}
}
