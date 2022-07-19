package by.epam.javaonline.task5_5.view;

import java.util.List;

import by.epam.javaonline.task5_5.bean.Client;
import by.epam.javaonline.task5_5.bean.Person;
import by.epam.javaonline.task5_5.bean.Present;
import by.epam.javaonline.task5_5.bean.Sweet;
import by.epam.javaonline.task5_5.bean.Wrap;
import by.epam.javaonline.task5_5.logic.LogicException;

public class View {

	public View() {
		super();
	}
	
	public void registrationResponse(Person person) {
		
		System.out.println("Welcome new "+person.getClass().getSimpleName()
				+ " "+ person.getName() + " !!!");
		System.out.println();
	}
	
	public void loginationResponse(Person person) {
		System.out.println("Welcome back "+person.getClass().getSimpleName()
				+ " "+ person.getName() + " !!!");
		System.out.println();
	}
	
	public void showSweetAssortment(List<Sweet> sweets) {
		
		String formatStr = "| %s | %12.12s | %16.16s | %6.6s | %9.9s |\n";
		int counter = 0;
		
		System.out.println("Current sweet's assortment:");
		System.out.printf(formatStr, "№", "Type", "Name", "Cost,$", "Weight,kg");
		
		
		for(Sweet sweet: sweets) {
			System.out.printf(formatStr, counter, sweet.getClass().getSimpleName(), sweet.getName(),
					String.valueOf(sweet.getCost()), String.valueOf(sweet.getWeight()));
			counter++;
		}
		System.out.println();
	}
	
	public void showWrapAssortment(List<Wrap> wraps) {
		
		String formatStr = "| %s | %16.16s | %6.6s | %9.9s |\n";
		int counter = 0;
		
		System.out.println("Current wrap's assortment:");
		System.out.printf(formatStr, "№", "Type", "Cost,$", "Weight,kg");
		
		
		for(Wrap wrap: wraps) {
			System.out.printf(formatStr, counter, wrap.getType(),
					String.valueOf(wrap.getCost()), String.valueOf(wrap.getWeight()));
			counter++;
		}
		System.out.println();
	}
	
	public void showPresent(Client client, String presentName) throws LogicException{
		
		Present present;
		Wrap wrap;
		List<Sweet> sweets;
		String formatStr;
		int counter;
		double totalCost;
		double totalWeight;
		
		present = client.getPresent(presentName);
		wrap = present.getWrap();
		sweets = present.getSweets();
		formatStr = "| %s | %12.12s | %16.16s | %6.6s | %9.9s |\n";
		counter = 0;
		totalCost = client.getCostOfPresent(presentName);
		totalWeight = client.getWeightOfPresent(presentName);
		
		System.out.println("The " + client.getName() + "'s " + presentName + ":");
		System.out.printf(formatStr, "№", "Type", "Name", "Cost,$", "Weight,kg");
		System.out.printf(formatStr, "-", "Wrap", wrap.getType(),
				String.valueOf(wrap.getCost()), String.valueOf(wrap.getWeight()));
		for(Sweet sweet: sweets) {
			System.out.printf(formatStr, counter, sweet.getClass().getSimpleName(), sweet.getName(),
					String.valueOf(sweet.getCost()), String.valueOf(sweet.getWeight()));
			counter++;
		}
		System.out.printf(formatStr, "-", "-","-", "-", "-");
		System.out.printf(formatStr, "-", "-","Total", String.valueOf(totalCost), String.valueOf(totalWeight));
		System.out.println();
	}
	
	public void showAllPresents(Client client) throws LogicException{
		
		List<Present> presents = client.getAllPresents();
		double totalCost = client.getCostOfAllPresents();
		
		System.out.println("ALL " + client.getName().toUpperCase() + "'S PRESENTS:");
		System.out.println();
		
		for(Present present: presents) {
			showPresent(client, present.getName());	
		}
		System.out.printf("TOTAL COST OF ALL %s'S PRESENTS IS %.2f$.\n",client.getName().toUpperCase(),totalCost);
		System.out.println();
	}
}
