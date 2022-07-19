package by.epam.javaonline.task5_5.bean;

import java.io.Serializable;
import java.util.List;

import by.epam.javaonline.task5_5.logic.AdminLogic;
import by.epam.javaonline.task5_5.logic.LogicException;
import by.epam.javaonline.task5_5.logic.LogicProvider;

public class Administrator extends Person implements Serializable{
	
	private static final long serialVersionUID = 8450282047504027683L;
	
	private static final AdminLogic adminLogic = LogicProvider.getInstance().getAdminLogic();

	public Administrator() {
		super();
	}
	
	public Administrator(String name, String password) {
		super(name, password);
	}
	
	public List<Wrap> getAllWraps() throws LogicException {
		return adminLogic.getAllWraps();
	}
	
	public List<Wrap> addWraps(List<Wrap> list) throws LogicException {
		return adminLogic.addWraps(list);
	}
	
	public Wrap removeWrap(String type) throws LogicException {
		return adminLogic.removeWrap(type);
	}
	
	public List<Sweet> getAllSweets() throws LogicException {
		return adminLogic.getAllSweets();
	}
	
	public List<Sweet> addSweets(List<Sweet> list) throws LogicException {
		return adminLogic.addSweets(list);
	}
	
	public Sweet removeSweet(String className, String name) throws LogicException {
		return adminLogic.removeSweet(className, name);
	}
	
	public Person removePerson(String name) throws LogicException {
		return adminLogic.removePerson(name);
	}
	
	public Administrator addNewAdmin (String name, String password) throws LogicException{
		return adminLogic.addNewAdmin(name, password);
	}
}
