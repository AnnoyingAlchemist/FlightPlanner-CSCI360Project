package flightPlanner;

public class Beacon {
	private String ICAO;
	private String name;
	private double latitude;
	private double longitude;
	private int[] type; //holds Integers that can range from 0 to 3. 
						//0 represents VOR, 1 represents VORTAC, 2 represents NDB, 3 represents Loran.

	
	public String getICAO() {
		return ICAO;
	}
	public void setICAO(String iCAO) {
		//Should not be called with an iCAO that is not between 3-4 characters long
		ICAO = iCAO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		//Should not be called with an name that is not between 1-50 characters long
		this.name = name;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		//Should only be called with a Double value between -90 to 90
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		//Should only be called with a Double value between -180 to 180
		this.longitude = longitude;
	}
	public int[] getType() {
		return type;
	}
	public void setType(int[] type) {
		this.type = type;
	}
	public static void add() throws IOException {
		//Allows user to create a beacon and fill out attributes.
		//Information will be saved to airport.txt file.
		//Information is inputed by user using scanner,
	}
	public static void modify() throws IOException{
		//Will locate beacon and allow user to change information.
		//New information will be appended to list and old work will be deleted.
	}
	public static void delete() throws IOException{
		//Information will be searched and once found deleted from file.
	}
	public static void search() throws IOException{
		//If the beacon exists information will be displayed
		// If not message will be displayed to user.
		
	}
	public static void display() throws IOException{
		//Will display list of all beacons
	}

}
