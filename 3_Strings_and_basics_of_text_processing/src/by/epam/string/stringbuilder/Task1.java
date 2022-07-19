package by.epam.javaonline.string.stringbuilder;

/* Дан текст (строка). Найдите наибольшее количество
 * подряд идущих пробелов в нем.*/

public class Task1 {

	public static void main(String[] args) {
		
		String line;
		int maxSpaceNumber;
		
		line = "The   Character     class    wraps a   value   of the    primitive type  char in   an object.    ";
		maxSpaceNumber = maxSpaceCounter(line);
		
		System.out.printf("Для строки ниже: \n'%s' \nмаксимальное количество подряд идущих пробелов равно - %d.",
				line, maxSpaceNumber);
	}
	
	// метод подсчета  макс.количества подряд идущ. пробелов
	public static int maxSpaceCounter(String line) {
		
		int maxNumber = 0; // макс.количество подряд идущ. пробелов
		int number = 0; // текущее количество подряд идущ. пробелов
		
		for (int i = 0; i < line.length(); i++) {
			
			char symbol = line.charAt(i);
			
			if(symbol == ' ') {
				number++;
			} else {
				
				if (number > 0) {
					
					if(number > maxNumber) {
						maxNumber = number;
						number = 0;
					} else {
						number = 0;
					}
				}	
			}
		}
		return maxNumber;
	}

}
