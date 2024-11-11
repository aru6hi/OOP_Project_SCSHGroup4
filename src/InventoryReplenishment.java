public class InventoryReplenishment {
	private String reqID;
	private String medName;
	private Status reqStatus;
	private int reqAmount;
	
	private static int currAvailableID = 1;
	
	public InventoryReplenishment(String medName, int reqAmount) {
		this.reqID = genReqID();
		this.medName = medName;
		this.reqStatus = Status.PENDING;
		this.reqAmount = reqAmount;
	}
	
	private String genReqID() {
		//Unique cause it's based off a static counter
		int maxNumPartLength = 4;
		String numericPart = String.valueOf(currAvailableID);
		if (numericPart.length() < maxNumPartLength) {
			int remaining = maxNumPartLength - numericPart.length();
			
			//append a bunch of 0s to front
			for (int i = 0; i < remaining; i++) {
				numericPart = "0" + numericPart;
			}
		}
		
		currAvailableID++;
		
		return "R" + numericPart;
	}
	
	public void requestApprove() {
		this.reqStatus = Status.APPROVED;
	}

	public void requestReject() {
		this.reqStatus = Status.REJECTED;
	}

	public String getMedicineName() {
        return this.medName;
    }
	
	public String getReqID() {
		return this.reqID;
	}
	
	public Status getReqStatus() {
		return this.reqStatus;
	}

	public int getReqAmount(){
		return this.reqAmount;
	}
}
