package hiearchy;

public class Slave extends LowerClass {
	// Some slaves can free themselves by earning enough money, but most of the time, they are slave for life
	String color;
	int amountOfDebt;
	int yearsOfService;
	
	public Slave(String name, char sex, int age, String id, int amountOfDebt, int yearsOfService, String color) {
		super(name, sex, age, id);
		this.color = color;
		this.amountOfDebt = amountOfDebt;
		this.yearsOfService = yearsOfService;
	}
	
	public int getDebt() {
		return amountOfDebt;
	}
	
	public int getSev() {
		return yearsOfService;
	}
	

	void decreaseDebt(int numPaid) {
		amountOfDebt -= numPaid;
	}
	
	void increaseDebt(int numOwed) {
		amountOfDebt += numOwed;
	}
	
	@Override
	public String toString() {
		return "Slave [color=" + color + ", amountOfDebt=" + amountOfDebt + ", name=" + name + ", id=" + id + ", sex="
				+ sex + ", age=" + age + ", yearsOfService= " + yearsOfService + "]";
	}
}
