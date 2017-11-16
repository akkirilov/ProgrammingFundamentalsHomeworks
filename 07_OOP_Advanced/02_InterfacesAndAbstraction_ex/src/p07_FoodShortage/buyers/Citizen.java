package p07_FoodShortage.buyers;

public class Citizen extends Buyer{

	private String id;
	private String birthDate;

	public Citizen(String name, int age, String id, String birthDate) {
		super(name, age);
		this.id = id;
		this.birthDate = birthDate;
	}

	@Override
	public void buyFood() {
		super.increaseFood(10);
	}

}
