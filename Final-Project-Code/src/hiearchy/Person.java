package hiearchy;

public abstract class Person {
	String name;
	String id;
	char sex; 
	int age;
	
	public Person(String name, char sex, int age, String id) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.id = id;
	}
	
	// Getters 
	public String getName() {
		return name;
	}
	public char getSex() {
		return sex;
	}
	public int getAge() {
		return age;
	}
	public String getId() {
		return id;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public abstract String toString();
}
