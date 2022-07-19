package by.epam.javaonline.task4_1_8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerList {
	
	private final List<Customer> customers = new ArrayList<>();
	
	public CustomerList() {
		
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	
	public void showCustomers() {
		
		if(customers.isEmpty()) {
			System.out.println("LIST OF CUSTOMERS IS EMPTY!!!!");
		} else {
			
			for(Customer customer: customers) {
				System.out.println(customer.customerInfo());
			}
			System.out.println();
		}
		
	}
	
	public void showCustomersInCardRange(String start, String end) {
		
		long min = Long.valueOf(start.replaceAll("\\s", ""));
		long max = Long.valueOf(end.replaceAll("\\s", ""));
		
		if(customers.isEmpty()) {
			System.out.println("LIST OF CUSTOMERS IS EMPTY!!!!");
		} else {
			
			for(Customer customer: customers) {
				
				long cardNum = Long.valueOf(customer.getCreditCardNumber().replaceAll("\\s", ""));
				if(min <= cardNum && max >= cardNum) {
					System.out.println(customer.customerInfo());
				}
			}
			System.out.println();
		}
	}
	
	public void customerListSortByName() {
		
		int min = 0;
		Person person_min = null;
		Person person_j = null;
		
		for(int i = 0; i < customers.size(); i++) {
			
			min = i;
			
			for (int j = i; j < customers.size(); j++) {
				
				person_min = customers.get(min).getPerson();
				person_j = customers.get(j).getPerson();
				
				if(person_j.compare(person_min) < 0) {
					min = j;
				}
			}
			
			Customer temp = customers.get(min);
			customers.set(min, customers.get(i));
			customers.set(i,temp);
		}
	}
	
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [customers=" + customers + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerList other = (CustomerList) obj;
		return Objects.equals(customers, other.customers);
	}
}
