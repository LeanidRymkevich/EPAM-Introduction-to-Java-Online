package by.epam.javaonline.task4_1_10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class PlaneSchedule {
	
	private final List<Airline> schedule = new ArrayList<>();
	
	public PlaneSchedule() {
		
	}
	
	public PlaneSchedule(Airline...flights) {
		schedule.addAll(Arrays.asList(flights));
	}

	public List<Airline> getSchedule() {
		return schedule;
	}
	
	private static String airlineInfo(Airline flight) {
		
		String destination;
		String flightNumber;
		String planeType;
		String depatureTime;
		StringBuilder result = new StringBuilder();
		int lineLength;
			
		destination = String.format("| %14.14s |", flight.getDestination()).toString();
		flightNumber = String.format(" %13.13s |", flight.getFlightNumber()).toString();
		planeType = String.format(" %10.10s |", flight.getPlaneType()).toString();
		
		if(flight.getDepatureTime().isEmpty()) {
			depatureTime = String.format(" %1$7s | %1$11s |\n", "Unknown");
			result.append(destination);
			result.append(flightNumber);
			result.append(planeType);
			result.append(depatureTime);
			lineLength = result.length();
		} else if (flight.getDepatureTime().size() == 1) {
			depatureTime = String.format(" %7s | %11s |\n", flight.getDepatureTime().get(0).getTime(),flight.getDepatureTime().get(0).getDay());
			result.append(destination);
			result.append(flightNumber);
			result.append(planeType);
			result.append(depatureTime);
			lineLength = result.length();
		} else {
			depatureTime = String.format(" %7s | %11s |\n", flight.getDepatureTime().get(0).getTime(),flight.getDepatureTime().get(0).getDay());
			result.append(destination);
			result.append(flightNumber);
			result.append(planeType);
			result.append(depatureTime);
			lineLength = result.length();
			
			for(int j = 1; j < flight.getDepatureTime().size(); j++) {
				
				result.append("|");
				for(int i = 0; i <= lineLength - 2 - depatureTime.length(); i++) {
					
					if(i == destination.length() -2 ||
					   i == destination.length() + flightNumber.length() -2 ||
					   i == destination.length() + flightNumber.length() + planeType.length() - 2) {
						result.append("|"); 
					} else {
						result.append(" ");
					}	
				}
				depatureTime = String.format(" %7s | %11s |\n", flight.getDepatureTime().get(j).getTime(),flight.getDepatureTime().get(j).getDay());
				result.append(depatureTime);
			}
		}
		
		result.append("|");
		for(int i = 0; i < lineLength - 3; i++) {
			
			if(i == destination.length() - 2 ||
			   i == destination.length() + flightNumber.length() - 2 ||
			   i == destination.length() + flightNumber.length() + planeType.length() - 2 ||
			   i == destination.length() + flightNumber.length() + planeType.length() + 8) {
				result.append("|");
			} else {
				result.append("_");
			}
		}
		result.append("|");
		
		return result.toString();
	}
	
	private static String ScheduleHat() {
		
		StringBuilder result = new StringBuilder();
		StringBuilder line = new StringBuilder();
		String hat;
		int width;
		
		hat = String.format("| %14.14s | %13.13s | %10.10s | %7s | %11s |\n", "Destination",
				"Flight Number", "Plane Type","Time", "Day Of Week");
		width = hat.length();
		
		for(int i = 0; i < width - 3; i++) {
			line.append("_");
		}
		result.append(" " + line + "\n" + hat + "|" + line + "|");
		
		
		return result.toString();
	}
	
	public void showSchedule() {
		
		if(schedule.isEmpty()) {
			System.out.println("THERE ARE NO AVAILABLE FLIGHTS AT THE MOMENT!!!");
			return;
		}
		
		System.out.println(ScheduleHat());
		
		for(Airline flight: this.schedule) {
			System.out.println(airlineInfo(flight));
		}
	}
	
	public void showFlightsByDestination(String destination) {
		
		if(schedule.isEmpty()) {
			System.out.println("THERE ARE NO AVAILABLE FLIGHTS AT THE MOMENT!!!");
			return;
		}
		
		if(destination == null || destination == "") {
			System.out.println("INCORRECT ARGUEMENT VALUE!!!");
			return ;
		}
		
		boolean contain = false;
		
		for(Airline flight: schedule) {
			
			if(flight.getDestination().compareToIgnoreCase(destination) == 0) {
				contain = true;
				break;
			}
		}
		
		if(!contain) {
			System.out.println("THERE ARE NO FLIGHTS WITH SUCH DESTINATION!!!");
			return;
		}
		
		System.out.println(ScheduleHat());
		for(Airline flight: schedule) {
			if(flight.getDestination().compareToIgnoreCase(destination) == 0) {
				System.out.println(airlineInfo(flight));
			}
		}
	}
	
	public void showFlightsByDayOfWeek(String dayOfWeek) {
		
		if(schedule.isEmpty()) {
			System.out.println("THERE ARE NO AVAILABLE FLIGHTS AT THE MOMENT!!!");
			return;
		}
		
		if(dayOfWeek == null || dayOfWeek == "") {
			System.out.println("INCORRECT ARGUEMENT VALUE!!!");
			return ;
		}
		
		boolean contain = false;
		
		for(Airline flight: schedule) {
			
			for(DayAndTime day: flight.getDepatureTime()) {
				if(day.getDay().toString().compareToIgnoreCase(dayOfWeek) == 0) {
					contain = true;
					break;
				}
			}
		}
		
		if(!contain) {
			System.out.println("THERE ARE NO FLIGHTS IN THAT DAY!!!");
			return;
		}
		
		System.out.println(ScheduleHat());
		for(Airline flight: schedule) {
			
			for(DayAndTime day: flight.getDepatureTime()) {
				if(day.getDay().toString().compareToIgnoreCase(dayOfWeek) == 0) {
					System.out.println(airlineInfo(flight));
				}
			}
		}
	}
	
	public void showScheduleByDayAndTime(String day, String time) {
		
		if(schedule.isEmpty()) {
			System.out.println("THERE ARE NO AVAILABLE FLIGHTS AT THE MOMENT!!!");
			return;
		}
		
		if(day == null || day == "" || time == null || time == "") {
			System.out.println("INCORRECT ARGUEMENT VALUE!!!");
			return ;
		}
		
		String pattern = "([01][0-9]|2[0-3])\\.[0-5][0-9]";
		
		if(!time.matches(pattern)) {
			System.out.println("INCORRECT ARGUEMENT VALUE!!!");
			return ;
		}
		
		String[] hoursAndMinutes;
		int hours;
		int minutes;
		boolean contain;
		
		hoursAndMinutes = time.split("\\.");
		hours = Integer.valueOf(hoursAndMinutes[0]);
		minutes = Integer.valueOf(hoursAndMinutes[1]);
		contain = false;
		
		for(Airline flight: schedule) {
			
			for(DayAndTime d: flight.getDepatureTime()) {
				if(d.getDay().toString().compareToIgnoreCase(day) == 0) {
					
					if(Integer.valueOf(d.getHours()) > hours ||
					  (Integer.valueOf(d.getHours()) == hours && Integer.valueOf(d.getMinutes()) > minutes)) {
						contain = true;
						break;
					}
				}
			}
		}
		
		if(!contain) {
			System.out.println("THERE ARE NO FLIGHTS IN THAT DAY AFTER THAT TIME!!!");
			return;
		}
		
		System.out.println(ScheduleHat());
		for(Airline flight: schedule) {
			
			for(DayAndTime d: flight.getDepatureTime()) {
				if(d.getDay().toString().compareToIgnoreCase(day) == 0) {
					
					if(Integer.valueOf(d.getHours()) > hours ||
					  (Integer.valueOf(d.getHours()) == hours && Integer.valueOf(d.getMinutes()) > minutes)) {
						System.out.println(airlineInfo(flight));
					}
				}
			}
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(schedule);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlaneSchedule other = (PlaneSchedule) obj;
		return Objects.equals(schedule, other.schedule);
	}
	
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [schedule=" + schedule + "]";
	}
}
