package by.epam.javaonline.algorithm.arayofarray;

/*Сформировать квадратную матрицу порядка N по правилу:
 * a(i, j) = sin( (i^2 - j^2) / n^2 ), 
 * и подсчитать количество положительных элементов в ней.
*/

public class Task7 {

	public static void main(String[] args) {
		
		int n;
		double[][] a;
		
		n = 6;
		a = new double[n][n];
		
		int counter = 0; 
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
				
				double b =(double) (i * i - j * j) / (n * n);
				a[i][j] = Math.sin(b);
				
				if(a[i][j] > 0) {
					counter++;
				}
			}
		}
		
		System.out.printf("Получившийся массив a[%d][%d]: \n", n,n);
		printArray(a);
		System.out.printf("В нем %d положительных элементов.", counter);	
	}
	
	public static void printArray (double[][] a) {
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf("%8.2f", a[i][j]);
			}
			System.out.println();
		}
	}
}
