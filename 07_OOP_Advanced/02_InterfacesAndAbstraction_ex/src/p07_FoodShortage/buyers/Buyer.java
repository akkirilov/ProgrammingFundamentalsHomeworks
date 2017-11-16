package p07_FoodShortage.buyers;

public abstract class Buyer implements BuyerInterface {

	private String name;
	private int age;
	private int food;
	
	protected Buyer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		this.food = 0;
	}
	
	protected void increaseFood(int food) {
		this.food += food;
	}
	
	public int getFood() {
		return this.food;
	}

	public String getName() {
		return name;
	}
	
}
