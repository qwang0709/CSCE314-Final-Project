package hiearchy;

public class Merchant extends MiddleClass {
	 int numServants;
	 int moneyOwned;

	public Merchant(String name, char sex, int age, String id, int numServants, int moneyOwned) {
		super(name, sex, age, id);
		this.numServants = numServants;
		this.moneyOwned = moneyOwned;
	}
	
	public int getServant() {
		return numServants;
	}
	
	public int getMoney() {
		return moneyOwned;
	}
	

	@Override
	public String toString() {
		return "Merchant [name=" + name + ", id=" + id + ", sex=" + sex + ", age=" + age + ", numServants= " + numServants + ", moneyOwned= " + moneyOwned + "]";
	}

}
