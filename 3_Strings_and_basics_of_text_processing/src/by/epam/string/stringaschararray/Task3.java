package by.epam.javaonline.string.stringaschararray;

// В строке найти количество цифр

public class Task3 {

	public static void main(String[] args) {
		
		String line;
		int numberOfDigit;
		
		line = "The Character123 class wraps a0 value5 of the67 prim89itive type char in an object";
		numberOfDigit = numberOfDigitInLine(line);
		
		System.out.printf("Число цифр в исходной строке: \n'%s' \nравно - %d.", line, numberOfDigit);
	}
	
	public static int numberOfDigitInLine(String line) {
		
		int number = 0;
		
		for (int i = 0; i < line.length(); i++) {
			
			char symbol = line.charAt(i);
			if (Character.isDigit(symbol)) {
				number++;
			}
		}
		return number;
	}

}
