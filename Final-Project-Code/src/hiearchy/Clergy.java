package hiearchy;

public class Clergy extends UpperClass{
	
	int numServants;
	int moneyOwned;
	String nameOfFaith;
	
	public Clergy(String name, char sex, int age, String id, int numServants, int moneyOwned, String nameOfFaith) {
		super(name, sex, age, id);
		this.nameOfFaith = nameOfFaith;
		this.numServants = numServants;
		this.moneyOwned = moneyOwned;
	}
	
	
	public int getServant() {
		return numServants;
	}
	
	public int getMoney() {
		return moneyOwned;
	}
	
	public String getFaith() {
		return nameOfFaith;
	}
	

	@Override
	public String toString() {
		return "Clergy [numServants=" + numServants + ", moneyOwned=" + moneyOwned + ", name=" + name + ", id=" + id + ", sex=" + sex + ", age=" + age + "]";
	}

}
