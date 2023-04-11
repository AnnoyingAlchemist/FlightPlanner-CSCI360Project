package flightPlanner;

import java.io.*;
import java.util.*;
public class AirportManger extends Airport { //import airports
	
	public class AirportManager{ 
	String make; 
	String model; 
	double fuelEfficiency; 
	double fuelCapacity; 
	int[] fuelType; 
	double airspeed;
	
	
	public static void Add() throws IOException {
		
		
		//Allows user to create an airport and fill out attributes.
		//Information will be saved to airport.txt file.
		//Information is inputed by user using scanner,
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
		//Will display list of all available airports.
	}
	
	//Methods for runway information
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
}
