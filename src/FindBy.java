import java.util.Collection;
import java.util.ArrayList;

/**
 * Utility class containing various ways to query a database
 */
public final class FindBy {
	
	//This class will store a bunch of find by methods
	
	/**
	 * searches ArrayList for DatabaseItem with matching id
	 * @param dbArray the ArrayList to search
	 * @param id the id to match
	 * @return ArrayList of DatabaseItem with matching id
	 */
	public static <T extends DatabaseItem> ArrayList<T> id(Collection<T> dbArray, String id) {
        return FindUtils.findByProperty(dbArray, item -> id.equals(item.getID()));
    }
	
	/**
	 * searches ArrayList for Account with matching Role
	 * @param dbArray the ArrayList to search
	 * @param role the role to match
	 * @return ArrayList of Account with matching Role
	 */
	public static <T extends Account> ArrayList<T> role(Collection<T> dbArray, Role role) {
		return FindUtils.findByProperty(dbArray, account -> account.hasRole(role));
	}
	
	/**
	 * searches ArrayList for Appointment with matching Status
	 * @param dbArray the ArrayList to search
	 * @param status the status to match
	 * @return ArrayList of Appointment with matching status
	 */
	public static <T extends Appointment> ArrayList<T> status(Collection<T> dbArray, Status status) {
		return FindUtils.findByProperty(dbArray, appt -> appt.getStatus() == status);
	}
	
	/**
	 * searches ArrayList for ApptOutRecord with matching Status
	 * @param dbArray the ArrayList to search
	 * @param status the status to match
	 * @return ArrayList of ApptOutRecord with matching status
	 */
	public static <T extends ApptOutRecord> ArrayList<T> outRecStatus(Collection<T> dbArray, Status status) {
		return FindUtils.findByProperty(dbArray, appt -> appt.getStatus() == status);
	}
	
	/**
	 * searches ArrayList for Appointment with matching patientID
	 * @param dbArray the ArrayList to search
	 * @param id the id to match
	 * @return ArrayList of Appointment with matching id
	 */
	public static <T extends Appointment> ArrayList<T> apptPatientID(Collection<T> dbArray, String id) {
		return FindUtils.findByProperty(dbArray, appt -> id.equals(appt.getPatientID()));
	}
	
	/**
	 * searches ArrayList for Appointment with matching doctorID
	 * @param dbArray the ArrayList to search
	 * @param id the id to match
	 * @return ArrayList of Appointment with matching id
	 */
	public static <T extends Appointment> ArrayList<T> apptDoctorID(Collection<T> dbArray, String id) {
		return FindUtils.findByProperty(dbArray, appt -> id.equals(appt.getDoctorID()));
	}
	
	/**
	 * searches ArrayList for StockedMedicine with stock < alert
	 * @param dbArray the ArrayList to search
	 * @return ArrayList of StockedMedicine with stock < alert
	 */
	public static <T extends StockedMedicine> ArrayList<T> belowAlertLevel(Collection<T> dbArray) {
		return FindUtils.findByProperty(dbArray, med -> med.getCurrentStock() <= med.getAlertLimit());
	}
	
}
