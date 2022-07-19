package by.epam.javaonline.task4_2_2;

import java.util.Objects;

public class Engine {
	
	private String manufactureMark;
	
	public Engine() {
		
	}

	public Engine(String manufactureMark) {
		this.manufactureMark = manufactureMark;
	}

	public String getManufactureMark() {
		return manufactureMark;
	}

	public void setManufactureMark(String manufactureMark) {
		this.manufactureMark = manufactureMark;
	}

	@Override
	public int hashCode() {
		return Objects.hash(manufactureMark);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Engine other = (Engine) obj;
		return Objects.equals(manufactureMark, other.manufactureMark);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [manufactureMark=" + manufactureMark + "]";
	}
	
	

}
