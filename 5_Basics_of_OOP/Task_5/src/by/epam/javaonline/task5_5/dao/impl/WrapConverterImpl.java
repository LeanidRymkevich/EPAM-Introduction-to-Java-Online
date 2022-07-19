package by.epam.javaonline.task5_5.dao.impl;

import by.epam.javaonline.task5_5.bean.Wrap;
import by.epam.javaonline.task5_5.dao.WrapConverter;

public class WrapConverterImpl implements WrapConverter{
	
	// The object of Wrap-type in the data-file will be presented as a string below:
	// ClassName type="type" cost="cost" weight="weight"\n

	@Override
	public String wrapToString(Wrap wrap) {
		
		if(wrap == null) {
			return "null\n";
		}
		
		StringBuilder result = new StringBuilder();
		
		result.append(wrap.getClass().getSimpleName()).
			   append(" type=" + wrap.getType()).
			   append(" cost=" + wrap.getCost()).
			   append(" weight=" + wrap.getWeight()).
			   append("\n");
		return result.toString();
	}

	@Override
	public Wrap stringToWrap(String line) {
		
		if(line.equals("null")) {
			return null;
		}
		
		String[] params;
		String className;
		String type;
		String cost;
		String weight;
		

		params = line.split("\\s+");
		className = params[0];
		type = params[1].split("=")[1];
		cost = params[2].split("=")[1];
		weight = params[3].split("=")[1];
		
		if(className.equals("Wrap")) {
			return new Wrap(type, Double.valueOf(cost), Double.valueOf(weight));
		} else {
			return null;
		}
	}

}
