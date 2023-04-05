package flightPlanner;

public class Runway {
	private int length;
	private String id;
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Runway(int length, String idNum) {
		int maxLength = 10;
		this.id = idNum.substring(0, maxLength);
		
		if((length > 5000) || (length < 0)) {
			this.length = 0;
			System.out.println("Invalid Length. Length has been set to 0.");
		}
		else {
			this.length = length;			
		}
		
	}
}
