package nfs.entities.car;

public class ShowCar extends Car {

	private int stars;
	
	public ShowCar(String brand, String model, int yearOfProduction, 
			int horsepower, int acceleration, int suspension, int durability) {
		super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
		this.stars = 0;
	}
	
	public int getStars() {
		return stars;
	}

	public void addStar() {
		this.stars++;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append(this.stars).append(" *\r\n");
		return sb.toString();
	}

	@Override
	public void modify(int index, String addOn) {
		super.modify(index, addOn);
		stars += index;
	}
}
