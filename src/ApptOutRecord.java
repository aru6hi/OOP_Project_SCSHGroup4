public class ApptOutRecord {
	//Data from corresponding completed appt
	private String apptID;
	private Date date;
	
	//Own data
	private String service;
	private Status status = Status.PENDING; //defaults to pending
	private String notes;
	private Prescription prescription = new Prescription();
	
	public ApptOutRecord(String apptID, Date date, String service) {
		this.apptID = apptID;
		this.date = date;
		this.service = service;
	}
	
	public ApptOutRecord(String apptID, Date date, String service, Status status) {
		this.apptID = apptID;
		this.date = date;
		this.service = service;
		this.status = status;
	}
	
	public String toString() {
		//This is overriding the default Object.toString() method
		//Now you can print this class directly and it will be formatted nicely
		
		return "Appt ID: " + this.apptID + "\n"
				+ "Date: " + this.date + "\n"
				+ "Service: " + this.service.toString() + "\n"
				+ "Notes:" + this.notes + "\n"
				+ "Prescription:" + this.prescription + "\n"
				+ "Status: " + this.status.toString() + "\n";
				
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void setService(String service) {
		this.service = service;
	}
	
	public void addNotes(String notes) {
		this.notes = notes;
	}
	
	public void addPrescription(String name, String dosage) {
		prescription.addPrescription(name, dosage);
	}

	public Prescription getPrescription() {
		return this.prescription;
	}
	
	public Status getStatus() {
		return this.status;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getApptID() {
		return this.apptID;
	}
}
