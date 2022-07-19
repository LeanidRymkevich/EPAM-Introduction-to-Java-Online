package by.epam.javaonline.string.stringbuilder;

/* Строка X состоит из нескольких предложений, каждое из которых кончается точкой,
 * восклицательным или вопросительным знаком. Определить количество предложений в 
 * строке X.*/

public class Task10 {

	public static void main(String[] args) {
		
		String line;
		int sentenceNum;
		
		line = "Sdfsd dsfsdf, erw? Sfsdff, dfs! Fdsf sdfd. Gf sdfdf ds.";
		sentenceNum = sentenceCounter(line);
		
		System.out.printf("В строке: '%s' \nколичество предложений равно - %d.",
				line, sentenceNum);
	}
	
	public static int sentenceCounter(String line) {
		
		if (line.isEmpty()) {
			return 0;
		}
		
		int number = 1; // в строке есть хотя бы одно предложение 
		
		// по сути подсчет количества предложений сводится к подсчету
		// точек,восклицательных и вопросительных знаков вместе взятых
		// минус последний знак (при условии что мы не рассматриваем случаи
		// сокращений, цитат взятых в кавычки с восклицательным или вопросительными
		// знаками внутри одного предложения и троеточия) 
		for(int i = 0; i < line.length() - 1; i++) {
			
			char symbol = line.charAt(i);
			
			if(symbol == '.' || symbol == '!' || symbol == '?' ) {
				number++;
			}
		}
		return number;		
	}

}
