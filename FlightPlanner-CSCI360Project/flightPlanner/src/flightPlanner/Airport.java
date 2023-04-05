 package flightPlanner;

public class Airport { //extends Location? maybe?
	private String ICAO;
	private String name;
	private Double latitude; //negative values represent going south, positive values represent going north
	private Double longitude;//negative values represent going west, positive values represent going east
	private double[] frequency;
	private int[] radioType;
	private int[] fuelType;
	private Beacon[] beacons;
	private Runway runway;
	
	
	public Beacon[] getBeacons() {
		return beacons;
	}
	
	public void setBeacons(Beacon[] beacon) {
		this.beacons = beacon;
	}
	
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
		//Should only be called with a Double value between -180 to 180
		this.latitude = latitude;
	}
	
	public double[] getFrequency() {
		return frequency;
	}
	
	public void setFrequency(double[] frequency) {
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
	
	public int[] getRadioType() {
		return radioType;
	}
	
	public void setRadioType(int[] radioType) {
		//Should only be called with an array that holds integer values between 0 to 2
		this.radioType = radioType;
	}
	
	public int[] getFuelType() {
		return fuelType;
	}
	
	public void setFuelType(int[] fuelType) {
		//Should only be called when the array has between 1-3 items, with integer values from 0 to 3.
		this.fuelType = fuelType;
	}

	public Runway getRunway() {
		return runway;
	}

	public void setRunway(Runway runway) {
		this.runway = runway;
	}	
	
	public void displayInfo(Airport airport) {
		System.out.println(airport.getICAO());
		System.out.println(airport.getName());
		System.out.println(airport.getLatitude());
		System.out.println(airport.getLongitude());
		System.out.println(airport.getFrequency().toString());
		System.out.println(airport.getRadioType().toString());
		System.out.println(airport.getFuelType().toString());
		System.out.println(airport.getBeacons().toString());
		System.out.println(airport.getRunway());
	}
}
