package hiearchy;

public abstract class UpperClass extends Person {
	int numServants;
	int moneyOwned;
	boolean isRoyalFamily;
	
	public UpperClass(String name, char sex, int age, String id, int numServants, int moneyOwned, boolean isRoyal) {
		super(name, sex, age, id);
		this.moneyOwned = moneyOwned;
		this.numServants = numServants;
		isRoyalFamily = isRoyal;
	}

}
