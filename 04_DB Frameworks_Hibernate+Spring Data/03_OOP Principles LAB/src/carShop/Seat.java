package carShop;

public class Seat extends Sellable{
	
	private String countryProduced;

	public Seat(String model, String color, Integer horsePower, Double price, String countryProduced) {
		super(model, color, horsePower, price);
		this.countryProduced = countryProduced;
	}
	
	@Override
	public String toString() {
		return String.format("FOR SELL:%n%s is %s color and have %s horse power%n"
				+ "This is %s produced in %s and have %s tires%n"
				+ "PRICE: %.2f BGN", 
				getModel(), getColor(), getHorsePower(),
				getModel(), this.countryProduced, TYRES,
				getPrice());
	}	

}
