package vehicles;

import java.util.Random;

import tools.ToolBox;

public abstract class Vehicle {

	private String vinNumber;
	private int year;
	private String make;
	private long miles;
	private double cashAmount;
	private double timeSpent;

	public Vehicle() {
		Random numberGenerator = new Random();
		this.year = numberGenerator.nextInt(27) + 1990;
		this.make = ToolBox.choose("Honda","Chevy","Ford","Nissan","GMC","Dodge","Chrysler");
		//This whole block generates the VIN number ( only applies to randomly generated cars )
		StringBuilder str = new StringBuilder("1");
		str.append(make.substring(0,2).toUpperCase());
		str.append(ToolBox.choose("BH2Y3", "BC6LZ","TP4W4","PO032","TA9K2","PA2BV","LO2P3"));
		str.append("XM");
		str.append(ToolBox.choose("A", "B", "C", "D"));
		str.append((numberGenerator.nextInt(900000)+100000));
		//====================================================================================
		this.vinNumber = str.toString();
		this.miles = 0;
		this.cashAmount = 100.00d;
		this.timeSpent = 0.00d;
	}

	public Vehicle(int year, String make, String vin) {
		this.year = year;
		this.make = make;
		this.vinNumber = vin;
		this.miles = 0;
		this.cashAmount = 100.00d;
		this.timeSpent = 0.00d;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
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
