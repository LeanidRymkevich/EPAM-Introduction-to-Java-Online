package by.epam.javaonline.task5_5.main;

import java.util.List;

import by.epam.javaonline.task5_5.bean.Administrator;
import by.epam.javaonline.task5_5.bean.Candy;
import by.epam.javaonline.task5_5.bean.Chocolate;
import by.epam.javaonline.task5_5.bean.Client;
import by.epam.javaonline.task5_5.bean.Cookie;
import by.epam.javaonline.task5_5.bean.Waffle;
import by.epam.javaonline.task5_5.bean.Wrap;
import by.epam.javaonline.task5_5.builder.impl.CandyBuilderImpl;
import by.epam.javaonline.task5_5.builder.impl.ChocolateBuilderImpl;
import by.epam.javaonline.task5_5.builder.impl.CookieBuilderImpl;
import by.epam.javaonline.task5_5.builder.impl.WaffleBuilderImpl;
import by.epam.javaonline.task5_5.builder.impl.WrapBuilderImpl;
import by.epam.javaonline.task5_5.logic.LogicException;
import by.epam.javaonline.task5_5.logic.LogicProvider;
import by.epam.javaonline.task5_5.logic.PersonLogic;
import by.epam.javaonline.task5_5.logic.Validator;
import by.epam.javaonline.task5_5.utility.SourceFolderCleaner;
import by.epam.javaonline.task5_5.view.View;

/* Задача 5.
 * Создать консольное приложение, удовлетворяющее следующим требованиям:
 * • Корректно спроектируйте и реализуйте предметную область задачи.
 * • Для создания объектов из иерархии классов продумайте возможность использования порождающих шаблонов проектирования.
 * • Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
 * • для проверки корректности переданных данных можно применить регулярные выражения.
 * • Меню выбора действия пользователем можно не реализовывать, используйте заглушку.
 * • Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode(). 
 * Вариант B. Подарки. Реализовать приложение, позволяющее создавать подарки (объект, представляющий собой подарок). 
 * Составляющими целого подарка являются сладости и упаковка.
*/

public class Main {
	
	private static final LogicProvider provider = LogicProvider.getInstance();
	private static final PersonLogic personLogic = provider.getPersonLogic();
	private static final Validator validator = provider.getValidator();
	private static final View view = new View();

	public static void main(String[] args) {
		
		// the utility SourceFolderCleaner cleans the source folder before running
		// this main class
		
		new SourceFolderCleaner().clean();
		
		//_______________________________________________________________________
	
		// creating of the default administrator(the very first administrator)___
		
		Administrator defaultAdmin;
		String defaultName;
		String defaultPassword;
		
		defaultAdmin = null;
		defaultName = "DefaultAdmin";
		defaultPassword = "DefaultAdmin";
		
		try {
			defaultAdmin = personLogic.addNewAdministrator(defaultName, defaultPassword);
		} catch (LogicException e) {
			e.printStackTrace();
		}
		
		//________________________________________________________________
		
		// creating of an administrator and a client________________________________
		
		Administrator leanid;
		Client marta;
		String leanidName;
		String leanidPassword;
		String martaName;
		String martaPassword;
		
		leanid = null;
		marta = null;
		leanidName = "Leanid";
		leanidPassword = "123456sd7";
		martaName = "Marta1";
		martaPassword = "1251371sa3";
		
		try {
			
			leanidName = validator.registrationNameCheck(leanidName);
			leanidPassword = validator.personPasswordCheck(leanidPassword);
			
			if (leanidName == null) {
				System.out.println("This name already exists. Choose another name!!!");
				// // go to lines 51,52
			}
			
			leanid = defaultAdmin.addNewAdmin(leanidName, leanidPassword);
			view.registrationResponse(leanid);
			
		} catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			// go to lines 51,52
		} catch (LogicException e) {
			System.out.println("Sorry! System failure occurred!");
		}
		
		try {
			
			martaName = validator.registrationNameCheck(martaName);
			martaPassword = validator.personPasswordCheck(martaPassword);
			
			if (martaName == null) {
				System.out.println("This name already exists. Choose another name!!!");
				// // go to lines 51,52
			}
			
			marta = personLogic.addNewClient(martaName, martaPassword);
			view.registrationResponse(marta);
			
		} catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage()); // this name or/and password are incorrect
			// go to lines 51,52
		} catch (LogicException e) {
			System.out.println("Sorry! System failure occurred!");
		}
		
		//________________________________________________________________________________________________________
		
		// admin's actions________________________________________________________________________________________
		
		try {
			
			leanidName = validator.personNameCheck(leanidName);
			leanidPassword = validator.personPasswordCheck(leanidPassword);
			
			leanid = (Administrator) personLogic.logination(leanidName, leanidPassword);
			
			if(leanid == null) {
				System.out.println("Such a person doesn't exist"); // go to logination menu
			}
			
			view.loginationResponse(leanid);
			
			Wrap wrap_1 = new WrapBuilderImpl().setType("Сellophane").setCost(10).setWeight(0.1).getResult();
			Wrap wrap_2 = new WrapBuilderImpl().setType("Carton").setCost(15).setWeight(0.3).getResult();
			Wrap wrap_3 = new WrapBuilderImpl().setType("Plastic").setCost(20).setWeight(0.25).getResult();
			
			Candy candy = ((CandyBuilderImpl) new CandyBuilderImpl().setName("Squirrel").setCost(2).setWeight(0.03)).getResult();
			Chocolate chocolate = ((ChocolateBuilderImpl) new ChocolateBuilderImpl().setName("Alenka").setCost(8).setWeight(0.2)).getResult();
			Chocolate chocolate1 = ((ChocolateBuilderImpl) new ChocolateBuilderImpl().setName("Spartak").setCost(8).setWeight(0.2)).getResult();
			Cookie cookie = ((CookieBuilderImpl) new CookieBuilderImpl().setName("Сornflowers").setCost(5).setWeight(0.15)).getResult();
			Waffle waffle = ((WaffleBuilderImpl) new WaffleBuilderImpl().setName("BlackSeaWaffle").setCost(6).setWeight(0.15)).getResult();
			
			leanid.addWraps(List.of(wrap_1, wrap_2, wrap_3, wrap_3));
			leanid.addSweets(List.of(candy, chocolate, chocolate1, cookie, waffle));
			
			view.showSweetAssortment(leanid.getAllSweets());
			view.showWrapAssortment(leanid.getAllWraps());
			
			leanid.removeSweet("Chocolate", "Spartak");
			leanid.removeWrap("Plastic");
			
		} catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage()); // this name or/and password are incorrect 
		} catch (LogicException e) {
			System.out.println("Sorry! System failure occurred!");
		}
		
		// end of showing admin's actions_______________________________________________________
		
		// client's actions_____________________________________________________________________
		
		try {
			
			martaName = validator.personNameCheck(martaName);
			martaPassword = validator.personPasswordCheck(martaPassword);
			
			marta = (Client) personLogic.logination(martaName, martaPassword);
			
			if(marta == null) {
				System.out.println("Such a person doesn't exist"); // go to logination menu
			}
			
			view.loginationResponse(marta);
			
			view.showSweetAssortment(marta.getSweetAssortment());
			view.showWrapAssortment(marta.getWrapAssortment());
			
			marta.addPresent("BirthdayPresent", 1, 0,0,0,0,1,2,3);
			marta.addPresent("NewYearPresent", 2, 0,0,0,0,1,2,2,3,3);
			marta.addPresent("ChristmasPresent", 0, 0,2,1,3,1,2,2,3,3);
			view.showAllPresents(marta);
			
			marta.removePresent("NewYearPresent");
			view.showAllPresents(marta);
			
			// to see the result of removeCurrentClient()-operation, decomment code below
			/*
			marta.removeCurrentClient();
			
			marta = (Client) personLogic.logination(martaName, martaPassword);
			
			if(marta == null) {
				System.out.println("Such a person doesn't exist");
			}
			*/
			
		} catch(IllegalArgumentException ex) {
			System.out.println(ex.getMessage()); // this name or/and password are incorrect 
		} catch (LogicException e) {
			System.out.println("Sorry! System failure occurred!");
		}
		
		// end of showing client's actions_______________________________________________________
	}

}
