package by.epam.javaonline.task5_4.utility;

import by.epam.javaonline.task5_4.entity.Bullion;
import by.epam.javaonline.task5_4.entity.Coin;
import by.epam.javaonline.task5_4.entity.Gem;
import by.epam.javaonline.task5_4.entity.Ring;
import by.epam.javaonline.task5_4.entity.Treasure;

public class RandomCaveFiller {
	
	// the class-utility containing methods for random filling
	// a dragon's cave with different treasures 

	private static final String[] TREASURE_TYPES;
	private static final double MAX_COST;
	private static final double MIN_COST;
	private static final String[] MATERIALS;
	private static final String[] CURRENCIES;
	private static final double[] BULLION_WEIGHTS;
	private static final double[] GEM_WEIGHTS;
	private static final String[] GEMS;
	private static final double[] DIAMETERS;
	
	static{
		TREASURE_TYPES = new String[]{"Bullion", "Coin", "Gem", "Ring"};
		MAX_COST = 200;
		MIN_COST = 100;
		MATERIALS = new String[] {"Gold", "Silver", "Bronze", "Iron", "Platinum"};
		CURRENCIES = new String[] {"Cent", "Ducat", "Pesso", "Dinar", "Ruble"};
		BULLION_WEIGHTS = new double[]{2,5,10,15,20};
		GEM_WEIGHTS = new double[]{0.05, 0.08,0.1,0.15,0.20};
		GEMS = new String[]{"Diamont", "Ruby", "Sapphire", "Emerald", "Agate"};
		DIAMETERS = new double[]{6, 10, 14, 18, 20};
	}
	
	public RandomCaveFiller() {}
	
	public Treasure[] createTreasury(int itemNumber) {
		
		Treasure[] result;
		String treasureType;
		int typeInd;
		
		result = new Treasure[itemNumber];
		treasureType = null;
		typeInd = 0;
		
		for(int i = 0; i < itemNumber; i++) {
			
			typeInd = (int) (Math.random()*TREASURE_TYPES.length);
			treasureType = TREASURE_TYPES[typeInd];
			result[i] = create(treasureType);
		}
		return result;
	}
	
	private Treasure create(String treasureType) {
		
		Treasure treasure = null;
		switch(treasureType) {
		case "Bullion":
			treasure = randomBullionCreator();
			break;
		case "Coin":
			treasure = randomCoinCreator();
			break;
		case "Gem":
			treasure = randomGemCreator();
			break;
		case "Ring":
			treasure = randomRingCreator();
			break;
		}
		return treasure;
	}
	
	private Bullion randomBullionCreator() {
		
		int cost;
		int materialInd;
		int weightInd;
		
		cost = (int) (Math.random()*(MAX_COST - MIN_COST) + MIN_COST + 1);
		materialInd= (int) (Math.random()*MATERIALS.length);
		weightInd = (int) (Math.random()*BULLION_WEIGHTS.length);
		
		return new Bullion(cost, MATERIALS[materialInd], BULLION_WEIGHTS[weightInd]);
	}
	
	private Coin randomCoinCreator() {
		
		int cost;
		int materialInd;
		int currencyInd;
		
		cost = (int) (Math.random()*(MAX_COST - MIN_COST) + MIN_COST + 1);
		materialInd= (int) (Math.random()*MATERIALS.length);
		currencyInd = (int) (Math.random()*CURRENCIES.length);
		
		return new Coin(cost, CURRENCIES[currencyInd], MATERIALS[materialInd]);
	}
	
	private Gem randomGemCreator() {
		
		int cost;
		int gemInd;
		int weghtInd;
		
		cost = (int) (Math.random()*(MAX_COST - MIN_COST) + MIN_COST + 1);
		gemInd = (int) (Math.random()*GEMS.length);
		weghtInd = (int) (Math.random()*GEM_WEIGHTS.length);
		
		return new Gem(GEMS[gemInd],cost, GEM_WEIGHTS[weghtInd]);
	}
	
	
	private Ring randomRingCreator() {
		
		int cost;
		int materialInd;
		int diameterInd;
		
		cost = (int) (Math.random()*(MAX_COST - MIN_COST) + MIN_COST + 1);
		materialInd= (int) (Math.random()*MATERIALS.length);
		diameterInd = (int) (Math.random()*DIAMETERS.length);
		
		return new Ring(cost, DIAMETERS[diameterInd], MATERIALS[materialInd]);
	}
}
