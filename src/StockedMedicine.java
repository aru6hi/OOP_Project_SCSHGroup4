/**
 * Class representing medicine stocked in the inventory
 */
public class StockedMedicine extends DatabaseItem{
	private String medName;
	private int currentStock;
	private int alertLimit;
	
	/**
	 * Create a new StockedMedicine
	 * @param medName name of medicine
	 * @param currentStock current stock
	 * @param alertLimit minimum stock before alert
	 */
	public StockedMedicine(String medName, int currentStock, int alertLimit){
		super("M");
		this.medName = medName;
		this.currentStock = currentStock;
		this.alertLimit = alertLimit;
	}
	
	@Override
	public String toString() {
		return "[" + this.medName + "," 
				+ String.valueOf(this.currentStock) + "," 
				+ String.valueOf(this.alertLimit) + "]";
	}
	
	/**
	 * get medicine name
	 * @return medicine name
	 */
	public String getMedName(){
		return medName;
	}
	
	/**
	 * get current stock
	 * @return current stock
	 */
	public int getCurrentStock() {
		return currentStock;
	}
	
	/**
	 * set current stock
	 * @param currentStock the stock amount to set to
	 */
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}
	
	/**
	 * get alert limit
	 * @return alert limit
	 */
	public int getAlertLimit() {
		return alertLimit;
	}
	
	/**
	 * checks if a medicine's stock is below the alert limit
	 * @return true if stock < alert else false
	 */
	public boolean shouldAlert() {
		return currentStock < alertLimit;
	}
	
	/**
	 * set alert limit
	 * @param alertLimit the alert limit to set to
	 */
	public void setAlertLimit(int alertLimit){
  		this.alertLimit = alertLimit;
 	}
}
