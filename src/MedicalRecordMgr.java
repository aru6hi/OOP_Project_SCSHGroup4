import java.util.Scanner;

public class MedicalRecordMgr {
    private MedicalRecord[] medicalRecords;

    public MedicalRecordMgr() {
        medicalRecords = new MedicalRecord[100]; 
    }

    // Find a medical record by patient ID
    public MedicalRecord findByID(String patientID) {
        if (medicalRecords == null || MedicalRecord.getNumOfRecords() == 0) return null;
        
        for (MedicalRecord record : medicalRecords) {
            if (record != null && record.getPatientID() == patientID) {
                return record;
            }
        }
        return null;
    }

    // Add a medical record
    public void addRecord(Patient patient, String diagnoses, String medication, String pastTreatments) {
        MedicalRecord mRecord = new MedicalRecord();
        mRecord.setPatient(patient);
        mRecord.setDiagnoses(diagnoses);
        mRecord.setMedication(medication);
        mRecord.setPastTreatments(pastTreatments);
        
        medicalRecords[MedicalRecord.getNumOfRecords()] = mRecord;
        MedicalRecord.incrementRecords(); 
    }

    // Print a medical record
    public void printRecord(MedicalRecord medRecord) {
        if (medRecord == null) {
            System.out.println("No record found.");
            return;
        }

        System.out.println("Printing medical records for Patient ID: " + medRecord.getPatientID());
        Patient patient = medRecord.getPatient();
        System.out.println("Patient Name: " + patient.getName());
        System.out.println("Patient Age: " + patient.getAge());
        System.out.println("Diagnoses: " + medRecord.getDiagnoses());
        System.out.println("Medications: " + medRecord.getMedication());
        System.out.println("Past Treatments: " + medRecord.getPastTreatments());
    }

    // Edit a medical record
    public void editRecord(MedicalRecord medRecord) {
        if (medRecord == null) {
            System.out.println("No record found to edit.");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose one of the following: ");
        System.out.println("1. Edit Patient Diagnoses");
        System.out.println("2. Edit Patient Medications");
        System.out.println("3. Edit Patient Past Treatments");

        int option = sc.nextInt();
        sc.nextLine(); 

        switch(option) {
            case 1:
                System.out.println("Enter new diagnoses: ");
                String diag = sc.nextLine();
                medRecord.setDiagnoses(diag);
                break;
            case 2:
                System.out.println("Enter new medications: ");
                String med = sc.nextLine();
                medRecord.setMedication(med);
                break;
            case 3:
                System.out.println("Enter new past treatments: ");
                String treatment = sc.nextLine();
                medRecord.setPastTreatments(treatment); 
                break;
            default:
                System.out.println("Invalid option");
        }
        sc.close();
    }
}
