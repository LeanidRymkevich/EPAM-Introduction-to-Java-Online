package by.epam.javaonline.basic.loop;

// Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера

public class Task6 {

	public static void main(String[] args) {

		// насколько понимаю нужно вывести соответствие символ-числовой код ASCII
		// таблицы

		for (int i = 0; i <= 255; i++) {
			System.out.printf("Символ таблицы - '%c' и его код '%d'\n", (char) i, i);
		}

	}
}
