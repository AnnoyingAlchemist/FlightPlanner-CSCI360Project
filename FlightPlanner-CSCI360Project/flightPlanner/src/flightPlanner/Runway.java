package flightPlanner;
import java.io.IOException;

public class Runway {
	private double length; // in miles
	private String id;
	
	public Runway() {
		length = 1.0;
		id = "unknown";
	}
	
	public double getLength() {
		return length;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Runway(double length, String idNum) {
		//int maxLength = 10;
		this.id = idNum;
		
		if((length > 5000) || (length < 0)) {
			this.length = 0;
			System.out.println("Invalid Length. Length has been set to 0.");
		}
		else {
			this.length = length;			
		}
		
	}
	
}
