package by.epam.javaonline.algorithm.arayofarray;

/* Матрицу 10x20 заполнить случайными числами от 0 до 15.
 * Вывести на экран саму матрицу и номера строк,
 * в которых число 5 встречается три и более раз
*/

public class Task11 {

	public static void main(String[] args) {
		
		int n;
		int m;
		int[][] a;
		
		n = 10;
		m = 20;
		a = createAndFill(n,m);
		
		System.out.printf("В исходной матрице a[%d][%d]: \n", a.length, a[0].length);
		printArray(a);
		System.out.print("\nномера строк, в которых число 5 встречается три и более раз: ");
		
		int num = 0; 
		for (int i = 0; i < a.length; i++) {
			
			int counter = 0;
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == 5) {
					counter++;
				}
			}
			
			if (counter >= 3) {
				num++;
				System.out.printf("%d ", i + 1); // номер строки начиная с 1-й
			}
		}
		
		if (num == 0) {
			System.out.println("таких строк в матрице нет.");
		}

	}
	
	public static int[][] createAndFill(int n, int m){
		
		int[][] a = new int[n][m];
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
				a[i][j] = (int) (Math.random() * 15); // промежуток значений от 0 до 15
			}
		}
		
		return a;
	}
	
	public static void printArray(int a[][]) {
		
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[i].length; j++) {
				System.out.printf(" %3d ",a[i][j]);
			}
			System.out.println();
		}
	}	
}
