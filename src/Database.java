import java.util.ArrayList;
public interface Database<ItemType extends DatabaseItem> {
	/**
	 * Adds an item to the database.
	 * @param i the item to add
	 */
	void add(ItemType i);
	
	/**
	 * Removes an item from the database.
	 * @param i the item to remove
	 */
	void remove(ItemType i);
	
	/**
	 * Prints the contents of the database.
	 */
	void view();
	
	/**
	 * Gets the database array.
	 * @return the ArrayList containing the items of the database
	 */
	ArrayList<ItemType> getDB();
}
