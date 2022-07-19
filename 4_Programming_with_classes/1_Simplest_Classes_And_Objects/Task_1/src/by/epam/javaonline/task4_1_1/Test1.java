package by.epam.javaonline.task4_1_1;

/* 1.Создайте класс Test1 двумя переменными. Добавьте метод вывода
 * на экран и методы изменения этих переменных. Добавьте метод, который
 * находит сумму значений этих переменных, и метод, который находит
 * наибольшее значение из этих двух переменных.*/

public class Test1 {
	
	private int var_1 = 10;
	private int var_2 = 20;
	
	public Test1() {
		
	}
	
	public void setVar_1(int var) {
		var_1 = var;
	}
	
	public void setVar_2(int var) {
		var_2 = var;
	}
	
	public int getVar_1() {
		return var_1;
	}

	public int getVar_2() {
		return var_2;
	}

	public void printVar() {
		System.out.printf("var_1 = %d, var_2 = %d.\n", var_1, var_2);
	}
	
	public int varSum() {
		return var_1 + var_2;
	}
	
	public int biggestVar() {
		
		if(var_1 > var_2) {
			return var_1;
		} else {
			return var_2;
		}
	}

	
	
	public static void main(String[] args) {
		
		Test1 test = new Test1();
		
		test.printVar();
		
		test.setVar_1(30);
		test.setVar_2(40);
		
		test.printVar();
		
		int sum = test.varSum();
		System.out.printf("Sum of variable is %d.\n", sum);
		
		int biggestVar = test.biggestVar();
		System.out.printf("The biggest number of variables is %d.\n", biggestVar);
	}
}
