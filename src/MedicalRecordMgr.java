import java.util.ArrayList;
import java.util.Scanner;

public class MedicalRecordMgr {
    private ArrayList<MedicalRecord> medicalRecords = new ArrayList<MedicalRecord>();

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
    public void addRecord(Scanner sc, Patient patient, String diagnoses, String pastTreatments) {
        MedicalRecord mRecord = new MedicalRecord();
        mRecord.setPatient(patient);
        mRecord.setDiagnoses(diagnoses);
        mRecord.addMedication(sc);
        mRecord.setPastTreatments(pastTreatments);
        
        medicalRecords.set(MedicalRecord.getNumOfRecords(), mRecord);
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
                System.out.println("Choose one of the following: ");
                System.out.println("1. Enter new medication: ");
                System.out.println("2. Remove existing medication: ");
                int choice=sc.nextInt();
                sc.nextLine();
                switch(choice){
                    case 1:
                        medRecord.addMedication(sc);
                        break;
                    case 2:
                        medRecord.removeMedication(sc);
                        break;
                    default:
                        System.out.println("Invalid option");
                }
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
