package by.epam.javaonline.task5_5.dao;

import java.util.List;

import by.epam.javaonline.task5_5.bean.Sweet;

public interface SweetsDAO {

	List<Sweet> getAllSweets() throws DAOException;
	
	List<Sweet> addSweets(List<Sweet> list) throws DAOException;
	
	Sweet removeSweet(String className, String name) throws DAOException;
}
