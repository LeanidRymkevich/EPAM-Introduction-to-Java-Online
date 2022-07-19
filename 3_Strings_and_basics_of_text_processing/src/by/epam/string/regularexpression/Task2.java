package by.epam.javaonline.string.regularexpression;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Дана строка, содержащая следующий текст (xml-документ).
 * Напишите анализатор, позволяющий последовательно возвращать
 * содержимое узлов xml-документа и его тип (открывающий тег, закрывающий тег,
 * содержимое тега, тег без тела). Пользоваться готовыми парсерами XML
 * для решения данной задачи нельзя.*/

public class Task2 {

	public static void main(String[] args) {
		
		String xmlDoc = "<notes>\r\n"
						+ "<note id = \"1\">\r\n"
							+ "<to>Вася</to>\r\n"
							+ "<from>Света</from>\r\n"
							+ "<heading>Напоминание</heading>\r\n"
							+ "<body>Позвони мне завтра!</body>\r\n"
						+ "</note>\r\n"
						+ "<note id = \"2\">\r\n"
							+ "<to>Петя</to>\r\n"
							+ "<from>Маша</from>\r\n"
							+ "<heading>Важное напоминание</heading>\r\n"
							+ "<body/>\r\n"
						+ "</note>\r\n"
					   + "</notes>";
		
		System.out.println(analyser(xmlDoc));	
	}
	
	
	public static String analyser(String line) {
		
		StringBuilder result; 
		Pattern string; 
		Matcher stringFind; 
		Pattern openingTag; 
		Pattern closingTag;
		Pattern body;
		Pattern emptyBody;
		
		result = new StringBuilder(); 
		string = Pattern.compile("<.+>"); 
		stringFind = string.matcher(line);
		openingTag = Pattern.compile("<[^/]+>"); 
		closingTag = Pattern.compile("</.+>");
		body = Pattern.compile("(( |, )*(\\w|[А-Яа-я])+)+(?=<)");
		emptyBody = Pattern.compile("<.+/>");
		
		for(;;) {
			
			if(!stringFind.find()) {
				break;
			}
			
			String knot = stringFind.group();
			
			Matcher isOpeningTag = openingTag.matcher(knot);
			Matcher isClosingTag = closingTag.matcher(knot);
			Matcher isBody = body.matcher(knot);
			Matcher isEmptyBody = emptyBody.matcher(knot);
			
			if(isOpeningTag.find()) {
				result.append(isOpeningTag.group() + " - открывающий тег \n");
			}
			if(isBody.find()) {
				result.append(isBody.group() + " - тело тега \n");
			}
			if(isClosingTag.find()) {
				result.append(isClosingTag.group() + " - закрывающий тег \n");
			}
			if(isEmptyBody.find()) {
				result.append(isEmptyBody .group() + " - тег без тела \n");
			}
		}
		result.deleteCharAt(result.length() - 1);
		
		return result.toString();
	}
}
