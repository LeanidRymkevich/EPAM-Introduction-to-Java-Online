package by.epam.javaonline.task5_4.logic;

import by.epam.javaonline.task5_4.logic.impl.DragonLogicImpl;

public final class LogicProvider {

	private static final LogicProvider INSTANCE = new LogicProvider();
	
	private DragonLogic logic = new DragonLogicImpl();
	
	private LogicProvider() {}
	
	public static LogicProvider getInstance() {
		return INSTANCE;
	}

	public DragonLogic getLogic() {
		return logic;
	}

	public void setLogic(DragonLogic logic) {
		this.logic = logic;
	}
	
	
}
