package by.epam.javaonline.string.stringbuilder;

/* В строке вставить после каждого символа 'a' символ 'b'.*/

public class Task2 {

	public static void main(String[] args) {
		
		String line;
		StringBuilder result;
		
		line = "The Character class wraps a value of the primitive type char in an object.";
		result = bAfterAInsert(line);
		
		System.out.println("Исходная строка: " + line);
		System.out.println("Строка-результат: " + result);
	}
	
	public static StringBuilder bAfterAInsert(String line) {
		
		StringBuilder result = new StringBuilder(line);
		
		for(int i = 0; i < result.length(); i++) {
			
			char symbol = result.charAt(i);
			
			if (symbol == 'a') {
				result.insert(i + 1, 'b');
			}
		}
		
		return result;
	}

}
