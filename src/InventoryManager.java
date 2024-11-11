import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class InventoryManager {
	private Map<String, Medicine> medMap;
	private ArrayList<InventoryReplenishment> reqs; 
	
	public InventoryManager() {
		this.medMap = new HashMap<>();
		this.reqs = new ArrayList<>();
	}

	public void initializeInventory(){
		
		try {
			File medicineList = new File("Data Files\\Medicine_List.xlsx");
			Scanner scMedList = new Scanner(medicineList);
			
			while (scMedList.hasNextLine()) {
				String data = scMedList.nextLine();
				
				String[] values = data.split(",");
				
				String medName = values[0];
				int currentStock = Integer.parseInt(values[1]);
				int stockThreshold = Integer.parseInt(values[2]);
				
				Medicine medicine = new Medicine(medName, currentStock, stockThreshold);
				medMap.put(medName, medicine);
				System.out.println(data);
			}
			
			scMedList.close();
			
		} catch (FileNotFoundException e) {
	        System.out.println("Patient List file not found!");
	    }

	} 

	public Medicine getMedicine(String medName) {
        return medMap.get(medName); 
    }

	public InventoryReplenishment newRequest(String medName, int reqAmount) {
		InventoryReplenishment req = new InventoryReplenishment(medName, reqAmount);
		reqs.add(req);
		return req;
	}

	public void approveReq(String reqID){
		for (InventoryReplenishment req : reqs){
			if (req.getReqID().equals(reqID) && req.getReqStatus() == Status.PENDING){
				Medicine medicine = getMedicine(req.getMedicineName());
				if (medicine != null){
					medicine.updateCurrentStock(req.getReqAmount());
					req.requestApprove();
				}
			}
		}
	}
	
	public void printLowStockMeds(){
		System.out.println("Medicines low on stock: \n");
		for (Medicine medicine: medMap.values()){
			if (medicine.shouldAlert()){
				System.out.println(medicine.getMedName());
			}
		}
	}
	
 	public void printInventory(){
  		System.out.println("Medicine Inventory List: \n");
  		for (Medicine medicine: medMap.values()){
   			System.out.println(medicine);
  		}
 	}

}	

