package flightPlanner;

import java.util.ArrayList;

public class FlightPlan {
	private Airport start;
	private Airport destination;
	private double distance;
	private double heading;
	private ArrayList<ArrayList<Double>> refuelStops;
	
	public Airport getStart() {
		return this.start;
	}
	
	public Airport getDestination() {
		return this.destination;
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	public ArrayList<ArrayList<Double>> getRefuelStops() {
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
	
	public double getHeading() {
		return heading;
	}

	public void setHeading(double heading) {
		this.heading = heading;
	}

	public void setRefuelStops(ArrayList<ArrayList<Double>> stops) {
		this.refuelStops = stops;
	}
	
	public void addRefuelStop(ArrayList<Double> stop) {
		//append a stop to the FlightPlan object's refuelStops array.
		this.refuelStops.add(stop);
	}
	
	public static double findHeading(double long1, double long2, double lat1, double lat2 ) {
		//returns the heading in degrees 
		double theta = Math.acos((lat2 - lat1) / Math.sqrt(Math.pow(long2-long1, 2) + Math.pow(lat2-lat1, 2)));
		double thetaDegree = theta * 180 / Math.PI;
		//System.out.println("The value of theta is: " + thetaDegree);
		
		return thetaDegree;
	}
	
	public static double findHeading(Airport air1, Airport air2) {
		//returns the heading in degrees 
		double lat1 = air1.getLatitude();
		double long1 = air1.getLongitude();
		double lat2 = air2.getLatitude();
		double long2 = air2.getLongitude();
		
		double theta = Math.acos((lat2 - lat1) / Math.sqrt(Math.pow(long2-long1, 2) + Math.pow(lat2-lat1, 2)));
		double thetaDegree = theta * 180 / Math.PI;
		//System.out.println("The value of theta is: " + thetaDegree);
		
		return thetaDegree;
	}
	
	//Actual Methods that do stuff
	public FlightPlan planFlight(Airplane plane, Airport airport1, Airport airport2) {
		double flightDistance;
		FlightPlan plan = new FlightPlan();
		//Plans a flight from start to destination, using calculateDistance() and refueling stops.
		//Step 1: calculate distance from both airports using latitude and longitude.
		double totalDistance = calculateDistance(airport1, airport2);
		//Step 2: calculate how far the given Airplane object can fly, using its airspeed and fuel efficiency.
		double planeDistance = plane.calculateTravelDistance();
		//step 3: Compare the distance in step 2 to step 1. 
		if(planeDistance >= totalDistance) {
			//Case 1: The airplane can make the trip. Skip to step 4.
			
		}
		else {
			//Case 2: The airplane cannot make the trip. 
				//Step 3a: create a refuel stop at the farthest point the airplane can reach, and add it to an array. 
				//Next, repeat step 2, but use the location of the newly created refuel stop as the starting point. 
				//Repeat until the plane can reach its destination
				//This process should be done recursively.	
		}
		//Step 4: Display the results of the flight, and all of the refuel stops created.
		return plan;
	}
	
	public double calculateDistance(double lat1, double long1, double lat2, double long2){
		//Calculates distance from two pairs of latitude & longitude coordinates
		double distance = Math.sqrt(Math.pow((lat2-lat1), 2)+Math.pow((long2-long1), 2));
		//sqrt[(x2-x1)^2+(y2-y1)^2] = distance between two coordinates
		//returns the calculated distance as a double
		return distance * 69;
	}
	
	public static double calculateDistance(Airport airport1, Airport airport2){
		//Calculates distance from two airports by comparing their latitude and longitude attributes
		double latitude1 = airport1.getLatitude();
		double longitude1 = airport1.getLongitude();
		double latitude2 = airport2.getLatitude();
		double longitude2 = airport2.getLongitude();
		double distance = Math.sqrt(Math.pow((latitude2-latitude1), 2)+Math.pow((longitude2-longitude1), 2));
		//sqrt[(x2-x1)^2+(y2-y1)^2] = distance between two coordinates
		//returns the calculated distance as a double
		//Each degree of longitude is approximately 69 miles, though in real life it varies a bit between different point on the earth.
		return distance * 69;
	}
	
	public ArrayList<ArrayList<Double>> findRefuelStops(Airplane plane, Airport start, Airport end){
		int numStops = 0;
		
		//temp.setLatitude(start.getLatitude());
		//temp.setLongitude(start.getLongitude());
		
		if(calculateDistance(start, end) <= plane.calculateTravelDistance()) {
			numStops = 1;
		}
		else {
			Airport newStart = new Airport();
			
			double slope = (end.getLatitude() - start.getLatitude())/(end.getLongitude() - start.getLongitude());
			double newLat = start.getLatitude() + (start.getLongitude()*slope);
			double newLong = start.getLatitude() + (start.getLongitude()*slope);
			
			newStart.setLatitude(newLat);
			newStart.setLongitude(newLong);
			
			numStops += findRefuelNumber(plane, newStart, end);	
		}
		System.out.println("current stops needed: " + numStops);
		//Calculates refueling stops between the two given Airports 
		//based off of the given Airplane's fuel capacity and fuel efficiency
		//Should return an array of arrays that contains the Latitude & Longitude of each stop in an integer array. //or maybe just on array, refuelStops[]?
		// e.g (stops[0] and stops[1] makes up ONE location, with the order of the pair being: latitude first and longitude second)
		ArrayList<Double> stop;
		ArrayList<ArrayList<Double>> array = null;
		return array;
	}

	
	public static int findRefuelNumber(Airplane plane, Airport start, Airport end){
		int numStops = 0;
		if(calculateDistance(start, end) <= plane.calculateTravelDistance()) {
			numStops = 0;
		}
		else {
			//System.out.println("Before Rounding: " + calculateDistance(start, end)/plane.calculateTravelDistance());
			numStops = (int) Math.floor(calculateDistance(start, end)/plane.calculateTravelDistance());
		}
		return numStops;			
	}

}

//********
//show how to calculate heading using the formula below
//angle = cos^(-1) (y2-y1) / sqrt((x2-x1)^2 + (y2-y1^2))
//acos(double a) is the inverse of cos
//math.acos[(y2-y1)/Math.sqrt((x2-x1)^2 +(y2-y1)^2)]