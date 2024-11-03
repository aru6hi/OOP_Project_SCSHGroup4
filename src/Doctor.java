import java.util.Scanner;
import java.util.ArrayList;

public class Doctor extends User{
	private String name;
	private char gender;
	private int age;
	
	public Doctor(String ID, String name, char gender, int age) {
		super(ID, Role.DOCTOR);
		
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int newAge) {
		this.age = newAge;
	}
	
	public void scheduleOpenAppt(Scanner sc, ApptMgr apptmgr) {
		//patientID will be null until patient shows up to book it, then the id gets added
		
		System.out.println("Opening appointment slot...");
		System.out.println("Day:");
		int day = sc.nextInt();
		System.out.println("Month:");
		int month = sc.nextInt();
		System.out.println("Year:");
		int year = sc.nextInt();
		
		Date date = new Date(day, month, year);
		
		System.out.println("Time:");
		String time = sc.next();
		
		apptmgr.addAppt(this.getId(), null, day, month, year, time);
		System.out.println("Open Slot @ " + date + " " + time + " Scheduled!");
	}
	
	public void scheduleApptWithPatient(Scanner sc, ApptMgr apptmgr) {
		//This let's them directly schedule an appointment with a specific patient
		
		System.out.println("Scheduling Appointment with...");
		
		System.out.println("Patient ID:");
		String patientID = sc.next();
		
		System.out.println("Day:");
		int day = sc.nextInt();
		System.out.println("Month:");
		int month = sc.nextInt();
		System.out.println("Year:");
		int year = sc.nextInt();
		
		Date date = new Date(day, month, year);
		
		System.out.println("Time:");
		String time = sc.next();
		
		apptmgr.addAppt(this.getId(), patientID, day, month, year, time, Status.CONFIRMED);
		System.out.println("Appointment with " + patientID + " @ " + date + " " + time + " Scheduled!");
	}
	
	public void viewAcceptOrCancelPendingAppt(Scanner sc, ApptMgr apptmgr) {
		//This let's them see appointments so they can either confirm or decline
		ArrayList<Appointment> pendingAppts = apptmgr.findAllByStatus(Status.PENDING);
		
		System.out.println("Appointments pending confirmation:");
		System.out.println(pendingAppts);
		
		if (pendingAppts.size() <= 0) return;
		
		int input;
		String selectedApptID;
		Appointment selectedAppt;
		do {
			System.out.println("1) Accept Appointment");
			System.out.println("2) Cancel Appointment");
			System.out.println("3) Quit");
			input = sc.nextInt();
			
			switch (input) {
			case 1:
				System.out.println("Enter Appointment ID:");
				selectedApptID = sc.next();
				selectedAppt = apptmgr.findByApptID(selectedApptID);
				apptmgr.confirmAppt(selectedAppt);
				break;
			case 2:
				System.out.println("Enter Appointment ID:");
				selectedApptID = sc.next();
				selectedAppt = apptmgr.findByApptID(selectedApptID);
				apptmgr.cancelAppt(selectedAppt);
				break;
			}
			
		} while (input < 3 && input > 0);
	}
	
	public void viewPersonalAppts(Scanner sc, ApptMgr apptmgr) {
		ArrayList<Appointment> myAppts = apptmgr.findAllByDoctorID(this.getId());
		
		System.out.println("Your Schedule:");
		System.out.println(myAppts);
	}
	
	public void viewUpcomingAppts(Scanner sc, ApptMgr apptmgr) {
		ArrayList<Appointment> myAppts = apptmgr.findAllByDoctorID(this.getId());
		
		ArrayList<Appointment> confirmedAppts = new ArrayList<Appointment>();
		
		for (Appointment appt : myAppts) {
			if (appt.getStatus() == Status.CONFIRMED) {
				confirmedAppts.add(appt);
			}
		}
		
		System.out.println("Your Confirmed Appointments:");
		System.out.println(confirmedAppts);
	}
	
	public void viewCompletedAppts(Scanner sc, ApptMgr apptmgr) {
		ArrayList<Appointment> myAppts = apptmgr.findAllByDoctorID(this.getId());
		
		ArrayList<Appointment> confirmedAppts = new ArrayList<Appointment>();
		
		for (Appointment appt : myAppts) {
			if (appt.getStatus() == Status.COMPLETED) {
				confirmedAppts.add(appt);
			}
		}
		
		System.out.println("Your Completed Appointments:");
		System.out.println(confirmedAppts);
	}
	
	public void viewMyApptOutRecords(Scanner sc, ApptMgr apptmgr, ApptOutcomeMgr apptoutmgr) {
		ArrayList<Appointment> myAppts = apptmgr.findAllByDoctorID(this.getId());
		
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
		
		System.out.println(myApptOutRecords);
	}
	
	public void completeAppt(Scanner sc, ApptMgr apptmgr, ApptOutcomeMgr apptoutmgr) {
		int input;
		String selectedApptID;
		Appointment selectedAppt;
		do {
			viewUpcomingAppts(sc, apptmgr);
			System.out.println("1) Complete Appointment");
			System.out.println("2) Quit");
			input = sc.nextInt();
			
			switch (input) {
			case 1:
				System.out.println("Enter Appointment ID:");
				selectedApptID = sc.next();
				selectedAppt = apptmgr.findByApptID(selectedApptID);
				apptmgr.completeAppt(selectedAppt);
				
				//Create Outcome Record
				String service;
				System.out.println("Service provided:");
				service = sc.next();
				
				apptoutmgr.addApptOutRecord(selectedAppt.getApptID(), selectedAppt.getDate(), service);
				break;
			}
			
		} while (input < 2 && input > 0);
	}
	
	public void addNotes(Scanner sc, ApptMgr apptmgr, ApptOutcomeMgr apptoutmgr) {
		int jnput;
		ApptOutRecord selectedAppt;
		String notes;
		do {
			viewMyApptOutRecords(sc, apptmgr, apptoutmgr);
			System.out.println("1) Add Notes");
			System.out.println("2) Quit");
			jnput = sc.nextInt();
			
			switch (jnput) {
			case 1:
				System.out.println("Enter ApptID:");
				String selectedApptID = sc.next();
				sc.nextLine(); //This consumes the \n left behind
				selectedAppt = apptoutmgr.findByApptID(selectedApptID);
				
				System.out.println("Enter Notes:");
				notes = sc.nextLine();
				
				selectedAppt.addNotes(notes);
				
			}
		} while (jnput < 2);
	}
	
	public void addPrescription(Scanner sc, ApptMgr apptmgr, ApptOutcomeMgr apptoutmgr) {
		int jnput;
		ApptOutRecord selectedAppt;
		String prescription;
		do {
			viewMyApptOutRecords(sc, apptmgr, apptoutmgr);
			System.out.println("1) Add Prescription");
			System.out.println("2) Quit");
			jnput = sc.nextInt();
			
			switch (jnput) {
			case 1:
				System.out.println("Enter ApptID:");
				String selectedApptID = sc.next();
				sc.nextLine(); //This consumes the \n left behind
				selectedAppt = apptoutmgr.findByApptID(selectedApptID);
				
				System.out.println("Enter Prescription:");
				prescription = sc.nextLine();
				
				selectedAppt.addPrescription(prescription);
			}
		} while (jnput < 2);
	}
}
