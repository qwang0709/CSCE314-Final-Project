package hiearchy;

public class UpperClass extends Person {
	int numberOfSlaves;
	int netWorth; 
	public UpperClass(String name, char sex, int age, String id, Job job, int numSlaves, int netWorth) {
		super(name, sex, age, id, job);
		this.netWorth = netWorth;
		this.numberOfSlaves = numSlaves;
	}

	@Override
	public String toString() {
		return "UpperClass [name=" + name + ", sex=" + sex + ", age=" + age + ", id=" + id + ", job=" + job + "]";
	}

}
