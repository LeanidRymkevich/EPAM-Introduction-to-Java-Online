package by.epam.javaonline.task4_1_3;

import java.util.Arrays;
import java.util.Objects;

/* 3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы,
 * номер группы, успеваемость (массив из пяти элементов). Создайте массив из
 * десяти элементов такого типа. Добавьте возможность вывода фамилий и номеров
 * групп студентов, имеющих оценки, равные только 9 или 10.*/

public class Student {
	
	private String lastName;
	private String initials;
	private String groupNum;
	private final int examNum = 5;
	private int[] grades = new int[examNum];
	
	public Student() {
		
	}
	
	public Student(String lastName, String initials) {
		
		this.lastName = checkStringField(lastName);
		this.initials = checkStringField(initials);
	}
	
	public Student(String lastName, String initials, String groupNum) {
		
		this.lastName = checkStringField(lastName);
		this.initials = checkStringField(initials);
		this.groupNum = checkStringField(groupNum);
	}
	
	public Student(String lastName, String initials, String groupNum, int[] grades) {
		
		this.lastName = checkStringField(lastName);
		this.initials = checkStringField(initials);
		this.groupNum = checkStringField(groupNum);
		this.grades = arrayCheck(grades, this.examNum);
		
	}
	
	public String getLastName() {
		return lastName;
	}

	public String getInitials() {
		return initials;
	}

	public String getGroupNum() {
		return groupNum;
	}

	public int[] getGrades() {
		return grades;
	}

	public void setLastName(String lastName) {
		this.lastName = checkStringField(lastName);
	}

	public void setInitials(String initials) {
		this.initials = checkStringField(initials);
	}

	public void setGroupNum(String groupNum) {
		this.groupNum = checkStringField(groupNum);
	}

	public void setGrades(int[] grades) {
		this.grades = arrayCheck(grades, this.examNum);
	}


	private static String checkStringField(String field) {
		
		if(field == null) {
			return "Не определено";
		}
		
		if(field.isEmpty()) {
			return "Не определено";
		} else {
			return field;
		}
	}
	
	private static int[] arrayCheck(int[] array, int length) {
				
		if (array.length != length){
			return Arrays.copyOf(array, 5);
		} else {
			return array;
		}
	}
	
	public boolean isAStudent() {
		
		boolean isAStud = true;
		for(int grade: getGrades()) {
			
			if(grade < 9) {
				isAStud = false;
				break;
			}	
		}
		return isAStud;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(grades);
		result = prime * result + Objects.hash(examNum, groupNum, initials, lastName);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return examNum == other.examNum && Arrays.equals(grades, other.grades)
				&& Objects.equals(groupNum, other.groupNum) && Objects.equals(initials, other.initials)
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "Student [lastName=" + lastName + ", initials=" + initials + ", groupNum=" + groupNum + ", examNum="
				+ examNum + ", grades=" + Arrays.toString(grades) + "]";
	}
}
