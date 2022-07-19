package by.epam.javaonline.task4_2_5;

import java.util.Objects;

public class Client {

	private String firstName;
	private String lastName;
	private TouristVoucher touristVoucher;
	
	public Client() {
		
	}

	public Client(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Client(String firstName, String lastName, TouristVoucher touristVoucher) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.touristVoucher = touristVoucher;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public TouristVoucher getTouristVoucher() {
		return touristVoucher;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setTouristVoucher(TouristVoucher touristVoucher) {
		this.touristVoucher = touristVoucher;
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, touristVoucher);
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
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(touristVoucher, other.touristVoucher);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [firstName=" + firstName + ", lastName=" + lastName + ", touristVoucher=" + touristVoucher + "]";
	}
	
	
	
}
