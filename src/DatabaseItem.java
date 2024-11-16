/**
 * Represents an item that can be stored in a database
 */
public abstract class DatabaseItem {
	private String id;
	private static int idCounter = 1;
	
	/**
	 * Constructor for DatabaseItem
	 * @param prefix is the prefix for the id
	 */
	public DatabaseItem(String prefix) {
		this.id = genID(prefix, 5);
	}
	
	/**
	 * generates the id for this item
	 * @param prefix is the prefix for the id
	 * @param lengthOfID max length of the id
	 * @return String representing the id of database item
	 */
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
	
	/**
	 * Sets id
	 * @param id to set
	 */
	//Solely for use when importing csv
	public void setID(String id) {
		this.id = id;
	}
	
	/**
	 * gets id
	 * @return id of the database item
	 */
	public String getID() {
		return this.id;
	}
}
