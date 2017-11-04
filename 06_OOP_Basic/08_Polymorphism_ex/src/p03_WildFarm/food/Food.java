package p03_WildFarm.food;

public abstract class Food {

	private int quantity;

	public Food(int quantity) {
		setQuantity(quantity);
	}

	public int getQuantity() {
		return quantity;
	}

	private void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
