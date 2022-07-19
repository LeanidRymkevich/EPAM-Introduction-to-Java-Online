package by.epam.javaonline.task4_2_2;

import java.util.Objects;

public class Wheel {

	private float diameter;
	
	public Wheel() {
		
	}

	public Wheel(float diameter) {
		this.diameter = diameter;
	}

	@Override
	public int hashCode() {
		return Objects.hash(diameter);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wheel other = (Wheel) obj;
		return Float.floatToIntBits(diameter) == Float.floatToIntBits(other.diameter);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [diameter=" + diameter + "]";
	}
	
	
	
}
