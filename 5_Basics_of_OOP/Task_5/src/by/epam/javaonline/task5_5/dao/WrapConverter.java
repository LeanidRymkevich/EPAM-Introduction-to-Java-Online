package by.epam.javaonline.task5_5.dao;

import by.epam.javaonline.task5_5.bean.Wrap;

public interface WrapConverter {

	String wrapToString(Wrap wrap);
	
	Wrap stringToWrap(String line);
}
