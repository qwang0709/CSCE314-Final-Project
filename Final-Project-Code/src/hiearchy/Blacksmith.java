package hiearchy;

public class Blacksmith extends MiddleClass {

	public Blacksmith(String name, char sex, int age, String id) {
		super(name, sex, age, id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Blacksmith [name=" + name + ", id=" + id + ", sex=" + sex + ", age=" + age + "]";
	}

}