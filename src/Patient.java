
import java.util.ArrayList;
import java.util.Scanner;
public class Patient extends User{
	private String name;
	private String DOB;
	private String gender;
	private String bloodType;
	private int phoneNum;
	private String email;
	private int age;
	private String id;
	
	public Patient(String ID, String name, String DOB, String gender, String bloodType, int phoneNum, String email, int age) {
		super(ID, Role.PATIENT);
		this.id=ID;
		this.name = name;
		this.DOB = DOB;
		this.gender = gender;
		this.bloodType = bloodType;
		this.phoneNum = phoneNum;
		this.email = email;
		this.age=age;
	}

	public Patient(String ID, String name, String DOB, String gender, String bloodType, String email) {
		super(ID, Role.PATIENT);
		this.id=ID;
		this.name = name;
		this.DOB = DOB;
		this.gender = gender;
		this.bloodType = bloodType;
		this.phoneNum = -1;
		this.email = null;
	}
	
	public String getID(){
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	public int getAge(){
		return this.age;
	}
	
	public String getDOB() {
		return this.DOB;
	}
	
	public String getBloodType() {
		return this.bloodType;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public int getPhoneNum() {
		return this.phoneNum;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	public void setPhoneNum(int newPhoneNum) {
		this.phoneNum = newPhoneNum;
	}
	
	public void viewAvailableAppt(ApptMgr apptmgr) {
		System.out.println(apptmgr.findAllByStatus(Status.OPEN));
	}
	
	public void bookAppt(Scanner sc, ApptMgr apptmgr) {
		viewAvailableAppt(apptmgr);
		
		System.out.println("Enter Appointment ID to book:");
		String selectedApptID = sc.next();
		sc.nextLine();
		
		Appointment selectedAppt = apptmgr.findByApptID(selectedApptID);
		selectedAppt.setStatus(Status.PENDING); //change status to pending
		selectedAppt.setPatientID(this.getId()); //set patient id
		System.out.println(selectedAppt);
		System.out.println("Appointment pending confirmation!");
	}
	
	public void viewScheduledAppt(ApptMgr apptmgr) {
		System.out.println(apptmgr.findAllByPatientID(this.getId()));
	}
	
	public void cancelAppt(Scanner sc, ApptMgr apptmgr) {
		viewScheduledAppt(apptmgr);
		
		System.out.println("Enter Appointment ID to cancel:");
		String selectedApptID = sc.next();
		sc.nextLine();
		
		Appointment selectedAppt = apptmgr.findByApptID(selectedApptID);
		selectedAppt.setStatus(Status.CANCELLED);
		System.out.println(selectedAppt);
		System.out.println("Appointment cancelled!");
	}
	
	public void rescheduleAppt(Scanner sc, ApptMgr apptmgr) {
		viewScheduledAppt(apptmgr);
		
		System.out.println("Enter Appointment ID to reschedule:");
		String selectedApptID = sc.next();
		sc.nextLine();
		
		Appointment oldAppt = apptmgr.findByApptID(selectedApptID);
		oldAppt.setStatus(Status.OPEN);
		System.out.println(oldAppt);
		
		//Booking time
		viewAvailableAppt(apptmgr);
		System.out.println("Enter Appointment ID to book:");
		selectedApptID = sc.next();
		sc.nextLine();
		
		Appointment selectedAppt = apptmgr.findByApptID(selectedApptID);
		selectedAppt.setStatus(Status.PENDING);
		System.out.println(selectedAppt);
		
		System.out.println("Appointment Rescheduled from \n" + oldAppt + " to \n" + selectedAppt);
	}
	
	public void viewApptOutRecord(ApptMgr apptmgr, ApptOutcomeMgr apptoutmgr) {
		ArrayList<Appointment> myAppts = apptmgr.findAllByPatientID(this.getId());
		
		ArrayList<Appointment> myConfirmedAppts = new ArrayList<Appointment>();
		
		ArrayList<ApptOutRecord> myApptOutRecords = new ArrayList<ApptOutRecord>();
		
		for (Appointment appt : myAppts) {
			if (appt.getStatus() == Status.COMPLETED) {
				myConfirmedAppts.add(appt);
			}
		}
		
		for (Appointment appt : myConfirmedAppts) {
			myApptOutRecords.add(apptoutmgr.findByApptID(appt.getApptID()));
		}
		
		System.out.println(this.getId() + "'s Past Outcome Records:");
		System.out.println(myApptOutRecords);
	}

	public void viewMedicalRecord(MedicalRecordMgr medRecordMgr){
		MedicalRecord medRecord=medRecordMgr.findByID(this.getId());
		medRecordMgr.printRecord(medRecord);
	}
}
