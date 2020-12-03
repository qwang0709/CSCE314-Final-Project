package hiearchy;

public class Yeomen extends LowerClass {
	// These are servants who promised labor in exchange for transportation to the new colony 
	int amountOfDebt;
	int yearsOfService;

	public Yeomen(String name, char sex, int age, String id, int amountOfDebt, int yearsOfService) {
		super(name, sex, age, id);
		this.amountOfDebt = amountOfDebt;
		this.yearsOfService = yearsOfService;
	}
	
	public int getDebt() {
		return amountOfDebt;
	}
	
	public int getSev() {
		return yearsOfService;
	}
	
	
	void decreaseYear() {
		yearsOfService -= 1;
	}
	
	@Override
	public String toString() {
		return "Yeomen [ name=" + name + ", yearsOfService=" + yearsOfService + ", id=" + id + ", sex=" + sex + ", age="
				+ age + ",amountOfDebt = "+ amountOfDebt +" ]";
	}

}
