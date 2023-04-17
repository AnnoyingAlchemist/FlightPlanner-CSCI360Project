package flightPlanner;

import java.util.ArrayList;
import java.util.stream.Collectors;

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
	public static FlightPlan planFlight(Airplane plane, Airport airport1, Airport airport2) {
		ArrayList<Double> coordinates = new ArrayList<>();
		ArrayList<ArrayList<Double>> stops = new ArrayList<>();
		Airport temp = new Airport();
		
		coordinates.add(null);
		coordinates.add(null);
		
		FlightPlan plan = new FlightPlan();
		double heading = findHeading(airport1, airport2);
		double furthestLat = airport1.getLatitude();
		double furthestLong = airport1.getLongitude();
		double slope = (airport2.getLatitude() - airport1.getLatitude())/(airport2.getLongitude() - airport1.getLongitude());
		//Plans a flight from start to destination, using calculateDistance() and refueling stops.
		//Step 1: calculate distance from both airports using latitude and longitude.
		double totalDistance = calculateDistance(airport1, airport2);
		//Step 2: calculate how far the given Airplane object can fly, using its airspeed and fuel efficiency.
		double planeDistance = plane.calculateTravelDistance();
		//step 3: Compare the distance in step 2 to step 1. 
		if(planeDistance >= totalDistance) {
			//Case 1: The airplane can make the trip. Skip to step 4.
			plan.setHeading(heading);
			
		}
		else {
			int count = 0;
			while(planeDistance < calculateDistance(temp, airport2) && count <= 5) {
				count += 1;
				System.out.println("count: " + count);
				//Case 2: The airplane cannot make the trip. 
				//latitude of point = la2 =  asin(sin la1 * cos Ad  + cos la1 * sin Ad * cos theta)
				furthestLat = Math.asin(Math.sin(airport1.getLatitude()) * Math.cos(totalDistance)  + Math.cos(airport1.getLatitude()) * Math.sin(totalDistance) * Math.cos(heading));
				//double furthestLong = airport1.getLongitude() + (Math.atan2(Math.sin(heading) * Math.sin(totalDistance) * Math.cos(airport1.getLatitude()) , ()Math.cos(totalDistance) – Math.sin(airport1.getLatitude()) * Math.sin(airport2.getLatitude())));
				//longitude  of second point = lo2 = lo1 + atan2(sin theta * sin Ad * cos la1 , cos Ad – sin la1 * sin la2)
				furthestLong = (airport1.getLatitude() + airport1.getLongitude())*slope; //easier way of finding it?
				System.out.println("calculate distance: " +calculateDistance(furthestLat, furthestLong, airport2.getLatitude(), airport2.getLongitude()));
					//Step 3a: create a refuel stop at the farthest point the airplane can reach, and add it to an array. 
				coordinates.set(0, furthestLong);
				coordinates.set(1, furthestLat);
				stops.add(coordinates);
				
				temp.setLatitude(furthestLat);
				temp.setLongitude(furthestLong);
				//Next, repeat step 2, but use the location of the newly created refuel stop as the starting point. 
				//Repeat until the plane can reach its destination	
			}
		}
		//Step 4: Display the results of the flight, and all of the refuel stops created.
		plan.setRefuelStops(stops);
		return plan;
	}
	
	public static double calculateDistance(double lat1, double long1, double lat2, double long2){
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

	public void displayInfo() {
		//System.out.println("Starting Airport: "+ getStart());
		//System.out.println("Destination: " + getDestination());
		//System.out.println("Trip Distance: " + getDistance() + " miles");
		//System.out.println("Heading: " + getHeading() + " degrees");
	
		//String refuelString = getRefuelStops().stream().map(Object::toString).collect(Collectors.joining(", "));
		
		//System.out.println("Refuel Stops: " + fuelString);
		System.out.println("Refuel Stops: " + this.getRefuelStops().toString());
	}
	
}

//********
//show how to calculate heading using the formula below
//angle = cos^(-1) (y2-y1) / sqrt((x2-x1)^2 + (y2-y1^2))
//acos(double a) is the inverse of cos
//math.acos[(y2-y1)/Math.sqrt((x2-x1)^2 +(y2-y1)^2)]