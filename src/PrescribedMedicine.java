/**
 * Represents a medicine prescribed to a patient
 */
public class PrescribedMedicine {
	private String medicineID;
	private String medicineName;
	private int dosage;
	
	/**
	 * Creates a new PrescribedMedicine
	 * @param medicineID id of medicine prescribed
	 * @param name name of prescribed medicine
	 * @param dosage dose of prescribed medicine
	 */
	public PrescribedMedicine(String medicineID, String name, int dosage) {
		this.medicineID = medicineID; //Should match a stocked medicine
		this.medicineName = name;
		this.dosage = dosage;
	}
	
	/**
	 * get medicine id
	 * @return id of medicine prescribed
	 */
	public String getMedicineID() {
		return medicineID;
	}
	
	/**
	 * set medicine id
	 * @param medicineID id of medicine prescribed
	 */
	public void setMedicineID(String medicineID) {
		this.medicineID = medicineID;
	}

	public String toString() {
		return "(" + this.medicineName + " " + this.dosage + ")";
	}
	
	/**
	 * get name
	 * @return name of medicine prescribed
	 */
	public String getName() {
		return this.medicineName;
	}
	
	/**
	 * set name
	 * @param name name of medicine prescribed
	 */
	public void setName(String name) {
		this.medicineName = name;
	}
	
	/**
	 * get dose
	 * @return dose of medicine prescribed
	 */
	public int getDosage() {
		return this.dosage;
	}
	
	/**
	 * set dose
	 * @param dosage dose of medicine prescribed
	 */
	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
}
