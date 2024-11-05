package HMS;

import java.util.ArrayList;
public class Prescription {
	private ArrayList<PrescribedMedicine> prescriptionList = new ArrayList<PrescribedMedicine>();
	
	public Prescription() {	
	}
	
	public void addPrescription(String name, String dosage) {
		PrescribedMedicine med = new PrescribedMedicine(name, dosage);
		prescriptionList.add(med);
	}
	
	public String toString() {
		String out = "";
		
		for (PrescribedMedicine med : prescriptionList) {
			out = out + med;
		}
		
		return "[" + out + "]";
	}
	
	public void viewAll() {
		System.out.println(prescriptionList);
	}
	
	public void removePrescription(int index) {
		prescriptionList.remove(index);
	}
	
	public void removePrescription(PrescribedMedicine med) {
		prescriptionList.remove(med);
	}
}
