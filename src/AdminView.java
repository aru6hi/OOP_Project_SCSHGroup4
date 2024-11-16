import java.util.Scanner;

/**
 * Prints menus for admin
 */
public class AdminView implements View{
	private Scanner sc;
	private AdminController aCon;
	
	/**
	 * Creates a new AdminView object
	 * @param sc scanner for input
	 * @param aCon AdminController that will receive the inputs
	 */
	public AdminView(Scanner sc, AdminController aCon) {
		this.sc = sc;
		this.aCon = aCon;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void printMenu() {
		int option;
		
		do {
		System.out.println("1. View Staff Records");
		System.out.println("2. Add Staff");
		System.out.println("3. Remove Staff");
		System.out.println("4. Update Staff");
		System.out.println("5. View All Appointments");
		System.out.println("6. View Inventory");
		System.out.println("7. Update Inventory Stock");
		System.out.println("8. Update Inventory Low Level Alert");
		System.out.println("9. Approve Replenishment Request");
		System.out.println("10. View Low Stock");
		System.out.println("11. Return to login page");
		
		System.out.print("Enter your choice: ");
        option = sc.nextInt();
        sc.nextLine(); 
        
        chooseOption(option);
		} while (option<11);
        
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void chooseOption(int option) {
		aCon.choose(option);
	}
}
