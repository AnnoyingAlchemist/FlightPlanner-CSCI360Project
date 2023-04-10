package flightPlanner;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Created Menus displayed below:\n");
		airportMenu();
		airplaneMenu();
		beaconMenu();
		runwayMenu();
		System.out.println("DISCLAIMER: This is not a real Flight Planning System & it should not be used as such."); //Replace with actual disclamer
		boolean validLogin = false;
		//Ask user for user name and password, and store the answers as variables using a scanner object. 
		//Continues until a valid login is given.
		while(!validLogin) {
			Scanner scan = new Scanner(System.in);  
			System.out.println("Enter username:");
			String userName = scan.nextLine();
			System.out.println("Enter password:");
			String password = scan.nextLine();
			System.out.println("Username is: " + userName);  
			System.out.println("Password is: " + password);  	
			
			if(checkLogin(userName, password)) {
				validLogin = true;
				System.out.println("valid login!");
			}
			else {
				System.out.println("Invalid credentials!\n"
								+ "Please try again.\n");
			}
		}
	    
		boolean exitProgram = false;
		while(!exitProgram) {	
			displayMenu();
			Scanner scan = new Scanner(System.in);  
			System.out.println("Menu option:");
			String menuOption = scan.nextLine();
			
			switch(menuOption){
				case "1":
					System.out.println("Plan a flight!"); //Replace with appropriate method call 
					break;
				case "2":
					airportMenuLoop();
					break;
				case "3":
					airplaneMenuLoop();
					break;
				case "4":
					exitProgram = true;
					System.out.println("bye bye!");
					break;
				default:
					System.out.println("Invalid input! Try again.\n");
					break;
			}
		}
		
		//displayMenu() should run in a while loop that only breaks when the user chooses to exit the program.
		//Call a function corresponding to the option the user picks.
			//Option 4 should close the program and break the while loop
		
			//Airport manager and Airplane manager options will call airportMenu() and airplaneMenu() respectively, 
			//and put the user in an another while loop that only breaks when they choose to go back.
				//In the airport and airplane manager menu, each option should call its corresponding function from the
				//AirportManager and AirplaneManager classes: add(), modify(), delete(), and display().
				//After the chosen option is resolved, call airportMenu() or airplaneMenu() again
		
				//'Back' should call displayMenu() and break the while loop.
		
				//'Beacons and runways' should call beaconrunwayMenu()
					//each option should call a corresponding function from the Beacon or runway class
					//After the chosen option is resolved, call beaconrunwayMenu() again
					//'back' should take the user back to the airport manager menu
		
			//'Plan a flight' will ask the user to enter a plane, starting airport, and destination, and then call 
				//planFlight() from the FlightPlan class using the given answers as parameters for the function
				//any invalid responses will display an error and send the user back to the displayMenu() menu.
	}

	public static boolean checkLogin(String user, String pass) {
		//Iterate through the AdminUsers.txt file and compare the user name and password given to those in the file
		//If they match any user name/password combinations in the file, return true. 
		//If they do not, return false.
		//Should be called upon startup of the program.
		return true;
	}
	
	public static void displayMenu() {
		//Display a text menu full of actions that the user can take
		System.out.println("----------------------------------------------------------");
		System.out.println("1 - Plan a flight\n"
						+ "2 - Airport manager\n"
						+ "3 - Airplane manager\n"
						+ "4 - Exit");
		System.out.println("----------------------------------------------------------\n");
	}
	
	public static void airportMenu() { //should only be called in airportMenuLoop unless you JUST need to display this text for some reason
		//Display a text menu full of actions that the user can take
		System.out.println("----------------------------------------------------------\r\n"
						+ "1 - Create an Airport\r\n"
						+ "2 - Modify an Airport\r\n"
						+ "3 - Delete an Airport\r\n"
						+ "4 - Display all Airports\r\n"
						+ "5 - Beacons\r\n"
						+ "6 - Runways\r\n"
						+ "7 - Back\r\n"
						+ "----------------------------------------------------------\n");
	}
	
	public static void airportMenuLoop() { //For use in the main method
		boolean exitProgram = false;
		while(!exitProgram) {	
			airportMenu();
			Scanner scan = new Scanner(System.in);  
			System.out.println("Menu option:");
			String menuOption = scan.nextLine();
			
			switch(menuOption){
				case "1":
					createAirportLoop(); //System.out.println("Create an Airport"); //replace these print statements with appropriate method calls from Airport Class
					break;
				case "2":
					System.out.println("Modify an Airport");
					break;
				case "3":
					System.out.println("Delete an Airport");
					break;
				case "4":
					System.out.println("Display all Airports");
					break;
				case "5":
					beaconMenuLoop(); //Should lead to a sub-menu. Call beaconMenuLoop()
					break;
				case "6":
					runwayMenuLoop(); //Should lead to a sub-menu. Call runwayMenuLoop()
					break;
				case "7":
					exitProgram = true;
					System.out.println("exiting menu...");
					break;
				default:
					System.out.println("Invalid input! Try again.\n");
					break;
			}
		}
	}
	
	public static void createAirportLoop(){
		//Should be called anytime you would create an airport in a sub menu
		boolean validInput = false;
		System.out.println();
		Scanner scan = new Scanner(System.in); 
		String ICAO = "";
		String name = "";
		double latitude = 0.0;
		double longitude = 0.0;
		ArrayList<Double> frequency = new ArrayList<Double>();;
		ArrayList<String> radioType = new ArrayList<String>();
		ArrayList<String> fuelType = new ArrayList<String>();
		
		//only creates airport object at the end to prevent half-complete objects from being made if user shuts down program halfway through.
		while(!validInput) {
			System.out.println("Enter the ICAO:");
			ICAO = scan.nextLine();
			if(ICAO.length() <5 && ICAO.length() >2) {
				validInput = true;				
			}
			else {
				System.out.println("ICAO must be between 3-4 characters!\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter the name:");
			name = scan.nextLine();
			if(name.length() <50 && name.length() >0) {
				validInput = true;				
			}
			else {
				System.out.println("Name must be between 0-50 characters!\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter the latitude: \n"
					+ "(Negative values represent going South)");
			latitude = scan.nextDouble(); //will likely break with string inputs... maybe try-catch would help here?
			if(latitude <90 && latitude >-90) {
				validInput = true;				
			}
			else {
				System.out.println("Latitude must be between -90 to 90 degrees!\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter the longitude: \n"
					+ "(Negative values represent going West)");
			longitude = scan.nextDouble(); //will likely break with string inputs... maybe try-catch would help here?
			if(longitude <90 && longitude >-90) {
				validInput = true;				
			}
			else {
				System.out.println("Longitude must be between -90 to 90 degrees!\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter the frequency: ");
			frequency.add(scan.nextDouble()); //118 to 135.975
			if(frequency.get(0) <= 135.975 && frequency.get(0) >= 118) {
				validInput = true;				
			}
			else {
				frequency.remove(0);
				System.out.println("Frequency must be between 118 to 135.975 degrees!\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter a radio type: \n");
			radioType.add(0, scan.next()); 
			if(radioType.get(0).equals("bye") || radioType.get(0).equals("hi")) { //need to check data dictionary for parameters later...
				validInput = true;				
			}
			else {
				radioType.remove(0);
				System.out.println("Invalid radio type!\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter a second radio type: \n"
					+ "(Type 'done' to finish)");
			radioType.add(1, scan.next()); 
			if(radioType.get(1).equals("bye") || radioType.get(1).equals("hi")) { //need to check data dictionary for parameters later...
				validInput = true;				
			}
			else if(radioType.get(1).equals("done")) {
				radioType.remove(1);
				radioType.add(1, "N/A");
				validInput = true;
			}
			else {
				radioType.remove(1);
				System.out.println("Invalid radio type!\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter a third radio type: \n"
					+ "(Type 'done' to finish)");
			radioType.add(2, scan.next()); 
			if(radioType.get(2).equals("bye") || radioType.get(2).equals("hi")) { //need to check data dictionary for parameters later...
				validInput = true;				
			}
			else if(radioType.get(2).equals("done")) {
				radioType.remove(2);
				radioType.add(2, "N/A");
				validInput = true;
			}
			else {
				radioType.remove(2);
				System.out.println("Invalid radio type!\n");
			}
		}
validInput = false;
		
		while(!validInput) {
			System.out.println("Enter a fuel type: \n");
			fuelType.add(0, scan.next()); 
			if(fuelType.get(0).equals("bye") || fuelType.get(0).equals("hi")) { //need to check data dictionary for parameters later...
				validInput = true;				
			}
			else {
				fuelType.remove(0);
				System.out.println("Invalid fuel type!\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter a second fuel type: \n"
					+ "(Type 'done' to finish)");
			fuelType.add(1, scan.next()); 
			if(fuelType.get(1).equals("bye") || fuelType.get(1).equals("hi")) { //need to check data dictionary for parameters later...
				validInput = true;				
			}
			else if(fuelType.get(1).equals("done")) {
				fuelType.remove(1);
				fuelType.add(1, "N/A");
				validInput = true;
			}
			else {
				fuelType.remove(1);
				System.out.println("Invalid fuel type!\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter a third fuel type: \n"
					+ "(Type 'done' to finish)");
			fuelType.add(2, scan.next()); 
			if(fuelType.get(2).equals("bye") || fuelType.get(2).equals("hi")) { //need to check data dictionary for parameters later...
				validInput = true;				
			}
			else if(fuelType.get(2).equals("done")) {
				fuelType.remove(2);
				fuelType.add(2, "N/A");
				validInput = true;
			}
			else {
				fuelType.remove(2);
				System.out.println("Invalid fuel type!\n");
			}
		}
		
		Airport airport = new Airport();
		airport.setICAO(ICAO);
		airport.setName(name);
		airport.setLatitude(latitude);
		airport.setLongitude(longitude);
		airport.setFrequency(frequency);
		//airport.setRadioType(radioType);
		//airport.setRadioType(fuelType);
		
		//Airport airport = new Airport(ICAO, name, latitude, longitude, frequency, radioType, fuelType);
		//airport.Add();
		
	}
	
	public static void airplaneMenu() {
		//Display a text menu full of actions that the user can take
		//print the following lines:
		System.out.println("----------------------------------------------------------\r\n"
				+ "1 - Create an Airplane\r\n"
				+ "2 - Modify an Airplane\r\n"
				+ "3 - Delete an Airplane\r\n"
				+ "4 - Display all Airplanes\r\n"
				+ "5 - Back\r\n"
				+ "----------------------------------------------------------\n");
	}
	
	public static void airplaneMenuLoop() { //For use in the main method
		boolean exitProgram = false;
		while(!exitProgram) {	
			airplaneMenu();
			Scanner scan = new Scanner(System.in);  
			System.out.println("Menu option:");
			String menuOption = scan.nextLine();
			
			switch(menuOption){
				case "1":
					System.out.println("Create an Airplane"); //replace these print statements with appropriate method calls from Airplane Class
					break;
				case "2":
					System.out.println("Modify an Airplane");
					break;
				case "3":
					System.out.println("Delete an Airplane");
					break;
				case "4":
					System.out.println("Display all Airplanes");
					break;
				case "5":
					exitProgram = true;
					System.out.println("exiting menu...");
					break;
				default:
					System.out.println("Invalid input! Try again.\n");
					break;
			}
		}
	}
	
	public static void beaconMenu() {
		//Display a text menu full of actions that the user can take. ONLY displays the text, has no functional use.
		System.out.println("----------------------------------------------------------\r\n"
				+ "1 - Add a Beacon to an airport\r\n"
				+ "2 - Modify a Beacon\r\n"
				+ "3 - Delete a Beacon from an airport\r\n"
				+ "4 - Display all Beacons\r\n"
				+ "5 - Back\r\n"
				+ "----------------------------------------------------------\r\n");
	}
	
	public static void beaconMenuLoop() { //For use in the main method
		boolean exitProgram = false;
		while(!exitProgram) {	
			beaconMenu();
			Scanner scan = new Scanner(System.in);  
			System.out.println("Menu option:");
			String menuOption = scan.nextLine();
			
			switch(menuOption){
				case "1":
					System.out.println("Create a Beacon"); //replace these print statements with appropriate method calls from Beacon Class
					break;
				case "2":
					System.out.println("Modify a Beacon");
					break;
				case "3":
					System.out.println("Delete a Beacon");
					break;
				case "4":
					System.out.println("Display all Beacons");
					break;
				case "5":
					exitProgram = true;
					System.out.println("exiting menu...");
					break;
				default:
					System.out.println("Invalid input! Try again.\n");
					break;
			}
		}
	}
	
	public static void runwayMenu() {
		System.out.println("----------------------------------------------------------\r\n"
				+ "1 - Add a Runway to an airport\r\n"
				+ "2 - Modify a Runway\r\n"
				+ "3 - Delete a Runway from an airport\r\n"
				+ "4 - Display all Runways\r\n"
				+ "5 - Back\r\n"
				+ "----------------------------------------------------------\r\n");
	}
	
	public static void runwayMenuLoop() { //For use in the main method
		boolean exitProgram = false;
		while(!exitProgram) {	
			runwayMenu();
			Scanner scan = new Scanner(System.in);  
			System.out.println("Menu option:");
			String menuOption = scan.nextLine();
			
			switch(menuOption){
				case "1":
					System.out.println("Create a Runway"); //replace these print statements with appropriate method calls from Runway Class
					break;
				case "2":
					System.out.println("Modify a Runway");
					break;
				case "3":
					System.out.println("Delete a Runway");
					break;
				case "4":
					System.out.println("Display all Runways");
					break;
				case "5":
					exitProgram = true;
					System.out.println("exiting menu...");
					break;
				default:
					System.out.println("Invalid input! Try again.\n");
					break;
			}
		}
	}
	
}
