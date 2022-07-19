package by.epam.javaonline.task5_1;

import java.util.Objects;

public abstract class File {

	private String name;
	private String path;
	
	public File() {
		
	}
	
	public File(String path) {
		this.path = path;
	}
	
	public File(String path, String name) {
		this.name = name;
		this.path = path;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public abstract void rename(String newName);
	
	public static String StringValidation(String string, String defaultString) {
		
		if(string == null || string.isEmpty()) {
			return defaultString;
		} else {
			return string;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, path);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		File other = (File) obj;
		return Objects.equals(name, other.name) && Objects.equals(path, other.path);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + name + ", path=" + path + "]";
	}
}
