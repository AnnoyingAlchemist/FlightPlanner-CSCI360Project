 package flightPlanner;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Airport { //extends Location? maybe?
	private String ICAO;
	private String name;
	private Double latitude; //negative values represent going south, positive values represent going north
	private Double longitude;//negative values represent going west, positive values represent going east
	private ArrayList<Double> frequency;
	private ArrayList<String> radioType;
	private ArrayList<String> fuelType;
	//private Beacon[] beacons;
	private Runway runway;
	
	public Airport(String icao, String name, Double latitude, Double longitude, ArrayList<Double> freq, ArrayList<String> radioType, ArrayList<String> fuelType) {
		this.ICAO = icao;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.frequency = freq;
		this.radioType = radioType;
		this.fuelType = fuelType;
	}
	
	public Airport() {
		ArrayList<String> temp = new ArrayList<>();
		ArrayList<Double> temp2 = new ArrayList<>();
		ArrayList<String> temp3 = new ArrayList<>();
		temp.add("N/A");
		temp.add("N/A");
		temp.add("N/A");
		temp2.add(0.0);
		temp2.add(0.0);
		temp2.add(0.0);
		temp3.add("N/A");
		temp3.add("N/A");
		temp3.add("N/A");
		this.ICAO = "NULL";
		this.name = "N/A";
		this.latitude = 0.0;
		this.longitude = 0.0;
		this.radioType = temp;
		this.frequency = temp2;
		this.fuelType = temp3;
		//runway = null;
	}
	
	/*
	public Beacon[] getBeacons() {
		return beacons;
	}
	
	public void setBeacons(Beacon[] beacon) {
		this.beacons = beacon;
	}
	*/
	public String getICAO() {
		return ICAO;
	}
	
	public void setICAO(String ICAO) {
		//Should only be called with a String length of between 3-4 characters.
		this.ICAO = ICAO;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		//Should only be called with a String value between 1-50 characters
		this.name = name;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		//Should only be called with a Double value between -90 to 90
		this.latitude = latitude;
	}
	
	public ArrayList<Double> getFrequency() {
		return frequency;
	}
	
	public void setFrequency(ArrayList<Double> frequency) {
		//Should only be called with an array that holds double values between 118 to 135.975
		this.frequency = frequency;
	
	}
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		//Should only be called with a Double value between -90 to 90
		this.longitude = longitude;
	}
	
	public ArrayList<String> getRadioType() {
		return radioType;
	}
	
	public void setRadioType(ArrayList<String> radioType) {
		//Should only be called with an array that holds integer values between 0 to 2
		this.radioType = radioType;
	}
	
	public ArrayList<String> getFuelType() {
		return fuelType;
	}
	
	public void setFuelType(ArrayList<String> fuelType) {
		//Should only be called when the array has between 1-3 items, with integer values from 0 to 3.
		this.fuelType = fuelType;
	}

	public Runway getRunway() {
		return runway;
	}

	public void setRunway(Runway runway) {
		this.runway = runway;
	}	
	
	public void displayInfo() {
		System.out.println("ICAO: "+ getICAO());
		System.out.println("Name: " + getName());
		System.out.println("Latitude: " + getLatitude());
		System.out.println("Longitude:" + getLongitude());
		
		String frequencyString = getFrequency().stream().map(Object::toString).collect(Collectors.joining(", "));
		String radioString = getRadioType().stream().map(Object::toString).collect(Collectors.joining(", "));
		String fuelString = getFuelType().stream().map(Object::toString).collect(Collectors.joining(", "));
		
		System.out.println("Frequencies: " + frequencyString);
		System.out.println("Radio Types: " + radioString);
		System.out.println("Compatible Fuel Types: " + fuelString);
		//System.out.println(airport.getBeacons().toString());
		//System.out.println("Runway ID: " + getRunway().getId());
		//System.out.println("Runway Length: " + getRunway().getLength() + " miles");
	}
}
