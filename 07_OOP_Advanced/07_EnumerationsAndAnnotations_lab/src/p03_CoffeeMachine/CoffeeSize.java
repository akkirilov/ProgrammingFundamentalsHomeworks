package p03_CoffeeMachine;

public enum CoffeeSize {
	
	SMALL(50, 50), NORMAL(100, 75), DOUBLE (200, 100);
	
	private Integer dosage;
	private Integer price;
	
	CoffeeSize(Integer dosage, Integer price) {	
		this.dosage = dosage;
		this.price = price;
	}

	public Integer getDosage() {
		return dosage;
	}

	public Integer getPrice() {
		return price;
	}
	
}
