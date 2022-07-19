package by.epam.javaonline.task5_4.dao;

import by.epam.javaonline.task5_4.dao.impl.CaveDAOImpl;

public final class DAOProvider {

	private static final DAOProvider INSTANCE = new DAOProvider();
	
	private CaveDAO caveDAO = new CaveDAOImpl();
	
	private DAOProvider() {}
	
	public static DAOProvider getInstance() {
		return INSTANCE;
	}

	public CaveDAO getCaveDAO() {
		return caveDAO;
	}

	public void setCaveDAO(CaveDAO caveDAO) {
		this.caveDAO = caveDAO;
	}
}
