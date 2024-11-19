import java.util.Scanner;
import java.util.ArrayList;

/**
 * Controller unit for Doctor functions
 */
public class DoctorController implements Controller{
	private Scanner sc;
	private ApptDB apptDB;
	private ApptOutDB apptOutDB;
	private PatientRecordDB medRecDB;
	private InventoryDB inventoryDB;
	private CurrentSession session;
	
	/**
	 * Creates a new Doctor Controller
	 * @param sc scanner for input
	 * @param apptDB appointment database
	 * @param apptOutDB appointment outcome record database
	 * @param medRecDB patient record database
	 * @param session current session
	 */
	public DoctorController(Scanner sc, ApptDB apptDB, ApptOutDB apptOutDB, PatientRecordDB medRecDB, InventoryDB inventoryDB, CurrentSession session) {
		this.sc = sc;
		this.apptDB = apptDB;
		this.apptOutDB = apptOutDB;
		this.medRecDB = medRecDB;
		this.inventoryDB = inventoryDB;
		this.session = session;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void runChosenOption(int option) {
		switch (option) {
        case 1:
        	viewPatientMedicalRecord();
        	break;
        case 2:
        	updatePatientMedicalRecord();
        	break;
        case 3:
        	viewPersonalAppts();
        	break;
        case 4:
        	scheduleOpenAppt();
        	break;
        case 5:
        	confirmOrCancelPendingAppt();
        	break;
        case 6:
        	viewUpcomingAppts();
        	break;
        case 7:
        	//Complete an appointment
        	completeAppt();
        	break;
        case 8:
        	break;
        }
	}
	
	/**
	 * Prints patient record of specific patient ID
	 */
	public void viewPatientMedicalRecord(){
		System.out.println("Enter Patient ID: ");
		String patientID = sc.nextLine();
		ArrayList<PatientRecord> a = FindBy.id(medRecDB.getDB(), patientID);
		if (a.isEmpty()) {
			System.out.println("No Records Found!");
		}
		else {
			System.out.println(a.get(0));
		}
	}
	
	/**
	 * Updates medical record of patient with specific patient ID
	 */
	public void updatePatientMedicalRecord() {
		System.out.println("Enter patient ID to update the record: ");
		String patientID=sc.nextLine();
		ArrayList<PatientRecord> a = FindBy.id(medRecDB.getDB(), patientID);
		if (a.isEmpty()) {
			System.out.println("No Records Found!");
		}
		else {
			//Edit Record
			PatientRecord record = a.get(0);
			System.out.println("Choose one of the following: ");
	        System.out.println("1. Edit Patient Diagnoses");
	        System.out.println("2. Edit Patient Medications");
	        System.out.println("3. Edit Patient Past Treatments");

	        int option = sc.nextInt();
	        sc.nextLine(); 

	        switch(option) {
	            case 1:
	                System.out.println("Enter new diagnoses: ");
	                String diag = sc.nextLine();
	                record.setDiagnoses(diag);
	                break;
	            case 2:
	                System.out.println("Choose one of the following: ");
	                System.out.println("1. Enter new medication: ");
	                System.out.println("2. Remove existing medication: ");
	                int choice=sc.nextInt();
	                sc.nextLine();
	                switch (choice) {
	                    case 1:
	                    	
	                    	inventoryDB.view();
	                    	
	                    	String medID;
	        				System.out.println("Medicine ID:");
	        				medID = sc.next();
	        				sc.nextLine();
	        				
	        				//Check if the ID is valid
	        				ArrayList<StockedMedicine> check = FindBy.id(inventoryDB.getDB(), medID);
	        				if (check.isEmpty()) {
	        					System.out.println("Invalid ID!");
	        				}
	        				else {
	        					StockedMedicine med = check.get(0);
		                    	String name = med.getMedName();
		                    	
		                    	System.out.println("Enter dosage: ");
		                    	int dose = sc.nextInt();
		                    	sc.nextLine();
		                    	
		                        record.addPrescription(medID, name, dose);
	        				}
	                        break;
	                    case 2:
	                    	System.out.println(record.getPrescription());
	                    	System.out.println("Enter index to remove: ");
	                    	int i = sc.nextInt();
	                        record.removePrescription(i);
	                        break;
	                    default:
	                        System.out.println("Invalid option");
	                }
                    break;
	            case 3:
	                System.out.println("Enter new past treatments: ");
	                String treatment = sc.nextLine();
	                record.setPastTreatments(treatment); 
	                break;
	            default:
	                System.out.println("Invalid option");   
			}
		}
	}
	
	/**
	 * View appointments with doctorID matching the logged in doctor
	 */
	public void viewPersonalAppts() {
		ArrayList<Appointment> myAppts = FindBy.apptDoctorID(apptDB.getDB(), session.getActiveUser().getID());
		System.out.println("Your Schedule:");
		System.out.println(myAppts);
	}
	
	/**
	 * Schedule an open appointment
	 */
	public void scheduleOpenAppt() {
		//patientID will be null until patient shows up to book it, then the id gets added
		
		System.out.println("Opening appointment slot...");
		
		Appointment appt = new Appointment();
		
		System.out.println("Day:");
		int day = sc.nextInt();
		System.out.println("Month:");
		int month = sc.nextInt();
		System.out.println("Year:");
		int year = sc.nextInt();
		
		appt.setDate(year, month, day);
		
		System.out.println("Hour:");
		int hour = sc.nextInt();
		System.out.println("Minute:");
		int minute = sc.nextInt();
		
		appt.setTime(hour, minute);
		
		appt.setDoctorID(session.getActiveUser().getID());
		
		apptDB.add(appt);
		System.out.println(String.format("Open Slot @ %d-%d-%d %d:%d Scheduled!", year, month, day, hour, minute));
	}
	
	/**
	 * See all pending appointments and either confirm or cancel by appointment id
	 */
	public void confirmOrCancelPendingAppt() {
		//This let's them see appointments so they can either confirm or decline
		ArrayList<Appointment> pendingAppts = FindBy.status(apptDB.getDB(), Status.PENDING);
		pendingAppts = FindBy.apptDoctorID(pendingAppts, session.getActiveUser().getID());
		
		System.out.println("Appointments pending confirmation:");
		System.out.println(pendingAppts);
		
		if (pendingAppts.size() <= 0) {
			System.out.println("No Pending Appointments!");
			return;
		}
		
		int input;
		String selectedApptID;
		ArrayList<Appointment> selectedAppts;
	
		System.out.println("1) Accept Appointment");
		System.out.println("2) Cancel Appointment");
		input = sc.nextInt();
		
		switch (input) {
		case 1:
			System.out.println("Enter Appointment ID:");
			selectedApptID = sc.next();
			selectedAppts = FindBy.id(apptDB.getDB(), selectedApptID);
			if (selectedAppts.isEmpty()) {
				System.out.println("Invalid Appointment ID!");
			}
			else {
				selectedAppts.get(0).setStatus(Status.CONFIRMED);
			}
			
			break;
		case 2:
			System.out.println("Enter Appointment ID:");
			selectedApptID = sc.next();
			selectedAppts = FindBy.id(apptDB.getDB(), selectedApptID);
			if (selectedAppts.isEmpty()) {
				System.out.println("Invalid Appointment ID!");
			}
			else {
				selectedAppts.get(0).setStatus(Status.OPEN);
				selectedAppts.get(0).setPatientID(null);
			}
			
			break;
		}
	}
	
	/**
	 * prints all upcoming appointments of logged in doctor
	 */
	public void viewUpcomingAppts() {
		ArrayList<Appointment> myAppts = FindBy.apptDoctorID(apptDB.getDB(), session.getActiveUser().getID());
		
		ArrayList<Appointment> confirmedAppts = new ArrayList<Appointment>();
		
		confirmedAppts = FindBy.status(myAppts, Status.CONFIRMED);
		
		System.out.println("Your Confirmed Appointments:");
		System.out.println(confirmedAppts);
	}
	
	/**
	 * complete an appointment and generate appropriate appointment outcome record
	 */
	public void completeAppt() {
		String selectedApptID;
		ArrayList<Appointment> selectedAppt;
		
		viewUpcomingAppts();
		
		ArrayList<Appointment> myAppts = FindBy.apptDoctorID(apptDB.getDB(), session.getActiveUser().getID());
		ArrayList<Appointment> confirmedAppts = new ArrayList<Appointment>();
		confirmedAppts = FindBy.status(myAppts, Status.CONFIRMED);
		
		if (confirmedAppts.isEmpty()) {
			System.out.println("No Confirmed Appointments");
			return;
		}
		
		System.out.println("Enter Appointment ID:");
		selectedApptID = sc.next();
		selectedAppt = FindBy.id(apptDB.getDB(), selectedApptID);
		
		if (selectedAppt.isEmpty()) {
			System.out.println("Invalid Appointment ID!");
		}
		else {
			Appointment a = selectedAppt.get(0);
			a.setStatus(Status.COMPLETED);
			
			//Create Outcome Record
			String service;
			System.out.println("Service provided:");
			service = sc.next();
			sc.nextLine();
			
			String note;
			System.out.println("Notes:");
			note = sc.next();
			sc.nextLine();
			
			ApptOutRecord apptOut = new ApptOutRecord(a.getID());
			apptOut.setService(service);
			apptOut.setNotes(note);
			
			apptOut.setDate(a.getDate());
			
			int input;
			do {
				System.out.println("1) Add Medicine");
				System.out.println("2) Quit");
				input = sc.nextInt();
				
				if (input >= 2) {
					break;
				}
				
				//Create PrescribedMedicine
				
				inventoryDB.view();
				
				String medID;
				System.out.println("Medicine ID:");
				medID = sc.next();
				sc.nextLine();
				
				//Check if the ID is valid
				ArrayList<StockedMedicine> check = FindBy.id(inventoryDB.getDB(), medID);
				if (check.isEmpty()) {
					System.out.println("Invalid ID!");
				}
				else {
					StockedMedicine med = check.get(0);
                	String name = med.getMedName();
                	
                	int dose;
    				System.out.println("Dosage:");
    				dose = sc.nextInt();
    				sc.nextLine();
    				
    				apptOut.addPrescription(medID, name, dose);
				}
			} while (input < 2);
			
			//Add the record to the DB
			apptOutDB.add(apptOut);
		}
	}
}
