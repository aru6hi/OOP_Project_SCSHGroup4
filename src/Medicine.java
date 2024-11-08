public class Medicine {
	private String medName;
	private int currentStock;
	private int alertLimit;
	
	public Medicine(String medName, int currentStock, int alertLimit){
		this.medName = medName;
		this.currentStock = currentStock;
		this.alertLimit = alertLimit;
	}
	
	public String getMedName(){
		return medName;
	}
	
	public int getCurrentStock() {
		return currentStock;
	}
	
	public void updateCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}
	
	public int getAlertLimit() {
		return alertLimit;
	}
	
	public boolean shouldAlert() {
		return currentStock < alertLimit;
	}

	public void updateAlertLimit(int alertLimit){
  		this.alertLimit = alertLimit;
 	}
}
