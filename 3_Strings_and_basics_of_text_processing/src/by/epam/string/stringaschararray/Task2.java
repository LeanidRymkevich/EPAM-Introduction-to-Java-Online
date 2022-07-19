package by.epam.javaonline.string.stringaschararray;

// Замените в строке все вхождения 'word' на 'letter'

public class Task2 {

	public static void main(String[] args) {
		
		String line; // исходная строка
		String stingReplaced; // заменяемое слово
		String stringReplacing; // заменяющее слово
		String result1; // результат замены стандартным методом класса String
		String result2; // результат замены написанным мной методом, кот. по результату аналогичный выше упомянутому методу
		String result3; // результат метода кот. заменяет ИСКЛЮЧИТЕЛЬНО искомое слово вне зависимости от регистра
		
		line = "word, String, worm, wording, Word, word";
		stingReplaced = "word";
	    stringReplacing = "letter";
		
		
		result1 = line.replace(stingReplaced, stringReplacing);
		result2 = replaceWord(line, stingReplaced, stringReplacing);
		result3 = replaceWordIgnoreCase(line, stingReplaced, stringReplacing);
		
		System.out.printf("Исходна строка: '%s'.\n", line);
		System.out.printf("Измененная строка методом 1: '%s'.\n", result1);
		System.out.printf("Измененная строка методом 2: '%s'.\n", result2);
		System.out.printf("Измененная строка методом 3: '%s'.\n", result3);
	}
	
	
	// метод замены слов по результату аналогичный со стандартным методом класса String - replace
	public static String replaceWord (String line, String target, String replacement) {
		
		String result = "";
		int ind = 0;
		
		for (int i = 0; i < line.length(); i++) {
						
			if (line.charAt(i) == target.charAt(ind)) {
				
				ind++; 
				
				if (ind == target.length()) {
					
					result += replacement;
					ind = 0;		
				} 
			} else {
				
				if (ind > 0) {
					
					result += line.substring(i - ind, i + 1);
					ind = 0;
				} else {
					result += line.charAt(i);
					
				}				
			}
		}
		return result;
	}
	
	// метод замены слов который, например, для слова "word" в исходной строке не внесет изменений в слово
	// "wording", но проигнорирует регистр и заменит слово "Word"
	public static String replaceWordIgnoreCase (String line, String target, String replacement) {
		
		String result = "";
		int ind = 0;
		
		for (int i = 0; i < line.length(); i++) {
			
			// Character.toLowerCase() - приводит символ в нижний регистр, тем
			// самым для искомого слова в нижнем регистре заменяем как слово "word"
			// так и "Word", если регистр искомого слова заранее не известен, то можно
			// ввести начальную проверку Character.isLowerCase() и ввести доп. переменную и т.д.
			if (Character.toLowerCase(line.charAt(i)) == target.charAt(ind)) {
				
				ind++;
				
				if (ind == target.length()) {
					
					if (i == line.length() - 1) { // конец ли строки?
						result += replacement;
						ind = 0;
					} else { // если не конец строки следующий символ латинская буква?
						if ((line.charAt(i + 1) >= 'A' && line.charAt(i + 1) <= 'Z') || 
								(line.charAt(i + 1) >= 'a' && line.charAt(i + 1) <= 'z')) { // если да то это не искомое слово
							
							result += line.substring(i - ind, i + 1);
							ind = 0;
			
						} else { // если нет то искомое слово
							result += replacement;
							ind = 0;
						}
					}
				} 	
			} else {
				
				if (ind > 0) {
					
					result += line.substring(i - ind, i + 1);
					ind = 0;
				} else {
					
					result += line.charAt(i);
					
				}				
			}
		}
		return result;
	}

}
