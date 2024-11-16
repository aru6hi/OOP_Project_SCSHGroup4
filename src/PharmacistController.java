import java.util.ArrayList;
import java.util.Scanner;

public class PharmacistController implements Controller{
	private Scanner sc;
	private ReplenishmentDB replenishDB;
	private InventoryDB inventoryDB;
	private ApptOutDB apptOutDB;
	
	public PharmacistController(Scanner sc, ReplenishmentDB replenishDB, InventoryDB inventoryDB, ApptOutDB apptOutDB) {
		this.sc = sc;
		this.replenishDB = replenishDB;
		this.inventoryDB = inventoryDB;
		this.apptOutDB = apptOutDB;
	}

	public void choose(int option) {
		switch (option) {
        case 1:
        	viewApptOutRec();
        	break;
        case 2:
        	viewPendingApptOutRec();
        	break;
        case 3:
        	completePrescriptionStatus();
        	break;
        case 4:
        	viewInventory();
        	break;
        case 5:
        	submitReplenishmentRequest();
        	break;
        }
	}
	
	public void viewApptOutRec() {
		System.out.println(apptOutDB.getDB());
	}
	
	public void viewPendingApptOutRec() {
		System.out.println(FindBy.outRecStatus(apptOutDB.getDB(), Status.PENDING));
	}
	
	public void completePrescriptionStatus(){
		System.out.println("Enter Appointment Outcome Record ID:");
		String selectedApptID = sc.next();
		
		ArrayList<ApptOutRecord> a = FindBy.id(apptOutDB.getDB(), selectedApptID);

		if (a.isEmpty()) {
			System.out.println("Invalid ID!");
			return;
		}
		
		//Complete the record
		ApptOutRecord rec = a.get(0);
		rec.setStatus(Status.COMPLETED);
		
		//Deduct from inventory the amount used
		for (PrescribedMedicine p : rec.getPrescription()) {
			StockedMedicine med = FindBy.id(inventoryDB.getDB(), p.getMedicineID()).get(0);
			med.setCurrentStock(med.getCurrentStock() - p.getDosage());
		}

		System.out.println("Prescription Status for " + selectedApptID + "has been updated to COMPLETED.");
		return;
 	}
	
	public void viewInventory() {
		System.out.println("Inventory:");
		System.out.println(inventoryDB.getDB());
	}
	
	public void submitReplenishmentRequest() {
		
		viewInventory();
		
		System.out.println("Enter Medicine ID:");
		String medID = sc.next();
		sc.nextLine();
		
		ArrayList<StockedMedicine> a = FindBy.id(inventoryDB.getDB(), medID);

		if (a.isEmpty()) {
			System.out.println("Invalid ID!");
			return;
		}
		
		StockedMedicine med = a.get(0);
		
		System.out.println("Enter Request Ammount:");
		int amount = sc.nextInt();
		sc.nextLine();
		
		//Create Replenishment Request
		ReplenishmentRequest req = new ReplenishmentRequest(medID, med.getMedName(), amount);
		
		replenishDB.add(req);
		System.out.println("Request " + req.getID() + " submitted!");
	}
}
