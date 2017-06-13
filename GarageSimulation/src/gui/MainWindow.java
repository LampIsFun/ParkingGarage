package gui;

import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import structures.ParkingStructure;
import vehicles.Car;
import vehicles.Truck;
import vehicles.Van;
import vehicles.Vehicle;

public class MainWindow extends Application {

	private static final int PARKING_SPOTS = 100;
	private static final int VEHICLE_COUNT = 100;

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Generate Parking Structure and Vehicle Array.

		ParkingStructure lot = new ParkingStructure(PARKING_SPOTS);
		Vehicle[] vehicles = new Vehicle[VEHICLE_COUNT];

		// Fill Vehicle Array with Randomly Generated Vehicles. (only filling
		// 50/100 elements to allow room
		// for the user to create vehicles.)
		Random numberGenerator = new Random();
		for (int i = 0; i < 99; i++) {
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
		// Putting cars into parking spots.
		// for each car that has been created thus far...
		for (int i = 0; i < 99; i++) {
			// get a random parking spot number...
			int nextAvailableSpot = numberGenerator.nextInt(PARKING_SPOTS);
			// cycle through random numbers until one is marked empty.
			do {
				nextAvailableSpot = numberGenerator.nextInt(PARKING_SPOTS);
			} while (!lot.getPlaces()[nextAvailableSpot].checkEmpty());
			// put the car into that empty spot for 100-500 seconds.
			int timeSet = numberGenerator.nextInt(50) + 40;
			lot.parkVehicle(vehicles[i], timeSet, nextAvailableSpot);
			// System.out.println("V: " + vehicles[i] + " T: " + timeSet + " S:
			// " + nextAvailableSpot);
		}

		BorderPane fullPaneMain = new BorderPane();
		BorderPane fullPaneRegister = new BorderPane();

		float price = 0;

		// Main menu buttons
		Button registerSpot = new Button("Register Spot (" + lot.getOpenSpots() + " open.)");
		registerSpot.setPadding(new Insets(20, 20, 20, 20));
		Button exit = new Button("Exit");
		exit.setPadding(new Insets(20, 20, 20, 20));
		Button refresh = new Button("Refresh");
		refresh.setPadding(new Insets(20, 20, 20, 20));

		// Register Screen buttons
		Label vinLabel = new Label("VIN #: ");
		vinLabel.setTranslateY(4);
		TextField vinField = new TextField();
		vinField.setPromptText("Enter your VIN Number");
		Label makeLabel = new Label("Make: ");
		makeLabel.setTranslateY(4);
		TextField makeField = new TextField();
		makeField.setPromptText("Enter your make");
		Label yearLabel = new Label("Year: ");
		yearLabel.setTranslateY(4);
		ObservableList<String> options = FXCollections.observableArrayList("less than 2000", "2000", "2001", "2002",
				"2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015",
				"2016", "2017");
		ComboBox<String> yearComboBox = new ComboBox<String>(options);
		yearComboBox.setValue("Click to choose");
		Button backButton = new Button("Back");
		backButton.setPadding(new Insets(10, 20, 10, 20));
		backButton.setTranslateX(90);
		backButton.setTranslateY(5);

		Label typeLabel = new Label("Vehicle Type: ");
		typeLabel.setTranslateY(4);
		ObservableList<String> typeOptions = FXCollections.observableArrayList("Car", "Truck", "Van");
		ComboBox<String> typeComboBox = new ComboBox<String>(typeOptions);
		typeComboBox.setValue("Click to choose");

		Label spotLabel = new Label("Choose an available Parking Spot: ");
		spotLabel.setTranslateY(4);
		ObservableList<String> spotOptions = FXCollections.observableArrayList();
		ComboBox<String> spotComboBox = new ComboBox<String>(spotOptions);
		for (int i = 0; i < PARKING_SPOTS; i++) {
			if (lot.getPlaces()[i].checkEmpty()) {
				spotOptions.add(Integer.toString(i));
				spotComboBox.setValue(Integer.toString(i));
			}
		}
		Button refreshSpots = new Button("Refresh");
		refreshSpots.setPadding(new Insets(5, 5, 5, 5));

		Slider timeSlider = new Slider();
		timeSlider.setMin(0);
		timeSlider.setMax(10);
		timeSlider.setValue(10);
		timeSlider.setShowTickLabels(true);
		timeSlider.setShowTickMarks(true);
		timeSlider.setMajorTickUnit(5);
		timeSlider.setMinorTickCount(10);
		timeSlider.setBlockIncrement(5);

		Label displayTime = new Label(Double.toString(timeSlider.getValue()) + " Minutes.");
		displayTime.setTranslateY(4);

		Label displayPrice = new Label("Price: " + Float.toString(price) + "$");

		displayPrice.setTranslateY(4);

		Button finalRegister = new Button("Register");
		finalRegister.setPadding(new Insets(20, 80, 20, 80));
		finalRegister.setTranslateY(-20);

		// Main Menu panels
		HBox leftSide = new HBox();
		leftSide.setPadding(new Insets(30, 30, 30, 30));
		leftSide.getChildren().addAll(registerSpot, refresh);

		HBox rightSide = new HBox();
		rightSide.setPadding(new Insets(30, 30, 30, 30));
		rightSide.getChildren().addAll(exit);

		// Register Screen panels
		HBox registerSide = new HBox(10);
		registerSide.setPadding(new Insets(10, 30, 10, 30));
		registerSide.getChildren().addAll(vinLabel, vinField, makeLabel, makeField, yearLabel, yearComboBox,
				backButton);
		HBox registerType = new HBox(10);
		registerType.setPadding(new Insets(10, 30, 10, 30));
		registerType.getChildren().addAll(typeLabel, typeComboBox);
		HBox registerSide2 = new HBox(10);
		registerSide2.setPadding(new Insets(10, 30, 10, 30));
		registerSide2.getChildren().addAll(spotLabel, spotComboBox, refreshSpots, timeSlider, displayTime);

		HBox registerPrice = new HBox(50);
		registerPrice.setPadding(new Insets(10, 30, 10, 30));
		registerPrice.getChildren().addAll(displayPrice, finalRegister);

		VBox registerScreen = new VBox();
		registerScreen.getChildren().addAll(registerSide, registerType, registerSide2, registerPrice);

		// Pane Control
		BorderPane.setAlignment(leftSide, Pos.CENTER_LEFT);
		BorderPane.setAlignment(rightSide, Pos.CENTER_RIGHT);
		BorderPane.setAlignment(registerScreen, Pos.CENTER);
		fullPaneMain.setLeft(leftSide);
		fullPaneMain.setRight(rightSide);
		fullPaneRegister.setCenter(registerScreen);

		Scene sceneMain = new Scene(fullPaneMain, 800, 450);
		Scene sceneRegister = new Scene(fullPaneRegister, 800, 450);

		// Action List
		refresh.setOnAction(e -> {
			lot.purgeSpots();
			registerSpot.setText("Register Spot (" + lot.getOpenSpots() + " open.)");
			System.out.println("Refreshed: " + lot.getOpenSpots() + " spots open.");
		});

		registerSpot.setOnAction(e -> {
			primaryStage.setScene(sceneRegister);
			vinField.setText("");
			makeField.setText("");
			yearComboBox.setValue("Click to choose");
			typeComboBox.setValue("Click to choose");
			timeSlider.setValue(10);
			spotOptions.clear();
			for (int i = 0; i < PARKING_SPOTS; i++) {
				if (lot.getPlaces()[i].checkEmpty()) {
					spotOptions.add(Integer.toString(i));
					spotComboBox.setValue(Integer.toString(i));
				}
			}
		});

		backButton.setOnAction(e -> {
			primaryStage.setScene(sceneMain);
		});

		refreshSpots.setOnAction(e -> {
			spotOptions.clear();
			lot.purgeSpots();
			for (int i = 0; i < PARKING_SPOTS; i++) {
				if (lot.getPlaces()[i].checkEmpty()) {
					spotOptions.add(Integer.toString(i));
					spotComboBox.setValue(Integer.toString(i));
				}
			}
			System.out.println("Refreshed: " + lot.getOpenSpots() + " spots open.");
		});

		timeSlider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				displayTime.setText(String.format("%.2f", new_val) + " Minutes.");
				float newPrice = (float) ((((-0.001f) * Float.parseFloat(spotComboBox.getValue())) + 1.00f)
						* (timeSlider.getValue()));
				displayPrice.setText("Price: " + String.format("%.2f", newPrice) + "$");
				timeSlider.setStyle(null);
			}

		});
		spotComboBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				if ((arg1 != null && arg2 != null && arg0 != null)) {
					Float new_value = Float.parseFloat(spotComboBox.getValue());
					Float newPrice = ((float) ((((-0.001f) * new_value) + 1.00f) * (timeSlider.getValue())));
					displayPrice.setText("Price: " + String.format("%.2f", newPrice) + "$");
				}
				spotComboBox.setStyle(null);
			}
		});
		yearComboBox.valueProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				yearComboBox.setStyle(null);
			}
		});

		// Error Handling
		finalRegister.setOnAction(e -> {
			boolean errorsExist = false, makeError = false, vinError = false, spotError = false, yearError = false,
					timeError = false, typeError = false;
			String newMake = "";
			String newVin = "";
			String spotData = "";
			String newYear = "";
			Double timeData = 0.00;
			String vehicleType = "";
			//Vehicle myCar = new Car();
			if (!makeField.getText().isEmpty()) {
				newMake = makeField.getText();
				makeError = false;
			} else {
				makeField.setStyle("-fx-background-color: red;");
				makeError = true;
			}
			if (!vinField.getText().isEmpty()) {
				newVin = vinField.getText();
				vinError = false;
			} else {
				vinField.setStyle("-fx-background-color: red;");
				vinError = true;
			}
			if ((yearComboBox.getValue() != null) & (!yearComboBox.getValue().equals(""))
					& (!yearComboBox.getValue().equals("Click to choose"))) {
				newYear = yearComboBox.getValue();
				yearError = false;
			} else {
				yearComboBox.setStyle("-fx-background-color: red;");
				yearError = true;
			}
			if (spotComboBox.getValue() != null & !spotComboBox.getValue().equals("")
					& !spotComboBox.getValue().equals("Click to choose")) {
				spotData = spotComboBox.getValue();
				spotError = false;
			} else {
				spotComboBox.setStyle("-fx-background-color: red;");
				spotError = true;
			}
			if (timeSlider.getValue() == 0.00d) {
				timeSlider.setStyle("-fx-background-color: red;");
				timeError = true;
			} else {
				timeData = timeSlider.getValue();
			}
			if (typeComboBox.getValue() != null & !typeComboBox.getValue().equals("")
					& !typeComboBox.getValue().equals("Click to choose")) {
				typeError = false;
				vehicleType = typeComboBox.getValue();
			}
			if (makeError | vinError | spotError | yearError | timeError) {
				errorsExist = true;
			}
			if (!makeError & !vinError & !spotError & !yearError & !timeError) {
				errorsExist = false;
			}
			if (!errorsExist) {
				if (vehicleType.equals("Car")) {
					Vehicle myCar = new Car();
				}
				Vehicle myCar = new Car();
				myCar.setMake(newMake);
				myCar.setVinNumber(newVin);
				myCar.setYear(Integer.parseInt(newYear));
				lot.parkVehicle(myCar, (int) (Math.round(timeData * 60)), Integer.parseInt(spotData));
				primaryStage.setScene(sceneMain);
				System.out.println("Car made: "+myCar);
			}
		});

		exit.setOnAction(e -> {
			Platform.exit();
		});

		// Scene Setup
		primaryStage.setScene(sceneMain);
		primaryStage.setTitle("Parking Garage V1.0.0.0");
		primaryStage.show();

	}

}
