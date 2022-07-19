package by.epam.javaonline.task5_5.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Present implements Serializable{

	private static final long serialVersionUID = -3921635745640105352L;
	
	private String name;
	private Wrap wrap;
	private final List<Sweet> sweet = new ArrayList<>();
	
	public Present() {
		super();
	}
	
	public Present(String name) {
		super();
		this.name = name;
	}
	
	public Present(String name, Wrap wrap) {
		super();
		this.name = name;
		this.wrap = wrap;
	}
	
	public Present(String name, Wrap wrap, Sweet...sweets) {
		super();
		this.name = name;
		this.wrap = wrap;
		this.sweet.addAll(Arrays.asList(sweets));
	}

	public String getName() {
		return name;
	}

	public Wrap getWrap() {
		return wrap;
	}

	public List<Sweet> getSweets() {
		return sweet;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setWrap(Wrap wrap) {
		this.wrap = wrap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, sweet, wrap);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Present other = (Present) obj;
		return Objects.equals(name, other.name) && Objects.equals(sweet, other.sweet)
				&& Objects.equals(wrap, other.wrap);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + name + ", wrap=" + wrap + "]";
	}
}
