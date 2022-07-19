package by.epam.javaonline.algorithm.decomposition;

// Написать метод(методы), определяющий, в каком из данных двух чисел больше цифр

public class Task11 {

	public static void main(String[] args) {
		
		int number_1;
		int number_2;
		
		number_1 = 37891;
		number_2 = 12345;
		
		switch (NumHavMoreNumerals(number_1, number_2)) {	
		case 1:
			System.out.printf("Число %d имеет больше цифр, чем число %d.", number_1, number_2);
			break;
		case -1:
			System.out.printf("Число %d имеет меньше цифр, чем число %d.", number_1, number_2);
			break;
		case 0:
			System.out.printf("Число %d имеет то же количество цифр, что и число %d.", number_1, number_2);
		}
	}
	
	
	// метод определяющий количество цифр в числе
	public static int numeralAmount(int number) {
		
		int numeralAmount = 0;
		
		if (number == 0) {
			numeralAmount = 1;
		} else {
			
			while (number != 0) {
				
				number /= 10;
				numeralAmount++;
			}
		}		
		return numeralAmount;
	}
	
	
	// метод определяющий в каком числе больше цифр
	public static int NumHavMoreNumerals(int number_1, int number_2) {
		
		if(numeralAmount(number_1) > numeralAmount(number_2) ) {
			return 1;
		} else if (numeralAmount(number_1) < numeralAmount(number_2) ) {
			return -1;
		} else {
			return 0;
		}
	}

}
