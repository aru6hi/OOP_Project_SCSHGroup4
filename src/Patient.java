package HMS;

public class Patient extends User{
	private String name;
	private String DOB;
	private char gender;
	private String bloodType;
	private int phoneNum;
	private String email;
	
	public Patient(String ID, String name, String DOB, char gender, String bloodType, int phoneNum, String email) {
		super(ID, Role.PATIENT);
		
		this.name = name;
		this.DOB = DOB;
		this.gender = gender;
		this.bloodType = bloodType;
		this.phoneNum = phoneNum;
		this.email = email;
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
