package by.epam.javaonline.string.stringbuilder;

// import java.util.Scanner;

/* Вводится строка слов, разделенных пробелами. Найти самое длинное слово
 * и вывести его на экран. Случай, когда самых длинных слов может быть
 * несколько, не обрабатывать*/

public class Task8 {

	public static void main(String[] args) {
		
		// если нужно организовывать ввод с консоли,
		// но проверять проще с какой-либо фиксированной строкой
		// @SuppressWarnings("resource")
		// Scanner enter = new Scanner(System.in);
		// System.out.print("Введите строку >> ");
		// String line = enter.nextLine();
				
		String line = "The Character  class wraps a value";
		String result = maxLengthWord(line);
		
		System.out.printf("В исходной строке: '%s' \n",line);
		System.out.println("самое длинное слово - " + result);
	}
	
	public static String maxLengthWord(String line) {
		
		StringBuilder word;
		StringBuilder maxWord;
		int wordLength;
		int maxWordLength;
		
		word = new StringBuilder();
		maxWord = new StringBuilder();
		wordLength = 0;
		maxWordLength = 0;
		
		for(int i = 0; i < line.length(); i++) {
			
			char symbol = line.charAt(i);
			
			if (symbol != ' ') {
				
				wordLength++;
				word.append(symbol);
				
			} else {
				
				if (wordLength > 0) {
					
					if (wordLength > maxWordLength) {
						
						maxWordLength = wordLength;
						maxWord.delete(0, maxWord.length()).append(word);
						wordLength = 0;
						word.delete(0, word.length());
						
					} else {
						
						wordLength = 0;
						word.delete(0, word.length());
					}
				} 
			}
		}
		return maxWord.toString();
	}
	
}
