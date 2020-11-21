package hiearchy;

public class LowerClass extends Person {

	public LowerClass(String name, char sex, int age, String id, Job job) {
		super(name, sex, age, id, job);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "LowerClass [name=" + name + ", id=" + id + ", sex=" + sex + ", age=" + age + ", job=" + job + "]";
	}

}
