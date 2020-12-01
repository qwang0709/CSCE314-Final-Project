package hiearchy;

public class Yeomen extends LowerClass {
	// These are servants who promised labor in exchange for transportation to the new colony 
	int yearsOfService;
	@Override
	public String toString() {
		return "Yeomen [yearsOfService=" + yearsOfService + ", name=" + name + ", id=" + id + ", sex=" + sex + ", age="
				+ age + "]";
	}

	public Yeomen(String name, char sex, int age, String id, int amountOfDebt, int yearsOfService) {
		super(name, sex, age, id, amountOfDebt, yearsOfService);
		// TODO Auto-generated constructor stub
	}
	
	void decreaseYear() {
		yearsOfService -= 1;
	}

}
