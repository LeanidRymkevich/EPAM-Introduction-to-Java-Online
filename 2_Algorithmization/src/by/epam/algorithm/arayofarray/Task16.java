package by.epam.javaonline.algorithm.arayofarray;

import java.util.Arrays;

/* Магическим квадратом порядка n называется квадратная матрица размера n*n,
 * составленная из чисел 1, 2, 3,..., n^2 так, что суммы по каждому столбцу,
 * каждой строке и каждой из двух больших диагоналей равны между собой.
 *  Построить такой квадрат.
*/

public class Task16 {

	public static void main(String[] args) {
		
		int n;
		int[][] a;
		
		n = 3;
		a = new int[n][n];
		
		// здесь используется обычный перебор вариантов
		// работает только для матрицы 3*3
		
		boolean isAllEqual;
		int[] sum1;
		
		do {
			
			a = create(n);
			sum1 = sum(a);
			isAllEqual = isEqual(sum1);
			
		}while( !isAllEqual);
		
		System.out.printf("Итоговая матрица a[%d][%d]:\n", a.length, a[0].length);
		printArray(a);
		System.out.println("Матрица содержащая суммы элементов столбцов, строк, и 2-х диагоналей " + Arrays.toString(sum1));
	}
	
	
	// метод создающий матрицу размера n*n, состоящую из элементов от 1 до n^2 включительно
	// с размещением чисел на случайных позициях в массиве
	public static int[][] create(int n) { 
		
		int[][] a = new int[n][n];
		
		for (int k = 1; k <= n * n; k++) {
			
			int i = (int) (Math.random()* n);
			int j = (int) (Math.random()* n);
			
			while (a[i][j] != 0) {
				 i = (int) (Math.random()* n);
				 j = (int) (Math.random()* n);				
			}
			
			a[i][j] = k;
		}
		
		return a;
	}
	
	// метод подсчета сумм столбцов, строк и 2-х диагоналей
	// и помещающий каждый из результатов в одномерный массив сумм
	public static int[] sum(int[][] a) {
		
		int[] sum;
		int number;
		
		number = a.length + a.length + 2;
		sum = new int[number];
		
		int gld = 0;
		int vsd = 0;
		
		for(int i = 0; i < a.length; i++) {
				
			int str = 0;
			int stl = 0;
			for(int j = 0; j < a[0].length; j++) {
				str += a[i][j];
				stl += a[j][i];
					
			}
			
			gld += a[i][i];
			vsd += a[i][a.length - 1 - i];
			
			sum[i] = str;
			sum[a.length + i] = stl;
		}
		
		sum[a.length + a.length] = gld;
		sum[a.length + a.length + 1] = vsd;
		
		return sum;
	}
	
	// проверяет равны ли все элементы одномерного массива
	public static boolean isEqual(int[] sum) {
		
		boolean isAllEqual = true;
		int number = sum[0];
		
		for (int num: sum) {
			
			if(num != number) {
				isAllEqual = false;
				break;
			}
		}
		
		return isAllEqual;
	}
	
	// метод печати в консоль
	public static void printArray (int[][] a) {
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(Arrays.toString(a[i]));
		}	
	}
}
