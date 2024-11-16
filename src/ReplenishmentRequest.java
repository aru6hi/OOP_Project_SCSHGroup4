
public class ReplenishmentRequest extends DatabaseItem{
	private String medicineID;
	private String medName;
	private Status reqStatus;
	private int reqAmount;
	
	public ReplenishmentRequest(String medicineID, String medName, int reqAmount) {
		super("R");
		this.medicineID = medicineID;
		this.medName = medName;
		this.reqAmount = reqAmount;
		this.reqStatus = Status.PENDING;
	}
	
	public void requestApprove() {
		this.reqStatus = Status.APPROVED;
	}

	public void requestReject() {
		this.reqStatus = Status.REJECTED;
	}
	
	public String getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(String medicineID) {
		this.medicineID = medicineID;
	}
	
	public String getMedicineName() {
        return this.medName;
    }
	
	public Status getReqStatus() {
		return this.reqStatus;
	}

	public int getReqAmount(){
		return this.reqAmount;
	}
}
