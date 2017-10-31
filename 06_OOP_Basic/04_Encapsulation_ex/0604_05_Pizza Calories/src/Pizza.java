import java.util.ArrayList;
import java.util.List;

public class Pizza {

	private static final int MAX_TOPPINGS_COUNT = 15;
	
	private String name;
	private Dough dough;
	private List<Topping> toppings;
	
	public Pizza(String name, int toppingCount) {
		super();
		setName(name);
		checkToppingCount(toppingCount);
		this.toppings = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		if (name == null || name.isEmpty() || name.length() > MAX_TOPPINGS_COUNT) {
			throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
		}
		this.name = name;
	}
	
	public void setDough(Dough dough) {
		this.dough = dough;
	}

	private void checkToppingCount(int toppingCount) {
		if (toppingCount < 0 || toppingCount > 10) {
			throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
		}
	}

	public void addTopping(Topping topping) {
		this.toppings.add(topping);
	} 
	
	public double countCallories() {
		double res = dough.getCallories();
		for (Topping t : toppings) {
			res += t.getCallories();
		}
		return res;
	}

	@Override
	public String toString() {
		return String.format("%s - %.2f", this.name, this.countCallories());
	}
	
}
