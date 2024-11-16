import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class ParseFile {
	
	public static void parseFilePatient(String filepath, AccountDB acctDB, MedicalRecordDB medRecDB) {
		try {
			File file = new File(filepath);
			Scanner sc = new Scanner(file);
			
			// Skip the header (first line)
            if (sc.hasNextLine()) {
                sc.nextLine(); // Skipping the header line
            }
    
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] values = data.split(",");
                
                // Parse the patient details from the CSV line
                String id = values[0];
                String name = values[1];
                String dob = values[2];
                
                String[] yyyymmdd = dob.split("-");
                int year = Integer.parseInt(yyyymmdd[0]);
                int month = Integer.parseInt(yyyymmdd[1]);
                int day = Integer.parseInt(yyyymmdd[2]);
                
                String gender = values[3];
                String bloodType = values[4];
                String email = values[5];
                
                Account user = new Account();
                user.setID(id);
                user.setRole(Role.PATIENT);
                
                MedicalRecord medRec = new MedicalRecord(id);
                medRec.setName(name);
                medRec.setDob(year, month, day);
                medRec.setGender(gender);
                medRec.setBloodType(bloodType);
                medRec.setEmail(email);
                
                acctDB.add(user);
                medRecDB.add(medRec);
                
                
            }
			sc.close();
		} 
		catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
	}
	
	public static void parseFileStaff(String filepath, AccountDB acctDB, StaffRecordDB staffRecDB) {
        try {
            File staffList = new File(filepath);
            Scanner scStaffList = new Scanner(staffList);
            
            // Skip the header (first line)
            if (scStaffList.hasNextLine()) {
                scStaffList.nextLine(); // Skipping the header line
            }
    
            while (scStaffList.hasNextLine()) {
                String data = scStaffList.nextLine();
                String[] values = data.split(",");
    
                // Parse the staff details from the CSV line
                String id = values[0];
                String name = values[1];
                String roleString = values[2];
                String gender = values[3];
                int age = Integer.parseInt(values[4]);
    
                Role role;
                try {
                    role = Role.valueOf(roleString.toUpperCase());  // Convert role string to Role enum
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid role for staff member: " + roleString);
                    continue;  // Skip invalid roles
                }
    
                Account user = new Account();
                user.setID(id);
                user.setRole(role);
                
                StaffRecord staffRec = new StaffRecord(id);
                staffRec.setName(name);
                staffRec.setGender(gender);
                staffRec.setAge(age);
                
                acctDB.add(user);
                staffRecDB.add(staffRec);
                
            }
            scStaffList.close();
        } 
        catch (FileNotFoundException e) {
            System.out.println("Staff list file not found!");
        }
    }
	
	public static void parseFileMedicine(String filepath, InventoryDB inventoryDB) {
		try {
			File file = new File(filepath);
			Scanner sc = new Scanner(file);
			
			// Skip the header (first line)
            if (sc.hasNextLine()) {
                sc.nextLine(); // Skipping the header line
            }
    
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                String[] values = data.split(",");
                
                // Parse the patient details from the CSV line
                String name = values[0];
                int stock = Integer.parseInt(values[1]);
                int alert = Integer.parseInt(values[2]);
                
                StockedMedicine med = new StockedMedicine(name, stock, alert);
                
                inventoryDB.add(med);
            }
			sc.close();
		} 
		catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
	}
}
