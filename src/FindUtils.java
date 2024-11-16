import java.util.Collection;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Utility class containing  generic methods to search databases
 * Used in FindBy class
 */
public final class FindUtils {
	
	private FindUtils() {};
	
	/**
	 * Filters a Collection by a Predicate
	 * @param col Collection object
	 * @param filter The function for filtering the Collection
	 * @return ArrayList containing filtered items
	 */
	//T is the type of object in the collection
	//Returns an arraylist of type T
    public static <T> ArrayList<T> findByProperty(Collection<T> col, Predicate<T> filter) {
        return col.stream().filter(filter).collect(Collectors.toCollection(ArrayList::new));
    }
    
    /**
	 * Filters a Database by a Predicate
	 * @param db Database object
	 * @param filter The function for filtering the Collection
	 * @return ArrayList containing filtered items
	 */
    //Overloaded version for database input
    public static <T extends DatabaseItem> ArrayList<T> findByProperty(Database<T> db, Predicate<T> filter) {
        return db.getDB().stream().filter(filter).collect(Collectors.toCollection(ArrayList::new));
    }
}
