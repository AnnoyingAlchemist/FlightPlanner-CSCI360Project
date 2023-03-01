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
	
	public void addRefuelStop(double stop) {
		//append a stop to the FlightPlan object's refuelStops array.
	//this.refuelStops.add(stop);
	}
	
	//Actual Methods that do stuff
	public void planFlight(Airplane plane, Airport airport1, Airport airport2) {
		//Plans a flight from start to destination, using calculateDistance() and refueling stops.
		//Step 1: calculate distance from both airports using latitude and longitude.
		//Step 2: calculate how far the given Airplane object can fly, using its airspeed and fuel efficiency.
		//step 3: Compare the distance in step 2 to step 1. 
			//Case 1: The airplane can make the trip. Skip to step 4.
			//Case 2: The airplane cannot make the trip. 
				//Step 3a: create a refuel stop at the farthest point the airplane can reach, and add it to an array. 
				//Next, repeat step 2, but use the location of the newly created refuel stop as the starting point. 
				//Repeat until the plane can reach its destination
				//This process should be done recursively.
		//Step 4: Display the results of the flight, and all of the refuel stops created.
	}
	
	public double calculateDistance(Airport airport1, Airport airport2){
		//Calculates distance from two airports by comparing their latitude and longitude attributes
		//When being used in calculations, latitude and longitude should be using their absolute value 
		//returns the calculated distance as a double
	}
	
	public double[] calculateRefuel(Airplane plane, Airport start, Airport end){
		//Calculates refueling stops between the two given Airports 
		//based off of the given Airplane's fuel capacity and fuel efficiency
		//Should return an array of arrays that contains the Latitude & Longitude of each stop in an integer array.
		// e.g (stops[0] and stops[1] makes up ONE location, with the order of the pair being: latitude first and longitude second)
	}
}

//********
//show how to calculate heading using the formula below
//angle = cos^(-1) (y2-y1) / sqrt((x2-x1)^2 + (y2-y1^2))
//acos(double a) is the inverse of cos
//math.acos[(y2-y1)/Math.sqrt((x2-x1)^2 +(y2-y1)^2)]