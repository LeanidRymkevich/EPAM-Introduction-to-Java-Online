package by.epam.javaonline.task5_2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Payment implements Serializable{
	
	private static final long serialVersionUID = -317128577283448190L;
	
	private static int counter = 0;
	
	private final int id;
	private final List<Item> goods = new ArrayList<>();
	
	public Payment() {
		counter++;
		id = counter;
	}
		
	public int getId() {
		return id;
	}

	public List<Item> getGoods() {
		return goods;
	}

	public Item addItem(String name, double cost) {
		return addItem(new Item(name, cost));
	}

	public Item addItem(Item item) {
		goods.add(item);
		return item;
	}
	
	public int removeItem(String name, int amount) {
		
		// method returns amount of items deleted
		
		if(name == null || name.isEmpty() || amount == 0) {
			return 0;
		}
		
		int counter = 0;
		Iterator<Item> iterator = goods.iterator();
		
		while(iterator.hasNext()) {
			
			if(iterator.next().getName().equalsIgnoreCase(name)) {
				counter++;
				
				if(counter <= amount) {
					iterator.remove();
				} else {
					break;
				}
			}
		}
		return counter;
	}
	
	public double totalSum() {
		
		double sum = 0;
		
		for(Item item : goods) {
			sum += item.getCost();
		}
		
		return sum;
	}
	
	public void sortByName() {
		goods.sort((Item a, Item b) -> a.name.compareTo(b.name));
	}
	
	public void sortByCost() {
		goods.sort((Item a, Item b) -> Double.compare(a.getCost(), b.getCost()));
	}
	

	// Static nested class Item ____________________________

	public static class Item implements Serializable{
		
		private static final long serialVersionUID = 7290875302018413874L;
		
		private final static String DEFAULT_NAME = "Undefined item";
		
		private String name;
		private double cost;
		
		public Item() {
			
		}

		public Item(String name, double cost) {
			
			this.name = nameValidatin(name);
			this.cost = cost;
		}

		public String getName() {
			return name;
		}

		public double getCost() {
			return cost;
		}

		public void setName(String name) {
			this.name = nameValidatin(name);
		}

		public void setCost(double cost) {
			this.cost = cost;
		}

		private static String nameValidatin(String name) {
			
			if(name == null || name.isEmpty()) {
				return DEFAULT_NAME;
			} else {
				return name;
			}
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(cost, name);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Item other = (Item) obj;
			return Double.doubleToLongBits(cost) == Double.doubleToLongBits(other.cost)
					&& Objects.equals(name, other.name);
		}

		@Override
		public String toString() {
			return this.getClass().getSimpleName() + " [name=" + name + ", cost=" + cost + "]";
		}
	}
	
	// End of static nested class Item ________________________ 
	
	
	@Override
	public int hashCode() {
		return Objects.hash(goods, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(goods, other.goods) && id == other.id;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id=" + id + "]";
	}
}
