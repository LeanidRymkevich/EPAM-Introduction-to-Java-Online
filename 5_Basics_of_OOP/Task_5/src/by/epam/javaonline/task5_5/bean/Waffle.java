package by.epam.javaonline.task5_5.bean;

import java.io.Serializable;

public class Waffle extends Sweet implements Serializable{
	
	/* Although this class doesn't introduce new fields and functionality now,
	 * but there is possibility that assortment will be being extended in future
	*/

	private static final long serialVersionUID = -6192253274253278118L;

	public Waffle() {
		super();
	}

	public Waffle(String name, double cost, double weight) {
		super(name, cost, weight);
	}
}
