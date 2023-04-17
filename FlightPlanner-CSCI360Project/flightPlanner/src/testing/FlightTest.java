package testing;
import flightPlanner.*;
public class FlightTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Airport air1 = new Airport();
		air1.setLatitude(0.0);
		air1.setLongitude(12.0);
		Airport air2 = new Airport();
		air2.setLatitude(0.0);
		air2.setLongitude(6.0);
		
		FlightPlan flightPlan = new FlightPlan();
		double distance = flightPlan.calculateDistance(air1, air2);		
		System.out.println("method returned: " + distance + " miles");
		//System.out.println("calculated distance: " + distance*69 + " miles");
		
		Airplane plane = new Airplane();
		plane.setFuelEfficiency(100.0);
		plane.setFuelCapacity(100.0);
		
		System.out.println("Fuel efficiency: " + plane.getFuelEfficiency() + " liters per hundred miles");
		System.out.println("Fuel capacity: " + plane.getFuelCapacity() + " liters");
		System.out.println("calculate Distance: " + FlightPlan.calculateDistance(air1, air2) + " miles");
		
		System.out.println("Number of Stops needed: " + FlightPlan.findRefuelNumber(plane, air1, air2));
	}

}
