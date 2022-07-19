package by.epam.javaonline.string.stringbuilder;

/* Посчитать количество строчных (маленьких) и прописных (больших)
 * букв в введенной строке. Учитывать только английские буквы.*/

public class Task9 {

	public static void main(String[] args) {
		
		String line;
		int lowerCaseLetterNum;
		int upperCaseLetterNum;
		
		line = " sdfAfd 1d2A sdf8HFPdf";
		lowerCaseLetterNum = lowerCaseletterCounter(line);
		upperCaseLetterNum = upperCaseletterCounter(line);
		
		System.out.printf("В строке: '%s' \nколичество строчных (маленьких) букв равно - %d;"
				+ "\nколичество прописных (больших) букв равно - %d.",
				line, lowerCaseLetterNum, upperCaseLetterNum);
	}
	
	public static int lowerCaseletterCounter(String line) {
		
		int number = 0;
		
		for(int i = 0; i < line.length(); i++) {
			
			char symbol = line.charAt(i);
			
			if(Character.isLetter(symbol)) {
				
				if(Character.isLowerCase(symbol)) {
					number++;
				} 
			}
		}
		return number;
	}
	
	public static int upperCaseletterCounter(String line) {
		
		int number = 0;
		
		for(int i = 0; i < line.length(); i++) {
			
			char symbol = line.charAt(i);
			
			if(Character.isLetter(symbol)) {
				
				if(Character.isUpperCase(symbol)) {
					number++;
				} 
			}
		}
		return number;
	}
}
