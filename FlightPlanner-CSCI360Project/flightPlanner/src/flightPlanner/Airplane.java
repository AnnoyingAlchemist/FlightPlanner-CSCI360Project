package flightPlanner;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Airplane {
	private String make;
	private String model;
	private Double fuelEfficiency; //in liters per hundred miles
	private Double fuelCapacity; //in liters
	private ArrayList<String> fuelType; // | 0 = jet A | 1 = Jet A1 | 2 = Jet B | 3 = ABGAS |
	private Double airspeed; //in miles per hour
	
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		//Should only be called when make is between 1-15 characters
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		//Should only be called when model is between 1-15 characters
		this.model = model;
	}
	public Double getFuelEfficiency() {
		return fuelEfficiency;
	}
	public void setFuelEfficiency(Double fuelEfficiency) {
		//Should only be called when fuelEfficiency is less than 1,000 
		this.fuelEfficiency = fuelEfficiency;
	}
	public Double getFuelCapacity() {
		return fuelCapacity;
	}
	public void setFuelCapacity(Double fuelCapacity) {
		//Should only be called with a parameter value of less than 100,000.
		this.fuelCapacity = fuelCapacity;
	}
	public ArrayList<String> getFuelType() {
		return fuelType;
	}
	public void setFuelType(ArrayList<String> fuelType) {
		//Should only be called when the array has between 1-3 items, with string values of "jet A", "Jet A1", "Jet B", or "ABGAS".
		this.fuelType = fuelType;
	}
	public Double getAirspeed() {
		return airspeed;
	}
	public void setAirspeed(Double airspeed) {
		this.airspeed = airspeed;
	}
	
	public double calculateTravelDistance() { //returns units in miles, and assumes plane is filled to capacity.
		return (this.getFuelCapacity()/this.getFuelEfficiency())*100;
	}
	
	public void displayInfo() {
		System.out.println("Make: "+ getMake());
		System.out.println("Model: " + getModel());
		System.out.println("Fuel Efficiency: " + getFuelEfficiency() + " liters per hundred miles");
		System.out.println("Fuel Capacity:" + getFuelCapacity() + " liters");
		
		String fuelString = getFuelType().stream().map(Object::toString).collect(Collectors.joining(", "));
		
		System.out.println("Compatible Fuel Types: " + fuelString);
		System.out.println("Cruising Airspeed: " + getAirspeed() + " miles per hour");
	}
}
