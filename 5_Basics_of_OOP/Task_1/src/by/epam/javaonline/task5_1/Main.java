package by.epam.javaonline.task5_1;

/* Задача 1.
 * Создать объект класса Текстовый файл, используя классы Файл, Директория.
 * Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.
*/

public class Main {

	public static void main(String[] args) {
	
		Directory root = new Directory("C:\\root", "root");
		TextFile rootFile_1 = root.createTextFile("rootFile_1", "txt");
		TextFile rootFile_2 = root.createTextFile("rootFile_2", "txt");
		
		Directory branch_1 = root.createSubDirectory("branch_1");
		Directory branch_2 = root.createSubDirectory("branch_2");
		
		TextFile branchFile_11 = branch_1.createTextFile("branchFile_11", "doc");
		
		TextFile branchFile_21 = branch_2.createTextFile("branchFile_21", "docx");
		
		Directory leaf_21 = branch_2.createSubDirectory("leaf_21");
		Directory leaf_22 = branch_2.createSubDirectory("leaf_22");
		
		TextFile leafFile_211 = leaf_21.createTextFile("leafFile_211", "fb2");
		TextFile leafFile_212 = leaf_21.createTextFile("leafFile_212", "fb2");
		
		TextFile leafFile_221 = leaf_22.createTextFile("leafFile_221", "rtf");
		
		View.printDirectory(root);
		
		//_________________________________________
		System.out.println("\n");
		//_________________________________________
		
		leafFile_211.rename("Document_1");
		leaf_22.rename("TheLastDirectory");
		
		root.removeSubDirectory("branch_1");
		leaf_21.removeTextFile("leafFile_212");
		
		View.printDirectory(root);
		
		//_________________________________________
		System.out.println("\n");
		//_________________________________________
	
		String str1 = "Задача 1. ";
		String str2 = "Создать объект класса Текстовый файл, используя классы Файл, Директория. ";
		String str3 = "Методы: создать, переименовать, вывести на консоль содержимое, дополнить, удалить.";
		
		rootFile_1.addToContent(str1);
		View.printTextFile(rootFile_1);
		
		System.out.println("\n");
		
		rootFile_1.addToContent(str2, str3);
		View.printTextFile(rootFile_1);
	}

}
