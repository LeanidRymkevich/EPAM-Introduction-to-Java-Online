package by.epam.javaonline.task5_5.dao.impl;

import by.epam.javaonline.task5_5.bean.Present;
import by.epam.javaonline.task5_5.bean.Sweet;
import by.epam.javaonline.task5_5.bean.Wrap;
import by.epam.javaonline.task5_5.builder.PresentBuilder;
import by.epam.javaonline.task5_5.builder.impl.PresentBuilderImpl;
import by.epam.javaonline.task5_5.dao.PresentConverter;
import by.epam.javaonline.task5_5.dao.SweetConverter;
import by.epam.javaonline.task5_5.dao.WrapConverter;

public class PresentConverterImpl implements PresentConverter{
	
	private final SweetConverter sweetConverter = new SweetConverterImpl();
	private final WrapConverter wrapConverter = new WrapConverterImpl();

	// The object of Present-type in the data-file will be presented as a string below:
	// ClassName_|_Name="name"_|_Wrap presentation from WrapConverter_|_Sweets presentations from SweetsConverter separated by "," \n
	
	@Override
	public String presentToString(Present present) {
		
		if(present == null) {
			return "null\n";
		}
		
		StringBuilder result;
		String wrap;
		String sweet;
		Sweet current;
		
		result = new StringBuilder();
		wrap = wrapConverter.wrapToString(present.getWrap());
		sweet = null;
		current = null;
		
		result.append(present.getClass().getSimpleName()).
					 append("_|_Name=" + present.getName()).
					 append("_|_" + wrap).
					 deleteCharAt(result.length() -1).
					 append( "_|_");
		
		if(present.getSweets().isEmpty()) {
			result.append("null\n");
			return result.toString();
		}
		
		for(int i = 0; i < present.getSweets().size(); i++) {
			current = present.getSweets().get(i);
			sweet = sweetConverter.sweetToString(current);
			result.append(sweet).deleteCharAt(result.length() -1).append(", ");
		}
		result.delete(result.length()-2, result.length()).append("\n");
		
		return result.toString();
					 
	}

	@Override
	public Present stringToPresent(String line) {
		
		if(line.equals("null")) {
			return null;
		}
		
		String[] params;
		String name;
		Wrap wrap;
		String[] sweets;
		Sweet sweet;
		PresentBuilder builder;
		
		params = line.split("\\_\\|\\_");
		name = params[1].split("=")[1];
		wrap = wrapConverter.stringToWrap(params[2]);
		builder = new PresentBuilderImpl();
		sweet = null;
		
		if(params[3].equals("null")) {
			return builder.setName(name).setWrap(wrap).getResult();
		}
		
		sweets = params[3].split(",\\s+");
		builder.setName(name).setWrap(wrap);
		
		for(int i = 0; i < sweets.length;i++) {
			sweet = sweetConverter.stringToSweet(sweets[i]);
			builder.addSweet(sweet);
		}
		
		return builder.getResult();
	}
}
