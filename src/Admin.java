
public class Admin extends User{
	private String name;
	private String gender;
	private int age;
	
	public Admin(String ID, String name, String gender, int age) {
		super(ID, Role.ADMIN);
		
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public injectInventory(InventoryManager inventory){
  		this.inventory = inventory;
 	} //we need something like pharmacist.setInventory(inventory); in mainapp

	public void viewInventory(){
  		inventory.printInventory();
 	}

	public void approveReplenishment(int reqID){
		InventoryReplenishment req = inventory.approveReq(reqID);
		System.out.println("Replenishment Request #" + req.getReqID()+" is approved");
	}

	public void updateAlertAdmin(String medName, int newAmount){
		Medicine medicine = inventory.getMedicine(medName);
		medicine.updateAlertLimit(newAmount); 
		System.println(medName + " alert levels updated to " + newAmount);
		//newAmount is the how much you want to alert to be 	
	}


	public void updateStockAdmin(String medName, int newAmount){
		Medicine medicine = inventory.getMedicine(medName);
		medicine.updateCurrentStock(newAmount); 
		System.println(medName + " has been replenished to " + newAmount);
		//newAmount is the how much you want to replenish till 	
	}

	public void addStockAdmin(String medName, int byAmount){
		Medicine medicine = inventory.getMedicine(medName);
		medicine.updateCurrentStock(newAmount + byAmount); 
		System.println(byAmount + " of " + medName + " has been added");	
	}

	public void removeStockAdmin(String medName, int byAmount){
		Medicine medicine = inventory.getMedicine(medName);
		medicine.updateCurrentStock(newAmount - byAmount); 
		System.println(byAmount + " of "medName + " has been removed");
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
