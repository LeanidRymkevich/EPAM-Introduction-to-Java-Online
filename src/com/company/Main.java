package com.company;

public class Main {

    public static void main(String[] args) {
		for (int num = 0; num <= 120; num++){
			// проверяем числа с еденицей в конце
			if (num % 10 == 1) {
				if (num % 100 == 11) {
					System.out.println(num + " рублей;");
				} else {
					System.out.println(num + " рубль;");
				}
			}
			// проверяем числа с цифрами: 2, 3, 4 в конце
			else if ( (num % 10) >=2 && (num % 10) <=4 ){
				if ( (num % 100) >=12 && (num % 100) <=14 ){
					System.out.println(num + " рублей;");
				}
				else {
					System.out.println(num + " рубля;");
				}
			}
			// определяем падеж для всех остальных цифр не подпадающих под вышеперечисленные правила
			else {
				System.out.println(num + " рублей;");
			}
		}

    }
}
