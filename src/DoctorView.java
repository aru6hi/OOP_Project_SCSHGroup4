import java.util.Scanner;

/**
 * Prints menu for doctor
 */
public class DoctorView implements View{
	Scanner sc;
	DoctorController dCon;
	
	/**
	 * Creates a new DoctorView object
	 * @param sc scanner for input
	 * @param aCon Controller that will receive the inputs
	 */
	public DoctorView(Scanner sc, DoctorController dCon) {
		this.sc = sc;
		this.dCon = dCon;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void printMenu() {
		int option;
		
		do {
			System.out.println("1. View Patient Medical Records");
			System.out.println("2. Update Patient Medical Records");
			System.out.println("3. View Personal Schedule");
			System.out.println("4. Set Availability for Appointments");
			System.out.println("5. Accept or Decline Appointment Requests");
			System.out.println("6. View Upcoming Appointments");
			System.out.println("7. Record Appointment Outcome");
			System.out.println("8. Return to login page");
		
			System.out.print("Enter your choice: ");
	        option = sc.nextInt();
	        sc.nextLine(); 
	        
	        chooseOption(option);
		} while (option<8);
        
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void chooseOption(int option) {
		dCon.choose(option);
	}
}
