import java.util.Scanner;

public class MedicalRecord {
    private static int numOfRecords = 0; 
    private Patient patient; 
    private String diagnoses;
    private Prescription medication;
    private String pastTreatments;

    // Constructor to initialize fields
    public MedicalRecord() {
        this.diagnoses = "EMPTY"; 
        this.pastTreatments = "EMPTY";
    }

    // Getters and Setters
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public void addMedication(Scanner sc){
        String choice="Y";
        while(choice.equalsIgnoreCase("Y")){
            System.out.println("Enter name of medicine: ");
            String name= sc.nextLine();
            System.out.println("Enter dosage of this medicine: ");
            String dosage=sc.nextLine();
            this.medication.addPrescription(name, dosage);
            System.out.println("Do you want to add more medicines? (Y/N)");
            choice=sc.nextLine();
        }
    }

    public void removeMedication(Scanner sc){
        String choice="Y";
        while(choice.equalsIgnoreCase("Y")){
            System.out.println("List of current medications: ");
            this.medication.viewAll();
            System.out.println("Enter index of the medicine to be removed: ");
            int index=sc.nextInt();
            this.medication.removePrescription(index-1);
            System.out.println("Do you want to remove more medicines? (Y/N)");
            choice=sc.nextLine();
        }
    }

    public void setPastTreatments(String pastTreatments) {
        this.pastTreatments = pastTreatments;
    }

    public String getDiagnoses() {
        return this.diagnoses;
    }

    public Prescription getMedication() {
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
