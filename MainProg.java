package com.menu;
import com.file.FileOperations;
import com.handle.HandleOptions;
import com.main.MenuOptions;
public class MainProg {
	public static void main(String[] args) {
		FileOperations.createMainFolderIfNotPresent("project");
		MenuOptions.printWelcomeScreen("LockedMe", "Shabhana meatha");
		HandleOptions.handleWelcomeScreenInput();
	}	
}
