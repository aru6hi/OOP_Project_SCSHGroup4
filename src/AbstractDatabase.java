import java.util.ArrayList;
public abstract class AbstractDatabase<ItemType extends DatabaseItem> implements Database<ItemType>{
	protected ArrayList<ItemType> db = new ArrayList<ItemType>();
	
	@Override
	public void add(ItemType i) {
		db.add(i);
	}
	
	@Override
	public void remove(ItemType i) {
		db.remove(i);
	}
	
	@Override
	public void view() {
		System.out.println(this.db);
	}
	
	@Override
	public ArrayList<ItemType> getDB() {
		return this.db;
	}
	
	public String toString() {
		return this.db.toString();
	}
}
