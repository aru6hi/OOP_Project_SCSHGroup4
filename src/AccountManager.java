import java.util.Scanner;

public class AccountManager {

    private User[] users; // Array to hold different User types
    private int userCount;
    private final int MAX_USERS = 100;
    private Scanner sc;

    public AccountManager() {
        sc = new Scanner(System.in);
        users = new User[MAX_USERS];
        userCount = 0;
    }

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

    //REGISTRATION METHOD
    private void register() {
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
        users[userCount++] = user;
        System.out.println(role + " account created successfully for " + name);
    }

    // LOGIN METHOD
    private User login() {
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

    private User findUser(String id, Role role) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getId().equals(id) && users[i].isRole(role)) {
                return users[i];
            }
        }
        return null; // User not found
    }

}
