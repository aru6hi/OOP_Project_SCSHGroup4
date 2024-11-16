import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment extends DatabaseItem{
	private String doctorID;
	private String patientID;
	
	private LocalTime time;
	private LocalDate date;
	private Status status = Status.OPEN; //Defaults to open
	
	public Appointment() {
		super("A");
	}
	
	@Override
	public String toString() {
		return "Appointment ID: " + this.getID() + "\n" +
				"Doctor ID: " + this.doctorID + "\n" +
				"Patient ID: " + this.patientID + "\n" +
				"Date: " + this.date + "\n" +
				"Time: " + this.time + "\n" +
				"Status: " + this.status + "\n";
	}
	
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	
	public void setDate(LocalDate date) {
		this.date = date; 
	}
	
	public void setDate(int year, int month, int day) {
		this.date = LocalDate.of(year, month, day); 
	}
	
	public void setTime(LocalTime time) {
		this.time = time; 
	}
	
	public void setTime(int hour, int minute) {
		this.time = LocalTime.of(hour, minute);
	}
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDoctorID() {
		return doctorID;
	}

	public String getPatientID() {
		return patientID;
	}

	public LocalTime getTime() {
		return time;
	}

	public LocalDate getDate() {
		return date;
	}

}
