package vehicles;

import java.util.Random;

import tools.ToolBox;

public abstract class Vehicle {
	
	public static long nextVin = 0;

	private long vinNumber;
	private int year;
	private String make;
	private long miles;
	private double cashAmount;
	private double timeSpent;
	
	public Vehicle() {
		Random numberGenerator = new Random();
		this.year = numberGenerator.nextInt(27) + 1990;
		this.make = ToolBox.choose("Honda","Chevy","Ford","Nissan","GMC","Dodge","Chrysler");
		
		this.vinNumber = nextVin++;
		this.miles = 0;
		this.cashAmount = 100.00d;
		this.timeSpent = 0.00d;
	}

	public static long getNextVin() {
		return nextVin;
	}

	public static void setNextVin(long nextVin) {
		Vehicle.nextVin = nextVin;
	}

	public long getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(long vinNumber) {
		this.vinNumber = vinNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public long getMiles() {
		return miles;
	}

	public void setMiles(long miles) {
		this.miles = miles;
	}

	public double getCashAmount() {
		return cashAmount;
	}

	public void setCashAmount(double cashAmount) {
		this.cashAmount = cashAmount;
	}

	public double getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(double timeSpent) {
		this.timeSpent = timeSpent;
	}
	
	
}
