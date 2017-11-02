package nfs.entities.car;

import java.util.ArrayList;
import java.util.List;

public class PerformanceCar extends Car {

	private List<String> addOns;
	
	public PerformanceCar(String brand, String model, int yearOfProduction, 
			int horsepower, int acceleration, int suspension, int durability) {
		super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
		this.addOns = new ArrayList<>();
	}
	
	public List<String> getAddOns() {
		return addOns;
	}

	public void addAddOns(String addOn) {
		this.addOns.add(addOn);
	}

	@Override
	protected void setHorsepower(int horsepower) {
		super.setHorsepower(horsepower + (int) ((horsepower * 50) / 100));
	}

	@Override
	protected void setSuspension(int suspension) {
		super.setSuspension(suspension - (int) ((suspension * 25) / 100));
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append("Add-ons: ")
		.append(this.addOns.size() == 0 ? "None" : this.addOns.toString().replaceAll("\\[|\\]", "")).append("\r\n");
		return sb.toString();
	}

	@Override
	public void modify(int index, String addOn) {
		super.modify(index, addOn);
		this.addAddOns(addOn);
	}

}
