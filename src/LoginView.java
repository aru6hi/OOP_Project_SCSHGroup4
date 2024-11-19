import java.util.Scanner;

/**
 * Prints menu for login
 */
public class LoginView implements View{
	Scanner sc;
	LoginController con;
	
	/**
	 * Creates new LoginView object
	 * @param sc scanner for input
	 * @param con controller to receive input
	 */
	public LoginView(Scanner sc, LoginController con) {
		this.sc = sc;
		this.con = con;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void printMenu() {
		int option;
		
		do {
			//Display nice current user
			Account activeUser = con.getSession().getActiveUser();
			
			if (activeUser != null) {
				System.out.println("Currently logged in: " + activeUser.getRole() + " " + activeUser.getID());
				
				System.out.println("1. Login");
				System.out.println("2. Logout ");
				System.out.println("3. Start");
			}
			else {
				System.out.println("Currently logged in: NONE");
				
				System.out.println("1. Login");
				System.out.println("2. Logout ");
				System.out.println("3. Exit");
			}
		
			System.out.print("Enter your choice: ");
	        option = sc.nextInt();
	        sc.nextLine(); 
	        
	        chooseOption(option);
	        
		} while (option<3);
        
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void chooseOption(int option) {
		con.runChosenOption(option);
	}
}
