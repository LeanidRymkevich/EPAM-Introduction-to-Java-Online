package by.epam.javaonline.task4_2_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Client {

	private String firstName;
	private String lastName;
	private String passportNumber;
	private final List<Account> accounts = new ArrayList<>();
	
	public Client() {
		
	}
	
	public Client(String firstName, String passportNumber) {
		this.firstName = firstName;
		this.passportNumber = passportNumber;
	}
	
	public Client(String firstName, String lastName, String passportNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.passportNumber = passportNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	public boolean addAccount(Account account) {
		accounts.add(account);
		return true;
	}
	
	public boolean removeAllAccounts() {
		accounts.clear();
		return true;
	}
	
	public boolean removeAccount(long number) {
				
		Account account = accountSearch(number);
		
		if(account == null) {
			return false;
		} else {
			accounts.remove(account);
			return true;
		}
	}
	
	public List<Account> getAccounts(){
		return List.copyOf(accounts);
	}
	
	public Account accountSearch(long number) {
		
		if(accounts.isEmpty()) return null;
		
		for(int i = 0; i < accounts.size(); i++) {
			
			if(accounts.get(i).getAccountNumber() == number) {
				return accounts.get(i);
			}
		}
		return null;
	}
	
	public boolean accountSort() {
		
		if(accounts.isEmpty()) return false;
		if(accounts.size() == 1)return true;
		
		Comparator<Account> comparator = new Comparator<>() {

			@Override
			public int compare(Account o1, Account o2) {
				
				if(o1.getAccountNumber() > o2.getAccountNumber()) {
					return 1;
				} else if (o1.getAccountNumber() < o2.getAccountNumber()) {
					return -1;
				} else {
					return 0;
				}
			}
			
		};
		
		accounts.sort(comparator);
		return true;
	}
	
	public long generalSum() {
		
		if(accounts.isEmpty()) return 0;
		
		long sum = 0;
		for(Account account: accounts) {
			sum += account.getBalance();
		}
		return sum;
	}
	
	public long positiveBalancesSum() {
		
		if(accounts.isEmpty()) return 0;
		
		long sum = 0;
		for(Account account: accounts) {
			
			if(account.getBalance() > 0) {
				sum += account.getBalance();
			}
		}
		return sum;
	}
	
	public long negativeBalancesSum() {
		
		if(accounts.isEmpty()) return 0;
		
		long sum = 0;
		for(Account account: accounts) {
			
			if(account.getBalance() < 0) {
				sum += account.getBalance();
			}
		}
		return sum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accounts, firstName, lastName, passportNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(accounts, other.accounts) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(passportNumber, other.passportNumber);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [firstName=" + firstName + ", lastName=" + lastName + ", passportNumber=" + passportNumber
				+ ", accounts=" + accounts + "]";
	}
	
	
}
