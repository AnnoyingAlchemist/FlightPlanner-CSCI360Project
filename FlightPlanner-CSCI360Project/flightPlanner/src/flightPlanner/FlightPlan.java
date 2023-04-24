package flightPlanner;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FlightPlan {
	private Airport start;
	private Airport destination;
	private Airplane plane;
	private double distance;
	private double heading;
	private ArrayList<ArrayList<Double>> refuelStops;
	
	public Airport getStart() {
		return this.start;
	}
	
	public Airport getDestination() {
		return this.destination;
	}
	
	public Airplane getPlane() {
		return plane;
	}

	public void setPlane(Airplane plane) {
		this.plane = plane;
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
		//treat latitude as 'Y' value and longitude as 'X' value
		//returns the heading in degrees 
		double theta = Math.acos((lat2 - lat1) / Math.sqrt(Math.pow(long2-long1, 2) + Math.pow(lat2-lat1, 2)));
		double thetaDegree = theta * 180 / Math.PI;
		if(long1 > long2) {
			return 360 - thetaDegree;
		}
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
		if(long1 > long2) {
			return 360 - thetaDegree;
		}
		
		return thetaDegree;
	}
	
	public static double findTravelTime(double lat1, double long1, double lat2, double long2, Airplane plane) {
		return calculateDistance(lat1, long1, lat2, long2)/plane.getAirspeed();
	}
	
	public static FlightPlan planFlight(Airplane plane, Airport airport1, Airport airport2) {
		ArrayList<Double> coordinates = new ArrayList<>();
		ArrayList<ArrayList<Double>> stops = new ArrayList<>();
		Airport temp = new Airport();
		temp.setLatitude(airport1.getLatitude());
		temp.setLongitude(airport1.getLongitude());
		coordinates.add(airport1.getLongitude());
		coordinates.add(airport1.getLatitude());
		stops.add(coordinates);
		//stops.add(null);
		
		FlightPlan plan = new FlightPlan();
		plan.setRefuelStops(stops);
		plan.setStart(airport1);
		plan.setDestination(airport2);
		
		double heading = findHeading(airport1, airport2);
		plan.setHeading(heading);
		
		double furthestLat = airport1.getLatitude();
		double furthestLong = airport1.getLongitude();
		double slope = (airport2.getLatitude() - airport1.getLatitude())/(airport2.getLongitude() - airport1.getLongitude());
		//Plans a flight from start to destination, using calculateDistance() and refueling stops.
		//Step 1: calculate distance from both airports using latitude and longitude.
		double totalDistance = calculateDistance(airport1, airport2);
		//Step 2: calculate how far the given Airplane object can fly, using its airspeed and fuel efficiency.
		double planeDistance = plane.calculateTravelDistance();
		double distanceTravelled = 0;
		
		//step 3: Compare the distance in step 2 to step 1. 
		if(planeDistance >= totalDistance) {
			//Case 1: The airplane can make the trip. Skip to step 4.
			System.out.println("No stops needed!");
			plan.setDistance(calculateDistance(airport1, airport2));
		}
		else {
			int count = 0;
			//planeDistance < calculateDistance(temp, airport2) && count <= 5
			boolean notThere = true;
			
			while(notThere) {
				count += 1;
				//System.out.println("count: " + count);
				//Case 2: The airplane cannot make the trip. 
				//latitude of point = la2 =  asin(sin la1 * cos Ad  + cos la1 * sin Ad * cos theta)
				furthestLat = Math.asin(Math.sin(temp.getLatitude()) * Math.cos(planeDistance)  + Math.cos(temp.getLatitude()) * Math.sin(planeDistance) * Math.cos(heading));
				furthestLong = temp.getLongitude() + (Math.atan2(Math.sin(heading) * Math.sin(planeDistance) * Math.cos(temp.getLatitude()) , Math.cos(planeDistance) - Math.sin(temp.getLatitude()) * Math.sin(airport2.getLatitude())));
				//longitude  of second point = lo2 = lo1 + atan2(sin theta * sin Ad * cos la1 , cos Ad � sin la1 * sin la2)
				System.out.println("Leg #" + (count + 1));
				System.out.println("Flight time: " + findTravelTime(temp.getLatitude(), temp.getLongitude(), furthestLat, furthestLong, plane) + " hours");
				System.out.println("Furthest Latitude: " + furthestLat);
				System.out.println("calculate distance: " + calculateDistance(furthestLat, furthestLong, airport2.getLatitude(), airport2.getLongitude()));
				System.out.println("Travel time for this leg: " + calculateDistance(furthestLat, furthestLong, airport2.getLatitude(), airport2.getLongitude()));
				//System.out.println("airport long used in calculation: " + temp.getLongitude());
				//System.out.println("airport lat used in calculation: " + temp.getLatitude() + "\n");
				distanceTravelled += calculateDistance(furthestLat, furthestLong, airport2.getLatitude(), airport2.getLongitude());
					//Step 3a: create a refuel stop at the farthest point the airplane can reach, and add it to an array. 
				coordinates.set(0, furthestLong);
				//System.out.println("coordinates.set(0) is: " + coordinates.get(0));
				
				coordinates.set(1, furthestLat);
				//System.out.println("coordinates.set(1) is: " + coordinates.get(1));
				
				System.out.println("coordinates are: " + coordinates.toString());
								
				stops.add(coordinates);
				//System.out.println("stops are: " + stops.toString());
				
				plan.addRefuelStop(coordinates);
				
				System.out.println();
				
				temp.setLatitude(furthestLat);
				temp.setLongitude(furthestLong);
				
				if(planeDistance >= calculateDistance(temp, airport2)) {
					notThere = false;
					plan.setDistance(distanceTravelled);
				}
				
				else if(count >= 20) {
					plan.setDistance(distanceTravelled);
					break;
				}
				
				//Next, repeat step 2, but use the location of the newly created refuel stop as the starting point. 
				//Repeat until the plane can reach its destination	
			}
			if(notThere) {				
				System.out.println("Destination requires too many fuel stops! (over 20). Flight Cancelled.");
			}
			else {				
				System.out.println("number of refuel stops needed: " + count);
			}
		}
		//Step 4: Display the results of the flight, and all of the refuel stops created.
		//System.out.println("stops after exiting loop are: " + coordinates.toString());
		
		//plan.setRefuelStops(stops);
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
	
	/*
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
		//Should return an array of arrays that contains the Latitude & Longitude of each stop in an integer array. 
		// e.g (stops[0] and stops[1] makes up ONE location, with the order of the pair being: latitude first and longitude second)
		ArrayList<Double> stop;
		ArrayList<ArrayList<Double>> array = null;
		return array;
	}
	 */
	
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
		System.out.println("Starting Airport ICAO: "+ getStart().getICAO());
		System.out.println("Destination ICAO: " + getDestination().getICAO());
		System.out.println("Trip Distance: " + getDistance() + " miles");
		System.out.println("Heading: " + getHeading() + " degrees");
		System.out.println("Refuel Stops: " + this.getRefuelStops().toString());
	}
	
}

//********
//show how to calculate heading using the formula below
//angle = cos^(-1) (y2-y1) / sqrt((x2-x1)^2 + (y2-y1^2))
//acos(double a) is the inverse of cos
//math.acos[(y2-y1)/Math.sqrt((x2-x1)^2 +(y2-y1)^2)]