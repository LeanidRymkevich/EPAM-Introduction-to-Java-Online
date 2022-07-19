package by.epam.javaonline.task4_1_8;

public class Main {

	public static void main(String[] args) {
		
		Person person_2 = new Person("Ivanov", "Ivan", "Ivanovich");
		Person person_3 = new Person("Mask", "Ilon");
		Person person_4 = new Person("Karskiy", "Oleg", "Olegovich");
		Person person_5 = new Person("Jackson", "John");
		Person person_6 = new Person("Grzegorz", "Petr", "Adamovich");
		
		//___________________________________________________________________________
		
		Address address_2 = new Address("Belarus", "Minsk", "Prityckogo", "17/2","213");
		Address address_3 = new Address("USA", "New York", "1st Avenue", "123B");
		Address address_4 = new Address("Russia", "Moscow", "Lubyanka", "4/3");
		Address address_5 = new Address("The United Kingdom", "London", "Baker Street", "221b", "2");
		Address address_6 = new Address("Poland", "Poznan", "Narodova", "31B", "23");
		
		//___________________________________________________________________________
		
		String creditCardNumber_2 = "1234 1234 1234 1234";
		String creditCardNumber_3 = "4453 0123 9021 1245";
		String creditCardNumber_4 = "5812 6143 6721 4945";
		String creditCardNumber_5 = "3892 0943 2378 2945";
		String creditCardNumber_6 = "9021 1245 0943 2378";
		
		//___________________________________________________________________________
		
		String bankAccount_2 = "1234 1234 1234 1234 1234";
		String bankAccount_3 = "1206 1978 1234 4674 3543";
		String bankAccount_4 = "1275 4778 3434 0984 3483";
		String bankAccount_5 = "3892 0943 2378 2945 3483";
		String bankAccount_6 = "5812 1245 0943 2945 3434";
		
		//___________________________________________________________________________
		
		Customer cust_1 = new Customer();
		Customer cust_2 = new Customer(person_2, address_2, creditCardNumber_2, bankAccount_2);
		Customer cust_3 = new Customer(person_3, address_3, creditCardNumber_3, bankAccount_3);
		Customer cust_4 = new Customer(person_4, address_4, creditCardNumber_4, bankAccount_4);
		Customer cust_5 = new Customer(person_5, address_5, creditCardNumber_5, bankAccount_5);
		Customer cust_6 = new Customer(person_6, address_6, creditCardNumber_6, bankAccount_6);
		
		//____________________________________________________________________________
		
		CustomerList list = new CustomerList();
		list.getCustomers().add(cust_1);
		list.getCustomers().add(cust_2);
		list.getCustomers().add(cust_3);
		list.getCustomers().add(cust_4);
		list.getCustomers().add(cust_5);
		list.getCustomers().add(cust_6);
		
		//____________________________________________________________________________
		
		System.out.println("AVAILABLE CUSTOMERS:");
		list.showCustomers();
		
		//____________________________________________________________________________
		
		System.out.println("CUSTOMERS LIST SORTED BY NAME:");
		list.customerListSortByName();
		list.showCustomers();
		
		//____________________________________________________________________________
		
		String minCardNum = "3000 0000 0000 0000";
		String maxCardNum = "8000 0000 0000 0000";
		
		System.out.printf("CUSTOMERS WITH NUMBER OF CREDIT CARD IN RANGE [%s; %s]:\n", minCardNum, maxCardNum);
		list.showCustomersInCardRange(minCardNum, maxCardNum);	
	}
}
