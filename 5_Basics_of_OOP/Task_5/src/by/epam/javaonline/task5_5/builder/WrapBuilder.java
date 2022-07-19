package by.epam.javaonline.task5_5.builder;

import by.epam.javaonline.task5_5.bean.Wrap;

public interface WrapBuilder {

	WrapBuilder setType(String type);
	WrapBuilder setCost(double cost);
	WrapBuilder setWeight(double weight);
	Wrap getResult();
}
