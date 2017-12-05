package health.entities.cells.bloodCells;

public class WhiteBloodCell extends BloodCell {
	
	private int size;

	public WhiteBloodCell(String id, int health, int positionRow, int positionCol, int size) {
		super(id, health, positionRow, positionCol);
		setSize(size);
	}

	private void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append(String.format("--------Health: %d | Size: %d | Energy: %d",
				super.getHealth(),
				this.size,
				this.getEnergy()));
		return sb.toString();
	}

	@Override
	public long getEnergy() {
		return (super.getHealth() + this.size) * 2;
	}

}
