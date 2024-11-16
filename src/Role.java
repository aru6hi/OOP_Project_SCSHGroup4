/**
 * Role enum representing all possible roles accounts can have
 */
public enum Role {
	PATIENT("Patient", "P"),
	DOCTOR("Doctor", "D"),
	ADMINISTRATOR("Administrator", "A"),
	PHARMACIST("Pharmacist", "P"),
	STAFF("Staff", "S");
	
	private final String name;
	private final String prefix;
	
	private Role(String name, String prefix) {
		this.name = name;
		this.prefix = prefix;
	}
	
	public String toString() {
		return this.name;
	}
	
	/**
	 * gets the prefix associated with the Role
	 * @return prefix of the role
	 */
	public String getPrefix() {
		return this.prefix;
	}
}
