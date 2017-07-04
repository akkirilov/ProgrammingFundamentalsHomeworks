package carShop;

public abstract class Rentable extends AbstractCar{

	private Integer minRentDays; 
	private Double pricePerDay; 
	
	public Rentable(String model, String color, Integer horsePower, Integer minRentDays, Double pricePerDay) {
		super(model, color, horsePower);
		this.minRentDays = minRentDays;
		this.pricePerDay = pricePerDay;
	}

	public Integer getMinRentDays() {
		return minRentDays;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

}
