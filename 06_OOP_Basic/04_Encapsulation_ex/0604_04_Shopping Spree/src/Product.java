
public class Product {
	
	private String name;
	private double price;
	
	public Product(String name, double price) {
		super();
		setName(name);
		setPrice(price);
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

	public double getPrice() {
		return price;
	}

	private void setPrice(double price) {
		if (price < 0) {
			throw new IllegalArgumentException("Money cannot be negative");
		}
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("%s", name);
	}
	
}
