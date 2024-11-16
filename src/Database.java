import java.util.ArrayList;
public interface Database<ItemType extends DatabaseItem> {
	void add(ItemType i);
	void remove(ItemType i);
	void view();
	ArrayList<ItemType> getDB();
}
