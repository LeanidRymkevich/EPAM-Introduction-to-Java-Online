package by.epam.javaonline.task4_1_3;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		
		int studentsNum = 10;
		Student[] students = new Student[studentsNum];
		
		students[0] = new Student("Иванов", "И.И.", "106120", new int[] {1,2,3,4,5});
		students[1] = new Student("Петров", "П.П.", "106120", new int[] {5,2,6,4,5});
		students[2] = new Student("Сидоров", "С.С.", "106120", new int[] {10,9,10,9,9});
		students[3] = new Student("Макаров", "М.М.", "106120", new int[] {1,8,6,10,9});
		students[4] = new Student("Антонов", "А.А.", "106120", new int[] {4,7,3,9,10});
		students[5] = new Student("Николаенко", "Н.Н.", "106110", new int[] {10,9,10,9,9});
		students[6] = new Student("Игнатенко", "И.И.", "106110", new int[] {6,9,3,5,8});
		students[7] = new Student("Тимуров", "Т.Т.", "106110", new int[] {5,6,9,2});
		students[8] = new Student("Андреев", "В.С.", "106110", new int[] {7,9,10,4,6,10});
		students[9] = new Student("Максимчик", "М.А.", "106110", new int[] {10,10,10,10,10});
		
		System.out.println("ВСЕ СТУДЕНТЫ:");
		for(Student student: students) {
			printStudent(student);
		}
		System.out.println();
		
		System.out.println("СТУДЕНТЫ - ОТЛИЧНИКИ:");
		for(Student student: students) {
			
			if(student.isAStudent()) {
				printAStudent(student);
			}
		}
	}
	
	public static void printStudent(Student student) {
		System.out.printf("Студент: %12s %s Группа: %s Оценки: %20s.\n",
				student.getLastName(), student.getInitials(), student.getGroupNum(), Arrays.toString(student.getGrades()));
	}
	
	public static void printAStudent(Student student) {
		System.out.printf("Студент: %12s %s Группа: %s.\n",
				student.getLastName(), student.getInitials(), student.getGroupNum());
	}
}
