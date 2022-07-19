package by.epam.javaonline.task4_2_5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class TouristCompany {

	private String companyName;
	private final List<TouristVoucher> touristVouchers = new ArrayList<>();
	private final List<Client> clients = new ArrayList<>();
	
	public TouristCompany() {
		
	}

	public TouristCompany(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public boolean addTouristVoucher(TouristVoucher touristVoucher) {
		touristVouchers.add(touristVoucher);
		return true;
	}
	
	public List<TouristVoucher> getTouristVouchers(){
		return List.copyOf(touristVouchers);
	}
	
	public boolean removeAllTouristVouchers() {
		touristVouchers.clear();
		return true;
	}
	
	public boolean removeTouristVoucher() {
		
		if (touristVouchers.isEmpty()) return false;
		
		showTouristVouchers(touristVouchers);
		System.out.print("\nSELECT NUMBER OF TOURIST VOUCHER TO BE REMOVED FROM LIST ABOVE: ");
		
		int removeIndex = readNumber(0,touristVouchers.size() - 1);
		touristVouchers.remove(removeIndex);
		return true;
	}
	
	public List<Client> getClients(){
		return List.copyOf(clients);
	}
	
	public boolean addClient(Client client) {
		clients.add(client);
		return true;
	}
	
	public boolean removeAllClients() {
		clients.clear();
		return true;
	}
	
	public boolean removeClient() {
		
		if (clients.isEmpty()) return false;
		
		showClients(clients);
		System.out.print("\nSELECT NUMBER OF CLIENT TO BE REMOVED FROM LIST ABOVE: ");
		
		int removeIndex = readNumber(0,clients.size() - 1);
		clients.remove(removeIndex);
		return true;
	}
	
	public static void showClients(List<Client> clients) {
		
		System.out.println("AVAILABLE CLIENTS:");
		
		int counter = 0;
		for(Client client: clients) {
			System.out.println(counter + " - " + client);
			counter++;
		}
	}
	
	public static void showTouristVouchers(List<TouristVoucher> touristVouchers) {
		
		System.out.println("AVAILABLE TOURIST VOUCHERS:");
		
		int counter = 0;
		for(TouristVoucher voucher: touristVouchers) {
			System.out.println(counter + " - " + voucher);
			counter++;
		}
	}
	
	private static int readNumber(int lowBound, int highBound) {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String result = null;
		int res = 0;
		
		for(;;) {
			
			result = sc.nextLine();
			
			if(result.matches("\\d+")) {
				
				res = Integer.valueOf(result);
				
				if(res >= lowBound && res <= highBound) {
					return res;
				} else {
					System.out.print("Input error!!! Enter correct value! - "); 
					continue;
				}
				
			} else {
				System.out.print("Input error!!! Enter correct value! - "); 
				continue;
			}	
		}
	}
	
	public boolean sortTouristVouchersByTipe() {
		
		if(touristVouchers.isEmpty()) return false;
		
		Comparator<TouristVoucher> comparator = new Comparator<>() {

			@Override
			public int compare(TouristVoucher o1, TouristVoucher o2) {
				return o1.getType().toString().compareTo(o2.getType().toString());
			}
		};
		
		touristVouchers.sort(comparator);
		return true;
	}
	
	public boolean sortTouristVouchersByCountry() {
		
		if(touristVouchers.isEmpty()) return false;
		
		Comparator<TouristVoucher> comparator = new Comparator<>() {

			@Override
			public int compare(TouristVoucher o1, TouristVoucher o2) {
				return o1.getCountry().compareTo(o2.getCountry());
			}
		};
		
		touristVouchers.sort(comparator);
		return true;
	}

	public boolean sortTouristVouchersByLocation() {
		
		if(touristVouchers.isEmpty()) return false;
		
		Comparator<TouristVoucher> comparator = new Comparator<>() {

			@Override
			public int compare(TouristVoucher o1, TouristVoucher o2) {
				return o1.getLocation().compareTo(o2.getLocation());
			}
		};
		
		touristVouchers.sort(comparator);
		return true;
	}
	
	public boolean sortTouristVouchersByTransport() {
		
		if(touristVouchers.isEmpty()) return false;
		
		Comparator<TouristVoucher> comparator = new Comparator<>() {

			@Override
			public int compare(TouristVoucher o1, TouristVoucher o2) {
				return o1.getTransport().toString().compareTo(o2.getTransport().toString());
			}
		};
		
		touristVouchers.sort(comparator);
		return true;
	}

	public boolean sortTouristVouchersByNutrition() {
		
		if(touristVouchers.isEmpty()) return false;
		
		Comparator<TouristVoucher> comparator = new Comparator<>() {

			@Override
			public int compare(TouristVoucher o1, TouristVoucher o2) {
				return o1.getNutrition().toString().compareTo(o2.getNutrition().toString());
			}
		};
		
		touristVouchers.sort(comparator);
		return true;
	}
	
	public boolean sortTouristVouchersByDaysNumber() {

		if(touristVouchers.isEmpty()) return false;
		
		Comparator<TouristVoucher> comparator = new Comparator<>() {

			@Override
			public int compare(TouristVoucher o1, TouristVoucher o2) {
				return o1.getDaysNumber() - o2.getDaysNumber();
			}
		};
		
		touristVouchers.sort(comparator);
		return true;
	}
	
	public boolean sortTouristVouchersByCost() {

		if(touristVouchers.isEmpty()) return false;
		
		Comparator<TouristVoucher> comparator = new Comparator<>() {

			@Override
			public int compare(TouristVoucher o1, TouristVoucher o2) {
				return Double.compare(o1.getCost(), o2.getCost());
			}
		};
		
		touristVouchers.sort(comparator);
		return true;
	}
	
	public static TouristVoucher chooseTouristVoucher(List<TouristVoucher> vouchers) {
		
		if(vouchers == null || vouchers.isEmpty()) return null;
		
		System.out.print("\nSELECT NUMBER OF APPROPRIATE TOURIST VOUCHER FROM LIST ABOVE: ");
		
		int choiceIndex = readNumber(0,vouchers.size() - 1);
		return vouchers.get(choiceIndex);
	}
	
	public List<TouristVoucher> getTouristVouchersByType(TourismType type){
		
		if(touristVouchers.isEmpty()) return null;
		
		List<TouristVoucher> result = new ArrayList<>();
		
		for(int i = 0; i < touristVouchers.size(); i++) {
			
			if(touristVouchers.get(i).getType().equals(type)) {
				result.add(touristVouchers.get(i));
			}
		}
		
		if(result.isEmpty()) {
			return null;
		} else {
			return result;
		}
	}
	
	public List<TouristVoucher> getTouristVouchersCountry(String country){
		
		if(touristVouchers.isEmpty()) return null;
		
		List<TouristVoucher> result = new ArrayList<>();
		
		for(int i = 0; i < touristVouchers.size(); i++) {
			
			if(touristVouchers.get(i).getCountry().equals(country)) {
				result.add(touristVouchers.get(i));
			}
		}
		
		if(result.isEmpty()) {
			return null;
		} else {
			return result;
		}
	}
	
	public List<TouristVoucher> getTouristVouchersByLocation(String location){
		
		if(touristVouchers.isEmpty()) return null;
		
		List<TouristVoucher> result = new ArrayList<>();
		
		for(int i = 0; i < touristVouchers.size(); i++) {
			
			if(touristVouchers.get(i).getLocation().equals(location)) {
				result.add(touristVouchers.get(i));
			}
		}
		
		if(result.isEmpty()) {
			return null;
		} else {
			return result;
		}
	}
	
	public List<TouristVoucher> getTouristVouchersByTransport(Transport transport){
		
		if(touristVouchers.isEmpty()) return null;
		
		List<TouristVoucher> result = new ArrayList<>();
		
		for(int i = 0; i < touristVouchers.size(); i++) {
			
			if(touristVouchers.get(i).getTransport().equals(transport)) {
				result.add(touristVouchers.get(i));
			}
		}
		
		if(result.isEmpty()) {
			return null;
		} else {
			return result;
		}
	}
	
	public List<TouristVoucher> getTouristVouchersByNutrition(Nutrition nutrition){
		
		if(touristVouchers.isEmpty()) return null;
		
		List<TouristVoucher> result = new ArrayList<>();
		
		for(int i = 0; i < touristVouchers.size(); i++) {
			
			if(touristVouchers.get(i).getNutrition().equals(nutrition)) {
				result.add(touristVouchers.get(i));
			}
		}
		
		if(result.isEmpty()) {
			return null;
		} else {
			return result;
		}
	}
	
	public List<TouristVoucher> getTouristVouchersByDay(int dayNumber){
		
		if(touristVouchers.isEmpty()) return null;
		
		List<TouristVoucher> result = new ArrayList<>();
		
		for(int i = 0; i < touristVouchers.size(); i++) {
			
			if(touristVouchers.get(i).getDaysNumber() <= dayNumber) {
				result.add(touristVouchers.get(i));
			}
		}
		
		if(result.isEmpty()) {
			return null;
		} else {
			return result;
		}
	}
	
	public List<TouristVoucher> getTouristVouchersByCost(double cost){
		
		if(touristVouchers.isEmpty()) return null;
		
		List<TouristVoucher> result = new ArrayList<>();
		
		for(int i = 0; i < touristVouchers.size(); i++) {
			
			if(touristVouchers.get(i).getCost() <= cost) {
				result.add(touristVouchers.get(i));
			}
		}
		
		if(result.isEmpty()) {
			return null;
		} else {
			return result;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(clients, companyName, touristVouchers);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TouristCompany other = (TouristCompany) obj;
		return Objects.equals(clients, other.clients) && Objects.equals(companyName, other.companyName)
				&& Objects.equals(touristVouchers, other.touristVouchers);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [companyName=" + companyName + ", touristVouchers=" + touristVouchers + ", clients="
				+ clients + "]";
	}
	
	
}
