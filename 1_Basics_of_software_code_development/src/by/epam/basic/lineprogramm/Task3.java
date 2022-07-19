package by.epam.javaonline.basic.lineprogramm;
/*
 *Вычислить значение выражения по формуле (все переменные принимают действительные значения):
 *( (𝑠𝑖𝑛 𝑥 + 𝑐𝑜𝑠 𝑦) / (𝑐𝑜𝑠 𝑥 − 𝑠𝑖𝑛 𝑦) ) * 𝑡𝑔(𝑥 * 𝑦)
*/

public class Task3 {

	public static void main(String[] args) {

		double x;
		double y;
		double rez;

		x = 4.0;
		y = 3.0;

		rez = ((Math.sin(x) + Math.cos(y)) / (Math.cos(x) - Math.sin(y))) * Math.tan(x * y);

		System.out.printf("Expression rezult: %f", rez);

	}
}
