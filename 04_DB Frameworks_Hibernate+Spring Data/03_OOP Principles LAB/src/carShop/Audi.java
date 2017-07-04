package carShop;

public class Audi extends Rentable{

	public Audi(String model, String color, Integer horsePower, Integer minRentDays, Double pricePerDay) {
		super(model, color, horsePower, minRentDays, pricePerDay);
	}

	@Override
	public String toString() {
		return String.format("FOR RENT:%n"
				+ "%s is %s color and have %s horse power%n"
				+ "MIN DAYS: %d%n"
				+ "PRICE PER DAY: %.2f BGN", 
				getModel(), getColor(), getHorsePower(),
				getMinRentDays(),
				getPricePerDay());
	}
	
}
