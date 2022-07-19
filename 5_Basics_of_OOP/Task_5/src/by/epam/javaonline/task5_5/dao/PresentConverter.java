package by.epam.javaonline.task5_5.dao;

import by.epam.javaonline.task5_5.bean.Present;

public interface PresentConverter {

	String presentToString(Present present);
	
	Present stringToPresent(String line);
}
