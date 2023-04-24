package flightPlanner;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
		System.out.println("Created Menus displayed below:\n");
		airportMenu();
		airplaneMenu();
		beaconMenu();
		runwayMenu();
		*/
		System.out.println("THIS SOFTWARE IS NOT TO BE USED FOR FLIGHT PLANNING OR NAVIGATIONAL PURPOSES"); //Replace with actual disclamer
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
				System.out.println("\nInvalid credentials!\n"
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
					System.out.println("Shutting down...");
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
		if(user.toLowerCase().equals("brandon") && pass.toLowerCase().equals("admin")) {
			return true;
		}
		else {
			return false;
		}
		//Iterate through the AdminUsers.txt file and compare the user name and password given to those in the file
		//If they match any user name/password combinations in the file, return true. 
		//If they do not, return false.
		//Should be called upon startup of the program.
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
						+ "5 - Runways\r\n"
						+ "6 - Back\r\n"
						+ "----------------------------------------------------------\n");
	}
	
	public static void airportMenuLoop() { //For use in the main method when user chooses a menu option related to airports
		boolean exitProgram = false;
		while(!exitProgram) {	
			airportMenu();
			Scanner scan = new Scanner(System.in);  
			System.out.println("Menu option:");
			String menuOption = scan.nextLine();
			
			switch(menuOption){
			//replace these print statements with appropriate method calls from Airport/AirportManager Class
				case "1": //create an airport
					createAirportLoop(); //System.out.println("Create an Airport"); 
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
					/*
				case "5":
					beaconMenuLoop(); //Should lead to a sub-menu. Call beaconMenuLoop()
					break;
					*/
				case "5":
					runwayMenuLoop(); //Should lead to a sub-menu. Call runwayMenuLoop()
					break;
				case "6":
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
		//Should be called anytime you would ask for user input to create an airport.
		boolean validInput = false;
		System.out.println();
		Scanner scan = new Scanner(System.in); 
		String ICAO = "";
		String name = "";
		double latitude = 0.0;
		double longitude = 0.0;
		ArrayList<Double> frequency = new ArrayList<>();
		ArrayList<String> radioType = new ArrayList<>();
		ArrayList<String> fuelType = new ArrayList<>();
		
		Airport airport = new Airport();
		
		while(!validInput) {
			System.out.println("Enter the ICAO:");
			ICAO = scan.nextLine();
			if(ICAO.length() <5 && ICAO.length() >2) {
				validInput = true;	
				airport.setICAO(ICAO);
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
				airport.setName(name);
			}
			else {
				System.out.println("Name must be between 0-50 characters!\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			latitude = 912;
			Scanner dubScan = new Scanner(System.in);
			System.out.println("Enter the latitude: \n"
					+ "(Negative values represent going South)");
			if(dubScan.hasNextDouble()) {
				latitude = dubScan.nextDouble(); 		
				if(latitude <=90 && latitude >=-90) {
					validInput = true;
					airport.setLatitude(latitude);
				}
				else {
					System.out.println("Latitude must be between -90 to 90 degrees!\n");
				}
			}
			else {
				System.out.println("latitude must be a number!\n");
			}
			
		}
		
		validInput = false;
		
		while(!validInput) {
			longitude = 912;
			Scanner dubScan = new Scanner(System.in);
			System.out.println("Enter the longitude: \n"
					+ "(Negative values represent going West)");
			if(dubScan.hasNextDouble()) {
				longitude = dubScan.nextDouble(); 				
				if(longitude <=90 && longitude >=-90) {
					validInput = true;
					airport.setLongitude(longitude);
				}
				else {
					System.out.println("longitude must be between -90 to 90 degrees!\n");
				}
			}
			else {
				System.out.println("longitude must be a number!\n");
			}
			
		}
		
		validInput = false;
		
		while(!validInput) {
			double temp = 912.0;
			Scanner dubScan = new Scanner(System.in);
			System.out.println("Enter a frequency (from 118 to 135.975): ");
			if(dubScan.hasNextDouble()) {
				frequency.add(dubScan.nextDouble()); 				
				if(frequency.get(0) <= 135.975 && frequency.get(0) >= 118) {
					validInput = true;
					airport.setFrequency(frequency);
				}
				else {
					frequency.remove(0);
					System.out.println("Frequency must be between 118 to 135.975 degrees!\n");
				}
			}
			else {
				System.out.println("Frequency must be a number!\n");
			}
			
		}
		
		/*
		while(!validInput) {
			Scanner dubScan = new Scanner(System.in);
			System.out.println("Enter the frequency: ");
			if(dubScan.hasNextDouble()) {
				frequency.add(scan.nextDouble()); //118 to 135.975
				if(frequency.get(0) <= 135.975 && frequency.get(0) >= 118) {
					validInput = true;		
					airport.setFrequency(frequency);
				}
				else {
					frequency.remove(0);
					System.out.println("Frequency must be between 118 to 135.975 degrees!\n");
				}
			}
			else {
				System.out.println("frequency must be a number!\n");
			}
		}
		*/
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter a radio type: \n"
					+ "| VHF | UHF | SHF |");
			radioType.add(0, scan.next().toUpperCase()); 
			if(radioType.get(0).equals("VHF") || radioType.get(0).equals("SHF") || radioType.get(0).equals("UHF")) { 
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
					+ "(Type 'done' to skip)");
			radioType.add(1, scan.next().toUpperCase()); 
			if(radioType.get(1).equals("VHF") || radioType.get(1).equals("SHF") || radioType.get(1).equals("UHF")) { 
				validInput = true;				
			}
			else if(radioType.get(1).equals("DONE")) {
				radioType.set(1, "N/A");
				validInput = true;
			}
			else {
				radioType.remove(1);
				System.out.println("Invalid radio type!\n"
						+ "| VHF | UHF | SHF |\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter a third radio type: \n"
					+ "(Type 'done' to skip)");
			radioType.add(2, scan.next().toUpperCase()); 
			if(radioType.get(2).equals("VHF") || radioType.get(2).equals("SHF") || radioType.get(2).equals("UHF")) { 
				validInput = true;				
			}
			else if(radioType.get(2).equals("DONE")) {
				radioType.set(2, "N/A");
				validInput = true;
			}
			else {
				radioType.remove(2);
				System.out.println("Invalid radio type!\n"
						+ "| VHF | UHF | SHF |\n");
			}
		}
		airport.setRadioType(radioType);
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter a fuel type: \n"
					+"| JetA | JetA1 | JetB | AVGAS |");
			fuelType.add(0, scan.next().toUpperCase()); 
			if(fuelType.get(0).equals("JETA") || fuelType.get(0).equals("JETA1") || fuelType.get(0).equals("JETB") || fuelType.get(0).equals("AVGAS")) { 
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
					+ "(Type 'done' to skip)");
			fuelType.add(1, scan.next().toUpperCase().strip()); 
			if(fuelType.get(1).equals("JETA") || fuelType.get(1).equals("JETA1") || fuelType.get(1).equals("JETB") || fuelType.get(1).equals("AVGAS")) { 
				validInput = true;				
			}
			else if(fuelType.get(1).equals("DONE")) {
				fuelType.set(1, "N/A");
				validInput = true;
			}
			else {
				fuelType.remove(1);
				System.out.println("Invalid fuel type!\n"
						+"| JetA | JetA1 | JetB | AVGAS |\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter a third fuel type: \n"
					+ "(Type 'done' to skip)");
			fuelType.add(2, scan.next().toUpperCase()); 
			if(fuelType.get(2).equals("JETA") || fuelType.get(2).equals("JETA1") || fuelType.get(2).equals("JETB") || fuelType.get(2).equals("AVGAS")) { 
				validInput = true;				
			}
			else if(fuelType.get(2).equals("DONE")) {
				fuelType.set(2, "N/A");
				validInput = true;
			}
			else {
				fuelType.remove(2);
				System.out.println("Invalid fuel type!\n"
						+"| JetA | JetA1 | JetB | AVGAS |\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			String temp = "";
			System.out.println("Add runway? (y/n): ");
			temp = scan.next().toLowerCase(); 
			if(temp.equals("y") || temp.equals("yes")) { 
				validInput = true;
				airport.setRunway(createRunwayLoop());
			}
			else if(temp.equals("n") || temp.equals("no")){
				validInput = true;
			}
			else{				
				System.out.println("Invalid input.\n");
			}
		}
		
		airport.setFuelType(fuelType); 
		System.out.println();
		
		//Airport airport = new Airport(make, name, latitude, longitude, frequency, radioType, fuelType);
		System.out.println("Created airport has the following attributes:");
		airport.displayInfo();
		//airport.Add();
		System.out.println("\nAirport added to file.\n");
		
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
	
	public static void airplaneMenuLoop() { //For use in the main method for user to pick a menu option related to airplane
		boolean exitProgram = false;
		while(!exitProgram) {	
			airplaneMenu();
			Scanner scan = new Scanner(System.in);  
			System.out.println("Menu option:");
			String menuOption = scan.nextLine();
			
			switch(menuOption){
			//replace these print statements with appropriate method calls from Airplane/AirplaneManager Class
				case "1":
					createAirplaneLoop(); 
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
	
	public static void createAirplaneLoop(){
		//Should be called anytime you would ask for user input to create an airplane.
		boolean validInput = false;
		System.out.println();
		Scanner scan = new Scanner(System.in); 
		
		String make = "";
		String model = "";
		String type = "";
		Double fuelEfficiency; //in liters per hundred miles
		Double fuelCapacity; //in liters
		ArrayList<String> fuelType = new ArrayList<>(); // | jet A | Jet A1 | Jet B | ABGAS |
		Double airSpeed; //in miles per hour
		
		Airplane airplane = new Airplane();
		
		while(!validInput) {
			boolean isNumber = true;
			System.out.println("Enter the make:"); //data validation to make sure it's not a number?
			make = scan.nextLine();
			try {
	            Double num = Double.parseDouble(make);
	        } catch (NumberFormatException e) {
	            isNumber = false;
	        }
			if(make.length() <=50 && make.length() >=1 && !isNumber) {
				validInput = true;	
				airplane.setMake(make);
			}
			else if(isNumber) {
				System.out.println("Make cannot be only numbers!");
			}
			else {
				System.out.println("Make must be between 1-50 characters!\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter the model:");
			model = scan.nextLine();
			if(model.length() <= 50 && model.length() >0) {
				validInput = true;
				airplane.setModel(model);
			}
			else {
				System.out.println("model must be between 1-50 characters!\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter the type (| Jet | Prop | TurboProp |): ");
			type = scan.nextLine();
			if (type.toLowerCase().equals("jet") || type.toLowerCase().equals("prop") || type.toLowerCase().equals("turboprop")) {
				validInput = true;	
				airplane.setType(type.toLowerCase());
			}
			else {
				System.out.println("Invalid type!\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			fuelEfficiency = 2000.0;
			Scanner dubScan = new Scanner(System.in);
			System.out.println("Enter the plane's Fuel Efficiency: \n"
					+ "(Units are in liters per hundred miles)");
			if(dubScan.hasNextDouble()) {
				fuelEfficiency = dubScan.nextDouble(); 		
				if(fuelEfficiency <=1000 && fuelEfficiency >0) {
					validInput = true;
					airplane.setFuelEfficiency(fuelEfficiency);
				}
				else if(fuelEfficiency == 0){
					System.out.println("Fuel Efficiency cannot be 0!\n");
				}
				else if(fuelEfficiency < 0){
					System.out.println("Fuel Efficiency must be positive!\n");
				}
				else {
					System.out.println("Fuel Efficiency must be between 0 and 1000 liters per hundred miles!\n");
				}
			}
			else {
				System.out.println("Fuel Efficiency must be a number!\n");
			}
			
		}
		
		validInput = false;
		
		while(!validInput) {
			fuelCapacity = 2000.0;
			Scanner dubScan = new Scanner(System.in);
			System.out.println("Enter the plane's Fuel Capacity: \n"
					+ "(Units are in liters)");
			if(dubScan.hasNextDouble()) {
				fuelCapacity = dubScan.nextDouble(); 		
				if(fuelCapacity <=100000 && fuelCapacity >0) {
					validInput = true;
					airplane.setFuelCapacity(fuelCapacity);
				}
				else if(fuelCapacity == 0){
					System.out.println("Fuel Capacity cannot be 0!\n");
				}
				else if(fuelCapacity < 0){
					System.out.println("Fuel Capacity must be positive!\n");
				}
				else {
					System.out.println("Fuel Capacity must be less than 100,000 liters!\n");
				}
			}
			else {
				System.out.println("Fuel Capacity must be a number!\n");
			}
			
		}

		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter a fuel type: \n"
					+"| JetA | JetA1 | JetB | AVGAS |");
			fuelType.add(0, scan.next().toUpperCase()); 
			if(fuelType.get(0).equals("JETA") || fuelType.get(0).equals("JETA1") || fuelType.get(0).equals("JETB") || fuelType.get(0).equals("AVGAS")) { 
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
					+ "(Type 'done' to skip)");
			fuelType.add(1, scan.next().toUpperCase().strip()); 
			if(fuelType.get(1).equals("JETA") || fuelType.get(1).equals("JETA1") || fuelType.get(1).equals("JETB") || fuelType.get(1).equals("AVGAS")) { 
				validInput = true;				
			}
			else if(fuelType.get(1).equals("DONE")) {
				fuelType.set(1, "N/A");
				validInput = true;
			}
			else {
				fuelType.remove(1);
				System.out.println("Invalid fuel type!\n"
						+"| JetA | JetA1 | JetB | AVGAS |\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			System.out.println("Enter a third fuel type: \n"
					+ "(Type 'done' to skip)");
			fuelType.add(2, scan.next().toUpperCase()); 
			if(fuelType.get(2).equals("JETA") || fuelType.get(2).equals("JETA1") || fuelType.get(2).equals("JETB") || fuelType.get(2).equals("AVGAS")) { 
				validInput = true;				
			}
			else if(fuelType.get(2).equals("DONE")) {
				fuelType.set(2, "N/A");
				validInput = true;
			}
			else {
				fuelType.remove(2);
				System.out.println("Invalid fuel type!\n"
						+"| JetA | JetA1 | JetB | AVGAS |\n");
			}
		}
		
		validInput = false;
		
		while(!validInput) {
			airSpeed = 2000.0;
			Scanner dubScan = new Scanner(System.in);
			System.out.println("Enter the plane's cruising air speed: \n"
					+ "(Units are in miles per hour)");
			if(dubScan.hasNextDouble()) {
				airSpeed = dubScan.nextDouble(); 		
				if(airSpeed <=100000 && airSpeed >0) {
					validInput = true;
					airplane.setAirspeed(airSpeed);
				}
				else if(airSpeed == 0){
					System.out.println("Air Speed cannot be 0!\n");
				}
				else if(airSpeed < 0){
					System.out.println("Air Speed must be positive!\n");
				}
				else {
					System.out.println("Invalid air speed! Maximum air speed is 100,000 miles per hour!\n");
				}
			}
			else {
				System.out.println("Air Speed must be a number!\n");
			}
			
		}
		
		airplane.setFuelType(fuelType); 
		System.out.println();
		
		//airplane airplane = new airplane(make, name, latitude, longitude, frequency, radioType, fuelType);
		System.out.println("Created Airplane has the following attributes:");
		airplane.displayInfo();
		//airplane.Add();
		System.out.println("\nAirplane added to file.\n");
		
	}

	
	public static void beaconMenu() { 
		//Display a text menu full of actions that the user can take. ONLY displays the text, has no functional use.
		System.out.println("----------------------------------------------------------\r\n"
				+ "1 - Add a Beacon to an airport\r\n"
				+ "2 - Modify a Beacon\r\n"
				+ "3 - Delete a Beacon from an airport\r\n"
				+ "4 - Display all Beacons\r\n"
				+ "5 - Back\r\n"
				+ "<Beacon Functionality has been removed for the time being>" 
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
					createRunwayLoop(); //replace these print statements with appropriate method calls from Runway Class
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
	
	public static Runway createRunwayLoop() {
		boolean validInput = false;
		double length = 0;
		String id = "";
		
		while(!validInput) {
			id = "N/A";
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter the id of the runway: ");
				id = scan.nextLine(); 		
				if((id.length() <= 10) && (id.length() > 0)) {
					validInput = true;
				}
				else if(id.length() == 0) {					
					System.out.println("ID length cannot be 0!\n");
				}
				else {
					System.out.println("ID length must be under 10 characters!\n");
				}	
		}
		
		validInput = false;
		
		while(!validInput) {
			length = -1;
			Scanner dubScan = new Scanner(System.in);
			System.out.println("Enter the length of the runway: \n"
					+ "(in miles)");
			if(dubScan.hasNextDouble()) {
				length = dubScan.nextDouble(); 		
				if((length <= 5000) && (length > 0)) {
					validInput = true;
				}
				else if(length == 0) {					
					System.out.println("Length cannot be 0!\n");
				}
				else {
					System.out.println("Length must be under 5,000 miles!\n");
				}
			}
			else {
				System.out.println("Length must be a number!\n");
			}
			
		}
		
		Runway runway = new Runway((double) length, id);
		System.out.println("Runway ID: " + runway.getId());
		System.out.println("Runway length: " + runway.getLength() + " miles");
		//Runway.Add();
		System.out.println("Runway added to file successfully.\n");
		
		return runway;
	}
}
