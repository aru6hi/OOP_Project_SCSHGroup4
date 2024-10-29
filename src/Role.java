public enum Role {
	PATIENT,
	DOCTOR(true),
	ADMIN(true),
	PHARMACIST(true);
	
	private final boolean isStaff;
	
	private Role(boolean isStaff) {
		this.isStaff = isStaff;
	}
	
	//This overload ensures default is false
	//also makes it really easy to initialize
	private Role() {
		this.isStaff = false;
	}
	
	//This will be useful later to find all staff
	public boolean isStaff() {
		return this.isStaff;
	}
}
