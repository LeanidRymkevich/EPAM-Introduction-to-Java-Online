package by.epam.javaonline.task5_5.builder;

import by.epam.javaonline.task5_5.bean.Present;
import by.epam.javaonline.task5_5.bean.Sweet;
import by.epam.javaonline.task5_5.bean.Wrap;

public interface PresentBuilder{

	PresentBuilder setName(String name);
	PresentBuilder setWrap(Wrap wrap);
	PresentBuilder addSweet(Sweet sweet);
	Present getResult();
}
