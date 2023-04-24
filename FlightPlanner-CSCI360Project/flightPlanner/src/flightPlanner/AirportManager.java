package flightPlanner;

import java.io.*;
import java.util.*;
public class AirportManager{ //import airports
	private ArrayList<Airport> airports;
	
	public ArrayList<Airport> getAirports() {
		return this.airports;
	}
	public void setAirports(ArrayList<Airport> airportList) {
		this.airports = airportList;
	}
	
	public AirportManager() {
		Scanner read;
		ArrayList<Airplane> planeList = new ArrayList<Airplane>(); 
		ArrayList<String> fuelType = new ArrayList<String>();
		fuelType.add("N/A");
		fuelType.add("N/A");
		fuelType.add("N/A");
		airports = planeList;
		try {
			read = new Scanner (new File("src/airplanes.txt"));
			read.useDelimiter(",|\n");

			while(read.hasNext()) {
				Airplane tempPlane = new Airplane();
				tempPlane.setMake(read.next());
				tempPlane.setModel(read.next());
				tempPlane.setType(read.next());
				tempPlane.setFuelEfficiency(Double.parseDouble(read.next()));
				tempPlane.setFuelCapacity(Double.parseDouble(read.next()));
				//fuelCapacity = read.next();
				fuelType.set(0, read.next());
				fuelType.set(1, read.next());
				fuelType.set(2, read.next());
				tempPlane.setFuelType(fuelType);
				tempPlane.setAirspeed(Double.parseDouble(read.next()));
				
				//System.out.println("Plane #" + count + ":");
				//tempPlane.displayInfo();
				//System.out.println();
				airports.add(tempPlane);
				//fuelType.clear();
			}
			
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File doesn't exist!");
			e.printStackTrace();
		}	
	}
	
	public static void Add(Airport airport) throws IOException {
			//
        }

	
	public static void Modify() throws IOException{
		//Will locate airport and allow user to change information.
		//New information will be appended to list and old work will be deleted.
	}
	
	public static void Delete() throws IOException{
		//Information will be searched and once found deleted from file.
	}
	
	public static void Search() throws IOException{
		//If the airport exists information will be displayed
		// If not message will be displayed to user.
	}

	public static void Display() throws IOException{
    }
	
	public static void main(String[] args) throws IOException {
		//Delete();
		//Add();
		//Search();
		//Display();
		//Main method calls each method using a text based interface.
		// Numbers 1 - 5 will call each method.
		//For example: User will input 1 to add airplane or 4 to Search the database.
	}

	
	/*
	 * Methods for runway information
	 */
	public static void RAdd() throws IOException {
		//Allows user to create a runway and fill out attributes.
		//Information will be saved to airport.txt file.
		//Information is inputed by user using scanner,
	}
	public static void RModify() throws IOException{
		//Will locate runway and allow user to change information.
		//New information will be appended to list and old work will be deleted.
	}
	public static void RDelete() throws IOException{
		//Information will be searched and once found deleted from file.
	}
	public static void RSearch() throws IOException{
		//If the runway exists information will be displayed
		// If not message will be displayed to user.
		
	}
	public static void RDisplay() throws IOException{
		//Will display list of all runways.
	}

} 

