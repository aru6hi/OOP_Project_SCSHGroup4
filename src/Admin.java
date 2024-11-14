
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
