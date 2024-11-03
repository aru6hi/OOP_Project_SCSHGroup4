package HMS;

public class Appointment {
	private String doctorID;
	private String patientID;
	
	private Date date;
	private String time;
	
	private Status status = Status.OPEN; //Defaults to open
	
	private static int currAvailableApptID = 1;
	private String apptID;
	
	public Appointment(String doctorID, String patientID, Date date, String time) {
		this.apptID = genApptID();
		this.doctorID = doctorID;
		this.patientID = patientID;
		this.date = date;
		this.time = time;
	}
	
	public Appointment(String doctorID, String patientID, Date date, String time, Status status) {
		this.apptID = genApptID();
		this.doctorID = doctorID;
		this.patientID = patientID;
		this.date = date;
		this.time = time;
		this.status = status;
	}
	
	private String genApptID() {
		//Unique cause it's based off a static counter
		int maxNumPartLength = 5;
		String numericPart = String.valueOf(currAvailableApptID);
		if (numericPart.length() < maxNumPartLength) {
			int remaining = maxNumPartLength - numericPart.length();
			
			//append a bunch of 0s to front
			for (int i = 0; i < remaining; i++) {
				numericPart = "0" + numericPart;
			}
		}
		
		currAvailableApptID++;
		
		return "A" + numericPart;
	}
	
	public String toString() {
		//This is overriding the default Object.toString() method
		//Now you can print this class directly and it will be formatted nicely
		
		return "Appt ID: " + this.apptID + "\n"
				+ "Doctor ID: " + this.doctorID + "\n" 
				+ "Patient ID: " + this.patientID + "\n"
				+ "Date: " + this.date + "\n"
				+ "Time: " + this.time + "\n"
				+ "Status: " + this.status.toString() + "\n";
				
	}
	
	public void setStatus(Status newStatus) {
		this.status = newStatus;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public void setDate(Date newDate) {
		this.date = newDate;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setTime(String newTime) {
		this.time = newTime;
	}
	
	public String getTime() {
		return this.time;
	}
	
	public void setPatientID(String newPatientID) {
		this.patientID = newPatientID;
	}
	
	public void setDoctorID(String newDoctorID) {
		this.doctorID = newDoctorID;
	}
	
	public String getPatientID() {
		return this.patientID;
	}
	
	public String getDoctorID() {
		return this.doctorID;
	}
	
	public String getApptID() {
		return this.apptID;
	}
 }
