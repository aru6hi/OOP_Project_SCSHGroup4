import java.util.ArrayList;

/**
 * Abstract implementation of database
 * @param <ItemType> the type of item the database stores
 */
public abstract class AbstractDatabase<ItemType extends DatabaseItem> implements Database<ItemType>{
	/**
	 * The ArrayList that stores DatabaseItem
	 */
	protected ArrayList<ItemType> db = new ArrayList<ItemType>();
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void add(ItemType i) {
		db.add(i);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remove(ItemType i) {
		db.remove(i);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void view() {
		System.out.println(this.db);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ArrayList<ItemType> getDB() {
		return this.db;
	}
	
	/**
	 * Converts database array to string
	 */
	public String toString() {
		return this.db.toString();
	}
}
