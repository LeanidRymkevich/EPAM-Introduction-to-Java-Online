package by.epam.javaonline.basic.lineprogramm;

/*
 * Дано натуральное число Т, которое представляет длительность прошедшего времени в секундах. Вывести 
 * данное значение длительности в часах, минутах и секундах в следующей форме: ННч ММмин SSc.
*/

public class Task5 {

	public static void main(String[] args) {

		int num; // исходное число секунд
		int hours;
		int minutes;
		int seconds;

		num = 3773;

		hours = num / 3600;
		minutes = (num % 3600) / 60;
		seconds = num - hours * 3600 - minutes * 60;

		System.out.printf("%d секунд представляет собой %dч %dмин %dc", num, hours, minutes, seconds);

	}
}
