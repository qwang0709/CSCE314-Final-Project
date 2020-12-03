package hiearchy;

public class Bureucrat extends UpperClass {
	
	int numServants;
	int moneyOwned;

	public Bureucrat(String name, char sex, int age, String id, int numServants, int moneyOwned) {
		super(name, sex, age, id);
		this.moneyOwned = moneyOwned;
		this.numServants = numServants;
	}
	
	public int getServant() {
		return numServants;
	}
	
	public int getMoney() {
		return moneyOwned;
	}
	

	@Override
	public String toString() {
		return "Bureucrat [numServants=" + numServants + ", moneyOwned=" + moneyOwned + ", name=" + name + ", id=" + id + ", sex=" + sex + ", age=" + age + "]";
	}

}
