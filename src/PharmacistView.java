import java.util.Scanner;

public class PharmacistView implements View{
	Scanner sc;
	PharmacistController con;
	
	public PharmacistView(Scanner sc, PharmacistController con) {
		this.sc = sc;
		this.con = con;
	}
	
	public void printMenu() {
		int option;
		
		do {
		System.out.println("1. View All Appointment Outcome Record ");
		System.out.println("2. View Pending Appointment Outcome Record ");
		System.out.println("3. Update Prescription Status");
		System.out.println("4. View Medication Inventory");
		System.out.println("5. Submit Replenishment Request");
		System.out.println("6. Return to login page");
		
		System.out.print("Enter your choice: ");
        option = sc.nextInt();
        sc.nextLine(); 
        
        chooseOption(option);
		} while (option<6);
        
	}
	
	public void chooseOption(int option) {
		con.choose(option);
	}
}
