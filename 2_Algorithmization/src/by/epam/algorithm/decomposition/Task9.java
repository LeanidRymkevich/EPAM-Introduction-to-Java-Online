package by.epam.javaonline.algorithm.decomposition;

/* Даны числа X, Y, Z, Т — длины сторон четырехугольника.
 * Написать метод(методы) вычисления его площади, если угол
 * между сторонами длиной X и Y— прямой.
*/

public class Task9 {

	public static void main(String[] args) {
		
		/* так как угол между сторонами длиной X и Y — прямой,
		 * то по сути площадь четырехугольника можно рассчитать
		 * как сумму площадей 2-х треугольников (по трем сторонам)
		 * с общей стороной - гипотенузой прямоугольного треугольника с
		 * катетами длинной X и Y
		*/
		
		double x;
		double y;
		double z;
		double t;
		
		x = 10;
		y = 15;
		z = 12;
		t = 23;
		
		System.out.printf("Площадь четырехугольника со сторонами: Х = %.1f, Y = %.1f,"
				+ " Z = %.1f, T = %.1f и прямым углом между сторонами X и Y равна %.2f.",
				x, y, z, t, quadrangleArea(x, y, z, t));
	}
	
	
	// метод вычисления гипотенузы
	public static double hypotenuse(double a, double b) {
		
		return Math.sqrt(a * a + b * b);
	}
	
	
	// метод вычисления площади треугольника по 3-м его сторонам
	public static double triangleArea(double a, double b, double c) {
		
		double p;
		double area;
		
		p = (a + b + c) / 2;
		area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		
		return area;
	}
	
	
	// метод вычисления площади четырехугольника с прямым углом между сторонами X и Y
	public static double quadrangleArea(double x, double y, double z, double t) {
		
		double hypot;
		double area;
		
		hypot = hypotenuse(x,y);
		area = triangleArea(x, y, hypot) + triangleArea(z, t, hypot);
		
		return area;
	}

}
