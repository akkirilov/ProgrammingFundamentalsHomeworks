package p04_WorkForce.models;

import p04_WorkForce.contracts.Employee;

public abstract class AbstractEmployee implements Employee {
	
	private String name;

	protected AbstractEmployee(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
