 package flightPlanner;

import java.util.ArrayList;

public class Airport { //extends Location? maybe?
	private String ICAO;
	private String name;
	private Double latitude; //negative values represent going south, positive values represent going north
	private Double longitude;//negative values represent going west, positive values represent going east
	private ArrayList<Double> frequency;
	private ArrayList<Integer> radioType;
	private ArrayList<Integer> fuelType;
	//private Beacon[] beacons;
	private Runway runway;
	
	public void Airport(String icao, String name, Double latitude, Double longitude, ArrayList<Double> freq, ArrayList<Integer> radioType, ArrayList<Integer> fuelType) {
		this.ICAO = icao;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
		this.frequency = freq;
		this.radioType = radioType;
		this.fuelType = fuelType;
	}
	
	public void Airport() {
		ArrayList<Integer> temp = new ArrayList<>();
		ArrayList<Double> temp2 = new ArrayList<>();
		ArrayList<Integer> temp3 = new ArrayList<>();
		temp.add(0);
		temp2.add(0.0);
		temp3.add(0);
		this.ICAO = "NULL";
		this.name = "N/A";
		this.latitude = 0.0;
		this.longitude = 0.0;
		this.radioType = temp;
		this.frequency = temp2;
		this.fuelType = temp3;
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
	
	public ArrayList<Integer> getRadioType() {
		return radioType;
	}
	
	public void setRadioType(ArrayList<Integer> radioType) {
		//Should only be called with an array that holds integer values between 0 to 2
		this.radioType = radioType;
	}
	
	public ArrayList<Integer> getFuelType() {
		return fuelType;
	}
	
	public void setFuelType(ArrayList<Integer> fuelType) {
		//Should only be called when the array has between 1-3 items, with integer values from 0 to 3.
		this.fuelType = fuelType;
	}

	public Runway getRunway() {
		return runway;
	}

	public void setRunway(Runway runway) {
		this.runway = runway;
	}	
	
	public static void displayInfo(Airport airport) {
		System.out.println(airport.getICAO());
		System.out.println(airport.getName());
		System.out.println(airport.getLatitude());
		System.out.println(airport.getLongitude());
		System.out.println(airport.getFrequency().toString());
		System.out.println(airport.getRadioType().toString());
		System.out.println(airport.getFuelType().toString());
		//System.out.println(airport.getBeacons().toString());
		System.out.println(airport.getRunway());
	}
}
