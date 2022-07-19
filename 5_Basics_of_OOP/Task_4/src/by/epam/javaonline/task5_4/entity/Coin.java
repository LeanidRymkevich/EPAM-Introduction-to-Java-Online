package by.epam.javaonline.task5_4.entity;

import java.io.Serializable;
import java.util.Objects;

public class Coin extends Treasure implements Serializable{

	private static final long serialVersionUID = 3209929963375099052L;

	private static final String NAME = "Coin";
	
	private String currency;
	private String material;
	
	public Coin() {
	}
	
	public Coin(double cost) {
		super(NAME, cost);
	}
	
	public Coin(double cost, String currency, String material) {
		super(NAME, cost);
		this.currency = currency;
		this.material = material;
	}

	public String getCurrency() {
		return currency;
	}

	public String getMaterial() {
		return material;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(currency, material);
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
		Coin other = (Coin) obj;
		return Objects.equals(currency, other.currency) && Objects.equals(material, other.material);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + getName() + ", cost=" + getCost() + ", currency=" + currency + ", material=" + material + "]";
	}
}
