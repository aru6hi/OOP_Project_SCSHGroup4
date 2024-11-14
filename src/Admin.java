import java.util.Scanner;

public class Admin extends User{
	private String name;
	private String gender;
	private int age;
	
	public Admin(String ID, String name, String gender, int age) {
		super(ID, Role.ADMINISTRATOR);
		
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	
	public void approveReplenishment(Scanner sc, InventoryManager inventory){
		System.out.println("Enter Request ID:");
		String reqID = sc.next();

		InventoryReplenishment req = inventory.findByReqID(reqID);
		inventory.approveReq(req);
		System.out.println("Replenishment Request #" + req.getReqID()+" is approved");
	}

	public void updateAlertAdmin(Scanner sc, InventoryManager inventory){
		System.out.println("Enter Medicine Name:");
		String medName = sc.next();

		Medicine medicine = inventory.getMedicine(medName);
		System.out.println("Enter new alert limit:");
		int newAmount = sc.nextInt();

		medicine.updateAlertLimit(newAmount); 
		System.out.println(medName + " alert levels updated to " + newAmount);
		//newAmount is the how much you want to alert to be 	
	}


	public void updateStockAdmin(Scanner sc, InventoryManager inventory){
		System.out.println("Enter Medicine Name:");
		String medName = sc.next();

		Medicine medicine = inventory.getMedicine(medName);
		System.out.println("Set new amount:");
		int newAmount = sc.nextInt();

		medicine.updateCurrentStock(newAmount); 
		System.out.println(medName + " has been replenished to " + newAmount);
		//newAmount is the how much you want to replenish till 	
	}

	public void addStockAdmin(Scanner sc, InventoryManager inventory){
		System.out.println("Enter Medicine Name:");
		String medName = sc.next();

		Medicine medicine = inventory.getMedicine(medName);
		System.out.println("Enter amount to add:");
		int newAmount = sc.nextInt();
		
		medicine.updateCurrentStock(medicine.getCurrentStock() + byAmount); 
		System.out.println(byAmount + " of " + medName + " has been added");	
	}

	public void removeStockAdmin(Scanner sc, InventoryManager inventory){
		System.out.println("Enter Medicine Name:");
		String medName = sc.next();

		Medicine medicine = inventory.getMedicine(medName);
		System.out.println("Enter amount to remove:");
		int newAmount = sc.nextInt();

		medicine.updateCurrentStock(medicine.getCurrentStock() - byAmount); 
		System.out.println(byAmount + " of " + medName + " has been removed");
	}

	public void removestaff(Scanner sc, AccountManager account){
		System.out.println("Enter Staff Role to be removed (DOCTOR, PHARMACIST): ");
		String role = sc.nextLine();
		System.out.println("Enter id of staff member to be removed: ");
		String id=sc.nextLine();
		account.removeStaff(role, getRole());

		System.out.println(role + " with ID " + id + " has been removed successfully.");
	}

	public void updatestaff(Scanner sc, AccountManager account){
		System.out.println("Enter Staff Role to be updated (DOCTOR, PHARMACIST):");
		String roleinput = sc.nextLine();
		System.out.println("Enter id of staff member to be updated: ");
		String id=sc.nextLine();
		System.out.println("Enter new age of staff member to be updated: ");
		int age = sc.nextInt();
		Role role;
		User user=account.findUser(id, role);
	}

	public void addstaff(Scanner sc, AccountManager account){
		System.out.println("Enter ID for new staff member: ");
		String id = sc.nextLine();

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

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();  // Consume the newline character
    
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
 
        // Create a new User object based on the role
        User newStaff = null;
        switch (role) {
			case DOCTOR:
			newStaff = new Doctor(id, name, gender, age);
            break;
            case PHARMACIST:
            newStaff = new Pharmacist(id, name, gender, age);
            break;
            default:
            System.out.println("Unsupported role for staff member. Staff addition failed.");
            return;
        }

        // Set the password using the User class's method
        if (newStaff != null) {
			newStaff.setNewPassword(password);
			account.getUsers().add(newStaff);  // Add the new staff member to AccountManager's users list
			System.out.println(role + " account created successfully for " + name);
        }
	}

	public void viewstaff(AccountManager account){
		System.out.println("Staff List:");
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int newAge) {
		this.age = newAge;
	}
}
