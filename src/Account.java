import java.util.ArrayList;
public class Account extends DatabaseItem{
	private ArrayList<Role> role = new ArrayList<Role>();
	private String encPassword = SecurityTools.encryptPassword("password");
	
	public Account() {
		super("U");
	}
	
	public Account(String acctID) {
		super("U");
		this.setID(acctID);
	}
	
	public String toString() {
		return "ID: " + this.getID() + "\n" + "Roles: " + this.role; 
	}
	
	public void setPassword(String password) {
		String encPass = SecurityTools.encryptPassword(password);
		
		this.encPassword = encPass;
	}
	
	public String getEncPassword() {
		return this.encPassword;
	}
	
	public boolean hasRole(Role role) {
		return this.role.contains(role);
	}
	
	public ArrayList<Role> getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role.add(role);
	}
}
