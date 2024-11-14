import java.util.Scanner;

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

	public InventoryReplenishment createRequest(Scanner sc, InventoryManager inventory){
		System.out.println("Which medicine would you like to replenish?");
		String medName = sc.next();

		if (inventory.getMedicine == null){
			System.out.println("Invalid input. Exiting replenishment request...")
			return null;
		}
		
		System.out.println("Input replenishment amount:");
		int reqAmount = sc.nextInt();

  		InventoryReplenishment req = inventory.newRequest(medName,reqAmount);
  		System.out.println("Request for " + reqAmount + " of " + medName + "has been created");
  		return req;
 	}

 	public void updatePrescriptionStatus(Scanner sc, ApptOutcomeMgr apptoutcomemgr){
		System.out.println("Enter Appointment ID:");
		selectedApptID = sc.next();
		selectedAppt = apptoutcomemgr.findByApptID(selectedApptID);
		for (PrescribedMedicine med : Prescription ) { 
			dosageToSubtract = med.getDosage();
			med.updateCurrentStock(med.getCurrentStock() + dosageToSubtract); 
		}
		apptoutcomemgr.completeApptOutRecord(selectedAppt);
		System.out.println("Prescription Status for " + selectedApptID + "has been updated to COMPLETED.");
		return;
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
