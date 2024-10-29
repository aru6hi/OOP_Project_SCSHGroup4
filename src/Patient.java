public class Patient extends User{
	private String name;
	private String ID;
	private String DOB;
	private char gender;
	private String bloodType;
	private int phoneNum;
	private String email;
	private int age;
	
	public Patient(String ID, String name, String DOB, char gender, String bloodType, int phoneNum, String email, int age) {
		super(ID, Role.PATIENT);
		this.age=age;
		this.ID=ID;
		this.name = name;
		this.DOB = DOB;
		this.gender = gender;
		this.bloodType = bloodType;
		this.phoneNum = phoneNum;
		this.email = email;
	}
	
	public int getAge() {
		return this.age;
	}
	public String getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}
	
	public String getDOB() {
		return this.DOB;
	}
	
	public String getBloodType() {
		return this.bloodType;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public int getPhoneNum() {
		return this.phoneNum;
	}
	
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}
	
	public void setPhoneNum(int newPhoneNum) {
		this.phoneNum = newPhoneNum;
	}
}
