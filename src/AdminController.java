import java.util.Scanner;
import java.util.ArrayList;

/**
 * Controller unit for Administrator functions
 */
public class AdminController implements Controller{
	private Scanner sc;
	private ApptDB apptDB;
	private InventoryDB inventoryDB;
	private AccountDB acctDB;
	private StaffRecordDB staffDB;
	private ReplenishmentDB replenishDB;
	
	/**
	 * creates a admin controller with access to the databases it needs
	 * @param sc Scanner for input
	 * @param apptDB appointment database
	 * @param inventoryDB inventory database
	 * @param acctDB account database
	 * @param replenishDB replenishment request database
	 * @param staffDB staff records database
	 */
	public AdminController(Scanner sc, ApptDB apptDB, InventoryDB inventoryDB, AccountDB acctDB, ReplenishmentDB replenishDB, StaffRecordDB staffDB) {
		this.sc = sc;
		this.apptDB = apptDB;
		this.inventoryDB = inventoryDB;
		this.acctDB = acctDB;
		this.replenishDB = replenishDB;
		this.staffDB = staffDB;
	}
	
	/**
	 * {@inheritDoc}}
	 */
	public void runChosenOption(int option) {
		switch (option) {
        case 1:
        	viewStaff();
        	break;
        case 2:
        	addStaff();
        	break;
        case 3:
        	removeStaff();
        	break;
        case 4:
        	updateStaff();
        	break;
        case 5:
        	viewAppts();
        	break;
        case 6:
        	viewInventory();
        	break;
        case 7:
        	updateStock();
        	break;
        case 8:
        	updateLowLevelAlert();
        	break;
        case 9:
        	approveReplenishment();
        	break;
        case 10:
        	viewLowStock();
        	break;
        }
	}
	
	/**
	 * prints all staff records
	 */
	public void viewStaff() {
		System.out.println("Hospital Staff List:");
        System.out.println(staffDB.getDB());
	}
	
	/**
	 * Adds staff account and record
	 */
	public void addStaff() {
		//Need to create account and add record
		
		//Create account
		Account newAcct = new Account();
		String id = newAcct.getID();
		
		System.out.print("Enter role (DOCTOR, PHARMACIST): ");
		String roleInput = sc.nextLine().toUpperCase();
		
		Role role;
	    
        // Validate role input
		try {
			role = Role.valueOf(roleInput);
		} 
		catch (IllegalArgumentException e) {
			System.out.println("Invalid role entered. Staff addition failed.");
			return;
        }
		
		//Replace placeholder prefix, with appropriate role prefix
		id.replace("U", role.getPrefix());
		newAcct.setID(id); //VERY IMPORTANT
		
		//Give them appropriate roles
		newAcct.setRole(role);
		newAcct.setRole(Role.STAFF);
		
		//Create Staff Record
		System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();  // Consume the newline character
    
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        
        StaffRecord staffRec = new StaffRecord(id);
        staffRec.setGender(gender);
        staffRec.setName(name);
        staffRec.setAge(age);
        
        staffDB.add(staffRec);
	}
	
	/**
	 * Remove staff account and record
	 */
	public void removeStaff() {
		System.out.println("Enter id of staff member to be removed: ");
		String id = sc.nextLine();
		
		//Find Record to purge
		ArrayList<StaffRecord> a = new ArrayList<>();
		ArrayList<Account> b = new ArrayList<>();
		a = FindBy.id(staffDB.getDB(), id);
		b = FindBy.id(acctDB.getDB(), id);
		
		if (a.isEmpty() || b.isEmpty()) {
			System.out.println("No such id!");
			return;
		}
		
		//Purge and destroy
		acctDB.remove(b.get(0));
		staffDB.remove(a.get(0));

		System.out.println(id + " has been removed successfully.");
	}
	
	/**
	 * update staff record
	 */
	public void updateStaff() {
		System.out.println("Enter id of staff member to be updated: ");
		String id=sc.nextLine();
		
		System.out.println("Enter new age of staff member to be updated: ");
		int age = sc.nextInt();
		
		ArrayList<StaffRecord> a = new ArrayList<>();
		a = FindBy.id(staffDB.getDB(), id);

		if (!a.isEmpty()){
			a.get(0).setAge(age);
			System.out.println("Staff Member's age updated successfully.");
		} else {
			System.out.println("Staff Member not found or role mismatch.");
		}
	}
	
	/**
	 * prints all appointments
	 */
	public void viewAppts() {
		System.out.println("All Appointments:");
		System.out.println(apptDB.getDB());
	}
	
	/**
	 * prints inventory
	 */
	public void viewInventory() {
		System.out.println("Inventory:");
		System.out.println(inventoryDB.getDB());
	}
	
	/**
	 * update stock in of medicine in inventory
	 */
	public void updateStock() {
		
		viewInventory();
		
		System.out.println("Enter ID:");
		String id = sc.next();
		sc.nextLine();
		
		System.out.println("Set new amount:");
		int newAmount = sc.nextInt();

		ArrayList<StockedMedicine> a = new ArrayList<>();
		a = FindBy.id(inventoryDB.getDB(), id);

		if (!a.isEmpty()){
			a.get(0).setCurrentStock(newAmount);
			System.out.println("Stock updated successfully.");
		} else {
			System.out.println("Invalid ID");
		}
	}
	
	/**
	 * update low level alert of medicine in inventory
	 */
	public void updateLowLevelAlert() {
		
		viewInventory();
		
		System.out.println("Enter ID:");
		String id = sc.next();
		sc.nextLine();
		
		System.out.println("Set new alert level:");
		int newAmount = sc.nextInt();

		ArrayList<StockedMedicine> a = new ArrayList<>();
		a = FindBy.id(inventoryDB.getDB(), id);

		if (!a.isEmpty()){
			a.get(0).setAlertLimit(newAmount);
			System.out.println("Alert Level updated successfully.");
		} else {
			System.out.println("Invalid ID");
		}
	}
	
	/**
	 * prints all replenishment requests
	 */
	public void viewReplenishment() {
		System.out.println(replenishDB.getDB());
	}
	
	/**
	 * approves replenishment requests and update inventory accordingly
	 */
	public void approveReplenishment() {
		viewReplenishment();
		
		System.out.println("Enter Request ID:");
		String id = sc.next();

		ArrayList<ReplenishmentRequest> a = new ArrayList<>();
		a = FindBy.id(replenishDB.getDB(), id);
		
		if (a.isEmpty()) {
			System.out.println("Invalid Replenishment Request ID");
			return;
		}
		
		ReplenishmentRequest req = a.get(0);
		
		id = req.getMedicineID();
		ArrayList<StockedMedicine> b = new ArrayList<>();
		b = FindBy.id(inventoryDB.getDB(), id);
		
		StockedMedicine med = b.get(0);
		
		if (b.isEmpty()) {
			System.out.println("Invalid Medicine ID in request");
			return;
		}
		
		//Approve the request
		req.requestApprove();
		System.out.println("Request " + a.get(0).getID() + " Approved");
		
		//Add request amount to stock
		med.setCurrentStock(med.getCurrentStock() + req.getReqAmount());
	}
	
	/**
	 * view medicine in inventory with stock < alert limit
	 */
	public void viewLowStock() {
		System.out.println(FindBy.belowAlertLevel(inventoryDB.getDB()));
	}
}
