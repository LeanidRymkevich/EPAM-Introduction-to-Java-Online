package by.epam.javaonline.task5_5.builder.impl;

import java.util.ArrayList;
import java.util.List;

import by.epam.javaonline.task5_5.bean.Present;
import by.epam.javaonline.task5_5.bean.Sweet;
import by.epam.javaonline.task5_5.bean.Wrap;
import by.epam.javaonline.task5_5.builder.PresentBuilder;

public class PresentBuilderImpl implements PresentBuilder{

	private String name;
	private Wrap wrap;
	private List<Sweet> sweets = new ArrayList<>();
	
	@Override
	public PresentBuilder setName(String name) {
		this.name = name;
		return this;
	}

	@Override
	public  PresentBuilder setWrap(Wrap wrap) {
		this.wrap = wrap;
		return this;
	}

	@Override
	public PresentBuilder addSweet(Sweet sweet) {
		sweets.add(sweet);
		return this;
	}
	
	public Present getResult() {
		
		Present result = new Present(name, wrap);
		result.getSweets().addAll(sweets);
		
		return result;
	}
}
