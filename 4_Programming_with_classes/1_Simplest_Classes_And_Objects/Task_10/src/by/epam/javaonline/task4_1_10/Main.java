package by.epam.javaonline.task4_1_10;

public class Main {
	
	public static void main(String[] args) {
		
		Airline flight_1;
		Airline flight_2;
		Airline flight_3;
		Airline flight_4;
		Airline flight_5;
		Airline flight_6;
		
		flight_1 = new Airline("Moscow", "TK 1874", "Airbus A321", new DayAndTime(DayOfWeek.THURSDAY, "14.05"), new DayAndTime(DayOfWeek.SATURDAY, "07.25"));
		flight_2 = new Airline("Milan", "B2 786", "Boeing 737-800", new DayAndTime(DayOfWeek.MONDAY, "10.40"), new DayAndTime(DayOfWeek.WEDNESDAY, "13.55"));
		flight_3 = new Airline("Rio de Janeiro", "TK 1506", "Airbus A321", new DayAndTime(DayOfWeek.MONDAY, "11.35"));
		flight_4 = new Airline("Moscow", "B2 955", "Embraer E195", new DayAndTime(DayOfWeek.MONDAY, "13.40"), new DayAndTime(DayOfWeek.WEDNESDAY, "21.05"),
																   new DayAndTime(DayOfWeek.SUNDAY, "03.40"),new DayAndTime(DayOfWeek.THURSDAY, "11.40"));
		flight_5 = new Airline("Riga", "S7 2566", "Embraer E195", new DayAndTime(DayOfWeek.FRIDAY, "09.20"), new DayAndTime(DayOfWeek.TUESDAY, "19.00"),
				   												  new DayAndTime(DayOfWeek.THURSDAY, "23.30"),new DayAndTime(DayOfWeek.MONDAY, "22.10"));
		flight_6 = new Airline("Milan", "S7 2564", "Airbus A320neo", new DayAndTime(DayOfWeek.SATURDAY, "06.15"), new DayAndTime(DayOfWeek.FRIDAY, "20.50"));
		
		//_______________________________________________________________________________________________
		
		PlaneSchedule schedule = new PlaneSchedule(flight_1, flight_2, flight_3);
		schedule.getSchedule().add(flight_4);
		schedule.getSchedule().add(flight_5);
		schedule.getSchedule().add(flight_6);
		
		//_______________________________________________________________________________________________
		
		System.out.println("CURRENT FLIGHT SCHEDULE:");
		schedule.showSchedule();
		
		//_______________________________________________________________________________________________
		
		String city = "Milan";
		System.out.println();
		System.out.println("FLIGHTS TO: " + city);
		schedule.showFlightsByDestination(city);
		
		//_______________________________________________________________________________________________
		
		String day = "Thursday";
		System.out.println();
		System.out.println("FLIGHTS ON: " + day +"s");
		schedule.showFlightsByDayOfWeek(day);
		
		//_______________________________________________________________________________________________
		
		day = "Monday";
		String time = "13.00";
		System.out.println();
		System.out.println("FLIGHTS ON: " + day +"s after: " + time);
		schedule.showScheduleByDayAndTime(day, time);
	}
}
