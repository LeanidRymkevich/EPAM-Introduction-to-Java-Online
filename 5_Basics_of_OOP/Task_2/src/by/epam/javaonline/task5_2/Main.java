package by.epam.javaonline.task5_2;

/* Задача 2.
 * Создать класс Payment с внутренним классом, с помощью объектов
 * которого можно сформировать покупку из нескольких товаров.
*/

public class Main {

	public static void main(String[] args) {
		
		Payment payment_1 = new Payment();
		Payment payment_2 = new Payment();
		
		// the first payment
		
		Payment.Item banan = new Payment.Item("Banan", 10);
		Payment.Item lemon = new Payment.Item("Lemon", 7);
		Payment.Item bread = new Payment.Item("Bread", 3);
		Payment.Item milk = new Payment.Item("Milk", 5);
		Payment.Item chicken = new Payment.Item("Chicken", 15);
		Payment.Item pasta = new Payment.Item("Pasta", 20);
		Payment.Item cola = new Payment.Item("Coca-Cola", 8);
		payment_1.addItem(cola);
		payment_1.addItem(pasta);
		payment_1.addItem(pasta);
		payment_1.addItem(pasta);
		payment_1.addItem(chicken);
		payment_1.addItem(milk);
		payment_1.addItem(bread);
		payment_1.addItem(banan);
		payment_1.addItem(lemon);
		
		//____________________________
		
		// the second payment
		
		payment_2.addItem("Chair", 40);
		payment_2.addItem("Table", 50);
		payment_2.addItem("Sofa", 60);
		payment_2.addItem("Lamp", 35);
		payment_2.addItem("TV", 70);
		
		//______________________________
		
		View.showPayment(payment_1);
		System.out.println("\n");
		View.showPayment(payment_2);
		
		//__________________________
		
		payment_1.removeItem("pasta", 1);
		payment_1.sortByName();
		
		payment_2.sortByCost();
		
		//________________________
		
		System.out.println("\n");
		View.showPayment(payment_1);
		System.out.println("\n");
		View.showPayment(payment_2);
	}
}
