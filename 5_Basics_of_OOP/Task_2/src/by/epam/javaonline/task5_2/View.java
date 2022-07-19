package by.epam.javaonline.task5_2;

import java.util.List;

public class View {

	public static void showPayment(Payment payment) {
		
		List<Payment.Item> goods = payment.getGoods();
		
		System.out.printf("CUSTOMER'S PAYMENT #%d\n", payment.getId());
		for(Payment.Item item : goods) {
			System.out.printf("Item: [%s]; cost: [%.2f]$\n", item.getName(), item.getCost());
		}
		System.out.printf("TOTAL SUM = %.2f$.", payment.totalSum());
	}
}
