import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Car {
	
	private String model;
	private Engine engine;
	private Cargo cargo;
	private List<Tire> tires;
	
	public Car(String model, Engine engine, Cargo cargo) {
		super();
		this.model = model;
		this.engine = engine;
		this.cargo = cargo;
		this.tires = new ArrayList<>();
	}

	public boolean isTireWithPresureBelowOne() {
		boolean found = false;
		for (Tire t : tires) {
			if (t.getPresure() < 1) {
				found = true;
			}
			
		}
		return found;
	}

	public void addTire(Tire tire) {
		this.tires.add(tire);
	}

	public String getModel() {
		return model;
	}

	public Engine getEngine() {
		return engine;
	}

	public Cargo getCargo() {
		return cargo;
	}

	@Override
	public String toString() {
		return this.model;
	}

}
