package flightPlanner;
import java.io.*;
import java.util.*;

public class AirplaneManager extends Airplane{ //import airplane
	private ArrayList<Airplane> planes;
	
	public ArrayList<Airplane> getPlanes() {
		return planes;
	}

	public void setPlanes(ArrayList<Airplane> planes) {
		this.planes = planes;
	}

	public AirplaneManager() {
		Scanner read;
		try {
			read = new Scanner (new File("src/airplanes.txt"));
			read.useDelimiter(",");
			
			String make, model, type;
			double fuelEfficiency, fuelCapacity, airSpeed;
			ArrayList<String> fuelType = new ArrayList<String>();
			
			while(read.hasNext()) {
				make = read.next();
				model = read.next();
				type = read.next();
				try {
					fuelEfficiency = Double.parseDouble(read.next());
				}
				catch(NumberFormatException e) {
					System.out.println("Something went wrong reading fuelEfficiency. fuelEfficiency has been set to 1.");
					read.next();
					fuelEfficiency = 1.0;
				}
				try {
					fuelCapacity = Double.parseDouble(read.next());
				}
				catch(NumberFormatException e) {
					System.out.println("Something went wrong reading fuelCapacity. fuelCapacity has been set to 1.");
					read.next();
					fuelCapacity = 1.0;
				}
				
				fuelType.add(read.next());
				fuelType.add(read.next());
				fuelType.add(read.next());
				
				try {
					airSpeed = Double.parseDouble(read.next());
				}
				catch(NumberFormatException e) {
					System.out.println("Something went wrong reading air speed. air speed has been set to 1.");
					read.next();
					airSpeed = 1.0;
				}
				System.out.println(make + model + type + fuelEfficiency + fuelCapacity + fuelType.toString() + airSpeed);
			}
			
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File doesn't exist!");
			e.printStackTrace();
		}
	}
	
	public static void Add(Airplane plane) throws IOException {
		//Variables should be appended to the file in the order that they appear in the airplane class PIVs
		FileWriter writer = new FileWriter("src/airplanes.txt", true);
		writer.append(
		plane.getMake() + "," 
		+ plane.getModel() + ","
		+ plane.getType() + "," 
		+ plane.getFuelEfficiency() + "," 
		+ plane.getFuelCapacity() + ","
		+ plane.getFuelType().get(0).toString() + "," 
		+ plane.getFuelType().get(1).toString() + "," 
		+ plane.getFuelType().get(2).toString() + ","
		+ plane.getAirspeed() 
		+ "\n");
		writer.close();
	}
	public static void Modify(Airplane plane) throws IOException{
		FileReader reader = new FileReader("src/airplanes.txt");
		reader.close();
		//Will locate airport and allow user to change information.
		//New information will be appended to list and old work will be deleted.
	}
	
	public static void Delete(String make) throws IOException{
		Scanner read = new Scanner (new File("src/airplanes.txt"));
		read.useDelimiter(",");
		read.close();
	}
	
	public static boolean Search(String something) throws IOException{
		//If the airport exists information will be displayed
		// If not message will be displayed to user.
		FileReader reader = new FileReader("src/airplanes.txt");
		reader.close();
		return false;
	}

	public static void Display() throws IOException{
		Scanner read;
		try {
			read = new Scanner (new File("src/airplanes.txt"));
			read.useDelimiter(",");
			int count = 0;
			String make = "", model = "", type = "", fuelEfficiency = "", fuelCapacity = "", airSpeed = "";
			ArrayList<String> fuelType = new ArrayList<String>();
			
			while(read.hasNext()) {
				count++;
				make = read.next();
				model = read.next();
				type = read.next();
				fuelEfficiency = read.next();
				fuelCapacity = read.next();
				fuelType.add(read.next());
				fuelType.add(read.next());
				fuelType.add(read.next());
				airSpeed = read.nextLine();

				System.out.println("Airplane #" + count + ": " + make + ", " + model + ", " + type + ", " + fuelEfficiency + " liters/100mi" + ", " + fuelCapacity + " liters" + ", " + fuelType.toString() + airSpeed + " miles/hour");
				fuelType.clear();
			}
			
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File doesn't exist!");
			e.printStackTrace();
		}
    }
	/*
	public static void Display() throws IOException{
		Scanner read;
		try {
			read = new Scanner (new File("src/airplanes.txt"));
			read.useDelimiter(",");
			
			String make = "", model = "", type = "", fuelEfficiency = "", fuelCapacity = "", airSpeed = "";
			ArrayList<String> fuelType = new ArrayList<String>();
			
			while(read.hasNext()) {
				make = read.next();
				if(read.hasNext()) {
					model = read.next();
					
				}
				if(read.hasNext()) {
					type = read.next();
					
				}
				if(read.hasNext()) {
					fuelEfficiency = read.next();
					
				}
				if(read.hasNext()) {
					fuelCapacity = read.next();
					
				}
				if(read.hasNext()) {
					airSpeed = read.next();
					
				}
				if(read.hasNext()) {
					
				}
				System.out.println(make + "\n" + model + "\n" + type + "\n" + fuelEfficiency + "\n" + fuelCapacity + "\n" + fuelType.toString() + "\n" + airSpeed);
			}
			
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File doesn't exist!");
			e.printStackTrace();
		}
    }
	*/
	public static void main(String[] args) throws IOException {
		Airplane plane = new Airplane();
		//System.out.println(plane.getFuelType().get(0).toString());
		//Add(plane);
		//Modify(plane);
		Display();
		//Search();
		//Delete();
		//Display();
	}
}
