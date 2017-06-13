package structures;

public class ParkingSpot {

	private int placeNumber;
	private boolean handicapped;
	
	
	public ParkingSpot(int placeNumber, boolean handicapped) {
		super();
		
		this.placeNumber = placeNumber;
		this.handicapped = handicapped;
	}


	public int getPlaceNumber() {
		return placeNumber;
	}


	public boolean isHandicapped() {
		return handicapped;
	}
	
	
}
