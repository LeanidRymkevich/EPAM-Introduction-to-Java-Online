package by.epam.javaonline.string.stringbuilder;

// import java.util.Scanner;

/* Вводится строка. Требуется удалить из нее повторяющиеся символы
 * и все пробелы. Например, если было введено "abc cde def", то
 * должно быть выведено "abcdef".*/

public class Task7 {

	public static void main(String[] args) {
		
		// если нужно организовывать ввод с консоли,
		// но проверять проще с какой-либо фиксированной строкой
		// @SuppressWarnings("resource")
		// Scanner enter = new Scanner(System.in);
		// System.out.print("Введите строку >> ");
		// String line = enter.nextLine();
		
		String line = "aaabbbbccc ccccdddeee ddeeeddef fffcabd";
		String result = deleteCopiesAndSpaces(line);

		System.out.println("Исходная строка: " + line);
		System.out.println("Строка-результат: " + result);
	}
	
	
	public static String deleteCopiesAndSpaces(String line) {
		
		StringBuilder result = new StringBuilder(line);
		
		for (int i = 0; i < result.length(); i++) {
			
			char symbol = result.charAt(i);
			
			if (symbol == ' ') {
				
				result.deleteCharAt(i);
				i--;
				
			} else {
				
				for (int j = i + 1; j < result.length(); j++) {
					
					if(symbol == result.charAt(j)) {
						result.deleteCharAt(j);
						/* после каждого удаления символа нужно делать шаг назад так как
						 * последовательность символов изменяется, например для следующей 
						 * последовательности "ааабббб" на шаге i = 0 мы удалили j = 1 символ "а"
						 * и дальше по итерации переходим к символу j = 2, хотя последовательность
						 * изменилась и стала "аабббб" и символ j = 2 уже равен "б" и один символ
						 * "а" пропущен, именно поэтому нужно делать шаг назад т.е. j--, тоже и 
						 * с удалением пробела*/
						j--;
					}
				}
			}
		}
		return result.toString();	
	}
}
