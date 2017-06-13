package main;
import gui.MainWindow;
public class Main {
	@SuppressWarnings({ "static-access" })
	public static void main(String[] args) {
		MainWindow mainWindow = new MainWindow();
		mainWindow.launch(MainWindow.class);
	}
}