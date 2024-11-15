import java.util.Scanner;

public class HMSApp {
	
	private User activeUser;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HMSApp hms = new HMSApp();
		
		//Some sort of initialization of all our manager classes here
		AccountManager acctMgr = new AccountManager();
		ApptMgr apptMgr = new ApptMgr();
		ApptOutcomeMgr apptOutMgr = new ApptOutcomeMgr();
		InventoryManager inventory = new InventoryManager();
		MedicalRecordMgr medRecMgr = new MedicalRecordMgr();
		
		//After login success, set activeUser to the logged in user
		hms.startLoginMenu(sc, acctMgr);
		
		//pick which menu to use
		switch (hms.getActiveUser().getRole()) {
		case Role.PATIENT:
			Patient p = (Patient) hms.getActiveUser();
			hms.startPatientMenu(p, sc, apptMgr, apptOutMgr, medRecMgr);
			break;
		case Role.DOCTOR:
			Doctor d=(Doctor) hms.getActiveUser();
			hms.startDoctorMenu(d,sc,apptMgr,apptOutMgr,medRecMgr);
			break;
		case Role.PHARMACIST:
			Pharmacist ph=(Pharmacist) hms.getActiveUser();
			hms.startPharmacistMenu(ph,sc,apptOutMgr,inventory);
			break;
		case Role.ADMINISTRATOR:
			Admin a=(Admin) hms.getActiveUser();
			hms.startAdminMenu(a,sc,inventory);
			break;
		default:
			System.out.println("Unknown Role");
		}
		//Need some sort of loop here to return to login menu
		
		
		//After exiting whole program
		sc.close();
	}
	
	/*
	 * These guys might all need more params like the manager objects
	 * Placeholders for now
	 */
	public void startLoginMenu(Scanner sc, AccountManager acctMgr) {
		boolean exit = false;

        while (!exit) {
            System.out.println("Choose one of the following options:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int option = sc.nextInt();
            sc.nextLine(); 

            switch (option) {
                case 1:
                    // Register here
                	acctMgr.register(sc);
                    break;
                case 2:
                    //Login here
                	this.activeUser = acctMgr.login(sc);
                	
                	//If successfully logged in, move to next step
                	if (this.activeUser != null) {
                		exit = true;
                	}
                	
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
	}
	
	public void startPatientMenu(Patient p, Scanner sc, ApptMgr apptMgr, ApptOutcomeMgr apptOutMgr, MedicalRecordMgr medRecMgr) {
		int option;
		do {
			System.out.println("1. View Medical Record");
			System.out.println("2. Update Personal Information");
			System.out.println("3. View Available Appointment Slots");
			System.out.println("4. Schedule an Appointment");
			System.out.println("5. Reschedule an Appointment");
			System.out.println("6. Cancel an Appointment");
			System.out.println("7. View Scheduled Appointments");
			System.out.println("8. View Past Appointment Outcome Records");
			System.out.println("9. Logout");
			
			System.out.print("Enter your choice: ");
            option = sc.nextInt();
            sc.nextLine(); 
            
            switch (option) {
            case 1:
            	p.viewMedicalRecord(medRecMgr);
            	break;
            case 2:
            	p.updatePersonalInfo(sc);
            	break;
            case 3:
            	p.viewAvailableAppt(apptMgr);
            	break;
            case 4:
            	p.bookAppt(sc, apptMgr);
            	break;
            case 5:
            	p.rescheduleAppt(sc, apptMgr);
            	break;
            case 6:
            	p.cancelAppt(sc, apptMgr);
            	break;
            case 7:
            	p.viewScheduledAppt(apptMgr);
            	break;
            case 8:
            	p.viewApptOutRecord(apptMgr, apptOutMgr);
            	break;
            case 9:
            	break;
            }
            
		} while (option < 10 && option > 0);
	}
	
	public void startDoctorMenu(Doctor d, Scanner sc, ApptMgr apptMgr, ApptOutcomeMgr apptOutMgr, MedicalRecordMgr medRecMgr) {
		int option;
		do {
			System.out.println("1. View Patient Medical Records");
			System.out.println("2. Update Patient Medical Records");
			System.out.println("3. View Personal Schedule");
			System.out.println("4. Set Availability for Appointments");
			System.out.println("5. Accept or Decline Appointment Requests");
			System.out.println("6. View Upcoming Appointments");
			System.out.println("7. Record Appointment Outcome");
			System.out.println("8. Logout ");
			
			System.out.print("Enter your choice: ");
            option = sc.nextInt();
            sc.nextLine(); 
            
            switch (option) {
            case 1:
				d.getPatientHistory(sc, medRecMgr);
            	break;
            case 2:
				d.updateMedicalRecord(sc,medRecMgr);
            	break;
            case 3:
				d.viewPersonalAppts(sc,apptMgr);
            	break;
            case 4:
				d.scheduleOpenAppt(sc,apptMgr);
            	break;
            case 5:
				d.confirmOrCancelPendingAppt(sc,apptMgr);
            	break;
            case 6:
				d.viewUpcomingAppts(sc,apptMgr);
            	break;
            case 7:
				d.completeAppt(sc,apptMgr,apptOutMgr);
            	break;
            case 8:
            	break;
            }
            
		} while (option < 9 && option > 0);
	}
	
	public void startPharmacistMenu(Pharmacist ph, Scanner sc, ApptOutcomeMgr apptOutMgr, InventoryManager inventory) {
		int option;
		do {
			System.out.println("1. View Appointment Outcome Record");
			System.out.println("2. Update Prescription Status");
			System.out.println("3. View Medication Inventory");
			System.out.println("4. Submit Replenishment Request");
			System.out.println("5. Logout");
			
			System.out.print("Enter your choice: ");
            option = sc.nextInt();
            sc.nextLine(); 
            
            switch (option) {
            case 1:
				apptOutMgr.viewAll();
            	break;
            case 2:
				ph.updatePrescriptionStatus(sc, apptOutMgr)
            	break;
            case 3:
				ph.viewInventory();
            	break;
            case 4:
				ph.createRequest(sc, inventory);
            	break;
            case 5:
            	break;
           
            }
            
		} while (option < 6 && option > 0);
	}
	
	public void startAdminMenu(Admin a, Scanner sc, InventoryManager inventory,HMSApp hms, AccountManager acctMgr) {
		int option;
		do {
			System.out.println("1. View and Manage Hospital Staff");
			System.out.println("2. View Appointments details");
			System.out.println("3. View and Manage Medication Inventory");
			System.out.println("4. Approve Replenishment Requests");
			System.out.println("5. Logout");
			
			System.out.print("Enter your choice: ");
            option = sc.nextInt();
            sc.nextLine(); 
            
            switch (option) {
            case 1:
				a.adminStaffMenu(a,sc,acctMgr,hms,inventory);
            	break;
            case 2:
            	break;
            case 3:
				a.adminInventoryMenu(sc, inventory);
            	break;
            case 4:
				a.approveReplenishment(sc, inventory);
            	break;
            case 5:
			    System.out.println("Exiting the Application. Thank you!");
            	break;
            }
            
		} while (option < 6 && option > 0);
	}	
	
	
	public User getActiveUser() {
		return this.activeUser;
	}
}
