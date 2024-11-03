public class InventoryReplenishment {
	private int reqID;
	private String medName;
	private String reqStatus;
	private int reqAmount;
	
	public InventoryReplenishment(int reqID, String medName, String reqStatus, int reqAmount) {
		this.reqID = reqID;
		this.medName = medName;
		this.reqStatus = "Requested";
		this.reqAmount = reqAmount;
	}
	
	public void requestApprove() {
		this.reqStatus = "Approved";
	}

	public void requestReject() {
		this.reqStatus = "Rejected";
	}

	public String getMedicineName() {
        return medName;
    }
	
	public int getReqID() {
		return reqID;
	}
	
	public String getReqStatus() {
		return reqStatus;
	}

	public int getReqAmount(){
		return reqAmount;
	}
}
