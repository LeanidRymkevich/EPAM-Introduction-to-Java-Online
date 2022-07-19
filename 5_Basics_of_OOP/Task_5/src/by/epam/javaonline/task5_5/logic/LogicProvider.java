package by.epam.javaonline.task5_5.logic;

import by.epam.javaonline.task5_5.logic.impl.AdminLogicImpl;
import by.epam.javaonline.task5_5.logic.impl.ClientLogicImpl;
import by.epam.javaonline.task5_5.logic.impl.PersonLogicImpl;
import by.epam.javaonline.task5_5.logic.impl.ValidatorImpl;

public final class LogicProvider {

	private static final LogicProvider INSTANCE = new LogicProvider();
	
	private final PersonLogic personLogic = new PersonLogicImpl();
	private final AdminLogic adminLogic = new AdminLogicImpl();
	private final ClientLogic clientLogic = new ClientLogicImpl();
	private final Validator validator = new ValidatorImpl();
	
	private LogicProvider() {}
	
	public static LogicProvider getInstance() {
		return INSTANCE;
	}

	public PersonLogic getPersonLogic() {
		return personLogic;
	}

	public AdminLogic getAdminLogic() {
		return adminLogic;
	}

	public ClientLogic getClientLogic() {
		return clientLogic;
	}

	public Validator getValidator() {
		return validator;
	}
}
