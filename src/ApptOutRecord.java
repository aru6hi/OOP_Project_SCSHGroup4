import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Represents an Appointment Outcome Record
 */
public class ApptOutRecord extends DatabaseItem{
	private LocalDate date;
	
	/**
	 * get date of record
	 * @return LocalDate of record
	 */
	public LocalDate getDate() {
		return date;
	}
	
	/**
	 * sets date of record given LocalDate object
	 * @param date the date of the record
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	/**
	 * sets date of record given year month day
	 * @param year the year of record
	 * @param month the month of record
	 * @param day the day of record
	 */
	public void setDate(int year, int month, int day) {
		this.date = LocalDate.of(year, month, day); 
	}

	//Own data
	private String service;
	private Status status = Status.PENDING; //defaults to pending
	private String notes;
	private ArrayList<PrescribedMedicine> prescription;
	
	/**
	 * Creates an Appointment Outcome Record with the given ID
	 * @param apptID should be the same as the appointment that this record links to
	 */
	public ApptOutRecord(String apptID) {
		super("AO");
		this.setID(apptID);
		this.prescription  = new ArrayList<PrescribedMedicine>();
	}
	
	@Override
	public String toString() {
		return "ApptOutRecord [id=" + this.getID() + ", service=" + service + ", status=" + status + ", notes=" + notes
				+ ", prescription=" + prescription + "]";
	}
	
	/**
	 * Gets the service provided 
	 * @return service provided
	 */
	public String getService() {
		return service;
	}
	
	/**
	 * Sets the service provided
	 * @param service service provided
	 */
	public void setService(String service) {
		this.service = service;
	}
	
	/**
	 * get status of appointment outcome record
	 * @return status of record
	 */
	public Status getStatus() {
		return this.status;
	}
	
	/**
	 * set status of record
	 * @param status status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	/**
	 * get the notes recorded in the record
	 * @return the notes recorded
	 */
	public String getNotes() {
		return notes;
	}
	
	/**
	 * set the notes of the record
	 * @param notes notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	/**
	 * get the prescription
	 * @return ArrayList of PrescribedMedicine representing all the medicine prescribed
	 */
	public ArrayList<PrescribedMedicine> getPrescription() {
		return this.prescription;
	}
	
	/**
	 * Adds prescription to record
	 * @param medicineID ID of medicine
	 * @param name name of medicine
	 * @param dosage doseage of medicine
	 */
	public void addPrescription(String medicineID, String name, int dosage) {
		this.prescription.add(new PrescribedMedicine(medicineID, name, dosage));
	}
}
