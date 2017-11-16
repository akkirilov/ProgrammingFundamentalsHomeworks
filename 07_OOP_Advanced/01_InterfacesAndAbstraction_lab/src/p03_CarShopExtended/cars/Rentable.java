package p03_CarShopExtended.cars;

public interface Rentable extends Car {
	
	Integer getMinRentDay();
	
	Double getPricePerDay();

}
