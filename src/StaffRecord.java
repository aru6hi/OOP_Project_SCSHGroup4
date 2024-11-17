/**
 * A record of staff particulars
 */
public class StaffRecord extends DatabaseItem{
	
	private String name;
	private String gender;
	private int age;
	
	/**
	 * Create a new StaffRecord
	 * @param staffID must match account id for this staff member
	 */
	public StaffRecord(String staffID) {
		super("S");
		this.setID(staffID);
	}
	
	@Override
	public String toString() {
		return "(" +
				"staffID: " + this.getID() + "\n" +
				"name:" + this.name + "\n" +
				"gender: " + this.gender + "\n" +
				"age: " + String.valueOf(this.age) +
				")";
	}
	
	/**
	 * get name
	 * @return name of staff
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set name
	 * @param name name of staff
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get gender
	 * @return gender of staff
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * set gender
	 * @param gender of staff
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * get age
	 * @return age of staff
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * set age
	 * @param age age of staff
	 */
	public void setAge(int age) {
		this.age = age;
	}

	
	
}
