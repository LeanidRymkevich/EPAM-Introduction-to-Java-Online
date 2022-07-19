package by.epam.javaonline.task4_1_8;

import java.util.Formatter;
import java.util.Objects;

/* 8. Создать класс Customer, спецификация которого приведена ниже. Определить
 * конструкторы, set- и get- методы и метод toString(). Создать второй класс,
 * агрегирующий массив типа Customer, с подходящими конструкторами и методами.
 * Задать критерии выбора данных и вывести эти данные на консоль.
   Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки,
   номер банковского счета.
   Найти и вывести:
   a) список покупателей в алфавитном порядке;
   b) список покупателей, у которых номер кредитной карточки находится в
      заданном интервале.
*/

public class Customer {
	
	private static int counter = 0;
	
	private final int id;
	
	private Person person;
	private Address address;
	private String creditCardNumber;
	private String bankAccount;
	
	{
		person = new Person();
		address = new Address();
		creditCardNumber = "0000 0000 0000 0000";
		bankAccount = "0000 0000 0000 0000 0000";
	}
	
	public Customer() {
		counter++;
		id = counter;
	}
	
	public Customer(Person person, Address address, String creditCardNumber,String bankAccount) {
		
		counter++;
		id = counter;
		
		if (person != null) {
			this.person = person;
		} else {
			this.person = new Person();
		}
		
		if (address != null) {
			this.address = address;
		} else {
			this.address = new Address();
		}
		
		this.creditCardNumber = creditCardNumCheck(creditCardNumber);
		this.bankAccount = bankAccountCheck(bankAccount);
	}
	

	public int getId() {
		return id;
	}

	public Person getPerson() {
		return person;
	}

	public Address getAddress() {
		return address;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumCheck(creditCardNumber);
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccountCheck(bankAccount);
	}
	
	
	public String customerInfo() {
		
		try (Formatter result = new Formatter()) {
			
			StringBuilder line = new StringBuilder();
			String person;
			String address;
			String account;
			String card;
			String hat;
			int stringWidth;
			
			hat = "| Customer id: " + this.id;
			
			person = "| Last name: " + this.person.getLastName() + " | First name: " + this.person.getFirstName() + 
					" | Patronymic: " + this.person.getPatronymic();
			
			address = "| Country: " + this.address.getCountry() + " | City: " + this.address.getCity() + " | Street: " + 
						this.address.getStreet() + " | House number: " + this.address.getHouseNum() + 
						" | Flat numeber: " + this.address.getFlatNum() + " |";
			
			card = "| Card number: " + this.creditCardNumber;
			
			account = "| Account: " + this.bankAccount;
			
			for(int i = 1; i <= address.length() - 2; i++) {
				line.append('_');
			}
			
			stringWidth = line.length();
			
			result.format(" %1$s\n" +
						  "%2$-" + stringWidth +"s |\n" +
						  "|%1$-" + (stringWidth - 2) +"s|\n" +
						  "%3$-" + stringWidth +"s |\n" +
						  "|%1$-" + (stringWidth - 2) +"s|\n" +
						  "%4$-" + stringWidth +"s\n" +
						  "|%1$-" + (stringWidth - 2) +"s|\n" +
						  "%5$-" + stringWidth +"s |\n" +
						  "|%1$-" + (stringWidth - 2) +"s|\n" +
						  "%6$-" + stringWidth +"s |\n" +
						  "|%1$-" + (stringWidth - 2) +"s|",
						  line, hat, person, address, card, account);
			
			return result.toString();
		}
	}
	
	private static String creditCardNumCheck(String number) {
		String pattern = "(\\d{4}\\s?){4}";
		return Address.stringCheck(number, pattern, "0000 0000 0000 0000");
	}
	
	private static String bankAccountCheck(String account) {
		String pattern = "(\\d{4}\\s?){5}";
		return Address.stringCheck(account, pattern, "0000 0000 0000 0000 0000");
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, bankAccount, creditCardNumber, id, person);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(bankAccount, other.bankAccount)
				&& Objects.equals(creditCardNumber, other.creditCardNumber)
				&& Objects.equals(person, other.person);
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id=" + id + ", person=" + person + ", address=" + address + ", creditCardNumber="
				+ creditCardNumber + ", bankAccount=" + bankAccount + "]";
	}
}
