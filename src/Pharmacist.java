public class Pharmacist extends User{
	private String name;
	private String gender;
	private int age;
	private InventoryManager inventory;
	
	public Pharmacist(String ID, String name, String gender, int age) {
		super(ID, Role.PHARMACIST);

		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public void injectInventory(InventoryManager inventory){
  		this.inventory = inventory;
 	} //we need something like pharmacist.setInventory(inventory); in mainapp

	public void viewInventory(){
  		inventory.printInventory();
 	}

	public InventoryReplenishment createRequest(String medName, int reqAmount){
  		InventoryReplenishment req = inventory.newRequest(medName,reqAmount);
  		System.out.println("Request for " + reqAmount + " of " + medName + "has been created");
  		return req;
 	}

 	public void updatePrescriptionStatus(){
  		//To be added;
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
