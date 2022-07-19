package by.epam.javaonline.task5_5.dao;

import java.util.List;

import by.epam.javaonline.task5_5.bean.Wrap;

public interface WrapsDAO {

	List<Wrap> getAllWraps() throws DAOException;
	
	List<Wrap> addWraps(List<Wrap> list) throws DAOException;
	
	Wrap removeWrap(String type) throws DAOException;
}
