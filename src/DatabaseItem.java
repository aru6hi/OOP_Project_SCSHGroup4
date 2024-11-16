
public abstract class DatabaseItem {
	private String id;
	private static int idCounter = 1;
	
	public DatabaseItem(String prefix) {
		this.id = genID(prefix, 5);
	}
	
	private String genID(String prefix, int lengthOfID) {
		String numericPart = String.valueOf(idCounter);
		if (numericPart.length() < lengthOfID) {
			int remaining = lengthOfID - numericPart.length() - 1; //To account for the prefix
			
			//append a bunch of 0s to front
			for (int i = 0; i < remaining; i++) {
				numericPart = "0" + numericPart;
			}
		}
		
		idCounter++;
		
		return prefix + numericPart;
	}
	
	//Solely for use when importing csv
	public void setID(String id) {
		this.id = id;
	}
	
	public String getID() {
		return this.id;
	}
}
