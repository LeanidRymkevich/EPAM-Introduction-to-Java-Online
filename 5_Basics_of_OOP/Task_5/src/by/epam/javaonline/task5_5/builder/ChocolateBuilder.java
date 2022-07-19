package by.epam.javaonline.task5_5.builder;

import by.epam.javaonline.task5_5.bean.Chocolate;

public interface ChocolateBuilder extends SweetBuilder{

	Chocolate getResult();
}
