package p02_KingsGambit.models;

public abstract class AbstractUnit {
	
	private String name;
	
	protected AbstractUnit(String name) {
		this.name = name;
	}

	protected String getName() {
		return this.name;
	}

}
