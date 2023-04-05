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
		System.out.println("method returned: " + distance);
		System.out.println("calculated distance: " + distance*69 + " miles");
	}

}
