public abstract class User{
	private final String ID;
	private String encryptedPassword; //Never decrypt this for security
	private final Role role;
	
	public User(String ID, Role role) {
		this.ID = ID;
		this.role = role;
		
		//Encrypt raw default password
		String encPass = SecurityTools.encryptPassword("password");
		
		this.encryptedPassword = encPass;
	}
	
	public void setNewPassword(String rawNewPassword) {
		//Encrypt raw new password
		String encPass = SecurityTools.encryptPassword(rawNewPassword);
				
		this.encryptedPassword = encPass;
	}
	
	public boolean authenticatePassword(String inputPassword) {
		//Pass in the input password
		//It will encrypt it and compare to encrypted password
		//A match means the input is the same as the actual password
		String encPass = SecurityTools.encryptPassword(inputPassword);
		
		if (encPass.equals(encryptedPassword)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getId() {
		return this.ID;
	}
	
	public boolean isRole(Role role) {
		//In case we ever want to give multiple roles, this would be useful
		return this.role == role;
	}

	public Role getRole() {
		return this.role;
	}
}
