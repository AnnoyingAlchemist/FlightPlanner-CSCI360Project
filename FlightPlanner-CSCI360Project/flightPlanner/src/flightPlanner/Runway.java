package flightPlanner;

import java.io.IOException;

public class Runway {
	private double length; // in meters
	private String id;
	
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
	
	 // Methods for storing runway information
	 
	public static void Add() throws IOException {
		
	}
	public static void Modify() throws IOException{
		
	}
	public static void Delete() throws IOException{
		
	}
	public static void Search() throws IOException{
		
		
	}
	public static void Display() throws IOException{
		
	}
}
