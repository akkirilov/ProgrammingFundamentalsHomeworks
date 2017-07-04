package carShop;

public abstract class Sellable extends AbstractCar{

	private Double price; 
	
	public Sellable(String model, String color, Integer horsePower, Double price) {
		super(model, color, horsePower);
		this.price = price;
	}

	public Double getPrice() {
		return price;
	}

}
