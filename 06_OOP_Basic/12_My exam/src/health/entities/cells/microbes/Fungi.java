package health.entities.cells.microbes;

public class Fungi extends Microbe {

	public Fungi(String id, int health, int positionRow, int positionCol, int virulence) {
		super(id, health, positionRow, positionCol, virulence);
	}

	@Override
	public long getEnergy() {
		return super.getEnergy() / 4;
	}

}
