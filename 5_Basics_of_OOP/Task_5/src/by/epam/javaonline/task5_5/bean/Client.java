package by.epam.javaonline.task5_5.bean;

import java.io.Serializable;
import java.util.List;

import by.epam.javaonline.task5_5.logic.ClientLogic;
import by.epam.javaonline.task5_5.logic.LogicException;
import by.epam.javaonline.task5_5.logic.LogicProvider;

public class Client extends Person implements Serializable{
	
	private static final long serialVersionUID = 8044164781515438918L;
	
	private static final ClientLogic clientLogic = LogicProvider.getInstance().getClientLogic();

	public Client() {
		super();
	}
	
	public Client(String name, String password) {
		super(name, password);
	}
	
	public Present addPresent(String name, int numberOfWrap, int...numbersOfSweets) throws LogicException {
		return clientLogic.addPresent(this, name, numberOfWrap, numbersOfSweets);
	}
	
	public List<Present> getAllPresents() throws LogicException {
		return clientLogic.getAllPresents(this);
	}
	
	public Present getPresent(String name) throws LogicException {
		return clientLogic.getPresent(this, name);
	}
	
	public Present removePresent(String name) throws LogicException {
		return clientLogic.removePresent(this, name);
	}
	
	public double getCostOfPresent(String presentName) throws LogicException {
		return clientLogic.getCostOfPresent(this, presentName);
	}
	
	public double getCostOfAllPresents() throws LogicException {
		return clientLogic.getCostOfAllPresents(this);
	}
	
	public Client removeCurrentClient() throws LogicException {
		return clientLogic.removeCurrentClient(this);
	}
	
	public List<Sweet> getSweetAssortment() throws LogicException{
		return clientLogic.getSweetAssortment();
	}
	
	public List<Wrap> getWrapAssortment() throws LogicException {
		return clientLogic.getWrapAssortment();
	}
	
	public double getWeightOfPresent(String presentName) throws LogicException {
		return clientLogic.getWeightOfPresent(this, presentName);
	}
}
