package by.epam.javaonline.task5_1;

import java.io.Serializable;
import java.util.Objects;

public class TextFile extends File implements Serializable {

	private static final long serialVersionUID = -5347590236319645181L;
	
	public static final String DEFAULT_NAME = "NewTextDocument";
	public static final String DEFAULT_EXTENTION = "txt";
	
	private String extension;
	private final StringBuilder content = new StringBuilder();
	
	public TextFile() {
		
	}
	
	public TextFile(String path){
		super(path, DEFAULT_NAME);
		extension = DEFAULT_EXTENTION;
	}
	
	public TextFile(String path, String extension){
		super(path, DEFAULT_NAME);
		
		extension = File.StringValidation(extension, DEFAULT_EXTENTION);
		this.extension = extension;
	}
	
	public TextFile(String path, String extension, String name ){
		super(path);
		
		extension = File.StringValidation(extension, DEFAULT_EXTENTION);
		name = File.StringValidation(name, DEFAULT_NAME);
		
		setName(name);
		this.extension = extension;
	}

	public String getExtension() {
		return extension;
	}

	public StringBuilder getContent() {
		return content;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String addToContent(String...strings) {
		
		for(String string: strings) {
			if(string != null) {
				content.append(string);
			} else {
				continue;
			}
		}
		
		if(content.isEmpty()) {
			return null;
		} else {
			return content.toString();
		}
	}
	
	@Override
	public void rename(String newName) {
		setName(File.StringValidation(newName, DEFAULT_NAME));
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(content.toString(), extension);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		TextFile other = (TextFile) obj;
		return Objects.equals(content.toString(), other.content.toString()) && Objects.equals(extension, other.extension);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + getName() + ", path=" + getPath() + " [extension=" + extension + "]";
	}

}
