import java.util.Scanner;
public class AccountManager {

private Account account;
    private Scanner sc;

    public class BasicSecurityTools extends SecurityTools {
        // No additional code needed; inherits encryptPassword
    }

    public AccountManager() {
        sc = new Scanner(System.in);
        SecurityTools securityTool = new BasicSecurityTools(); // Assuming you have a SecurityTools class
        account = new Account(securityTool);
    }

    public void start() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose one of the following options:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Change Password");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int option = sc.nextInt();
            sc.nextLine(); // Clear the newline character

            switch (option) {
                case 1:
                    register();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    changePassword();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        sc.close();
    }

    private void register() {
        System.out.print("Enter a username for the new account:");
        String username = sc.nextLine();
        System.out.print("Enter a password:");
        String password = sc.nextLine();
        account.createacc(username, password);
    }

    private void login() {
        System.out.println("Enter your username:");
        String username = sc.nextLine();
        System.out.println("Enter your password:");
        String password = sc.nextLine();
        account.login(username, password);
    }

    private void changePassword() {
        System.out.println("Enter your username:");
        String username = sc.nextLine();
        System.out.println("Enter your old password:");
        String oldPassword = sc.nextLine();
        System.out.println("Enter your new password:");
        String newPassword = sc.nextLine();
        account.changePassword(username, oldPassword, newPassword);
    }

    public static void main(String[] args) {
        AccountManager app = new AccountManager();
        app.start();
    }
}