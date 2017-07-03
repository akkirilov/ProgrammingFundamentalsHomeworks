package shoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private String name;
	private double money;
	private List<Product> products;
	
	public Person(String name, double money) {
		this.name = name;
		this.money = money;
		this.products = new ArrayList<Product>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void addProduct(Product product) {
		if (this.money >= product.getCost()) {
			this.products.add(product);
			this.setMoney(this.money - product.getCost());
			System.out.printf("%s bought %s%n", this.getName(), product.getName());
		} else {
			System.out.printf("%s can't afford %s%n", this.getName(), product.getName());
		}
	}
	
	public void printProducts() {
		System.out.print(this.name + " - ");
		if (this.getProducts().size() > 0) {
			List<String> productsNames = new ArrayList<>();
			for (Product product : this.getProducts()) {
				productsNames.add(product.getName());
			}
			System.out.println(String.join(", ", productsNames));
		} else {
			System.out.println("Nothing bought");
		}
	}
	
}
