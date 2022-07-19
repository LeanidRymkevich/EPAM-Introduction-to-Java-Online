package by.epam.javaonline.task5_5.utility;

import java.io.File;

public class SourceFolderCleaner {

	private final String storagePath;
	
	{
		storagePath = new StringBuilder(new File("").getAbsolutePath()).
			     append("\\source").toString();
	}
	
	public SourceFolderCleaner() {}
	
	public void clean() {
		
		File folder = new File(storagePath);
		String[] files = folder.list();
		String path = null;
		
		for(int i = 0; i < files.length; i++) {
			path = storagePath + "\\" + files[i];
			new File(path).delete();
		}
	}
}
