package hiearchy;

public class Job {
	String name = "Unknown";
	double wage = 0;
	
	public String getJobName() {
		return name;
	}
	public double getWage() {
		return wage;
	}
	public void changeJob(String name) {
		this.name = name;
	}
	public void setWage(double wage) {
		this.wage = wage;
	} 
	
	public void increaseWage() {
		this.wage += 1;
	}

	
}
