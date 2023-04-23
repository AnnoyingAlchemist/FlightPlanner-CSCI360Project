package flightPlanner;

import java.io.*;
import java.util.*;
public class AirportManger extends Airplane { //import airports
	
	
	public static void Add() throws IOException {
		String str1 = "";
		String str2 = "";
		Double dou1 = 0.0;
		Double dou2 = 0.0;
		int int1 = 0;
		int int2 = 0;
		//Airplane(Str1, Str2, Int1, int2, int3, int4)
		Airport AA = new Airport();
		//Airport AA = new Airport(str1, str2, dou1, dou2, int1, int2);
		System.out.println("Enter ICAO:");
		Scanner input = new Scanner(System.in);
        str1 = input.next();
        try {
            // attach a file to FileWriter
            FileWriter fw = new FileWriter("C:\\Users\\chron\\eclipse-workspace\\FinalProject\\src\\airport.txt", true);
  
            //Puts each character into File and makes a new line for more information.
            for (int i = 0; i < str1.length(); i++)
                fw.write(str1.charAt(i));
            fw.write(System.lineSeparator());  
            System.out.println("Successfully written");
            fw.close();
  
        }
        catch (Exception e) {
            e.getStackTrace();}
        
    	System.out.println("Enter Name:");
        str2 = input.next();
        try {
            FileWriter fw = new FileWriter("C:\\Users\\chron\\eclipse-workspace\\FinalProject\\src\\airport.txt", true);
  
            for (int i = 0; i < str2.length(); i++)
                fw.write(str2.charAt(i));
            fw.write(System.lineSeparator());  
            System.out.println("Successfully written");
  
            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();}
        
    	System.out.println("Enter Latitude:");
        dou1 = input.nextDouble();
        try {
            // attach a file to FileWriter
            FileWriter fw = new FileWriter("C:\\Users\\chron\\eclipse-workspace\\FinalProject\\src\\airport.txt", true);
  
            //Puts each character into File and makes a new line for more information.
            Double.toString(dou1);
            fw.write(Double.toString(dou1));
            fw.write(System.lineSeparator());  
            System.out.println("Successfully written");
  
            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();}
        
        System.out.println("Enter Longitude:");
        dou2 = input.nextDouble();
        try {
            // attach a file to FileWriter
            FileWriter fw = new FileWriter("C:\\Users\\chron\\eclipse-workspace\\FinalProject\\src\\airport.txt", true);
  
            //Puts each character into File and makes a new line for more information.
            Double.toString(dou2);
            fw.write(Double.toString(dou2));
            fw.write(System.lineSeparator());  
            System.out.println("Successfully written");
  
            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();}
   
        System.out.println("Enter Radio Type:");
        int1 = input.nextInt();
        try {
            // attach a file to FileWriter
            FileWriter fw = new FileWriter("C:\\Users\\chron\\eclipse-workspace\\FinalProject\\src\\airport.txt", true);
  
            //Puts each character into File and makes a new line for more information.
            Double.toString(int1);
            fw.write(Double.toString(int1));
            fw.write(System.lineSeparator());  
            System.out.println("Successfully written");
  
            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();}
        System.out.println("Enter Airspeed:");
        int2 = input.nextInt();
        try {
            // attach a file to FileWriter
            FileWriter fw = new FileWriter("C:\\Users\\chron\\eclipse-workspace\\FinalProject\\src\\airport.txt", true);
  
            //Puts each character into File and makes a new line for more information.
            Double.toString(int2);
            fw.write(Double.toString(int2));
            fw.write(System.lineSeparator());
            fw.write(System.lineSeparator());
            System.out.println("Successfully written");
  
            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();}
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
		File file = new File("airport.txt");

	    Scanner search = new Scanner(System.in);

	    System.out.println("Search by Make or Model");
	    String line = search.next();
	    Scanner scanner;
	    try {
	        scanner = new Scanner(file).useDelimiter(" ");

	        while (scanner.hasNext()) {
	            final String lineFromFile = scanner.nextLine();
	            if (lineFromFile.contains(line)) {
	                // a match!
	                System.out.println(line);
	                for (int i = 0; i <= 5; i++){
	                	System.out.println(scanner.nextLine());
	                if (line.isBlank() == true) 
	                	break;}
	            }
	        }
	    } 
	    catch (IOException e) {
	        System.out.println(file.toString()+ "Not found");
	    }
	    
	}

	public static void Display() throws IOException{
	       // Open the file.
        FileReader fr = new FileReader("airport.txt");
        Scanner inFile = new Scanner(fr);

        // Read lines from the file till end of file
        while (inFile.hasNext())
        {
            // Read the next line.
            String line = inFile.nextLine();
            // Display the line.
            System.out.println(line);
        }

        // Close the file.
        inFile.close();
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

