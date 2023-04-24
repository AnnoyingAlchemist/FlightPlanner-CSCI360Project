package flightPlanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RunwayManager {
private ArrayList<Runway> runways;


	public ArrayList<Runway> getRunways() {
		return runways;
	}

	public void setRunways(ArrayList<Runway> runways) {
		this.runways = runways;
	}
	 // Methods for storing runway information
	 
	public RunwayManager() {
		Scanner read;
		ArrayList<Runway> runwayList = new ArrayList<Runway>();
		runways = runwayList;
		try {
			read = new Scanner (new File("src/runways.txt"));
			read.useDelimiter(",|\n");
			int count = 0;
			while(read.hasNext()) {
				count++;
				
				Runway tempRunway = new Runway(); 	
				tempRunway.setLength(Double.parseDouble(read.next()));
				tempRunway.setId(read.next());

				//System.out.println("Runway #" + count + ":");
				//System.out.println(tempRunway.getLength() + ", " + tempRunway.getId());
				runways.add(tempRunway);
			}
			
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File doesn't exist!");
			e.printStackTrace();
		}	
	}
	
	public static void Add(Runway runway) throws IOException {
		//Variables should be appended to the file in the order that they appear in the Runway class PIVs
				FileWriter writer = new FileWriter("src/runways.txt", true);
				writer.append(
				runway.getLength() + "," 
				+ runway.getId()
				+ "\n");
				writer.close();
	}

	public void Modify(int index, String attribute, String value) throws IOException{
		switch(attribute.toLowerCase().strip()) {
		case "length":
			try {
				this.getRunways().get(index).setLength(Double.parseDouble(value));
				this.overwriteFile();
				System.out.println("Modified Succesfully.\n");				
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid value!\n");				
				e.printStackTrace();
			}
			break;
		case "id":
			this.getRunways().get(index).setId(value);
			this.overwriteFile();
			System.out.println("Modified Succesfully.\n");
			break;
		default:
			System.out.println("Invalid request!");
			break;
		}
	}
	public void Delete(int index) throws IOException{
		this.getRunways().remove(index);
		this.overwriteFile();
	}
	public boolean Search(String id) throws IOException{
		for(Runway runway: this.getRunways()) {
			if(runway.getId().toLowerCase().equals(id.toLowerCase())) {
				System.out.println("Airport found! Displaying info...\n");
				System.out.println("Length: " + runway.getLength());
				System.out.println("ID: " + runway.getId());
				return true;
			}
		}
			System.out.println("Runway not found.");
			return false;
	}
	public static void Display() throws IOException{
		Scanner read;
		try {
			read = new Scanner (new File("src/runways.txt"));
			read.useDelimiter(",|\n");
			int count = 0;
			String id = "", length = "";
			
			while(read.hasNext()) {
				count++;
				length = read.next();
				id = read.next();

				System.out.println("Runway #" + count  + ": Length: " + length + " miles" + " ID: " + id);
			}
			
			read.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File doesn't exist!");
			e.printStackTrace();
		}
	}
	
	public void overwriteFile() throws IOException { //Should only be called on an instance of RunwayManager class.
		//Completely overwrites airports.txt with a new file based on the manager object this is called on AS SOON AS IT IS CALLED. 
		//BE VERY CAREFUL WITH THIS!
		RunwayManager manage = new RunwayManager();
		manage.setRunways(this.getRunways());
		
		FileWriter writer = new FileWriter("src/runways.txt");
		for(Runway runway: manage.getRunways()) {
			writer.append(
			runway.getLength() + "," 
			+ runway.getId()
			+ "\n");
		}
		writer.close();
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Runway runway = new Runway();
		//Add(runway);
		RunwayManager run = new RunwayManager();
		run.Search("unknown");
		//run.Delete(1);
		RunwayManager.Display();
		
	}
}
