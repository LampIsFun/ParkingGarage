package tools;

import java.util.Random;

public abstract class ToolBox {

	public static String choose(String c1, String c2, String c3, String c4, String c5, String c6, String c7) {
		String chosenString = "null";
		Random numberGenerator = new Random();
		int choose = numberGenerator.nextInt(7);
		switch (choose) {
		case 0: {
			chosenString = c1;
			break;
		}
		case 1: {
			chosenString = c2;
			break;
		}
		case 2: {
			chosenString = c3;
			break;
		}
		case 3: {
			chosenString = c4;
			break;
		}
		case 4: {
			chosenString = c5;
			break;
		}
		case 5: {
			chosenString = c6;
			break;
		}
		case 6: {
			chosenString = c7;
			break;
		}
		}
		return chosenString;
	}
	
	public static String choose(String c1, String c2, String c3, String c4, String c5, String c6) {
		String chosenString = "null";
		Random numberGenerator = new Random();
		int choose = numberGenerator.nextInt(6);
		switch (choose) {
		case 0: {
			chosenString = c1;
			break;
		}
		case 1: {
			chosenString = c2;
			break;
		}
		case 2: {
			chosenString = c3;
			break;
		}
		case 3: {
			chosenString = c4;
			break;
		}
		case 4: {
			chosenString = c5;
			break;
		}
		case 5: {
			chosenString = c6;
			break;
		}
		}
		return chosenString;
	}
	
	public static String choose(String c1, String c2, String c3, String c4, String c5) {
		String chosenString = "null";
		Random numberGenerator = new Random();
		int choose = numberGenerator.nextInt(5);
		switch (choose) {
		case 0: {
			chosenString = c1;
			break;
		}
		case 1: {
			chosenString = c2;
			break;
		}
		case 2: {
			chosenString = c3;
			break;
		}
		case 3: {
			chosenString = c4;
			break;
		}
		case 4: {
			chosenString = c5;
			break;
		}
		}
		return chosenString;
	}
	
	public static String choose(String c1, String c2, String c3, String c4) {
		String chosenString = "null";
		Random numberGenerator = new Random();
		int choose = numberGenerator.nextInt(4);
		switch (choose) {
		case 0: {
			chosenString = c1;
			break;
		}
		case 1: {
			chosenString = c2;
			break;
		}
		case 2: {
			chosenString = c3;
			break;
		}
		case 3: {
			chosenString = c4;
			break;
		}
		}
		return chosenString;
	}
	
	public static String choose(String c1, String c2, String c3) {
		String chosenString = "null";
		Random numberGenerator = new Random();
		int choose = numberGenerator.nextInt(3);
		switch (choose) {
		case 0: {
			chosenString = c1;
			break;
		}
		case 1: {
			chosenString = c2;
			break;
		}
		case 2: {
			chosenString = c3;
			break;
		}
		}
		return chosenString;
	}
	
	public static String choose(String c1, String c2) {
		String chosenString = "null";
		Random numberGenerator = new Random();
		int choose = numberGenerator.nextInt(2);
		switch (choose) {
		case 0: {
			chosenString = c1;
			break;
		}
		case 1: {
			chosenString = c2;
			break;
		}
		}
		return chosenString;
	}
}
