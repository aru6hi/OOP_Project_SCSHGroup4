import java.util.Scanner;
public class Account {
    private String[] usernames;
    private String[] passwords;
    private int accountcount;
    private SecurityTools securitytool;
    private final int MAX_ACC=100;

    Scanner sc = new Scanner(System.in);
    
    public Account(SecurityTools securitytool){
        this.usernames=new String[MAX_ACC];
        this.passwords=new String[MAX_ACC];
        this.accountcount=0;
        this.securitytool=securitytool;
    }

    //Method to create a new account
    public void createacc(String username, String rawpassword){
        if (findaccIndex(username)!=-1){
            System.out.println("Account with this username already exists.");
        }
        else {
            usernames[accountcount]=username;
            passwords[accountcount]=securitytool.encryptPassword(rawpassword);
            accountcount++;
            System.out.println("Account created successfully for " + username);
        }
    }

    //Method to handle login
    public boolean login(String username, String enteredPassword){
        int index=findaccIndex(username);
        if (index!=-1){
            String encryptedEnteredPassword =securitytool.encryptPassword(enteredPassword);
            // Compare the encrypted entered password with the stored encrypted password.
            if (passwords[index].equals(encryptedEnteredPassword)){
                System.out.println("Login Successful! Welcome " + username);
                return true;
            }
            else{
                System.out.println("Incorrect Password. Please Try Again.");
            }
        }
        else{
            System.out.println("Account with this username does not exist.");
        }
        return false;
    }

    //Method to change Password
    public void changePassword(String username, String oldPassword, String newPassword) {
        int index = findaccIndex(username);
        if (index != -1) {
            String encryptedOldPassword = securitytool.encryptPassword(oldPassword);
            if (passwords[index].equals(encryptedOldPassword)) {
                passwords[index] = securitytool.encryptPassword(newPassword);
                System.out.println("Password updated successfully for: " + username);
            } else {
                System.out.println("Old password is incorrect.");
            }
        } else {
            System.out.println("Account with this username does not exist.");
        }
    }

    // Helper method to find the index of an account by username.
    private int findaccIndex(String username) {
        for (int i = 0; i < accountcount; i++) {
            if (usernames[i].equals(username)) {
                return i;
            }
        }
        return -1;  // Return -1 if the account is not found.
    }

}
