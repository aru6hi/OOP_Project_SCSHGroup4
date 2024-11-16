import java.util.ArrayList;
import java.time.LocalDate;

public class ApptOutRecord extends DatabaseItem{
	//From Appt
	private LocalDate date;
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public void setDate(int year, int month, int day) {
		this.date = LocalDate.of(year, month, day); 
	}

	//Own data
	private String service;
	private Status status = Status.PENDING; //defaults to pending
	private String notes;
	private ArrayList<PrescribedMedicine> prescription = new ArrayList<PrescribedMedicine>();
	
	public ApptOutRecord(String apptID) {
		super("AO");
		this.setID(apptID);
	}
	
	@Override
	public String toString() {
		return "ApptOutRecord [id=" + this.getID() + ", service=" + service + ", status=" + status + ", notes=" + notes
				+ ", prescription=" + prescription + "]";
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public ArrayList<PrescribedMedicine> getPrescription() {
		return prescription;
	}

	public void addPrescription(String medicineID, String name, int dosage) {
		this.prescription.add(new PrescribedMedicine(medicineID, name, dosage));
	}
}
