import java.util.Scanner;
import java.util.ArrayList;

public class LoginController implements Controller{
	private Scanner sc;
	private AccountDB acctDB;
	private CurrentSession session;
	
	public CurrentSession getSession() {
		return session;
	}

	public void setSession(CurrentSession session) {
		this.session = session;
	}

	public LoginController(Scanner sc, AccountDB acctDB, CurrentSession session) {
		this.sc = sc;
		this.acctDB = acctDB;
		this.session = session;
	}
	
	public void choose(int option) {
		switch (option) {
        case 1:
        	login();
        	break;
        case 2:
        	logout();
        	break;
        }
	}
	
	//On login will update session object with active user
	public void login() {
		
		System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter role (DOCTOR, PATIENT, PHARMACIST): ");
        String roleInput = sc.nextLine().toUpperCase();
        Role role;
        
        try {
            role = Role.valueOf(roleInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid role entered. Login failed.");
            return;
        }

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        // Search for user in the array
        //ArrayList<Account> accountsWithRole = FindBy.role(acctDB.getDB(), role);
        ArrayList<Account> accountsWithIDAndRole = FindBy.id(FindBy.role(acctDB.getDB(), role), id);
        
        if (accountsWithIDAndRole.isEmpty()) {
        	System.out.println("No such Account! Login Failed.");
        	return;
        }
        
        Account acct = accountsWithIDAndRole.get(0);
        if (SecurityTools.authenticatePassword(acct, password)) {
        	System.out.println("Login Successful!");
        	session.setActiveUser(acct); //MAke my guy the current session user
        }
        
        //change default password on first login
        if (password.equals("password")) {
        	 System.out.print("Enter new password: ");
        	 password = sc.nextLine();
        	 
        	 acct.setPassword(password);
        }
        return;
	}
	
	
	public void logout() {
		session.setActiveUser(null);
		System.out.println("Logged Out");
	}
}
