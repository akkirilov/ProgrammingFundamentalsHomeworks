package health.entities.cells.microbes;

import health.entities.cells.Cell;

abstract class Microbe extends Cell {
	
	private int virulence;

	public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
		super(id, health, positionRow, positionCol);
		this.virulence = virulence;
	}

	@Override
	public long getEnergy() {
		return super.getHealth() + this.virulence;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append(String.format("--------Health: %d | Virulence: %d | Energy: %d",
				super.getHealth(),
				this.virulence,
				this.getEnergy()));
		return sb.toString();
	}
}
