package by.epam.javaonline.task4_1_7;

import java.util.Objects;

/* 7. Описать класс, представляющий треугольник. Предусмотреть
 * методы для создания объектов, вычисления площади, периметра
 * и точки пересечения медиан.*/

public class Triangle {
	
	private final Point A;
	private final Point B;
	private final Point C;
	
	public Triangle(Point a, Point b, Point c) {
		
		if(isPointsCorrect(a, b, c)) {
			A = a;
			B = b;
			C = c;
		} else { // default triangle
			A = new Point(0, 0);
			B = new Point(6, 0);
			C = new Point(3, 6);
		}
	}
	
	public Triangle(int x_1, int y_1, int x_2, int y_2, int x_3, int y_3) {
		
		Point a = new Point(x_1, y_1);
		Point b = new Point(x_2, y_2);
		Point c = new Point(x_3, y_3);
		
		if(isPointsCorrect(a, b, c)) {
			A = a;
			B = b;
			C = c;
		} else { // default triangle
			A = new Point(0, 0);
			B = new Point(6, 0);
			C = new Point(3, 6);
		}
	}

	public Point getA() {
		return A;
	}

	public Point getB() {
		return B;
	}

	public Point getC() {
		return C;
	}
	
	public Point pointOfMedianInters() {
		
		Point a1; // point of middle of triangle side AB
		double x;
		double y;
		int m;
		int n;
		
		a1 = new Point((A.getX() + B.getX())/ 2, (A.getY() + B.getY()) / 2);
		
		// point of medians intersection divides median 2:1 (m:n) ratio
		// let's find such a point
		
		m = 2;
		n = 1;
		x = (n * C.getX() + m * a1.getX()) / (m + n);
		y = (n * C.getY() + m * a1.getY()) / (m + n);
	
		return new Point(x, y);
	}
	
	public double triangleArea() {
		
		double[] sides;
		double halfPerim;
		double ab;
		double bc;
		double ac;
		
		sides = sideLengths();
		halfPerim = perimeter() / 2;
		ab = sides[0];
		bc = sides[1];
		ac = sides[2];
		
		return Math.sqrt(halfPerim * (halfPerim - ab) * (halfPerim - bc) * (halfPerim - ac));
	}
	
	public double perimeter() {
		
		double[] sides = sideLengths();
		
		int sum = 0;
		for(double side: sides) {
			sum += side;
		}
		
		return sum;
	}
	
	private double[] sideLengths() {
		
		double[] sides = new double[3];
		
		sides[0] = sideLength(A, B);
		sides[1] = sideLength(B, C);
		sides[2] = sideLength(A, C);
		
		return sides;
	}
	
	private double sideLength(Point p_1, Point p_2) {
		
		double deltaX = p_1.getX() - p_2.getX();
		double deltaY = p_1.getY() - p_2.getY();
		
		return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
	}
	
	private boolean isPointsCorrect(Point p1, Point p2, Point p3) {
		
		if(p1 == null || p1 == null || p2 == null) {
			return false;
		} 
		
		if(p1.equals(p2) || p1.equals(p3) || p2.equals(p3)) {
			return false;
		} 
		
		double k;
		double b;
		
		/*
		 straight line is the line function kind of y = k * x + b, that mean if we have
		 coordinates of two points we can find coefficients k and b, and then we will be able
		 to check if all points lay on one line
		 */
		
		k = 0;
		b = 0;
		
		if(p1.getX() == p2.getX()) { // in case if line is vertical
			return !(p1.getX() == p3.getX());
		} else {
			k = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
			b = p1.getY() - k * p1.getX();
			return !((p3.getY() == k * p3.getX() + b));
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(A, B, C);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		return Objects.equals(A, other.A) && Objects.equals(B, other.B) && Objects.equals(C, other.C);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [A=" + A + ", B=" + B + ", C=" + C + "]";
	}
	
	
}
