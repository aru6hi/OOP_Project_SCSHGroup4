package HMS;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class HMSApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		User activeUser;
		HMSApp hms = new HMSApp();
		
		//Some sort of initialization of all our manager classes here
		
		
		//After login success, set activeUser to the logged in user
		
		
		//pick which menu to use
		switch (activeUser.getRole()) {
		case Role.PATIENT:
			hms.startPatientMenu(sc);
			break;
		case Role.DOCTOR:
			hms.startDoctorMenu(sc);
			break;
		case Role.PHARMACIST:
			hms.startPharmacistMenu(sc);
			break;
		case Role.ADMIN:
			hms.startAdminMenu(sc);
			break;
		default:
			System.out.println("Unknown Role");
		}
		
		
		//After exiting whole program
		sc.close();
	}
	
	/*
	 * These guys might all need more params like the manager objects
	 * Placeholders for now
	 */
	public void startLoginMenu(Scanner sc) {
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
                    break;
                case 2:
                    //Login here
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
	
	public void startPatientMenu(Scanner sc) {
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
            	break;
            case 2:
            	break;
            case 3:
            	break;
            case 4:
            	break;
            case 5:
            	break;
            case 6:
            	break;
            case 7:
            	break;
            case 8:
            	break;
            case 9:
            	break;
            }
            
		} while (option < 10 && option > 0);
	}
	
	public void startDoctorMenu(Scanner sc) {
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
            	break;
            case 2:
            	break;
            case 3:
            	break;
            case 4:
            	break;
            case 5:
            	break;
            case 6:
            	break;
            case 7:
            	break;
            case 8:
            	break;
            }
            
		} while (option < 9 && option > 0);
	}
	
	public void startPharmacistMenu(Scanner sc) {
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
            	break;
            case 2:
            	break;
            case 3:
            	break;
            case 4:
            	break;
            case 5:
            	break;
           
            }
            
		} while (option < 6 && option > 0);
	}
	
	public void startAdminMenu(Scanner sc) {
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
            	break;
            case 2:
            	break;
            case 3:
            	break;
            case 4:
            	break;
            case 5:
            	break;
            }
            
		} while (option < 6 && option > 0);
	}	
}
