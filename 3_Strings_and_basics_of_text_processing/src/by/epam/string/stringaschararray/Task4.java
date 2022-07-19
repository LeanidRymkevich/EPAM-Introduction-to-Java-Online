package by.epam.javaonline.string.stringaschararray;

// В строке найти количество чисел

public class Task4 {

	public static void main(String[] args) {
		
		String line;
		int numberAmount;
		
		line = "709 The Character324 cl09ass wraps a03 val13ue5 of the67 prim8-9itive type char 09&12 in an object 0909";
		
		System.out.printf("Числа находящиеся в исходной строке - \n'%s': \n", line);
		numberAmount = amountOfNumbersInLine(line);
		
		System.out.printf("\nих общее количество равно - %d.", numberAmount);
	}
	
	
	// метод нахождения количества чисел и печати найденных чисел в консоль (09 - два числа)
	public static int amountOfNumbersInLine(String line) {
		
		int numberAmount; // общее количество чисел
		boolean isNumber; 
		String number; // строка для вывода полученных чисел
		
		numberAmount = 0;
		isNumber = false;
		number = "";
		
		for (int i = 0; i < line.length(); i++) {
			
			char symbol = line.charAt(i);
			
			if (Character.isDigit(symbol)) { // данный символ цифра?
				
				if (!isNumber && symbol == '0') { // первый ли 0 в числе если да то 0 - отдельное число 
					
					numberAmount++;
					System.out.print(symbol + ", ");
				} else { // если 0 не первое число на что указывает isNumber = true, то 0 - часть составного числа
					
					if (i == line.length() - 1) { // достигнут ли конец строки, если да то + 1 число
						
						numberAmount++;
						number += symbol;
						System.out.print(number + ", ");
					} else { // если конец строки не достигнут ищем конец цифр этого числа
						
						isNumber = true;
						number += symbol; 
					}
				}
			}else { // если текущий символ не цифра
				
				if (isNumber) { // предыдущий символ был цифрой?
					
					numberAmount++;
					isNumber = false;
					System.out.print(number + ", ");
					number = "";
				}
			}
		}
		return numberAmount;
	}

}
