package application;

import java.util.Random;

import structures.ParkingStructure;
import vehicles.Car;
import vehicles.Truck;
import vehicles.Van;
import vehicles.Vehicle;


public class Main{

	public static void main(String[] args) {

		//Generate Parking Structure and Vehicle Array.
				ParkingStructure lot = new ParkingStructure(100);
				Vehicle[] vehicles = new Vehicle[100];

				//Fill Vehicle Array with Randomly Generated Vehicles. (only filling 50/100 elements to allow room
				//for the user to create a car.)
				Random numberGenerator = new Random();
				for (int i = 0; i < 50; i++) {
					int choose = numberGenerator.nextInt(3);
					switch (choose) {
					case 0: {
						vehicles[i] = new Car();
						break;
					}
					case 1: {
						vehicles[i] = new Van();
						break;
					}
					case 2: {
						vehicles[i] = new Truck();
						break;
					}
					}
				}

		mainWindow.launch(args);
	}
}
