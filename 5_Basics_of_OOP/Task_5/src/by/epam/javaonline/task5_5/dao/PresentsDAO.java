package by.epam.javaonline.task5_5.dao;

import java.util.List;

import by.epam.javaonline.task5_5.bean.Client;
import by.epam.javaonline.task5_5.bean.Present;

public interface PresentsDAO {
	
	List<Present> addAllPresents(Client client, List<Present> list) throws DAOException;
	
	List<Present> getAllPresents(Client client) throws DAOException;
	
	Present getPresent(Client client, String name) throws DAOException;
	
	Present removePresent(Client client, String name) throws DAOException;
}
