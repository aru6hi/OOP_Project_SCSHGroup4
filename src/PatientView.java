import java.util.Scanner;

/**
 * Prints menus for Patient
 */
public class PatientView implements View{
	
	Scanner sc;
	PatientController pCon;
	
	/**
	 * Creates a new PatientView object
	 * @param sc Scanner for taking inputs
	 * @param pCon Controller that will receive the inputs
	 */
	public PatientView(Scanner sc, PatientController pCon) {
		this.sc = sc;
		this.pCon = pCon;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void printMenu() {
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
		System.out.println("9. Return to login page");
		
		System.out.print("Enter your choice: ");
        option = sc.nextInt();
        sc.nextLine(); 
        
        chooseOption(option);
		} while (option<9);
        
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void chooseOption(int option) {
		pCon.runChosenOption(option);
	}
}
