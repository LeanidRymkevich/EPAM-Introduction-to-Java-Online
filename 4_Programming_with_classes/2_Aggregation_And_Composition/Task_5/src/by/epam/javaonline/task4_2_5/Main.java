package by.epam.javaonline.task4_2_5;

import java.util.List;

/* 5. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки различного типа
 * (отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать возможность выбора транспорта,
 * питания и числа дней. Реализовать выбор и сортировку путевок.*/

public class Main {

	public static void main(String[] args) {
		
		TouristCompany primeTour = new TouristCompany("Prime Tour");
		
		Client client_1 = new Client("Petr", "Petrov");
		Client client_2 = new Client("Ivan", "Ivanov");
		
		TouristVoucher tv_1 = new TouristVoucher("Greece", "Tripoli", TourismType.EXCURSION, Transport.BUS, Nutrition.NOTHING_INCLUDED, 10, 200);
		TouristVoucher tv_2 = new TouristVoucher("Poland", "Warsaw", TourismType.EXCURSION, Transport.TRAIN, Nutrition.NOTHING_INCLUDED, 5, 100);
		TouristVoucher tv_3 = new TouristVoucher("Italy", "Florence", TourismType.RELAXATION, Transport.CAR, Nutrition.NOTHING_INCLUDED, 3, 100);
		TouristVoucher tv_4 = new TouristVoucher("Poland", "Warsaw", TourismType.RELAXATION, Transport.BUS, Nutrition.BREAKFAST_AND_LUNCH, 10, 300);
		TouristVoucher tv_5 = new TouristVoucher("Italy", "Florence", TourismType.SHOPPING, Transport.PLANE, Nutrition.BREAKFAST_ONLY, 5, 250);
		TouristVoucher tv_6 = new TouristVoucher("Poland", "Warsaw", TourismType.SHOPPING, Transport.BUS, Nutrition.ALL_INCLUDED, 10, 400);
		TouristVoucher tv_7 = new TouristVoucher("Greece", "Tripoli", TourismType.TREATMENT, Transport.PLANE, Nutrition.BREAKFAST_AND_LUNCH, 5, 400);
		TouristVoucher tv_8 = new TouristVoucher("Italy", "Venice", TourismType.TREATMENT, Transport.BUS, Nutrition.BREAKFAST_ONLY, 10, 200);
		TouristVoucher tv_9 = new TouristVoucher("Poland", "Warsaw", TourismType.EXCURSION, Transport.BUS, Nutrition.ALL_INCLUDED, 5, 200);
		TouristVoucher tv_10 = new TouristVoucher("Greece", "Tripoli", TourismType.RELAXATION, Transport.PLANE, Nutrition.ALL_INCLUDED, 3, 200);
		
		TouristVoucher tv_11 = new TouristVoucher("Greece", "Athens", TourismType.EXCURSION, Transport.BUS, Nutrition.NOTHING_INCLUDED, 10, 200);
		TouristVoucher tv_12 = new TouristVoucher("Poland", "Gdansk", TourismType.EXCURSION, Transport.TRAIN, Nutrition.NOTHING_INCLUDED, 5, 100);
		TouristVoucher tv_13 = new TouristVoucher("Italy", "Florence", TourismType.RELAXATION, Transport.CAR, Nutrition.NOTHING_INCLUDED, 3, 100);
		TouristVoucher tv_14 = new TouristVoucher("Poland", "Gdansk", TourismType.RELAXATION, Transport.SHIP, Nutrition.BREAKFAST_AND_LUNCH, 10, 300);
		TouristVoucher tv_15 = new TouristVoucher("Poland", "Gdansk", TourismType.SHOPPING, Transport.PLANE, Nutrition.BREAKFAST_ONLY, 5, 250);
		TouristVoucher tv_16 = new TouristVoucher("Italy", "Florence", TourismType.SHOPPING, Transport.BUS, Nutrition.ALL_INCLUDED, 10, 400);
		TouristVoucher tv_17 = new TouristVoucher("Greece", "Athens", TourismType.TREATMENT, Transport.PLANE, Nutrition.BREAKFAST_AND_LUNCH, 5, 400);
		TouristVoucher tv_18 = new TouristVoucher("Poland", "Gdansk", TourismType.TREATMENT, Transport.TRAIN, Nutrition.BREAKFAST_ONLY, 10, 200);
		TouristVoucher tv_19 = new TouristVoucher("Italy", "Florence", TourismType.EXCURSION, Transport.SHIP, Nutrition.ALL_INCLUDED, 5, 200);
		TouristVoucher tv_20 = new TouristVoucher("Poland", "Gdansk", TourismType.RELAXATION, Transport.PLANE, Nutrition.ALL_INCLUDED, 3, 200);
		
		primeTour.addTouristVoucher(tv_1);
		primeTour.addTouristVoucher(tv_2);
		primeTour.addTouristVoucher(tv_3);
		primeTour.addTouristVoucher(tv_4);
		primeTour.addTouristVoucher(tv_5);
		primeTour.addTouristVoucher(tv_6);
		primeTour.addTouristVoucher(tv_7);
		primeTour.addTouristVoucher(tv_8);
		primeTour.addTouristVoucher(tv_9);
		primeTour.addTouristVoucher(tv_10);
		primeTour.addTouristVoucher(tv_11);
		primeTour.addTouristVoucher(tv_12);
		primeTour.addTouristVoucher(tv_13);
		primeTour.addTouristVoucher(tv_14);
		primeTour.addTouristVoucher(tv_15);
		primeTour.addTouristVoucher(tv_16);
		primeTour.addTouristVoucher(tv_17);
		primeTour.addTouristVoucher(tv_18);
		primeTour.addTouristVoucher(tv_19);
		primeTour.addTouristVoucher(tv_20);
		
		primeTour.sortTouristVouchersByCountry();
		TouristCompany.showTouristVouchers(primeTour.getTouristVouchers());
		
		System.out.println();
		primeTour.sortTouristVouchersByTipe();
		TouristCompany.showTouristVouchers(primeTour.getTouristVouchers());
		
		System.out.println();
		primeTour.sortTouristVouchersByCost();
		TouristCompany.showTouristVouchers(primeTour.getTouristVouchers());
		List<TouristVoucher> lessThan_250 = primeTour.getTouristVouchersByCost(250); // show offers which cost less than 250$
		System.out.println();
		TouristCompany.showTouristVouchers(lessThan_250); 
		
		TouristVoucher client_1_choice = TouristCompany.chooseTouristVoucher(lessThan_250); 
		client_1.setTouristVoucher(client_1_choice);
		System.out.println(client_1);
		primeTour.addClient(client_1);
		
		
		System.out.println();
		primeTour.sortTouristVouchersByDaysNumber();
		TouristCompany.showTouristVouchers(primeTour.getTouristVouchers());
		List<TouristVoucher> lessThan_6_days = primeTour.getTouristVouchersByDay(6); // show offers which duration less than 6 days
		System.out.println();
		TouristCompany.showTouristVouchers(lessThan_6_days); 
		
		TouristVoucher client_2_choice = TouristCompany.chooseTouristVoucher(lessThan_6_days); 
		client_2.setTouristVoucher(client_2_choice);
		System.out.println(client_2);
		primeTour.addClient(client_2);
		
		
	}

}
