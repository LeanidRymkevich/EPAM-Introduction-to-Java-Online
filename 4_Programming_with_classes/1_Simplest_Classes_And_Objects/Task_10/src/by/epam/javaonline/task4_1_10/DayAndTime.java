package by.epam.javaonline.task4_1_10;

import java.util.Objects;

public class DayAndTime {
	
	private DayOfWeek day;
	private String time;
	private String hours;
	private String minutes;
	
	{
		day = DayOfWeek.MONDAY;
		time = "00.00";
		timeToHoursAndMinutes(this.time);
	}
	
	public DayAndTime() {
		
	}
	
	public DayAndTime(DayOfWeek day, String time) {
		this.day = day;
		this.time = timeCheck(time);
		timeToHoursAndMinutes(this.time);
	}
	
	
	public String getHours() {
		return hours;
	}

	public String getMinutes() {
		return minutes;
	}

	public DayOfWeek getDay() {
		return day;
	}

	public String getTime() {
		return time;
	}

	public void setDay(DayOfWeek day) {
		this.day = day;
	}

	public void setTime(String time) {
		this.time = timeCheck(time);
	}

	public static String stringCheck(String line, String pattern, String elseReturn) {
		
		if(line == null || line == "") {
			return elseReturn;
		}
		
		if(line.matches(pattern)) {
			return line;
		} else {
			return elseReturn;
		}
	}
	
	private String timeCheck(String time) {
		String pattern = "([01][0-9]|2[0-3])\\.[0-5][0-9]";
		return stringCheck(time, pattern, "00.00");
	}
	
	private void timeToHoursAndMinutes(String time) {
		
		String[] hoursAndMinutes = time.split("\\.");
		this.hours = hoursAndMinutes[0];
		this.minutes = hoursAndMinutes[1];
	}
	
	public int compare(DayAndTime other) {
		
		if(this.day.compareTo(other.day) > 0) {
			return 1;
		} else if(this.day.compareTo(other.day) < 0) {
			return -1;
		} else {
			
			if(this.hours.compareTo(other.hours) > 0) {
				return 1;
			} else if(this.hours.compareTo(other.hours) < 0) {
				return -1;
			} else {
				
				if(this.minutes.compareTo(other.minutes) > 0) {
					return 1;
				} else if(this.minutes.compareTo(other.minutes) < 0) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(day, hours, minutes, time);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DayAndTime other = (DayAndTime) obj;
		return day == other.day && Objects.equals(hours, other.hours) && Objects.equals(minutes, other.minutes)
				&& Objects.equals(time, other.time);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [day=" + day + ", time=" + time + ", hours=" + hours + ", minutes=" + minutes + "]";
	}
}
