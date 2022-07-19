package by.epam.javaonline.task4_2_4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Bank {
	
	private String name;
	private final List<Client> clients = new ArrayList<>();
	
	public Bank() {
		
	}

	public Bank(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Client> getClients(){
		return List.copyOf(clients);
	}
	
	public boolean addClient(Client client) {
		clients.add(client);
		return true;
	}
	
	public Client findClient(String passportNum) {
		
		if(clients.isEmpty()) return null;
		
		for(int i = 0; i < clients.size(); i++) {
			
			if(clients.get(i).getPassportNumber() == passportNum) {
				return clients.get(i);
			}
		}
		return null;
	}
	
	public Client findClientByFirstName(String name) {
		
		if(clients.isEmpty()) return null;
		
		for(int i = 0; i < clients.size(); i++) {
			
			if(clients.get(i).getFirstName() == name) {
				return clients.get(i);
			}
		}
		return null;
	}
	
	public Client findClientByLastName(String name) {
		
		if(clients.isEmpty()) return null;
		
		for(int i = 0; i < clients.size(); i++) {
			
			if(clients.get(i).getLastName() == name) {
				return clients.get(i);
			}
		}
		return null;
	}
	
	public Client findClienByAccount(long number) {
		
		if(clients.isEmpty()) return null;
		
		Account account = null;
		for(Client client: clients) {
			
			account = client.accountSearch(number);
			if(account != null) {
				return client;
			}
		}
		return null;
	}
	
	public boolean removeAllClients() {
		clients.clear();
		return true;
	}
	
	public boolean removeClient(String passportNum) {
		
		Client client = findClient(passportNum);
		
		if(client == null) {
			return false;
		} else {
			clients.remove(client);
			return true;
		}
	}
	
	public Account findAccount(long number) {
		
		if(clients.isEmpty()) return null;
		
		Account account = null;
		for(Client client: clients) {
			
			account = client.accountSearch(number);
			if(account != null) {
				return account;
			}
		}
		return null;
	}
	
	public List<Account> getAllAccounts(){
		
		if(clients.isEmpty()) return null;
		
		List<Account> accounts = new ArrayList<>();
		for(Client client: clients) {
			accounts.addAll(client.getAccounts());
		}
		return accounts;
	}
	
	public List<Account> getSortedAllAccounts(){
		
		List<Account> accounts= getAllAccounts();
		
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
		return accounts;
	}

	@Override
	public int hashCode() {
		return Objects.hash(clients, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		return Objects.equals(clients, other.clients) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + name + ", clients=" + clients + "]";
	}
	
	
}
