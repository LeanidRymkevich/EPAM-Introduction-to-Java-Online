package by.epam.javaonline.task4_1_8;

import java.util.Objects;

public class Person {
	
	private String lastName;
	private String firstName;
	private String patronymic;
	
	{
		lastName = "Undefined";
		firstName = "Undefined";
		patronymic = "Undefined";
	}
	
	public Person() {
		
	}
	
	public Person(String lastName, String firstName) {
		this.lastName = initialsCheck(lastName);
		this.firstName = initialsCheck(firstName);
	}

	public Person(String lastName, String firstName, String patronymic) {
		this.lastName = initialsCheck(lastName);
		this.firstName = initialsCheck(firstName);
		this.patronymic = initialsCheck(patronymic);
	}


	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setLastName(String lastName) {
		this.lastName = initialsCheck(lastName);
	}

	public void setFirstName(String firstName) {
		this.firstName = initialsCheck(firstName);
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = initialsCheck(patronymic);
	}
	
	public int compare(Person person) {
		
		if(this.lastName.compareToIgnoreCase(person.lastName) > 0) {
			return 1;
		} else if (this.lastName.compareToIgnoreCase(person.lastName) < 0) {
			return -1;
		} else {
			
			if(this.firstName.compareToIgnoreCase(person.firstName) > 0) {
				return 1;
			} else if (this.firstName.compareToIgnoreCase(person.firstName) < 0) {
				return -1;
			} else {
				
				if(this.patronymic.compareToIgnoreCase(person.patronymic) > 0) {
					return 1;
				} else if (this.patronymic.compareToIgnoreCase(person.patronymic) < 0) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}

	
	private static String initialsCheck(String name) {
		String pattern = "[A-Za-z]+";
		return Address.stringCheck(name, pattern, "Undefined");
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, patronymic);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(patronymic, other.patronymic);
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() +
				" [lastName=" + lastName + ", firstName=" + firstName + ", patronymic=" + patronymic + "]";
	}
}
