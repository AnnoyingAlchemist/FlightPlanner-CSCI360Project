package flightPlanner;

import java.io.*;
import java.util.*;
public class AirplaneManager { //import airplane
	
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
	public static void main(String[] args) throws IOException {
		//Main method calls each method using a text based interface.
		// Numbers 1 - 5 will call each method.
		//For example: User will input 1 to add airplane or 4 to Search the database.
	}
}
