package HMS;

public class PrescribedMedicine {
	private String medicineName;
	private String dosage;
	
	public PrescribedMedicine(String name, String dosage) {
		this.medicineName = name;
		this.dosage = dosage;
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
	
	public String getDosage() {
		return this.dosage;
	}
	
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
}
