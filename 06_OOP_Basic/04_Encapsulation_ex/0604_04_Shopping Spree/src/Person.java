import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String name;
	private double money;
	private List<Product> products;
	
	public Person(String name, double money) {
		super();
		setName(name);
		setMoney(money);
		this.products = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		if (name.isEmpty() || name.equals(" ")) {
			throw new IllegalArgumentException("Name cannot be empty");
		}
		this.name = name;
	}

	private void setMoney(double money) {
		if (money < 0) {
			throw new IllegalArgumentException("Money cannot be negative");
		}
		this.money = money;
	}
	
	public String buyProduct (Product product) {
		String res = this.name + "";
		if (this.money - product.getPrice() < 0) {
			res += " can't afford ";
		} else {
			this.money -= product.getPrice();
			res += " bought ";
			products.add(product);
		}
		res += product.getName();
		return res;
	}

	@Override
	public String toString() {
		if (this.products.size() > 0) {
			return String.format("%s - %s", name, this.products.toString().replaceAll("\\[|\\]", ""));
		}
		return String.format("%s - Nothing bought", name);
	}
	
}
