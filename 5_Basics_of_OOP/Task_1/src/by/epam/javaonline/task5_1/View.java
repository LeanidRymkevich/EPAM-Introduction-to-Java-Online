package by.epam.javaonline.task5_1;

import java.util.List;

public final class View {
	
	private static int counter;

	private View() {}
	
	public static void printTextFile(TextFile file) {
		System.out.printf("TextFile: name[%s.%s], path[%s],\n"
						+ "content: [%s]", file.getName(), file.getExtension(), file.getPath(), file.getContent());
	}
	
	public static void printDirectory(Directory folder) {
		
		System.out.printf("Directory: name[%s], path[%s]\n", folder.getName(), folder.getPath());
		
		
		if(!folder.getTextFiles().isEmpty() || !folder.getSubDirectories().isEmpty()) {
			counter++;
		}
		
		if(!folder.getTextFiles().isEmpty()) {
			
			for(TextFile file: folder.getTextFiles()) {
				
				for(int i = 0; i < counter; i++) {
					System.out.print("\t");
				}
				
				System.out.printf("TextFile: name[%s.%s], path[%s]\n", file.getName(), file.getExtension(), file.getPath());
			}
		}
		
		List<Directory> subDirectories = folder.getSubDirectories();
		if(!subDirectories.isEmpty()) {
			
			for(Directory fold: folder.getSubDirectories()) {
				
				for(int i = 0; i < counter; i++) {
					System.out.print("\t");
				}
				
				printDirectory(fold);
			}
		} else {
			counter -= 1;
			return;
		}
		counter = 0;
	}
}
