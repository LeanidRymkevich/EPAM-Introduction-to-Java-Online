package by.epam.javaonline.task4_1_2;

/* 2.Создайте класс Test2 двумя переменными. Добавьте конструктор с 
 * входными параметрами. Добавьте конструктор, инициализирующий 
 * члены класса по умолчанию. Добавьте set- и get- методы для
 * полей экземпляра класса.*/

public class Test2 {
	
	private int var_1;
	private int var_2;
	
	public Test2() {
		
	}
	
	public Test2(int var_1, int var_2) {
		this.var_1 = var_1;
		this.var_2 = var_2;
	}
	
	public int getVar_1() {
		return var_1;
	}

	public void setVar_1(int var_1) {
		this.var_1 = var_1;
	}

	public int getVar_2() {
		return var_2;
	}

	public void setVar_2(int var_2) {
		this.var_2 = var_2;
	}

	
	
	public static void main(String[] args) {
		
		Test2 t_1 = new Test2();
		Test2 t_2 = new Test2(10,20);
		
		t_1.setVar_1(30);
		t_1.setVar_2(40);
		
		System.out.printf("Object t_1: var_1 = %d, var_2 = %d.\n", t_1.getVar_1(), t_1.getVar_2());
		System.out.printf("Object t_2: var_1 = %d, var_2 = %d.\n", t_2.getVar_1(), t_2.getVar_2());
	}

}
