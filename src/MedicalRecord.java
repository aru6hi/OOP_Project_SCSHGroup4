import java.time.LocalDate;
import java.util.ArrayList;

public class MedicalRecord extends DatabaseItem{
	
	//Match id to patientID to find correct patient
	private String name;
	private LocalDate dob;
	private String gender;
	private String bloodType;
	private String email;
	
	private String diagnoses;
    private ArrayList<PrescribedMedicine> prescription = new ArrayList<PrescribedMedicine>();
	private String pastTreatments;
	
    public MedicalRecord(String patientID) {
		super("M");
		this.setID(patientID);
	}
    
    @Override
	public String toString() {
		return "(" +
				"patientID: " + this.getID() + "\n" +
				"name:" + this.name + "\n" +
				"DOB: " + this.dob + "\n" +
				"gender: " + this.gender + "\n" +
				"bloodType: " + this.bloodType + "\n" +
				"email: " + this.email + "\n" +
				"diagnoses: " + this.diagnoses + "\n" +
				"prescription:" + this.prescription + "\n" +
				"pastTreament:" + this.pastTreatments + 
				")";
	}
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(int year, int month, int day) {
		this.dob = LocalDate.of(year, month, day); 
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDiagnoses() {
		return diagnoses;
	}

	public void setDiagnoses(String diagnoses) {
		this.diagnoses = diagnoses;
	}

	public String getPastTreatments() {
		return pastTreatments;
	}

	public void setPastTreatments(String pastTreatments) {
		this.pastTreatments = pastTreatments;
	}
	
	public ArrayList<PrescribedMedicine> getPrescription() {
		return prescription;
	}

	public void addPrescription(String medID, String name, int dosage) {
		this.prescription.add(new PrescribedMedicine(medID, name, dosage));
	}
	
	public void removePrescription(int index) {
		this.prescription.remove(index);
	}
	
	

}
