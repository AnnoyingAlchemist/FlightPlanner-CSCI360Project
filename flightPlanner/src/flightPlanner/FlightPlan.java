package flightPlanner;

public class FlightPlan {
	private Airport start;
	private Airport destination;
	private double distance;
	private double[] refuelStops;
	
	public Airport getStart() {
		return this.start;
	}
	
	public Airport getDestination() {
		return this.destination;
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	public double[] getRefuelStops() {
		return this.refuelStops;
	}
	
	public void setStart(Airport start) {
		this.start = start;
	}
	
	public void setDestination(Airport destination) {
		this.destination = destination;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public void setRefuelStops(double[] stops) {
		this.refuelStops = stops;
	}
	//Actual Methods that do stuff
	public void planFlight(Airport airport1, Airport airport2) {
		//Plans a flight from start to destination, using calculateDistance() and refueling stops.
	}
	
	public int calculateDistance(Airport airport1, Airport airport2){
		//Calculates distance from two airports
		return 0;
	}
}

