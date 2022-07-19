package by.epam.javaonline.string.stringaschararray;

/* Удалить в строке все лишние пробелы, то есть серии подряд идущих
 * пробелов заменить на одиночные пробелы. Крайние пробелы в строке удалить*/

public class Task5 {

	public static void main(String[] args) {
		
		String line;
		String result;
		
		line = "     The   Character  123   class    wraps a0   value 5  of the6 7  prim89itive type  char in   an object.    ";
		result = deleteSpaces(line);
		System.out.printf("Исходная строка: '%s' \nПолученая строка: '%s'", line, result);
	}
	
	
	// метод удаления лишних пробелов в строке
	public static String deleteSpaces(String line) {
		
		line = trimString(line); // обрезаем крайние пробелы
		
		String result = ""; // строка-результат
		int number = 0; // число пробелов между символами
		
		for (int i = 0; i < line.length(); i++) {
			
			char symbol = line.charAt(i);
			
			if(symbol == ' ') { // пробел ли текущий символ
				number++; // если да ведем их счет
			} else { 
				
				if (number >= 1) { // сколько было пробелов до текущего символа 
					
					result +=" " + symbol; // если >= 1 то все пробелы заменяем одним и прибавляем символ 
					number = 0;
				} else { // если нет прибавляем только символ т.е. движемся по слову
					
					number = 0;
					result += symbol;
				}
			}
		}
		return result;
	}
	
	// обрезка пробелов в начале и в конце строки
	public static String trimString(String line) {
		
		int stringStart; // индекс начала строки без пробелов
		int ind; // текущий индекс
		char symbol; // текущий символ
		
		// поиск начала строки без пробелов
		stringStart = 0;
		ind = 0;
		symbol = line.charAt(ind);
		
		while(symbol == ' ') {
			
			ind++;
			stringStart++;
			symbol = line.charAt(ind);
		}
		
		int stringEnd; // индекс конца строки без пробелов
		
		// поиск конца строки без пробелов 
		stringEnd = line.length() - 1;
		ind = line.length() - 1;
		symbol = line.charAt(ind);
		
		while(symbol == ' ') {
			
			ind--;
			stringEnd--;
			symbol = line.charAt(ind);
		}
		
		// обрезка, хотя вместо всего выше перечисленного 
		// можно было бы использовать line.trim()
		line = line.substring(stringStart, stringEnd + 1);
		
		return line;
	}
}
