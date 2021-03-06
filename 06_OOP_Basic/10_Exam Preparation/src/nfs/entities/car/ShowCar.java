package nfs.entities.car;

public class ShowCar extends Car {

	private int stars;
	
	public ShowCar(String brand, String model, int yearOfProduction, 
			int horsepower, int acceleration, int suspension, int durability) {
		super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
		this.stars = 0;
	}
	
	private int getStars() {
		return stars;
	}

	private void addStars(int stars) {
		this.stars += stars;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append(this.getStars()).append(" *\r\n");
		return sb.toString();
	}

	@Override
	public void modify(int index, String addOn) {
		super.modify(index, addOn);
		addStars(index);
	}
}
