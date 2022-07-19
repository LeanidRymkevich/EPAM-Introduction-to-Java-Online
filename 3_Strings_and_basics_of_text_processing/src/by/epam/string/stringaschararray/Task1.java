package by.epam.javaonline.string.stringaschararray;

import java.util.Arrays;

/* Дан массив названий переменных в camelCase.
 * Преобразовать названия в snake_case*/

public class Task1 {

	public static void main(String[] args) {
		
		String[] camelCaseNames;
		String[] snake_case_names;
		
		camelCaseNames = new String[]{"camelCase",
									  "snakeCase",
									  "stringAsCharArray",
									  "stringsAndBasicsOfTextProcessing"};
		snake_case_names = new String[camelCaseNames.length];
		
		for (int i = 0; i < camelCaseNames.length; i++) {
			
			snake_case_names[i] =toSnakeCase(camelCaseNames[i]); 
		}
		
		System.out.printf("camelCaseNames[%d] = %s.\n", camelCaseNames.length, Arrays.toString(camelCaseNames));
		System.out.printf("snake_case_names[%d] = %s.\n", snake_case_names.length, Arrays.toString(snake_case_names));
	}
	
	
	// метод преобразования одиночной строки из camelCase в snake_case
	public static String toSnakeCase(String line) {
		
		String result = ""; // строка-результат 
		String buff = ""; // буфер для запоминания символа и добавления знака '_' при необходимости
		
		for (int i = 0; i < line.length(); i++) {
			
			if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
				
				buff = "_" + String.valueOf(line.charAt(i)).toLowerCase();
				
			} else {
				buff = String.valueOf(line.charAt(i));
			}
			result += buff;
		}
		return result;
	}

}
