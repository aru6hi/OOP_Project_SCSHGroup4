public class PrescribedMedicine {
	private String medicineID;
	private String medicineName;
	private int dosage;
	
	public PrescribedMedicine(String medicineID, String name, int dosage) {
		this.medicineID = medicineID; //Should match a stocked medicine
		this.medicineName = name;
		this.dosage = dosage;
	}
	
	public String getMedicineID() {
		return medicineID;
	}

	public void setMedicineID(String medicineID) {
		this.medicineID = medicineID;
	}

	public String toString() {
		return "(" + this.medicineName + " " + this.dosage + ")";
	}
	
	public String getName() {
		return this.medicineName;
	}
	
	public void setName(String name) {
		this.medicineName = name;
	}
	
	public int getDosage() {
		return this.dosage;
	}
	
	public void setDosage(int dosage) {
		this.dosage = dosage;
	}
}
