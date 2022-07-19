package by.epam.javaonline.string.stringbuilder;

/* С помощью функции копирования и операции конкатенации
 * составить из частей слова “информатика” слово “торт”*/

public class Task4 {

	public static void main(String[] args) {
		
		String word = "информатика";
		String result = "";
		
		result = result.concat(String.valueOf(word.charAt(word.indexOf('т'))));
		result = result.concat(String.valueOf(word.charAt(word.indexOf('о'))));
		result = result.concat(String.valueOf(word.charAt(word.indexOf('р'))));
		result = result.concat(String.valueOf(word.charAt(word.indexOf('т')))); 
		
		System.out.println(result);
	}

}
