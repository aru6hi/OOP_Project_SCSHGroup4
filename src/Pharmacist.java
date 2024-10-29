public class Pharmacist extends User{
	private String name;
	private char gender;
	private int age;
	
	public Pharmacist(String ID, String name, char gender, int age) {
		super(ID, Role.PHARMACIST);

		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public char getGender() {
		return this.gender;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int newAge) {
		this.age = newAge;
	}
}
