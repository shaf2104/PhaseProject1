package com.handle;
import java.util.List;
import java.util.Scanner;
import com.file.FileOperations;
import com.main.MenuOptions;
public class HandleOptions {
	public static void handleWelcomeScreenInput() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				MenuOptions.displayMenu();
				int input = sc.nextInt();

				switch (input) {
				case 1:
					FileOperations.displayAllFiles("project");
					break;
				case 2:
					HandleOptions.handleFileMenuOptions();
					break;
				case 3:
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleWelcomeScreenInput();
			} 
		} while (running == true);
	}
	
	public static void handleFileMenuOptions() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				MenuOptions.displayFileMenuOptions();
				FileOperations.createMainFolderIfNotPresent("project");
				
				int input = sc.nextInt();
				switch (input) {
				case 1:
					System.out.println("Enter the name of the file to be added to the \"project\" folder");
					String fileToAdd = sc.next();
					FileOperations.createFile(fileToAdd, sc);
					break;
				case 2:
					System.out.println("Enter the name of the file to be deleted from \"project\" folder");
					String fileToDelete = sc.next();
					FileOperations.createMainFolderIfNotPresent("project");
					List<String> filesToDelete = FileOperations.displayFileLocations(fileToDelete, "project");
					String deletionPrompt = "\nSelect index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					System.out.println(deletionPrompt);
					int idx = sc.nextInt();
					if (idx != 0) {
						FileOperations.deleteFileRecursively(filesToDelete.get(idx - 1));
					} else {
						for (String path : filesToDelete) {
							FileOperations.deleteFileRecursively(path);
						}
					}
					break;
				case 3:
					System.out.println("Enter the name of the file to be searched from \"main\" folder");
					String fileName = sc.next();
					FileOperations.createMainFolderIfNotPresent("project");
					FileOperations.displayFileLocations(fileName, "project");
					break;
				case 4:
					
					return;
				case 5:
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option from above.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				handleFileMenuOptions();
			}
		} while (running == true);
	}
}
