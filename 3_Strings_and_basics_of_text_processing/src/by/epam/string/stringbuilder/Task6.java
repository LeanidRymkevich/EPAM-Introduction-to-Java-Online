package by.epam.javaonline.string.stringbuilder;

// Из заданной строки получить новую, повторив каждый символ дважды

public class Task6 {

	public static void main(String[] args) {
		
		String line;
		String result;
		
		line = "The Character class wraps a value";
		result = doubleSymbols(line);
		
		System.out.println("Исходная строка: " + line);
		System.out.println("Строка-результат: " + result);

	}
	
	public static String doubleSymbols(String line) {
		
		StringBuilder result = new StringBuilder(line);
		
		for(int i = 0; i < result.length(); i +=2) {
			
			/*
			 если пробел не нужно удваивать то нужно оставить этот if
			 if(result.charAt(i) != ' ') {
				result.insert( i + 1, result.charAt(i));
			 } else {
				 i--;
			 }
			*/
			result.insert( i + 1, result.charAt(i));
		}
		return result.toString();
	}

}
