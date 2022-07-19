package by.epam.javaonline.algorithm.decomposition;

/* На плоскости заданы своими координатами n точек. Написать метод(методы), определяющие,
 * между какими из пар точек самое большое расстояние. 
 * Указание. Координаты точек занести в массив.*/

public class Task4 {

	public static void main(String[] args) {
		
		int n = 8; // количество точек 
		
		// точки на плоскости задаются координатами х и у
		// поэтому и создаем два массива хранящие их
		
		int[] x = new int[n];
		int[] y = new int[n];
		
		randomPoints(x, y); 
		
		System.out.println("Исходные точки:");
		pointPrint(x, y);
		
		findMaxDistance(x,y);
	}
	
	
	// метод генерации n-случайных точек
	public static void randomPoints(int[] x, int[] y) {
		
		for (int i = 0; i < x.length; i++) {
			
			x[i] = (int) (Math.random()*101 - 50); // [-50, 50]
			y[i] = (int) (Math.random()*101 - 50); // [-50, 50]
		}
	}
	
	
	// метод вывода точек в консоль
	public static void pointPrint (int[] x, int[] y) {
		
		for (int i = 0; i < x.length; i++) {
			
			System.out.printf("P%d(%d,%d) ", i + 1, x[i], y[i]);
		}
	}
	
	
	// метод расчета расстояния между 2-мя точками
	public static double distance(int x1, int y1, int x2, int y2) {
		
		int a; // катет
		int b; // катет
		double c; // гипотенуза
		
		a = Math.abs(x1 - x2);
		b = Math.abs(y1 - y2);
		c = Math.sqrt(a * a + b * b);
		
		return c;
	}
	
	
	
	// метод нахождения макс. из расстояний между точками
	public static void findMaxDistance(int[] x, int[] y) {
		
		double max = 0; 
		int ind1 = 0; 
		int ind2 = 0;
		
		System.out.println("\n\nРасстояния между точками:");
		
		for (int i = 0; i < x.length; i++) {
			
			for (int j = i + 1; j < x.length; j++) {
				
				double dist = distance(x[i], y[i], x[j], y[j]);
				
				System.out.printf("dist(P%d-P%d)=%.2f\n",i + 1,j + 1, dist);
				
				if (dist > max) {
					
					max = dist;
					ind1 = i;
					ind2 = j;
				}		
			}
		}
		
		System.out.printf("\nНаибольшее из них между точкой P%d(%d,%d) и P%d(%d,%d) равно: %.2f.",
				ind1 + 1, x[ind1], y[ind1], ind2 + 1, x[ind2], y[ind2], max);
	}

}
