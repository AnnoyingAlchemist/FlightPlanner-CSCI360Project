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
		ArrayList<Airport> airportList = new ArrayList<Airport>(); 
		ArrayList<String> radioType = new ArrayList<String>();
		radioType.add("N/A");
		radioType.add("N/A");
		radioType.add("N/A");
		ArrayList<String> fuelType = new ArrayList<String>();
		fuelType.add("N/A");
		fuelType.add("N/A");
		fuelType.add("N/A");
		airports = airportList;
		try {
			read = new Scanner (new File("src/airports.txt"));
			read.useDelimiter(",|\n");
			int count = 0;
			while(read.hasNext()) {
				count++;
				
				Airport tempAirport = new Airport(); 	
				tempAirport.setICAO(read.next());
				tempAirport.setName(read.next());
				tempAirport.setLatitude(Double.parseDouble(read.next()));
				tempAirport.setLongitude(Double.parseDouble(read.next()));
				tempAirport.setFrequency(Double.parseDouble(read.next()));
				
				radioType.set(0, read.next());
				radioType.set(1, read.next());
				radioType.set(2, read.next());
				
				fuelType.set(0, read.next());
				fuelType.set(1, read.next());
				fuelType.set(2, read.next());
				//tempAirport.setFuelType(fuelType);
				//System.out.println("Airport #" + count + ":");
				//System.out.println();
				airports.add(tempAirport);
			}
			
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File doesn't exist!");
			e.printStackTrace();
		}	
	}
	
	public static void Add(Airport airport) throws IOException {
		//Variables should be appended to the file in the order that they appear in the airport class PIVs
				FileWriter writer = new FileWriter("src/airports.txt", true);
				writer.append(
				airport.getICAO() + "," 
				+ airport.getName() + ","
				+ airport.getLatitude() + "," 
				+ airport.getLongitude() + "," 
				+ airport.getFrequency() + ","
				
				+ airport.getRadioType().get(0).toString() + "," 
				+ airport.getRadioType().get(1).toString() + "," 
				+ airport.getRadioType().get(2).toString() + "," 
				
				+ airport.getFuelType().get(0).toString() + "," 
				+ airport.getFuelType().get(1).toString() + "," 
				+ airport.getFuelType().get(2).toString() + "\n");
				writer.close();
        }

	
	public void Modify(int index, String attribute, String value) throws IOException{
		//Will locate airport and allow user to change information.
		//New information will be appended to list and old work will be deleted.
		switch(attribute.toLowerCase().strip()) {
			case "icao":
				this.getAirports().get(index).setICAO(value);
				this.overwriteFile();
				System.out.println("Modified Succesfully.\n");
				break;
			case "name":
				this.getAirports().get(index).setName(value);
				this.overwriteFile();
				System.out.println("Modified Succesfully.\n");
				break;
			case "latitude":
				try {
					this.getAirports().get(index).setLatitude(Double.parseDouble(value));
					this.overwriteFile();
					System.out.println("Modified Succesfully.\n");
					break;
					}
					catch(NumberFormatException e){
						System.out.println("Invalid request!");
						e.printStackTrace();
						break;
					}
			case "longitude":
				try {
					this.getAirports().get(index).setLongitude(Double.parseDouble(value));
					this.overwriteFile();
					System.out.println("Modified Succesfully.\n");
					break;
				}
				catch(NumberFormatException e){
					System.out.println("Invalid request!");
					e.printStackTrace();
					break;
				}
			case "frequency":
				try {
					this.getAirports().get(index).setFrequency(Double.parseDouble(value));
					this.overwriteFile();
					System.out.println("Modified Succesfully.\n");
					break;
				}
				catch(NumberFormatException e){
					System.out.println("Invalid request!");
					e.printStackTrace();
					break;
				}
			default:
				System.out.println("Invalid request!");
				break;
			}
	}
	
	public void Delete(int index) throws IOException{
		//Information will be searched and once found deleted from file.
		this.getAirports().remove(index);
		this.overwriteFile();
	}
	
	public boolean Search(String ICAO) throws IOException{
		//If the airport exists information will be displayed
		// If not message will be displayed to user.
		for(Airport airport: this.getAirports()) {
			if(airport.getICAO().toLowerCase().equals(ICAO.toLowerCase())) {
				System.out.println("Airport found! Displaying info...\n");
				airport.displayInfo();
				return true;
			}
		}
			return false;
	}

	public static void Display() throws IOException{
		Scanner read;
		try {
			read = new Scanner (new File("src/airports.txt"));
			read.useDelimiter(",|\n");
			int count = 0;
			String icao = "", name = "", latitude = "", longitude = "", frequency = "";
			ArrayList<String> radioType = new ArrayList<String>();
			ArrayList<String> fuelType = new ArrayList<String>();
			
			while(read.hasNext()) {
				count++;
				icao = read.next();
				name = read.next();
				latitude = read.next();
				longitude = read.next();
				frequency = read.next();
				
				radioType.add(read.next());
				radioType.add(read.next());
				radioType.add(read.next());
				
				fuelType.add(read.next());
				fuelType.add(read.next());
				fuelType.add(read.next());


				System.out.println("Airport #" + count + ": " + icao + ", " + name + ", " + latitude + " degrees, " + longitude + " degrees, " + frequency + " liters" + ", Radio types: " + radioType.toString() + ", " + ", " + " Fuel types: " + fuelType.toString());
				fuelType.clear();
				radioType.clear();
			}
			
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File doesn't exist!");
			e.printStackTrace();
		}
    }
	
	public void overwriteFile() throws IOException { //Should only be called on an instance of AirportManager class.
		//Completely overwrites airports.txt with a new file based on the manager object this is called on AS SOON AS IT IS CALLED. 
		//BE VERY CAREFUL WITH THIS!
		AirportManager manage = new AirportManager();
		manage.setAirports(this.getAirports());
		
		FileWriter writer = new FileWriter("src/airports.txt");
		for(Airport airport: manage.getAirports()) {
			writer.append(
			airport.getICAO() + "," 
			+ airport.getName() + ","
			+ airport.getLatitude() + "," 
			+ airport.getLongitude() + "," 
			+ airport.getFrequency() + ","
			+ airport.getRadioType().get(0) + "," 
			+ airport.getRadioType().get(1) + "," 
			+ airport.getRadioType().get(2) + ","
			+ airport.getFuelType().get(0) + "," 
			+ airport.getFuelType().get(1) + "," 
			+ airport.getFuelType().get(2)
			+ "\n");
		}
		writer.close();
	}
	
	public static void main(String[] args) throws IOException {
		//Airport air = new Airport();
		//Add(air);
		AirportManager manager = new AirportManager();
		//manager.Delete(0);
		//Add();
		//Search();
		//manager.Modify(0, "icao", "BEES");
		Display();
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

