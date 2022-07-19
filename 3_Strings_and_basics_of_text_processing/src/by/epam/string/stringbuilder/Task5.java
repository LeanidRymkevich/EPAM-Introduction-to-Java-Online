package by.epam.javaonline.string.stringbuilder;

/* Подсчитать, сколько раз среди символов заданной
 * строки встречается буква “а”.*/

public class Task5 {

	public static void main(String[] args) {
		
		String line;
		int coincidNumber;
		char symbol;
		
		symbol = 'a';
		line = "The Character class wraps a value of the primitive type char in an object.";
		coincidNumber = coincidenceNumber(symbol, line);
		
		System.out.printf("В строке ниже: \n'%s' \nсимвол '%c' встречается %d раз.",
				line, symbol, coincidNumber);
	}
	
	
	public static int coincidenceNumber(char ch, String line) {
		
		int number = 0;
		
		for(int i = 0; i < line.length(); i++) {
			
			if(line.charAt(i) == ch) {
				number++;
			}
		}
		return number;
	}
}
