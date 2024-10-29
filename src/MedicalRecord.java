public class MedicalRecord {
    private static int numOfRecords = 0; 
    private Patient patient; 
    private String diagnoses;
    private String medication;
    private String pastTreatments;

    // Constructor to initialize fields
    public MedicalRecord() {
        this.diagnoses = "EMPTY"; 
        this.medication = "EMPTY";
        this.pastTreatments = "EMPTY";
    }

    // Getters and Setters
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public void setPastTreatments(String pastTreatments) {
        this.pastTreatments = pastTreatments;
    }

    public String getDiagnoses() {
        return this.diagnoses;
    }

    public String getMedication() {
        return this.medication;
    }

    public String getPastTreatments() {
        return this.pastTreatments;
    }

    public Patient getPatient() {
        return this.patient;
    }

    public static int getNumOfRecords() {
        return numOfRecords;
    }

    public String getPatientID() {
        return patient.getID();
    }

    public static void incrementRecords() {
        numOfRecords++;
    }
}
