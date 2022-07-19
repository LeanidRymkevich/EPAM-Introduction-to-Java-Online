package by.epam.javaonline.task4_1_7;

public class Main {

	public static void main(String[] args) {
		
		Point a = new Point(-2,1);
		Point b = new Point(-2,5);
		Point c = new Point(0,1);
		
		Triangle tr1 = new Triangle(1,1,1,1,3,3);
		Triangle tr2 = new Triangle(1,1,2,2,3,3);
		Triangle tr3 = new Triangle(1,1,1,7,5,4);
		Triangle tr4 = new Triangle(a,b,c);
		
		System.out.println("1: " + tr1);
		System.out.println("2: " + tr2);
		System.out.println("3: " + tr3);
		System.out.println("4: " + tr4);
		
		double perimeter;
		double area;
		Point pointOfMedInter;
		
		perimeter = tr1.perimeter();
		area = tr3.triangleArea();
		pointOfMedInter = tr4.pointOfMedianInters();
		
		System.out.printf("\nPerimetr of triangle №1: %.2f.",perimeter);
		System.out.printf("\nArea of triangle №3: %.2f.",area);
		System.out.printf("\nPoint of medians intersection of triangle №3 "
				+ "is M(%.2f, %.2f).", pointOfMedInter.getX(), pointOfMedInter.getY());
	}

}
