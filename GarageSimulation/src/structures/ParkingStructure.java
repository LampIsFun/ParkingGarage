package structures;

import vehicles.Vehicle;

public class ParkingStructure {

	private int maxSpots;
	private ParkingSpot[] places;
	private boolean isFull;
	private int vehicleCount;

	//Constructor\\
	public ParkingStructure(int maxSpots) {
		this.maxSpots = maxSpots;
		this.places = new ParkingSpot[maxSpots];
		for(int i = 0; i < maxSpots; i++) {
			places[i] = new ParkingSpot(i,false);
		}
		this.isFull = false;
		this.vehicleCount = 0;
	}
	//Returns amount of unused spots.
	public int getOpenSpots() {
		int count = 0;
		for (int i = 0; i < maxSpots; i++) {
				if (places[i].checkEmpty()) {
					
					count++;
					//System.out.println(count);
				}
		}
		return count;
	}
	//Returns amount of parked cars.
	public int getParkedCars() {
		return (maxSpots - getOpenSpots());
	}
	//Parks a vehicle(v) into spot(spot) for seconds(s).
	public void parkVehicle(Vehicle v, int s, int spot) {
		places[spot].park(v,s);
		
	}
	//Returns max Spots.
	public int getMaxSpots() {
		return maxSpots;
	}
	//Returns the array of parking spots.
	public ParkingSpot[] getPlaces() {
		return places;
	}

	public void setPlaces(ParkingSpot[] places) {
		this.places = places;
	}

	public boolean isFull() {
		return isFull;
	}

	public void setFull(boolean isFull) {
		this.isFull = isFull;
	}

	public int getVehicleCount() {
		return vehicleCount;
	}

	public void setVehicleCount(int vehicleCount) {
		this.vehicleCount = vehicleCount;
	}
	
	public void purgeSpots() {
		for(int i = 0; i < maxSpots; i++) {
			places[i].checkEmpty();
		}
	}

}
