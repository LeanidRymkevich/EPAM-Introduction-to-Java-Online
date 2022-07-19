package by.epam.javaonline.basic.lineprogramm;

/*
 * Дано действительное число R вида nnn.ddd (три цифровых разряда в дробной и целой частях).
 * Поменять местами дробную и целую части числа и вывести полученное значение числа 
*/

public class Task4 {

	public static void main(String[] args) {

		// решение для конкретного случая действительного числа R вида nnn.ddd
		// (три цифровых разряда в дробной и целой частях)

		double r; // исходное число
		double nnn; // целая часть
		double ddd; // дробная часть
		double rez; // искомый результат

		r = 123.456;

		nnn = (int) r;
		ddd = (r - nnn) * 1000;

		rez = ddd + nnn / 1000;

		System.out.printf("Rezult = %.3f\n", rez);

		// решение для любого действительного числа

		double r1; // исходное число
		String str; // строчное представление числа
		int point; // индекс точки в строке
		String nn; // целая часть
		String dd; // дробная часть
		String newNumber; // искомое число в строковом виде

		r1 = 123456.789;

		// находим числа целой и дробной части используя стандартные методы класса
		// String
		str = String.valueOf(r1);
		point = str.indexOf('.');
		nn = str.substring(0, point);
		dd = str.substring(point + 1);

		newNumber = String.join(".", dd, nn);

		// double rez1 = Double.valueOf(newNumber); - если нужно не только вывести на
		// консоль, а использовать дальше полученное значение

		System.out.printf("Rezult1 = %s\n", newNumber);

	}
}
