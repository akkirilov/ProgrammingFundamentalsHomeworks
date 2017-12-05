package health.entities.cells;

public abstract class Cell {
	
	private String id;
	private long health;
	private int positionRow;
	private int positionCol;
	
	public Cell(String id, int health, int positionRow, int positionCol) {
		this.id = id;
		this.health = health;
		this.positionRow = positionRow;
		this.positionCol = positionCol;
	}

	public String getId() {
		return id;
	}

	public long getHealth() {
		return health;
	}

	public int getPositionRow() {
		return positionRow;
	}

	public int getPositionCol() {
		return positionCol;
	}
	
	public abstract long getEnergy();
	
	@Override
	public String toString() {
		return String.format("------Cell %s [%d,%d]\r\n", this.id, this.getPositionRow(), this.getPositionCol());
	}

	public void addHealth(long l) {
		this.health += l;
	}

	public void setNewPositions(Cell cell) {
		this.positionRow = cell.getPositionRow();
		this.positionCol = cell.getPositionCol();
	}

	public void reduceHealth(long l) {
		this.health -= l;
	}
	
}
