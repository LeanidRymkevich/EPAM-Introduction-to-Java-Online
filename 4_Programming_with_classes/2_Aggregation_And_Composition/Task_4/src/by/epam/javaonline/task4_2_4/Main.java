package by.epam.javaonline.task4_2_4;

import java.util.List;

/* 4. Счета. Клиент может иметь несколько счетов в банке. Учитывать возможность блокировки/разблокировки счета.
 * Реализовать поиск и сортировку счетов. Вычисление общей суммы по счетам. Вычисление суммы по всем счетам, 
 * имеющим положительный и отрицательный балансы отдельно.*/

public class Main {

	public static void main(String[] args) {
		
		Account account_1 = new Account(100);
		Account account_2 = new Account(-50);
		Account account_3 = new Account(200);
		Account account_4 = new Account(-100);
		Account account_5 = new Account(-150);
		Account account_6 = new Account(150);
		
		Client client_1 = new Client("Ivan", "Ivanov", "BM123456");
		Client client_2 = new Client("Petr", "Petrov", "BM789012");
		
		client_1.addAccount(account_1);
		client_1.addAccount(account_4);
		client_1.addAccount(account_5);
		
		client_2.addAccount(account_2);
		client_2.addAccount(account_3);
		client_2.addAccount(account_6);
		
		Bank bank = new Bank("MTBank");
		bank.addClient(client_1);
		bank.addClient(client_2);
		
		bank.findAccount(2).block();
		System.out.printf("Is account №2 belonging to %s active? - %b.\n", bank.findClienByAccount(2).getFirstName() + " "
				+ bank.findClienByAccount(2).getLastName(), bank.findAccount(2).isActive());
		
		bank.findAccount(2).unblock();
		System.out.printf("Is account №2 belonging to %s active? - %b.\n", bank.findClienByAccount(2).getFirstName() + " "
				+ bank.findClienByAccount(2).getLastName(), bank.findAccount(2).isActive());
		
		System.out.println("\nAll accounts in the bank:");
		List<Account> accounts = bank.getSortedAllAccounts();
		for(Account account: accounts) {
			System.out.println(account);
		}
		
		System.out.println();
		double sum_1 = bank.findClientByFirstName("Ivan").generalSum();
		System.out.printf("Sum of balance on Ivan's accounts is %.2f.\n",sum_1);
		
		System.out.println();
		double sum_2 = bank.findClientByLastName("Petrov").negativeBalancesSum();
		double sum_3 = bank.findClientByLastName("Petrov").positiveBalancesSum();
		System.out.printf("Sum of balances on Petrov's negative accounts is %.2f.\n",sum_2);
		System.out.printf("Sum of balances on Petrov's positive accounts is %.2f.\n",sum_3);
	}

}
