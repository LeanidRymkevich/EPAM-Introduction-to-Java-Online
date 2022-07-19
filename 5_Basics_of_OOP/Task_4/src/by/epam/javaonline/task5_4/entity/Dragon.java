package by.epam.javaonline.task5_4.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import by.epam.javaonline.task5_4.logic.DragonLogic;
import by.epam.javaonline.task5_4.logic.LogicException;
import by.epam.javaonline.task5_4.logic.LogicProvider;

public class Dragon implements Serializable{
	
	private static final long serialVersionUID = 2580500395576604476L;
	
	private final DragonLogic logic = LogicProvider.getInstance().getLogic(); 
	
	private String name;
	
	public Dragon() {
		
	}
	
	public Dragon(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	// the dragon's methods for work with his treasures_______________________________________________________
	
	public List<Treasure> addTreasures(Treasure...treasures) throws LogicException {
		return logic.addTreasures(this, treasures);
	}
	
	public List<Treasure> getAllTreasures() throws LogicException {
		return logic.getAllTreasures(this);
	}
	
	public List<Treasure> getMostExpensiveTreasures() throws LogicException {
		return logic.getMostExpensiveTreasures(this);
	}
	
	public List<Treasure> getTreasuresOnSetSum(double lowerBorder, double upperBorder) throws LogicException {
		return logic.getTreasuresOnSetSum(this, lowerBorder, upperBorder);
	}
	
	public Treasure removeTreasure(Treasure removedTreasure, boolean removeAllMatches) throws LogicException {
		return logic.removeTreasure(this, removedTreasure, removeAllMatches);
	}
	
	public int isDragonsCaveContain(Treasure searchedTreasure) throws LogicException {
		return logic.isDragonsCaveContain(this, searchedTreasure);
	}
	
	//_______________________________________________________________________________________________

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dragon other = (Dragon) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + name + "]";
	}
}
