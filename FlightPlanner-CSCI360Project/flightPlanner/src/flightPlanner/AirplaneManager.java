package flightPlanner;
import java.io.*;
import java.util.*;

public class AirplaneManager{ //import airplane
	
	public static void Add(Airplane plane) throws IOException {
		//Variables should be appended to the file in the order that they appear in the airplane class PIVs
		FileWriter writer = new FileWriter("src/airplanes.txt", true);
		writer.append(plane.getMake() + "," + plane.getModel() + "," + plane.getType() + "," + plane.getFuelEfficiency() + "," + plane.getFuelCapacity() + ","+ 
		plane.getFuelType().get(0).toString() + "," + plane.getFuelType().get(1).toString() + "," + plane.getFuelType().get(2).toString() + ","+ plane.getAirspeed() + "\n");
		writer.close();
	}
	public static void Modify(Airplane plane) throws IOException{
		FileReader reader = new FileReader("src/airplanes.txt");
		reader.close();
		//Will locate airport and allow user to change information.
		//New information will be appended to list and old work will be deleted.
	}
	
	public static void Delete() throws IOException{
		FileReader reader = new FileReader("src/airplanes.txt");
		reader.close();
	}
	
	public static boolean Search() throws IOException{
		//If the airport exists information will be displayed
		// If not message will be displayed to user.
		FileReader reader = new FileReader("src/airplanes.txt");
		reader.close();
		return false;
	}

	public static void Display() throws IOException{
		String airplane;
		FileReader reader = new FileReader("src/airplanes.txt");
		reader.close();
    }
	
	public static void main(String[] args) throws IOException {
		Airplane plane = new Airplane();
		//System.out.println(plane.getFuelType().get(0).toString());
		//Add(plane);
		//Modify(plane);
		//Display();
		//Search();
		//Delete();
		//Display();
	}
}
