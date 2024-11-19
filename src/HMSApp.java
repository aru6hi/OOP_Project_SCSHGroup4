import java.util.Scanner;
/**
 * Main program class
 */
public class HMSApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//Every DB
		AccountDB acctDB = new AccountDB();
		ApptDB apptDB = new ApptDB();
		ApptOutDB apptOutDB = new ApptOutDB();
		PatientRecordDB medRecDB = new PatientRecordDB();
		StaffRecordDB staffRecDB = new StaffRecordDB();
		InventoryDB inventoryDB = new InventoryDB();
		ReplenishmentDB replenishDB = new ReplenishmentDB();
		
		
		//Current Session tracker
		CurrentSession session = new CurrentSession();
		
		
		//All the Controllers
		PatientController pCon = new PatientController(sc, apptDB, apptOutDB, medRecDB, session);
		DoctorController dCon = new DoctorController(sc, apptDB, apptOutDB, medRecDB, session);
		AdminController aCon = new AdminController(sc, apptDB, inventoryDB, acctDB, replenishDB, staffRecDB);
		PharmacistController phCon = new PharmacistController(sc, replenishDB, inventoryDB, apptOutDB);
		LoginController lCon = new LoginController(sc, acctDB, session);
		
		//All the Views
		PatientView pView = new PatientView(sc, pCon);
		DoctorView dView = new DoctorView(sc, dCon);
		AdminView aView = new AdminView(sc, aCon);
		PharmacistView phView = new PharmacistView(sc, phCon);
		LoginView lView = new LoginView(sc, lCon);
		
		//Initialize from files 
		//HI HI IF YOU ARE THE TA OR PROF TESTING THE CODE
		//DO REMEMBER TO CHECK THE FILEPATH HERE IS CORRECT FOR YOUR DEVICE
		ParseFile.parseFilePatient("data\\Patient_List.csv", acctDB, medRecDB);
		ParseFile.parseFileStaff("data\\Staff_List.csv", acctDB, staffRecDB);
		ParseFile.parseFileMedicine("data\\Medicine_List.csv", inventoryDB);
		
		//Start System
		do {
			//print login menu
			lView.printMenu();
			
			Account activeUser = session.getActiveUser();
			
			
			if (activeUser == null) {
				System.out.println("No one logged in, terminating...");
				break;
			}
			
			//Print appropriate menu
			if (session.getActiveUser().hasRole(Role.PATIENT)) {
				pView.printMenu();
			}
			else if (session.getActiveUser().hasRole(Role.DOCTOR)){
				dView.printMenu();
			}
			else if (session.getActiveUser().hasRole(Role.ADMINISTRATOR)) {
				aView.printMenu();
			}
			else if (session.getActiveUser().hasRole(Role.PHARMACIST)){
				phView.printMenu();
			}
			
		} while (session.getActiveUser() != null);
	}
} 
