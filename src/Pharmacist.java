public class Pharmacist extends User{
	private String name;
	private String gender;
	private int age;
	
	public Pharmacist(String ID, String name, String gender, int age) {
		super(ID, Role.PHARMACIST);

		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getGender() {
		return this.gender;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int newAge) {
		this.age = newAge;
	}
}
