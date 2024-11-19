/**
 * Represent a request to replenish the inventory
 */
public class ReplenishmentRequest extends DatabaseItem{
	private String medicineID;
	private String medName;
	private Status reqStatus;
	private int reqAmount;
	
	/**
	 * Creates a new ReplenishmentRequest
	 * @param medicineID the id of the medicine to replenish
	 * @param medName the name of the medicine to replenish
	 * @param reqAmount the amount to replenish
	 */
	public ReplenishmentRequest(String medicineID, String medName, int reqAmount) {
		super("R");
		this.medicineID = medicineID;
		this.medName = medName;
		this.reqAmount = reqAmount;
		this.reqStatus = Status.PENDING;
	}
	
	public String toString() {
		return "(" + this.getID() + ", " + this.medName + ", " + this.reqAmount + ", " + this.reqStatus + ")";
	}
	
	/**
	 * Approves a request
	 */
	public void requestApprove() {
		this.reqStatus = Status.APPROVED;
	}
	
	/**
	 * Rejects a request
	 */
	public void requestReject() {
		this.reqStatus = Status.REJECTED;
	}
	
	/**
	 * get medicine id
	 * @return id of medicine to replenish
	 */
	public String getMedicineID() {
		return medicineID;
	}
	
	/**
	 * set medicine id
	 * @param medicineID id of medicine to replenish
	 */
	public void setMedicineID(String medicineID) {
		this.medicineID = medicineID;
	}
	
	/**
	 * get medicine name
	 * @return name of medicine to replenish
	 */
	public String getMedicineName() {
        return this.medName;
    }
	
	/**
	 * get request status
	 * @return status of replenishment request
	 */
	public Status getReqStatus() {
		return this.reqStatus;
	}
	
	/**
	 * get requested amount
	 * @return amount requested to replenish
	 */
	public int getReqAmount(){
		return this.reqAmount;
	}
}
