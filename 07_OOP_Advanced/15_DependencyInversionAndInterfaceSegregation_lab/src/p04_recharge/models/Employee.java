package p04_recharge.models;

import p04_recharge.interfaces.Sleeper;

public class Employee extends Worker implements Sleeper {
	
	private boolean isSlept;

	public Employee(String id) {
		super(id);
		this.isSlept = true;
	}

	@Override
	public void sleep() {
		this.isSlept = true;
	}

}
