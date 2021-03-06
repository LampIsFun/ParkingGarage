package structures;

import vehicles.Vehicle;

public class ParkingSpot {

	private int placeNumber;
	private boolean handicapped;
	private boolean empty;
	private Vehicle myVehicle;
	private long myTargetTime;

	public ParkingSpot(int placeNumber, boolean handicapped) {

		this.placeNumber = placeNumber;
		this.handicapped = handicapped;
		this.empty = true;
		this.myVehicle = null;
		this.myTargetTime = 0;
	}

	public int getPlaceNumber() {
		return placeNumber;
	}

	public void park(Vehicle v, int s) {
		if (empty) {
			setVehicle(v, s);
			empty = false;
		}
	}

	public Vehicle getVehicle() {
		return myVehicle;
	}

	private void setVehicle(Vehicle v, int s) {
		myVehicle = v;
		myTargetTime = (s * 1000) + System.currentTimeMillis();
	}

	public boolean isHandicapped() {
		return handicapped;
	}

	// Checks if spot is empty, if it is, return true, if it isn't, check if the
	// time has expired before returning true or false.
	public boolean checkEmpty() {
		if (empty) {
			return true;
		} else {
			if (myTargetTime < System.currentTimeMillis()) {
				setVehicle(null, 0);
				empty = true;
				myTargetTime = 0;
				return true;
			} else {
				return false;
			}
		}
	}
}
