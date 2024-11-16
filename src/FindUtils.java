import java.util.Collection;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public final class FindUtils {
	
	private FindUtils() {};
	
	//T is the type of object in the collection
	//Returns an arraylist of type T
    public static <T> ArrayList<T> findByProperty(Collection<T> col, Predicate<T> filter) {
        return col.stream().filter(filter).collect(Collectors.toCollection(ArrayList::new));
    }
    
    //Overloaded version for database input
    public static <T extends DatabaseItem> ArrayList<T> findByProperty(Database<T> db, Predicate<T> filter) {
        return db.getDB().stream().filter(filter).collect(Collectors.toCollection(ArrayList::new));
    }
}
