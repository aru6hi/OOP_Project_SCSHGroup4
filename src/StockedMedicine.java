public class StockedMedicine extends DatabaseItem{
	private String medName;
	private int currentStock;
	private int alertLimit;
	
	public StockedMedicine(String medName, int currentStock, int alertLimit){
		super("M");
		this.medName = medName;
		this.currentStock = currentStock;
		this.alertLimit = alertLimit;
	}
	
	public String toString() {
		return "[" + this.medName + "," 
				+ String.valueOf(this.currentStock) + "," 
				+ String.valueOf(this.alertLimit) + "]";
	}
	
	public String getMedName(){
		return medName;
	}
	
	public int getCurrentStock() {
		return currentStock;
	}
	
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}
	
	public int getAlertLimit() {
		return alertLimit;
	}
	
	public boolean shouldAlert() {
		return currentStock < alertLimit;
	}

	public void setAlertLimit(int alertLimit){
  		this.alertLimit = alertLimit;
 	}
}
