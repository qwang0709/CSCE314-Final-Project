package hiearchy;

public class Merchant extends UpperClass {

	public Merchant(String name, char sex, int age, String id, int numServants, int moneyOwned, boolean isRoyal) {
		super(name, sex, age, id, numServants, moneyOwned, isRoyal);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Merchant [numServants=" + numServants + ", moneyOwned=" + moneyOwned + ", isRoyalFamily=" + isRoyalFamily
				+ ", name=" + name + ", id=" + id + ", sex=" + sex + ", age=" + age + "]";
	}

}
