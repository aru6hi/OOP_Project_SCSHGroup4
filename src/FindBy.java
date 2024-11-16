import java.util.Collection;
import java.util.ArrayList;

public final class FindBy {
	
	//This class will store a bunch of find by methods
	
	public static <T extends DatabaseItem> ArrayList<T> id(Collection<T> dbArray, String id) {
        return FindUtils.findByProperty(dbArray, item -> id.equals(item.getID()));
    }
	
	public static <T extends Account> ArrayList<T> role(Collection<T> dbArray, Role role) {
		return FindUtils.findByProperty(dbArray, account -> account.hasRole(role));
	}
	
	public static <T extends Appointment> ArrayList<T> status(Collection<T> dbArray, Status status) {
		return FindUtils.findByProperty(dbArray, appt -> appt.getStatus() == status);
	}
	
	public static <T extends ApptOutRecord> ArrayList<T> outRecStatus(Collection<T> dbArray, Status status) {
		return FindUtils.findByProperty(dbArray, appt -> appt.getStatus() == status);
	}
	
	public static <T extends Appointment> ArrayList<T> apptPatientID(Collection<T> dbArray, String id) {
		return FindUtils.findByProperty(dbArray, appt -> id.equals(appt.getPatientID()));
	}
	
	public static <T extends Appointment> ArrayList<T> apptDoctorID(Collection<T> dbArray, String id) {
		return FindUtils.findByProperty(dbArray, appt -> id.equals(appt.getDoctorID()));
	}
	
	public static <T extends StockedMedicine> ArrayList<T> belowAlertLevel(Collection<T> dbArray) {
		return FindUtils.findByProperty(dbArray, med -> med.getCurrentStock() <= med.getAlertLimit());
	}
	
}
