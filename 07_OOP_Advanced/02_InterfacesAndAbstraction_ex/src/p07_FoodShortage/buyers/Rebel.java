package p07_FoodShortage.buyers;

public class Rebel extends Buyer{

	private String group;

	public Rebel(String name, int age, String group) {
		super(name, age);
		this.group = group;
	}

	@Override
	public void buyFood() {
		super.increaseFood(5);
	}

}
