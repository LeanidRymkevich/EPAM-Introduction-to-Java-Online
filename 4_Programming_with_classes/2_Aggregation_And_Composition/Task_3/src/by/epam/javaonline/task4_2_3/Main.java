package by.epam.javaonline.task4_2_3;

/* 3. Создать объект класса Государство, используя классы Область, Район, Город.
 * Методы: вывести на консоль столицу, количество областей, площадь, областные центры.*/

public class Main {

	public static void main(String[] args) {
	
		City glubokoe = new City("Glubokoe");
		City polotsk = new City("Glubokoe");
		City braslav = new City("Braslav");
		
		District glubokskij = new District("Glubokskij", glubokoe, 20_000, 1_800);
		District polotskij = new District("Polotskij", polotsk, 30_000, 2_400);
		District braslavskij = new District("Braslavskij", braslav, 13_000, 1_900);
		
		
		City borisov = new City("Borisov");
		City molodechno = new City("Molodechno");
		
		District borisovskij = new District("Borisovskij", borisov, 40_000, 3_200);
		District molodechenskij = new District("Molodechenskij", molodechno, 45_000, 3_800);
		
		
		City vitebsk = new City("Vitebsk");
		Region vitebskij = new Region("Vitebskij", vitebsk);
		vitebskij.addDistrict(glubokskij);
		vitebskij.addDistrict(polotskij);
		vitebskij.addDistrict(braslavskij);
		
		City minsk = new City("Minsk");
		Region minskij = new Region("Minskij", minsk, borisovskij, molodechenskij);
		
		
		State belarus = new State("Belarus", minsk, vitebskij, minskij);
		belarus.showCapital();
		belarus.showRegionNumber();
		belarus.showArea();
		belarus.showRegionCenters();
		
	}

}
