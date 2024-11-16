import java.util.ArrayList;

/**
 * Represents an account
 */
public class Account extends DatabaseItem{
	private ArrayList<Role> role = new ArrayList<Role>();
	private String encPassword = SecurityTools.encryptPassword("password");
	
	/**
	 * Constructs a blank account
	 */
	public Account() {
		super("U");
	}
	
	/**
	 * Construct account with given id
	 * @param acctID the id to construct account with
	 */
	public Account(String acctID) {
		super("U");
		this.setID(acctID);
	}
	
	/**
	 * Converts Account to String form for printing
	 */
	public String toString() {
		return "ID: " + this.getID() + "\n" + "Roles: " + this.role; 
	}
	
	/**
	 * Encrypts and sets password
	 * @param password the raw password to encrypt and store
	 */
	public void setPassword(String password) {
		String encPass = SecurityTools.encryptPassword(password);
		
		this.encPassword = encPass;
	}
	
	/**
	 * gets the encrypted password
	 * @return the encrypted password
	 */
	public String getEncPassword() {
		return this.encPassword;
	}
	
	/**
	 * Checks if the account has this role
	 * @param role the role to verify
	 * @return true if has this role, else false
	 */
	public boolean hasRole(Role role) {
		return this.role.contains(role);
	}
	
	/**
	 * get the array containing account roles
	 * @return ArrayList containing all roles of this account
	 */
	public ArrayList<Role> getRole() {
		return this.role;
	}
	
	/**
	 * Adds role to account
	 * @param role the role to add
	 */
	public void setRole(Role role) {
		this.role.add(role);
	}
}
