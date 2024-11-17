import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents an appointment
 */
public class Appointment extends DatabaseItem{
	private String doctorID;
	private String patientID;
	private LocalTime time;
	private LocalDate date;
	private Status status = Status.OPEN; //Defaults to open
	
	/**
	 * Constructs a blank appointment
	 */
	public Appointment() {
		super("A");
	}
	
	/**
	 * Converts Appointment to string
	 */
	@Override
	public String toString() {
		return "Appointment ID: " + this.getID() + "\n" +
				"Doctor ID: " + this.doctorID + "\n" +
				"Patient ID: " + this.patientID + "\n" +
				"Date: " + this.date + "\n" +
				"Time: " + this.time + "\n" +
				"Status: " + this.status + "\n";
	}
	
	/**
	 * Sets doctor id
	 * @param doctorID the doctor id to set
	 */
	public void setDoctorID(String doctorID) {
		this.doctorID = doctorID;
	}
	
	/**
	 * sets patient id
	 * @param patientID the patient id to set
	 */
	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
	
	/**
	 * sets date of appointment with LocalDate object
	 * @param date the date of appointment
	 */
	public void setDate(LocalDate date) {
		this.date = date; 
	}
	
	/**
	 * sets date of appointment given year month day
	 * @param year the year of appointment
	 * @param month the month of appointment
	 * @param day the day of appointment
	 */
	public void setDate(int year, int month, int day) {
		this.date = LocalDate.of(year, month, day); 
	}
	
	/**
	 * sets time of appointment given LocalTime object
	 * @param time the time of appointment
	 */
	public void setTime(LocalTime time) {
		this.time = time; 
	}
	
	/**
	 * sets time of appointment given hour and minute
	 * @param hour the hour of appointment
	 * @param minute the minute of appointment
	 */
	public void setTime(int hour, int minute) {
		this.time = LocalTime.of(hour, minute);
	}
	
	/**
	 * gets the status of appointment
	 * @return the status of appointment
	 */
	public Status getStatus() {
		return status;
	}
	
	/**
	 * Sets status of appointment
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	
	/**
	 * get id of doctor assigned to this appointment
	 * @return id of doctor assigned to this appointment
	 */
	public String getDoctorID() {
		return doctorID;
	}
	
	/**
	 * get id of patient that booked this appointment
	 * @return id of patient that booked this appointment
	 */
	public String getPatientID() {
		return patientID;
	}
	
	/**
	 * get time of appointment
	 * @return LocalTime representing time of appointment
	 */
	public LocalTime getTime() {
		return time;
	}
	
	/**
	 * get date of appointment
	 * @return LocalDate representing date of appointment
	 */
	public LocalDate getDate() {
		return date;
	}

}
