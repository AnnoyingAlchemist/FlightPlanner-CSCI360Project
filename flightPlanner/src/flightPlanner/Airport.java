package flightPlanner;


public class Airport {
	private String ICAO;
	private String name;
	private Double latitude;
	private Double longitude;
	private double[] frequency;
	private int[] radioType;
	private int[] fuelType;
	
	public String getICAO() {
		return ICAO;
	}
	
	public void setICAO(String iCAO) {
		ICAO = iCAO;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	public double[] getFrequency() {
		return frequency;
	}
	
	public void setFrequency(double[] frequency) {
		this.frequency = frequency;
	
	}
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public int[] getRadioType() {
		return radioType;
	}
	
	public void setRadioType(int[] radioType) {
		this.radioType = radioType;
	}
	
	public int[] getFuelType() {
		return fuelType;
	}
	
	public void setFuelType(int[] fuelType) {
		this.fuelType = fuelType;
	}	
}
