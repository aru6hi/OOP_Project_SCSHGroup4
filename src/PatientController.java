import java.util.Scanner;
import java.util.ArrayList;

/**
 * Controller unit for Patient functions
 */
public class PatientController implements Controller{
	private Scanner sc;
	private ApptDB apptDB;
	private ApptOutDB apptOutDB;
	private PatientRecordDB medRecDB;
	private CurrentSession session;
	
	/**
	 * Creates a new PatientController
	 * @param sc Scanner for input
	 * @param apptDB appointment database to work on
	 * @param apptOutDB appointment outcome database to work on
	 * @param medRecDB medical record database to work on
	 * @param session Current active session
	 */
	public PatientController(Scanner sc, ApptDB apptDB, ApptOutDB apptOutDB, PatientRecordDB medRecDB, CurrentSession session) {
		this.sc = sc;
		this.apptDB = apptDB;
		this.apptOutDB = apptOutDB;
		this.medRecDB = medRecDB;
		this.session = session;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void choose(int option) {
		switch (option) {
        case 1:
        	viewMedicalRecord();
        	break;
        case 2:
        	updatePersonalInfo();
        	break;
        case 3:
        	viewAvailableAppt();
        	break;
        case 4:
        	bookAppt();
        	break;
        case 5:
        	rescheduleAppt();
        	break;
        case 6:
        	cancelAppt();
        	break;
        case 7:
        	viewScheduledAppt();
        	break;
        case 8:
        	viewPastApptOutRecord();
        	break;
        case 9:
        	break;
        }
	}
	
	private PatientRecord findMyRecord() {
		ArrayList<PatientRecord> a = new ArrayList<>();
		a = FindBy.id(medRecDB.getDB(), session.getActiveUser().getID());
		
		if (a.isEmpty()) {
			System.out.println("No Records Found!");
			return null;
		}
		return a.get(0);
	}
	
	/**
	 * View personal medical record
	 */
	public void viewMedicalRecord() {
		System.out.println(findMyRecord());
	}
	
	/**
	 * Update personal info
	 */
	public void updatePersonalInfo() {
		PatientRecord myRec = findMyRecord();
		viewMedicalRecord();
		
		System.out.println("What would you like to update?");
		System.out.println("1. Email");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Enter new email:");
			String email = sc.next();
			sc.nextLine();
			
			myRec.setEmail(email);
			break;
		default:
			System.out.println("Invalid Choice");
		}
	}
	
	/**
	 * View open appointments
	 * @return ArrayList of all open appointments
	 */
	public ArrayList<Appointment> viewAvailableAppt() {
		ArrayList<Appointment> a = new ArrayList<>();
		a = FindBy.status(apptDB.getDB(), Status.OPEN);
		if (a.isEmpty()) {
			System.out.println("No Available Appointment!");
		}
		System.out.println(a);
		return a;
	}
	
	/**
	 * Book an open appointment
	 */
	public void bookAppt() {
		
		ArrayList<Appointment> a = new ArrayList<>();
		a = viewAvailableAppt();
		
		if (!a.isEmpty()) {
			System.out.println("Enter Appointment ID to book:");
			String selectedApptID = sc.next();
			sc.nextLine();
			
			a = FindBy.id(apptDB.getDB(), selectedApptID);
			
			if (a.isEmpty()) {
				System.out.println("Invalid Appointment ID!");
			}
			else {
				Appointment appt = a.get(0);
				appt.setStatus(Status.PENDING);
				appt.setPatientID(session.getActiveUser().getID());
				System.out.println("Appointment pending confirmation!");
			}
		}
	}
	
	/**
	 * view booked appointments
	 * @return ArrayList containing personal booked appointments
	 */
	public ArrayList<Appointment> viewScheduledAppt() {
		ArrayList<Appointment> a = new ArrayList<>();
		a = FindBy.apptPatientID(apptDB.getDB(), session.getActiveUser().getID());
		if (a.isEmpty()) {
			System.out.println("No Scheduled Appointment!");
		}
		System.out.println(a);
		return a;
	}
	
	/**
	 * Cancel an appointment
	 */
	public void cancelAppt() {
		ArrayList<Appointment> a = new ArrayList<>();
		a = viewScheduledAppt();
		
		if (!a.isEmpty()) {
			System.out.println("Enter Appointment ID:");
			String selectedApptID = sc.next();
			sc.nextLine();
			
			a = FindBy.id(apptDB.getDB(), selectedApptID);
			
			if (a.isEmpty()) {
				System.out.println("Invalid Appointment ID!");
			}
			else {
				a.get(0).setStatus(Status.OPEN);
				System.out.println("Appointment cancelled!");
			}
		}
	}
	
	/**
	 * Reschedule an appointment
	 */
	public void rescheduleAppt() {
		//Cancel Old
		cancelAppt();
		
		//Booking new
		bookAppt();
	}
	
	/**
	 * view past appointment outcome records
	 */
	public void viewPastApptOutRecord() {
		ArrayList<Appointment> myAppts = FindBy.apptPatientID(apptDB.getDB(), session.getActiveUser().getID());
		
		ArrayList<Appointment> myCompletedAppts = new ArrayList<Appointment>();
		
		ArrayList<ApptOutRecord> myApptOutRecords = new ArrayList<ApptOutRecord>();
		
		myCompletedAppts = FindBy.status(myAppts, Status.COMPLETED);
		
		for (Appointment appt : myCompletedAppts) {
			ArrayList<ApptOutRecord> a = FindBy.id(apptOutDB.getDB(), appt.getID());
			myApptOutRecords.addAll(a);
		}
		
		System.out.println("Past Outcome Records:");
		System.out.println(myApptOutRecords);
	}
}
