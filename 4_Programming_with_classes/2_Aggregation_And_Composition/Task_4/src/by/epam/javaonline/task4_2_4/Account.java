package by.epam.javaonline.task4_2_4;

import java.util.Objects;

public class Account {
	
	private static long counter = 0;
	private final long accountNumber;
	private double balance;
	private boolean isActive;
	
	public Account() {
		counter++;
		accountNumber = counter;
		isActive = true;
	}
	
	public Account(double balance) {
		counter++;
		accountNumber = counter;
		isActive = true;
		this.balance = balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean block() {
		isActive = false;
		return isActive;
	}
	
	public boolean unblock() {
		isActive = true;
		return isActive;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, balance, isActive);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return accountNumber == other.accountNumber
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& isActive == other.isActive;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [accountNumber=" + accountNumber + ", balance=" + balance + ", isActive=" + isActive + "]";
	}


	
}
