import java.time.LocalDate;
import java.util.ArrayList;

/**
 * A record of patient personal particulars
 */
public class PatientRecord extends DatabaseItem{
	
	//Match id to patientID to find correct patient
	private String name;
	private LocalDate dob;
	private String gender;
	private String bloodType;
	private String email;
	
	private String diagnoses;
    private ArrayList<PrescribedMedicine> prescription = new ArrayList<PrescribedMedicine>();
	private String pastTreatments;
	
	/**
	 * Creates a patient record
	 * @param patientID must match the PatientID of their account
	 */
    public PatientRecord(String patientID) {
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
    
    /**
     * get name
     * @return name of patient
     */
	public String getName() {
		return name;
	}
	
	/**
	 * set name
	 * @param name name of patient
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get date of birth
	 * @return date of birth of patient
	 */
	public LocalDate getDob() {
		return dob;
	}
	
	/**
	 * set date of birth
	 * @param year year of birth
	 * @param month month of birth
	 * @param day day of birth
	 */
	public void setDob(int year, int month, int day) {
		this.dob = LocalDate.of(year, month, day); 
	}
	
	/**
	 * get gender
	 * @return gender of patient
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * set gender
	 * @param gender gender of patient
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * get blood type
	 * @return blood type of patient
	 */
	public String getBloodType() {
		return bloodType;
	}
	
	/**
	 * set blood type
	 * @param bloodType blood type of patient
	 */
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	
	/**
	 * get email
	 * @return email of patient
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * set email
	 * @param email email of patient
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * get diagnosis
	 * @return diagnosis of patient
	 */
	public String getDiagnoses() {
		return diagnoses;
	}
	
	/**
	 * set diagnosis
	 * @param diagnoses diagnosis of patient
	 */
	public void setDiagnoses(String diagnoses) {
		this.diagnoses = diagnoses;
	}
	
	/**
	 * get past treatments
	 * @return past treatments of patient
	 */
	public String getPastTreatments() {
		return pastTreatments;
	}
	
	/**
	 * set past treatments
	 * @param pastTreatments past treatments of patient
	 */
	public void setPastTreatments(String pastTreatments) {
		this.pastTreatments = pastTreatments;
	}
	
	/**
	 * get prescription
	 * @return ArrayList containing PrescribedMedicine of patient
	 */
	public ArrayList<PrescribedMedicine> getPrescription() {
		return prescription;
	}
	
	/**
	 * Adds a PrescribedMedicine to the record
	 * @param medID id of the medicine
	 * @param name name of the medicine
	 * @param dosage dose of medicine
	 */
	public void addPrescription(String medID, String name, int dosage) {
		this.prescription.add(new PrescribedMedicine(medID, name, dosage));
	}
	
	/**
	 * Removes a prescription by index
	 * @param index index of prescription to remove
	 */
	public void removePrescription(int index) {
		this.prescription.remove(index);
	}
	
	

}
