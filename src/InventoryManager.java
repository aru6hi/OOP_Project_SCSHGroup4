import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.Map;
import java.io.HashMap;
import java.io.ArrayList;

public class InventoryManager {
	private Map<String, Medicine> medMap;
	private ArrayList<InventoryReplenishment> reqs; 
	public int stockThreshold;
	public int currentStock;
	public String medName;
	
	public InventoryManager() {
		this.medMap = new HashMap<>();
		this.req = new ArrayList<>();
	}


	public void initializeInventory(){
		File medicineList = new File("Medicine_List.csv");
		Scanner scMedList = new Scanner(medicineList);
		
		while (scMedList.hasNextLine()) {
			String data = scMedList.nextLine();
			
			String[] values = data.split(",");
			
			medName = values[0];
			currentStock = Integer.parseInt(values[1]);
			stockThreshold = Integer.parseInt(values[2]);
			
			Medicine medicine = new Medicine(medName, currentStock, stockThreshold);
			medMap.put(medName, medicine);
			System.out.println(data);
		}
		scMedList.close();
	} 

	
	
	public String getMedicineStock(String medName, int currentStock, int stockThreshold) {
		
		if (currentStock < stockThreshold) {
			System.out.println("Stock levels are low for " + medName);
		}
		return "The current stock of " + medName + "is " + currentStock;
	}

	public InventoryReplenishment newRequest(String medName, int reqAmount) {
		InventoryReplenishment req = new InventoryReplenishment(medName, reqAmount);
		reqs.add(req);
		return req;
	}

	public void approveReq(int reqID){
		for (InventoryReplenishment req : reqs){
			if (req.getReqID() == reqID && req.getReqStatus().equals("Pending")){
				Medicine medicine = getMedMap(req.getMedicineName());
				if (medicine != NULL){
					medicine.updateCurrentStock(req.getReqAmount());
					req.approveReq();
				}
				break;
			}
		}
	}

	public Medicine getMedMap(String medName) {
        return medMap.get(medName); 
    }

	public void printLowStockMeds(){
		System.out.println("Medicines low on stock: \n");
		for (Medicine medicine: medMap.values()){
			if (currentStock < stockThreshold){
				System.out.println(getMedicineStock(medicine.getMedName()));
			}
		}
	}
 
 	public void printInventory(){
  		System.out.println("Medicine Inventory List: \n");
  		for (Medicine medicine: medMap.values()){
   			System.out.println(getMedicineStock(medicine.getMedName()));
  		}
 	}

}	

