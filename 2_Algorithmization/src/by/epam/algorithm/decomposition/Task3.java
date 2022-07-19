package by.epam.javaonline.algorithm.decomposition;

/* Вычислить площадь правильного шестиугольника со стороной а,
 * используя метод вычисления площади треугольника*/

public class Task3 {

	public static void main(String[] args) {
		
		/* Особенность правильного шестиугольника — равенство его стороны
		 * и радиуса описанной окружности, т.е. его площадь может быть 
		 * вычислена как 6 площадей равностороннего треугольника со стороной а */
		
		double a;
		double s;
		
		a = 6;
		s = regularHexagonArea(a);
		
		System.out.printf("Площадь правильного шестиугольника со стороной a = %.2f равна %.2f.", a, s);
		
	}
	
	// метод расчета площади равностороннего треугольника по его одной стороне
	public static double equilTriangleArea(double a) {
		
		return a * a * Math.sqrt(3) / 4;
	}
	
	
	// метод расчета площади правильного шестиугольника по его одной стороне
	public static double regularHexagonArea(double a) {
		
		return 6 * equilTriangleArea(a);
	}
}
