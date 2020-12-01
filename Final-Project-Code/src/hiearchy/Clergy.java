package hiearchy;

public class Clergy extends UpperClass{
	String nameOfFaith;
	public Clergy(String name, char sex, int age, String id, int numServants, int moneyOwned, boolean isRoyal, String nameOfFaith) {
		super(name, sex, age, id, numServants, moneyOwned, isRoyal);
		this.nameOfFaith = nameOfFaith;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Clergy [numServants=" + numServants + ", moneyOwned=" + moneyOwned + ", isRoyalFamily=" + isRoyalFamily
				+ ", name=" + name + ", id=" + id + ", sex=" + sex + ", age=" + age + "]";
	}

}
