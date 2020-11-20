package hiearchy;

public abstract class Person {
	String name;
	String id;
	char sex; 
	int age;
	// User-defined class 
	Job job;
	
	public Person(String name, char sex, int age, String id, Job job) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.id = id;
		this.job = job;
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

	@Override
	public abstract String toString();
}
