package carShop;

public abstract class AbstractCar implements Car {
	
	String model;
	String color;
	Integer horsePower;
	
	public AbstractCar(String model, String color, Integer horsePower) {
		super();
		this.model = model;
		this.color = color;
		this.horsePower = horsePower;
	}

	@Override
	public String getModel() {
		return this.model;
	}

	@Override
	public String getColor() {
		return this.color;
	}

	@Override
	public Integer getHorsePower() {
		return this.horsePower;
	}
	
}
