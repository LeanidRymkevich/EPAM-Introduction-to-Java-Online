package by.epam.javaonline.task5_5.builder.impl;

import by.epam.javaonline.task5_5.bean.Cookie;
import by.epam.javaonline.task5_5.builder.CookieBuilder;

public class CookieBuilderImpl extends SweetBuilderImpl implements CookieBuilder{

	@Override
	public Cookie getResult() {
		return new Cookie(getName(), getCost(), getWeight());
	}

}
