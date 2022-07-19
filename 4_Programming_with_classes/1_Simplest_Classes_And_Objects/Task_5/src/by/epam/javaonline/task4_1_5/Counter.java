package by.epam.javaonline.task4_1_5;

import java.util.Objects;

/* 5. Опишите класс, реализующий десятичный счетчик, который
 * может увеличивать или уменьшать свое значение на единицу в
 * заданном диапазоне. Предусмотрите инициализацию счетчика
 * значениями по умолчанию и произвольными значениями. Счетчик
 * имеет методы увеличения и уменьшения состояния, и метод 
 * позволяющее получить его текущее состояние. Написать код,
 * демонстрирующий все возможности класса.*/

public class Counter {
	
	private int max_value;
	private int min_value;
	private int current_value;
	
	// initialization by default
	{
		max_value = 99;
		min_value = 0;
		current_value = 0;
	}
	
	public Counter() {
		
	}
	
	public Counter (int max, int min, int value) {
		
		if(max > min) {
			
			this.max_value = max;
			this.min_value = min;
			
		} else if (max == min) {
			
			this.max_value = 99;
			this.min_value = 0;
			
		} else {
			
			this.max_value = min;
			this.min_value = max;
		}
		
		if(value < min) {
			this.current_value = min;
		}
		
		if(value > max) {
			this.current_value = max;
		}
	}
	
	public int getCurrent_value() {
		return current_value;
	}

	// random initialization 
	public int randomInit() {
		
		max_value = (int)(Math.random()* 1000);
		min_value = (int)(Math.random()* 1000);
		
		for(;;) {
			
			if(max_value < min_value) {
				
				int temp = max_value;
				max_value = min_value;
				min_value = temp;
				break;
				
			} else if (max_value > min_value) {
				break;
			} else {
				
				max_value = (int)(Math.random()* 1000);
				min_value = (int)(Math.random()* 1000);
			}
		}
		
		int diff = max_value - min_value;
		
		current_value = min_value + (int)(Math.random() * (diff + 1));
		
		return current_value;
	}
	
	public int increase() {
		
		if (current_value == max_value) {
			current_value = min_value;
		} else {
			current_value++;
		}
		return current_value;
	}
	
	public int decrease() {
		
		if (current_value == min_value) {
			current_value = max_value;
		} else {
			current_value--;
		}
		return current_value;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(current_value, max_value, min_value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Counter other = (Counter) obj;
		return current_value == other.current_value && max_value == other.max_value && min_value == other.min_value;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [max_value=" + max_value + ", min_value=" + min_value + ", current_value=" + current_value
				+ "]";
	}
}
