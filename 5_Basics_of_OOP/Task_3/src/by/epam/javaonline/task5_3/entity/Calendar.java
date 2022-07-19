package by.epam.javaonline.task5_3.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Calendar implements Serializable{

	private static final long serialVersionUID = 281297810264913733L;
	
	private final List<Day> days = new ArrayList<>();
	
	public Calendar() {
		
	}
	
	public List<Day> getDays() {
		return days;
	}	
	
	// static nested class WorkDay_____________________________

	public static class WorkDay extends Day{

		private static final long serialVersionUID = -3079657707857236147L;
		
		{
			setFreeDay(false);
		}
		
		public WorkDay() {
			
		}
		
		public WorkDay(int date, Month month, int year) {
			super(date, month, year);
		}
		
		// methods hashCode, equals and toStrig aren't redefined because class
		// doesn't contain fields except ones in parent class Day 
		
	}
	
	// end of static nested class WorkDay_____________________
	
	// static nested class FreekDay___________________________
	
	public static class FreeDay extends Day{

		private static final long serialVersionUID = -6581279719458256284L;
		
		private FreeDayCause cause;
		
		{
			setFreeDay(true);
		}
		
		public FreeDay() {
			
		}
		
		public FreeDay(int date, Month month, int year) {
			super(date, month, year);
		}
		
		public FreeDay(int date, Month month, int year, FreeDayCause cause) {
			super(date, month, year);
			this.cause = cause;
		}

		public FreeDayCause getCause() {
			return cause;
		}

		public void setCause(FreeDayCause cause) {
			this.cause = cause;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + Objects.hash(cause);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			FreeDay other = (FreeDay) obj;
			return cause == other.cause;
		}

		@Override
		public String toString() {
			return this.getClass().getSimpleName() + " [cause=" + cause + "]";
		}
		
		
	}
	
	// end of static nested class FreekDay______________________________
	
	@Override
	public int hashCode() {
		return Objects.hash(days);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calendar other = (Calendar) obj;
		return Objects.equals(days, other.days);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
