package nfs.entities.car;

public abstract class Car {
	
	private String brand;
	private String model;
	private int yearOfProduction;
	private int horsepower;
	private int acceleration;
	private int suspension;
	private int durability;
	
	public Car(String brand, String model, int yearOfProduction, int horsepower, 
			int acceleration, int suspension, int durability) {
		setBrand(brand);
		setModel(model);
		setYearOfProduction(yearOfProduction);
		setHorsepower(horsepower);
		setAcceleration(acceleration);
		setSuspension(suspension);
		setDurability(durability);
	}

	private void setBrand(String brand) {
		this.brand = brand;
	}

	private void setModel(String model) {
		this.model = model;
	}

	private void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	protected void setHorsepower(int horsepower) {
		this.horsepower = horsepower;
	}

	private void setAcceleration(int acceleration) {
		this.acceleration = acceleration;
	}

	protected void setSuspension(int suspension) {
		this.suspension = suspension;
	}

	private void setDurability(int durability) {
		this.durability = durability;
	}
	
	public void decreaseDurability(int param) {
		this.durability -= param;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	private int getYearOfProduction() {
		return yearOfProduction;
	}

	private int getHorsepower() {
		return horsepower;
	}

	private int getAcceleration() {
		return acceleration;
	}

	private int getSuspension() {
		return suspension;
	}

	private int getDurability() {
		return durability;
	}
	
	public void modify(int index, String addOn) {
		this.horsepower += index;
		this.suspension += (int) (index / 2);
	}
	
	public int getOverallPerformance() {
		return getEnginePerformance() + getSuspensionPerformance();
	}
	
	public int getEnginePerformance() {
		return (int) (horsepower / acceleration);
	}
	
	public int getSuspensionPerformance() {
		return suspension + durability;
	}
	
	public int getTimePerformance () {
		return ((horsepower / 100) * acceleration);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getBrand()).append(" ").append(this.getModel()).append(" ").append(this.getYearOfProduction()).append("\r\n")
			.append(this.getHorsepower()).append(" HP, 100 m/h in ").append(this.getAcceleration()).append(" s\r\n")
			.append(this.getSuspension()).append(" Suspension force, ").append(this.getDurability()).append(" Durability").append("\r\n");
		return sb.toString(); 
	}
}
