import java.io.*;
import java.util.*;
public class AirplaneManager{ //import airplane
	
	public static void Add() throws IOException {
		String str1 = "";
		String str2 = "";
		Double int1 = 0.0;
		Double int2 = 0.0;
		int int3 = 0;
		Double int4 = 0.0;
		//Airplane(Str1, Str2, int1, int2, int3, int4)
		Airplane A1 = new Airplane();
		System.out.println("Enter Make:");
		Scanner input = new Scanner(System.in);
        str1 = input.next();
        try {
            // attach a file to FileWriter
            FileWriter fw = new FileWriter("src/airport.txt", true);
  
            //Puts each character into File and makes a new line for more information.
            for (int i = 0; i < str1.length(); i++)
                fw.write(str1.charAt(i));
            fw.write(System.lineSeparator());  
            System.out.println("Successfully written");
            fw.close();
  
        }
        catch (Exception e) {
            e.getStackTrace();}
        
    	System.out.println("Enter Model:");
        str2 = input.next();
        try {
            // attach a file to FileWriter
            FileWriter fw = new FileWriter("src/airport.txt", true);
  
            //Puts each character into File and makes a new line for more information.
            for (int i = 0; i < str2.length(); i++)
                fw.write(str2.charAt(i));
            fw.write(System.lineSeparator());  
            System.out.println("Successfully written");
  
            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();}
        
    	System.out.println("Enter FuelEffiancy in MPH:");
        int1 = input.nextDouble();
        try {
            // attach a file to FileWriter
            FileWriter fw = new FileWriter("src/airport.txt", true);
  
            //Puts each character into File and makes a new line for more information.
            Double.toString(int1);
            fw.write(Double.toString(int1));
            fw.write(System.lineSeparator());  
            System.out.println("Successfully written");
  
            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();}
        
        System.out.println("Enter Fuel Capacity in MPH:");
        int2 = input.nextDouble();
        try {
            // attach a file to FileWriter
            FileWriter fw = new FileWriter("src/airport.txt", true);
  
            //Puts each character into File and makes a new line for more information.
            Double.toString(int2);
            fw.write(Double.toString(int2));
            fw.write(System.lineSeparator());  
            System.out.println("Successfully written");
  
            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();}
   
        System.out.println("Enter Fuel Type:");
        int3 = input.nextInt();
        try {
            // attach a file to FileWriter
            FileWriter fw = new FileWriter("src/airport.txt", true);
  
            //Puts each character into File and makes a new line for more information.
            Double.toString(int3);
            fw.write(Double.toString(int3));
            fw.write(System.lineSeparator());  
            System.out.println("Successfully written");
  
            fw.close();
        }
        catch (Exception e) {
            e.getStackTrace();}
        System.out.println("Enter Airspeed:");
        int4 = input.nextDouble();
        try {
            // attach a file to FileWriter
            FileWriter fw = new FileWriter("src/airport.txt", true);
  
            //Puts each character into File and makes a new line for more information.
            Double.toString(int4);
            fw.write(Double.toString(int4));
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
		File file = new File("src/airport.txt");
		File tempFile = new File("help.txt"); 
		 
		BufferedReader reader = new BufferedReader(new FileReader(file)); 
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile)); 
		 
		String lineToRemove = "Help"; 
		String currentLine; 
		 
		while((currentLine = reader.readLine()) != null) { 
		 
		// trim newline when comparing with lineToRemove 
		    String trimmedLine = currentLine.trim(); 
		    
		    if(trimmedLine.equals(lineToRemove)) continue; 
		 
		    writer.write(currentLine + System.getProperty("line.separator")); 
		} 
		 
		writer.close();  
		reader.close();  
		 
		boolean successful = tempFile.renameTo(file); 
	    Scanner search = new Scanner(System.in);

	    System.out.println("Search by Make or Model");
	    String line = search.next();
	    Scanner scanner;
	    try { scanner = new Scanner(file).useDelimiter(" ");

	        while (scanner.hasNext()) {
	            final String lineFromFile = scanner.nextLine();
	            if (lineFromFile.contains(line)) {
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
	
	public static void Search() throws IOException{
		//If the airport exists information will be displayed
		// If not message will be displayed to user.
		File file = new File("src/airport.txt");

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
        FileReader fr = new FileReader("src/airport.txt");
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
}
