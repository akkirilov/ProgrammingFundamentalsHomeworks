package health.entities.cells.bloodCells;

public class RedBloodCell extends BloodCell {
	
	private int velocity;

	public RedBloodCell(String id, int health, int positionRow, int positionCol, int velocity) {
		super(id, health, positionRow, positionCol);
		setVelocity(velocity);
	}

	private void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append(String.format("--------Health: %d | Velocity: %d | Energy: %d",
				super.getHealth(),
				this.velocity,
				this.getEnergy()));
		return sb.toString();
	}

	@Override
	public long getEnergy() {
		return super.getHealth() + this.velocity;
	}

}
