package by.epam.javaonline.string.regularexpression;

import java.util.Scanner;

/* Создать приложение, разбирающее текст (текст хранится в строке) и
 * позволяющее выполнять с текстом три различных операции: отсортировать
 * абзацы по количеству предложений; в каждом предложении отсортировать
 * слова по длине; отсортировать лексемы в предложении по убыванию количества
 * вхождений заданного символа, а в случае равенства – по алфавиту.*/

public class Task1 {

	public static void main(String[] args) {
		
		String title = "Travelling";
		String text = "Thousands of people travel every day. To prove it, I invite you to a railway or a bus station," // кол.предл. 4
				    + " a port or an airport. There you will see thousands of people trying to catch a train, a bus,"
				    + " a ship or a plane. Everybody wants to go somewhere and to get there as quickly as possible,"
				    + " with all conveniences and safely."
				    + "\n"
				    + "Of course, travelling by plane is the fastest, but it is also the most expensive. That's why" // кол.предл. 5
				    + " if people have time they go by train. It is one of the most popular means of travelling. Trains"
				    + " go slower than planes, but you can see much more interesting places of the country you are travelling"
				    + " through. Modern trains are very comfortable and you can enjoy even the longest journey."
				    + "\n"
				    + "Travelling by sea is popular mostly for pleasure trips. Onboard large ships and small river boats people" // кол.предл. 3
				    + " can visit foreign countries and different places of interest within their own country. A trip by sea is"
				    + " usually called a voyage or a cruise."
				    + "\n"
				    + "Buses also can take you to any place you wish. It can be a trip not far from your home or a long journey" // кол.предл. 2
				    + " even to a foreign country."
				    + "\n"
				    + "Many people prefer travelling by car. They don't have to buy tickets. They don't have to carry heavy luggage." // кол.предл. 4
				    + " They can stop wherever they wish and spend as much time as they like at any place."
				    + "\n"
				    + "But some people like spending their holidays travelling on foot or by bike."; // кол.предл. 1
		
		operationsOnText(title,text);

	}
	
	// метод выбора операции и вызова соотв.метода-реализации
	public static void operationsOnText(String title,String text) {
		
		printText(title, text, 120);
		printMenu();
		
		int operation = enterNumberOfOperation();
		
		System.out.println("\n");
		
		while(operation != 0) {
			
			switch(operation) {
				
			case 1:
				
				String title1 = "Sorting on number of sentences in paragraph of initial text";
				String sortOnParagText = sortOnParagraphs(text);
				
				printText(title1, sortOnParagText, 120);
				System.out.println("\nКОНЕЦ ВЫПОЛНЕНИЯ ОПЕРАЦИИ №1!");
				
				printMenu();
				operation = enterNumberOfOperation();
				System.out.println("\n");
				break;
			case 2:
				
				String title2 = "Sorting on length of words in sentences of initial text";
				String sortOnWordLenText = sortSentencesInTextOnWordLength(text);
				
				printText(title2, sortOnWordLenText, 120);
				System.out.println("\nКОНЕЦ ВЫПОЛНЕНИЯ ОПЕРАЦИИ №2!");
				
				printMenu();
				operation = enterNumberOfOperation();
				System.out.println("\n");
				break;
			case 3:
				
				char symbol = enterSymbolForSearch();
				System.out.println();
				String title3 = "Sorting on enter number of char in words in sentences of initial text";
				String sortOnSymbolNumInWord = sortSentencesInTextOnSymbolNumInWord(text, symbol);
				
				printText(title3, sortOnSymbolNumInWord, 120);
				System.out.println("\nКОНЕЦ ВЫПОЛНЕНИЯ ОПЕРАЦИИ №3!");
				
				printMenu();
				operation = enterNumberOfOperation();
				System.out.println("\n");
				break;
			}
			
		}
		System.out.print("КОНЕЦ РАБОТЫ ПРИЛОЖЕНИЯ!");
	}
	
	
	// метод печати текста в консоль любой ширины строки с интервалом между абзацами
	// в один enter, без переносов и разрывов слов
	public static void printText(String title, String text, int lineWidth) {
		
		System.out.printf("%"+ lineWidth/2+ "S\n\n", title);
		
		int n = 1; // число переносов строк 
		int nextLine = 0; // подсчет количества символов в абзаце
		
		for(int i = 0; i < text.length(); i++) {
			
			char symbol = text.charAt(i);
			
			if(symbol == '\n') { // для нового абзаца
				nextLine = 0;
				n = 1;
				System.out.println();
			} 
			
			if (nextLine == n * lineWidth) { // ограничение по ширине строки
				
				if(symbol != ' ') {
					nextLine--;
				} else {
					System.out.print(symbol);
					System.out.println();
					n++;
					continue;
				}
			}
			nextLine++;
			System.out.print(symbol);
		}
		System.out.println("\n"); 
	}
	
	
	// печать в консоль меню
	public static void printMenu() {
		
		System.out.println(" ______________________________________________________________________");
		System.out.println("| НАД ИСХОДНЫМ ТЕКСТОМ \"TRAVELLING\" ВОЗМОЖНЫ СЛЕДУЮЩИЕ ОПЕРАЦИИ:       |\n"
						 + "|                                                                      |\n"
				 		 + "| 1 - отсортировать абзацы по количеству предложений;                  |\n"
				 		 + "| 2 - в каждом предложении отсортировать слова по длине;               |\n"
				 		 + "| 3 - отсортировать лексемы в предложении по убыванию количества       |\n"
				 		 + "|     вхождений заданного символа, а в случае равенства – по алфавиту. |\n"
				 		 + "|______________________________________________________________________|\n");
		
		System.out.print("Введите номер необходимой операции или 0 для выхода >> ");
	}
	
	
	// метод ввода и проверки ввода номера операции
	public static int enterNumberOfOperation() {
		
		@SuppressWarnings("resource")
		Scanner enter = new Scanner(System.in);
		String operation = enter.nextLine(); // номер в виде строки чтобы легче было написать проверку ввода
		
		while(!operation.equals(String.valueOf('1')) &&
			  !operation.equals(String.valueOf('2')) &&
			  !operation.equals(String.valueOf('3')) &&
			  !operation.equals(String.valueOf('0'))) {
			
			System.out.print("Ошибка ввода номера операции! Введите номер необходимой операции или 0 для выхода >> ");
			operation = enter.nextLine();
		}
		return Integer.valueOf(operation);
	}
	
	// метод сортировки абзацев текста по возрастанию количества предложений в них
	public static String sortOnParagraphs(String text) {
		
		String[] paragraphs = text.split("\\n"); // разбитие текста на абзацы
		
		for(int i = 0; i < paragraphs.length; i++) { // сортировка выбором
			
			int min = i; // индекс абзаца с мин. количеством предложений на i-м шаге
			
			for(int j = i; j < paragraphs.length; j++) {
				
				int sentenceNum = paragraphs[j].split("[.!?]\\s+").length;
				int minSentNum = paragraphs[min].split("[.!?]\\s+").length;
				
				if(sentenceNum < minSentNum) {
					min = j;
				}
			}
			
			String temp = paragraphs[min];
			paragraphs[min] = paragraphs[i];
			paragraphs[i] = temp;
		}
		
		// составление новой строки с текстом с отсортированными по количеству предложений абзацами
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < paragraphs.length; i++) {
			result.append(paragraphs[i] + "\n");
		}
		result.deleteCharAt(result.length() - 1); // удаление последнего "лишнего" \n
		
		return result.toString();
	}
	
	
	// разбиение текста на абзацы, абзацы на предложения, сортировка слов в 
	// предложении по возрастанию их длинны и составление теста обратно
	public static String sortSentencesInTextOnWordLength(String text) {
			
		String[] paragraphs; // массив абзацев 
		int paragraphsNum; // количество абзацев
		String[][] sentences; // массив предложений
		
		paragraphs = text.split("\n");
		paragraphsNum = paragraphs.length;
		sentences = new String[paragraphsNum][];
			
		for(int i = 0; i < sentences.length; i++) {
				
			sentences[i] = paragraphs[i].split("[.!?]\\s+");
		}
			
		for (int i = 0; i < sentences.length; i++) {
				
			for(int j = 0; j < sentences[i].length; j++) {
				sentences[i][j] = sortSentenceOnWordLength(sentences[i][j]);
			} 
		}
			
		StringBuilder result = new StringBuilder();
			
		for (int i = 0; i < sentences.length; i++) {
				
			for(int j = 0; j < sentences[i].length; j++) {
				result.append(sentences[i][j] + " ");
			}
			result.setCharAt(result.length() - 1,'\n');
		}
		result.deleteCharAt(result.length() - 1); // удаление последнего "лишнего" \n
			
		return result.toString();
	}
		
		
	// сортировка предложения по длине слов сортировкой Шелла
	public static String sortSentenceOnWordLength(String sentence) {
			
		String[] words;
		int k;
		int step;
			
		words = sentence.split("\\s*(\\s|,|!|\\.)\\s*");
		k = 1; // номер шага сортировки
	    step = (int) Math.pow(2,k) - 1; // метод вычисления шага согласно Хиббарду
			
		while(step <= words.length) { // условие окончания сортировки согласно Хиббарду
				
			for(int i = step; i< words.length; i++) { 
					
				for (int j = i; j >= step; j -= step) { 
						
					if(words[j].length() < words[j - step].length()) {
							
						String temp = words[j];
						words[j] = words[j - step];
						words[j - step] = temp;
							
					} else {
						break;
					}
				}
			}
				
			k++;
			step = (int) Math.pow(2,k) - 1;
		}
			
		// составление новой строки с текстом с отсортированными по количеству предложений абзацами
		StringBuilder result = new StringBuilder();
				
		for(int i = 0; i < words.length; i++) {
			result.append(words[i] + " ");
		}
		result.setCharAt(result.length() - 1,'.');
			
		return result.toString();
	}
	
	
	// разбиение текста на абзацы, абзацы на предложения, сортировка слов в 
	// предложении по убыванию количества вхождений заданного символа, если
	// их количество равно, то по алфавиту и составление теста обратно
	public static String sortSentencesInTextOnSymbolNumInWord(String text, char symbol) {
					
		String[] paragraphs; // массив абзацев 
		int paragraphsNum; // количество абзацев
		String[][] sentences; // массив предложений
				
		paragraphs = text.split("\n");
		paragraphsNum = paragraphs.length;
		sentences = new String[paragraphsNum][];
					
		for(int i = 0; i < sentences.length; i++) {
						
			sentences[i] = paragraphs[i].split("[.!?]\\s+");
		}
					
		for (int i = 0; i < sentences.length; i++) {
						
			for(int j = 0; j < sentences[i].length; j++) {
				sentences[i][j] = sortSentenceOnSymbolNumInWord(sentences[i][j], symbol);
			} 
		}
					
		StringBuilder result = new StringBuilder();
					
		for (int i = 0; i < sentences.length; i++) {
						
			for(int j = 0; j < sentences[i].length; j++) {
				result.append(sentences[i][j] + " ");
			}
			result.setCharAt(result.length() - 1,'\n');
		}
		result.deleteCharAt(result.length() - 1); // удаление последнего "лишнего" \n
					
		return result.toString();
	}
		
	// сортировка предложения по убывания по количеству вхождений символа в слово сортировкой Шелла
	public static String sortSentenceOnSymbolNumInWord(String sentence, char symbol) {
					
		String[] words;
		int k;
		int step;
					
		words = sentence.split("\\s*(\\s|,|!|\\.)\\s*");
		k = 1; // номер шага сортировки
		step = (int) Math.pow(2,k) - 1; // метод вычисления шага согласно Хиббарду
					
		while(step <= words.length) { // условие окончания сортировки согласно Хиббарду
						
			for(int i = step; i< words.length; i++) { 
							
				for (int j = i; j >= step; j -= step) { 
								
					if(compareTwoWords(words[j], words[j - step], symbol) ) {
									
						String temp = words[j];
						words[j] = words[j - step];
						words[j - step] = temp;
									
					} else {
						break;
					}
				}
			}
						
			k++;
			step = (int) Math.pow(2,k) - 1;
		}
					
		// составление новой строки с текстом с отсортированными по количеству предложений абзацами
		StringBuilder result = new StringBuilder();
						
		for(int i = 0; i < words.length; i++) {
			result.append(words[i] + " ");
		}
		result.setCharAt(result.length() - 1,'.');
					
		return result.toString();
	}
		
		
	// метод ввода символа латинского алфавита для поиска
	public static char enterSymbolForSearch() {
			
		System.out.print("Введите искомый ЛАТИНСКИЙ символ >> ");
			
		@SuppressWarnings("resource")
		Scanner enter = new Scanner(System.in);
		String operation = enter.nextLine(); // номер в виде строки чтобы легче было написать проверку ввода
			
		for(;;) {
				
			if(operation.length() > 1) {
				
				System.out.print("Ошибка ввода! Введите искомый ЛАТИНСКИЙ символ >> ");
				operation = enter.nextLine();
				
			} else {
				
				char symbol = operation.toLowerCase().charAt(0);
				
				if (symbol >= 'a' && symbol <= 'z') {
					break;
				} else {
					System.out.print("Ошибка ввода! Введите искомый ЛАТИНСКИЙ символ >> ");
					operation = enter.nextLine();	
				}
			}
		}
		return operation.charAt(0);
	}
		
		
	// метод сравнения двух слов по количеству вхождений в них заданного символа,
	// если их количество равно, то сравнение по алфавиту, метод возвращает "true"
	// если word_1 > word_2
	public static boolean compareTwoWords(String word_1, String word_2, char symbol) {
			
		int symbolNum_1 = 0; // количество вхождений символа в слово 1
		int symbolNum_2 = 0; // количество вхождений символа в слово 2
		
		for(int i = 0; i < word_1.length(); i++) {
				
			if(word_1.charAt(i) == symbol) {
				symbolNum_1++;
			}
		}
			
		for(int i = 0; i < word_2.length(); i++) {
				
			if(word_2.charAt(i) == symbol) {
				symbolNum_2++;
			}
		}
			
		// алгоритм сравнения
		if(symbolNum_1 > symbolNum_2) {
			return true;
		} else if (symbolNum_1 < symbolNum_2) {
			return false;
		} else {
				
			if(word_1.compareToIgnoreCase(word_2) > 0) {
				return true;
			} else if(word_1.compareToIgnoreCase(word_2) == 0) {
				return false;
			} else {
				return false;
			}
		}
	}
}
