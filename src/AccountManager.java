import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class AccountManager {

    private ArrayList<User> users; // Array to hold different User types

    public AccountManager() {
        users = new ArrayList<>();
        initializePatientsfromFile(); // Load patients from file
        initializeStafffromFile();   // Load staff from file
    }


    private void initializePatientsfromFile() {
        try {
            File patientList = new File("Data Files\\Patient_List.csv");
            Scanner scPatientList = new Scanner(patientList);
            
            // Skip the header (first line)
            if (scPatientList.hasNextLine()) {
                scPatientList.nextLine(); // Skipping the header line
            }
    
            while (scPatientList.hasNextLine()) {
                String data = scPatientList.nextLine();
                String[] values = data.split(",");
                
                // Parse the patient details from the CSV line
                String id = values[0];
                String name = values[1];
                String dob = values[2];
                String gender = values[3];
                String bloodType = values[4];
                String email = values[5];
    
                // Create a new Patient object
                Patient patient = new Patient(id, name, dob, gender, bloodType, email);
                
                // Add the patient to the users ArrayList
                users.add(patient);  // Adds to the end of the list
            }
            
            scPatientList.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Patient List file not found!");
        }
    }

    
    private void initializeStafffromFile() {
        try {
            File staffList = new File("Data Files\\Staff_List.csv");
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
                //String password = values[5]; Removed cause password is not stored in the file
    
                Role role;
                try {
                    role = Role.valueOf(roleString.toUpperCase());  // Convert role string to Role enum
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid role for staff member: " + roleString);
                    continue;  // Skip invalid roles
                }
    
                // Create staff member based on role
                User staffMember = null;
                switch (role) {
                    case DOCTOR:
                        staffMember = new Doctor(id, name, gender, age);
                        break;
                    case PHARMACIST:
                        staffMember = new Pharmacist(id, name, gender, age);
                        break;
                    // Add cases for other roles as needed
                    default:
                        System.out.println("Unsupported role in staff list: " + roleString);
                        continue;  // Skip unsupported roles
                }
    
                // Set the password and add the staff member to the users list
                if (staffMember != null) {
                    staffMember.setNewPassword("password");  // Set password using the method in User class
                    users.add(staffMember);  // Adds the staff member to the users ArrayList
                }
            }
            
            scStaffList.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("Staff list file not found!");
        }
    }
    public void removeStaff(String id, Role role) {
        // Search for the staff member by ID and role
        for (User user : users) {
            // Check if the user has the specified role and ID
            if (user.getId().equals(id) && user.isRole(role) && (role == Role.DOCTOR || role == Role.PHARMACIST)) {
                users.remove(user); // Remove the staff member from the list
            }
        }
    }

    
    /*
    public void start() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose one of the following options:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int option = sc.nextInt();
            sc.nextLine(); 

            switch (option) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }
	*/
    
    //REGISTRATION METHOD
    public void register(Scanner sc) {
        System.out.print("Enter ID for new account: ");
        String id = sc.nextLine();
        
        System.out.print("Enter role (DOCTOR, PATIENT, PHARMACIST): ");
        String roleInput = sc.nextLine().toUpperCase();
        Role role;
        
        try {
            role = Role.valueOf(roleInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid role entered. Registration failed.");
            return;
        }

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        // Create user object based on role
        User user = null;
        switch (role) {
            case DOCTOR:
                System.out.print("Enter age: ");
                int AGE = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Gender: ");
                String GENDER=sc.nextLine();
                user = new Doctor(id, name, GENDER, AGE);
                break;
            case PATIENT:
                System.out.print("Enter date of birth: ");
                String dob = sc.nextLine();
                System.out.print("Enter blood type: ");
                String bloodType = sc.nextLine();
                System.out.print("Enter Gender: ");
                String gender=sc.nextLine();
                System.out.print("Enter phone number: ");
                int phoneNum = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                System.out.print("Enter age: ");
                int age = sc.nextInt();
                sc.nextLine(); // Consume newline
                user = new Patient(id, name, dob, gender, bloodType, phoneNum, email, age);
                break;
            case PHARMACIST:
                System.out.print("Enter age: ");
                int age1 = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Gender: ");
                String gender1=sc.nextLine();
                user = new Pharmacist(id, name, gender1, age1);
                break;
            default:
                System.out.println("Unsupported role.");
                return;
        }

        user.setNewPassword(password);
        users.add(user);
        System.out.println(role + " account created successfully for " + name);
    }

    // LOGIN METHOD
    public User login(Scanner sc) {
        System.out.print("Enter ID: ");
        String id = sc.nextLine();

        System.out.print("Enter role (DOCTOR, PATIENT, PHARMACIST): ");
        String roleInput = sc.nextLine().toUpperCase();
        Role role;
        
        try {
            role = Role.valueOf(roleInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid role entered. Login failed.");
            return null;
        }

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        // Search for user in the array
        User user = findUser(id, role);
        if (user != null) {
            if (user.authenticatePassword(password)) {
                System.out.println("Login successful! Welcome " + user.getId());
                return user;
            } else {
                System.out.println("Incorrect password. Please try again.");
                return null;
            }
        } else {
            System.out.println("User not found or role mismatch.");
            return null;
        }
    }

    public User findUser(String id, Role role) {
        for (User user : users) { // Iterate over each user in the ArrayList
            if (user.getId().equals(id) && user.isRole(role)) {
                return user; // Return the user if ID and role match
            }
        }
        return null; // User not found
    }
}
