package by.epam.javaonline.algorithm.decomposition;

/* Два простых числа называются «близнецами», если они отличаются
 * друг от друга на 2 (например, 41 и 43). Найти и напечатать все
 * пары «близнецов» из отрезка [n,2n], где n - заданное натуральное
 * число больше 2. Для решения задачи использовать декомпозицию.*/

public class Task13 {

	public static void main(String[] args) {
		
		int n;
		int[] twinsArray;
		
		n = 40;
		twinsArray = findTwins(n, 2 * n);
		printTwins(twinsArray, n, 2 * n);
	}
	
	
	// метод проверяющий простое ли число аргумент 
	public static boolean isSimple(int number) {
		
		boolean isSimple = true;
		
		// 0 и 1 - не простые числа
		if (number == 0 || number == 1) {
			return false;
		}
		
		for (int i = 2; i < number; i++) {
			
			if (number % i == 0) {
				isSimple = false;
				break;
			}
		}
		
		return isSimple;
	}
	
	
	// метод поиска пар чисел-близнецов на отрезке и сохранение их в массиве
	public static int[] findTwins(int start, int end){
		
		int twinsAmount = 0; 
		
		// определение количества пар
		for (int i = start; i <= end - 2; i++) {
			
			if (isSimple(i)) {
				
				if(isSimple(i + 2)) {
					twinsAmount++;
				}
			}
		}
		
		// создание массива пар близнецов
		int[] twinsArray;
		int ind;
		
		twinsArray = new int[2* twinsAmount];
		ind = 0;
		
		for (int i = start; i <= end - 2; i++) {
			
			if (isSimple(i)) {
				
				if(isSimple(i + 2)) {
					twinsArray[ind] = i;
					twinsArray[ind + 1] = i + 2;
					ind +=2; 
				}
			}
		}
		
		return twinsArray;
	}
	
	
	// метод печати пар чисел близнецов в консоль
	public static void printTwins(int[] a, int start, int end) {
		
		System.out.printf("Пары чисел близнецы близнецов на отрезке [%d, %d]:\n",start,end);
		
		for(int i = 0; i < a.length - 1; i +=2) {
			System.out.printf("(%d и %d) ", a[i], a[i + 1]);
		}
	}

}
