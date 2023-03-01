package flightPlanner;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Ask user for user name and password, and store the answers as variables using a scanner object
		//Call checkLogin() to verify their user name and password
		//If login returns false, display an error to the user and ask them for their credentials again
		//If login returns true, continue the program and call displayMenu().
		
		//displayMenu() should run in a while loop that only breaks when the user chooses to exit the program.
		//Call a function corresponding to the option the user picks.
			//Option 4 should close the program and break the while loop
		
			//Airport manager and Airplane manager options will call airportMenu() and airplaneMenu() respectively, 
			//and put the user in an another while loop that only breaks when they choose to go back.
				//In the airport and airplane manager menu, each option should call its corresponding function from the
				//AirportManager and AirplaneManager classes: add(), modify(), delete(), and display().
				//After the chosen option is resolved, call airportMenu() or airplaneMenu() again
		
				//'Back' should call displayMenu() and break the while loop.
		
				//'Beacons and Runaways' should call beaconRunawayMenu()
					//each option should call a corresponding function from the Beacon or Runaway class
					//After the chosen option is resolved, call beaconRunawayMenu() again
					//'back' should take the user back to the airport manager menu
		
			//'Plan a flight' will ask the user to enter a plane, starting airport, and destination, and then call 
				//planFlight() from the FlightPlan class using the given answers as parameters for the function
				//any invalid responses will display an error and send the user back to the displayMenu() menu.
	}

	public boolean checkLogin(String user, String pass) {
		//Iterate through the AdminUsers.txt file and compare the user name and password given to those in the file
		//If they match any user name/password combinations in the file, return true. 
		//If they do not, return false.
		//Should be called upon startup of the program.
		return true;
	}
	
	public void displayMenu() {
		//Display a text menu full of actions that the user can take
		//print the following lines:
		//----------------------------------------------------------
		//1 - Plan a flight
		//2 - Airport manager
		//3 - Airplane manager
		//4 - Exit
		//----------------------------------------------------------
	}
	
	public void airportMenu() {
		//Display a text menu full of actions that the user can take
		//print the following lines:
		//----------------------------------------------------------
		//1 - Create an Airport
		//2 - Modify an Airport
		//3 - Delete an Airport
		//4 - Display all Airports
		//5 - Beacons and Runaways
		//6 - Back
		//----------------------------------------------------------
	}
	
	public void airplaneMenu() {
		//Display a text menu full of actions that the user can take
		//print the following lines:
		//----------------------------------------------------------
		//1 - Create an Airplane
		//2 - Modify an Airplane
		//3 - Delete an Airplane
		//4 - Display all Airplanes
		//5 - Back
		//----------------------------------------------------------
	}
	
	public void beaconRunawayMenu() {
		//Display a text menu full of actions that the user can take
		//print the following lines:
		//----------------------------------------------------------
		//1 - Add a Beacon to an airport
		//2 - Modify a Beacon
		//3 - Delete a Beacon from an airport
		//4 - Display all Beacons
		//------------------------------------
		//5 - Add a Runaway to an airport
		//6 - Modify a Runaway
		//7 - Delete a Runaway from an airport
		//8 - Display all Runaways
		
		//9 - Back
		//----------------------------------------------------------
	}
	
}
