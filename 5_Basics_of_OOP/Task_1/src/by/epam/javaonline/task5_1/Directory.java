package by.epam.javaonline.task5_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Directory extends File implements Serializable {

	private static final long serialVersionUID = -7905101143892903362L;
	
	public static final String DEFAULT_NAME = "NewDirectory";
	public static final String DEFAULT_PATH = "C:\\";

	private final List<Directory> subDirectories = new ArrayList<>();
	private final List<TextFile> textFiles = new ArrayList<>();
	
	public Directory() {
		
	}
	
	public Directory(String path) {
		path = File.StringValidation(path, DEFAULT_PATH);
		
		setPath(path);
		setName(DEFAULT_NAME);
	}
	
	public Directory(String path, String name) {
		
		path = File.StringValidation(path, DEFAULT_PATH);
		name = File.StringValidation(name, DEFAULT_NAME);
		
		setPath(path);
		setName(name);
	}
	
	public List<Directory> getSubDirectories() {
		return subDirectories;
	}

	public List<TextFile> getTextFiles() {
		return textFiles;
	}

	public TextFile createTextFile(String extension) {
		return createTextFile(TextFile.DEFAULT_NAME, extension);
	}
	
	public TextFile createTextFile(String fileName, String extension) {
		
		if(extension == null || fileName == null || extension.isEmpty()) {
			return null;
		}
		
		TextFile result;
		String path;
		
		path = createPathForFile(fileName, extension);
		result = new TextFile(path, extension, fileName);
		textFiles.add(result);
		
		return result;
	}
	
	private String createPathForFile(String fileName, String extension) {
		
		StringBuilder path;
		
		path = new StringBuilder("\\");
		path.append(getName());
		path.append("\\");
		path.append(fileName);
		path.append(".");
		path.append(extension);
		 
		return path.toString();
	}
	
	public Directory createSubDirectory(String name) {

		name = File.StringValidation(name, DEFAULT_NAME);

		String path = "\\" + getName()+"\\" + name;
		Directory sub = new Directory(path, name);
		subDirectories.add(sub);
		return sub;
	}
	
	public boolean removeTextFile(String name) {
		
		if (name == null || name.isEmpty()) {
			return false;
		}
		
		boolean isExist = false;
		
		Iterator<TextFile> iterator = textFiles.iterator();
		
		while(iterator.hasNext()) {
			
			TextFile file = (TextFile) iterator.next();
			
			if(file.getName().equals(name)) {
				iterator.remove();
				isExist = true;
			}
		}
		
		if(isExist) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean removeSubDirectory(String name) {
		
		if (name == null || name.isEmpty()) {
			return false;
		}
		
		boolean isExist = false;
		
		Iterator<Directory> iterator = subDirectories.iterator();
		
		while(iterator.hasNext()) {
			
			Directory folder = (Directory) iterator.next();
			
			if(folder.getName().equals(name)) {
				iterator.remove();;
				isExist = true;
			}
		}
		
		if(isExist) {
			return true;
		} else {
			return false;
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
		result = prime * result + Objects.hash(subDirectories, textFiles);
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
		Directory other = (Directory) obj;
		return Objects.equals(subDirectories, other.subDirectories) && Objects.equals(textFiles, other.textFiles);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [name=" + getName() + ", path=" + getPath() + "]";
	}
	
	
}
