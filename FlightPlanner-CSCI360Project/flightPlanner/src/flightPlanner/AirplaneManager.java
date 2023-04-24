package flightPlanner;
import java.io.*;
import java.util.*;

public class AirplaneManager{ //import airplane
	private ArrayList<Airplane> planes;
	
	public ArrayList<Airplane> getPlanes() {
		return planes;
	}

	public void setPlanes(ArrayList<Airplane> planes) {
		this.planes = planes;
	}

	public AirplaneManager() {
		Scanner read;
		ArrayList<Airplane> planeList = new ArrayList<Airplane>(); 
		ArrayList<String> fuelType = new ArrayList<String>();
		fuelType.add("N/A");
		fuelType.add("N/A");
		fuelType.add("N/A");
		planes = planeList;
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
				planes.add(tempPlane);
				//fuelType.clear();
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
	
	public void Modify(int index, String attribute, String value) throws IOException{ //Should only be called on an instance of AirplaneManager class.
		//ArrayList<Airplane> tempList = new ArrayList<Airplane>();
		//Airplane tempPlane = new Airplane();
		switch(attribute.toLowerCase().strip()) {
		case "make":
			this.getPlanes().get(index).setMake(value);
			this.overwriteFile();
			break;
		case "model":
			this.getPlanes().get(index).setModel(value);
			this.overwriteFile();
			break;
		case "type":
			this.getPlanes().get(index).setType(value);
			this.overwriteFile();
			break;
		case "fuelefficiency":
			try {
			this.getPlanes().get(index).setFuelEfficiency(Double.parseDouble(value));
			this.overwriteFile();
			break;
			}
			catch(NumberFormatException e){
				System.out.println("Something has gone horribly wrong with Modify() for Airplane!");
				e.printStackTrace();
				break;
			}
		case "fuelcapacity":
			try {
				this.getPlanes().get(index).setFuelCapacity(Double.parseDouble(value));
				this.overwriteFile();
				break;
				}
				catch(NumberFormatException e){
					System.out.println("Something has gone horribly wrong with Modify() for Airplane!");
					e.printStackTrace();
					break;
				}
		case "airspeed":
			try {
				this.getPlanes().get(index).setAirspeed(Double.parseDouble(value));
				this.overwriteFile();
				break;
				}
				catch(NumberFormatException e){
					System.out.println("Something has gone horribly wrong with Modify() for Airplane!");
					e.printStackTrace();
					break;
				}
		default:
			System.out.println("invalid request");
			break;
		}
		//Will locate airport and allow user to change information.
		//New information will be appended to list and old work will be deleted.
	}
	
	public void ModifyFuelType(int index, int fuelIndex, String value) throws IOException{

			try {
				this.getPlanes().get(index).getFuelType().set(fuelIndex, value);
				this.overwriteFile();				
			}
			catch(NumberFormatException e){
				System.out.println("Something has gone horribly wrong with Modify() for Airplane!");
				e.printStackTrace();	
			}

	}
	
	public void Delete(int index) throws IOException{
		this.getPlanes().remove(index);
		this.overwriteFile();
	}
	
	public boolean Search(String make, String model) throws IOException{
		//If the airport exists information will be displayed
		// If not message will be displayed to user.
		for(Airplane airplane: this.getPlanes()) {
			if(airplane.getMake().toLowerCase().equals(make.toLowerCase()) && airplane.getModel().toLowerCase().equals(model.toLowerCase())) {
				System.out.println("Airplane found! Displaying info...\n");
				airplane.displayInfo();
				return true;
			}
		}
		System.out.println("Airplane not found");
		return false;
	}

	public static void Display() throws IOException{
		Scanner read;
		try {
			read = new Scanner (new File("src/airplanes.txt"));
			read.useDelimiter(",|\n");
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
				airSpeed = read.next();

				System.out.println("Airplane #" + count + ": " + make + ", " + model + ", " + type + ", " + fuelEfficiency + " liters per 100 miles" + ", " + fuelCapacity + " liters" + ", Fuel types: " + fuelType.toString() + ", " +airSpeed + " miles/hour");
				fuelType.clear();
			}
			
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File doesn't exist!");
			e.printStackTrace();
		}
    }
	
	public void overwriteFile() throws IOException { //Should only be called on an instance of AirplaneManager class.
		//Completely overwrites airplanes.txt with a new file based on the manager object this is called on AS SOON AS IT IS CALLED. 
		//BE VERY CAREFUL WITH THIS!
		AirplaneManager manage = new AirplaneManager();
		manage.setPlanes(this.getPlanes());
		
		FileWriter writer = new FileWriter("src/airplanes.txt");
		for(Airplane airplane: manage.getPlanes()) {
			writer.append(
			airplane.getMake() + "," 
			+ airplane.getModel() + ","
			+ airplane.getType() + "," 
			+ airplane.getFuelEfficiency() + "," 
			+ airplane.getFuelCapacity() + ","
			+ airplane.getFuelType().get(0) + "," 
			+ airplane.getFuelType().get(1) + "," 
			+ airplane.getFuelType().get(2) + ","
			+ airplane.getAirspeed() 
			+ "\n");
		}
		writer.close();
	}

	public static void main(String[] args) throws IOException {
		Airplane plane = new Airplane();
		AirplaneManager manage = new AirplaneManager();
		//System.out.println("SIZE: " +manage.getPlanes().size());
		//manage.getPlanes().get(0).displayInfo();
		//System.out.println(plane.getFuelType().get(0).toString());
		//Add(plane);
		//manage.Modify(1, "make", "IT WORKS!!!!");
		//manage.Delete(0);
		Display();
		//manage.Search("rad", "bad");
		//Delete();
		//Display();
	}
}
