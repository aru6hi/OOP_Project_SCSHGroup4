
public class StaffRecord extends DatabaseItem{
	
	private String name;
	private String gender;
	private int age;
	
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
}
