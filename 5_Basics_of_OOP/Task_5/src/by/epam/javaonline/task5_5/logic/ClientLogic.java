package by.epam.javaonline.task5_5.logic;

import java.util.List;

import by.epam.javaonline.task5_5.bean.Client;
import by.epam.javaonline.task5_5.bean.Present;
import by.epam.javaonline.task5_5.bean.Sweet;
import by.epam.javaonline.task5_5.bean.Wrap;

public interface ClientLogic {

	Present addPresent(Client client,String name, int numberOfWrap, int...numbersOfSweets) throws LogicException;
	
	List<Present> getAllPresents(Client client) throws LogicException;
	
	Present getPresent(Client client, String name) throws LogicException;
	
	Present removePresent(Client client, String name) throws LogicException;
	
	double getCostOfPresent(Client client, String presentName) throws LogicException;
	
	double getWeightOfPresent(Client client, String presentName) throws LogicException;
	
	double getCostOfAllPresents(Client client) throws LogicException;
	
	Client removeCurrentClient(Client client) throws LogicException;
	
	List<Sweet> getSweetAssortment() throws LogicException;
	
	List<Wrap> getWrapAssortment() throws LogicException;
}
