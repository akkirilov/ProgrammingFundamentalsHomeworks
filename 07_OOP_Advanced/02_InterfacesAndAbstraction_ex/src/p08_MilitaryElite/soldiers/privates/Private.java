package p08_MilitaryElite.soldiers.privates;

import p08_MilitaryElite.soldiers.Soldier;

public class Private extends Soldier implements PrivateApi {
	
	private double salary;

	public Private(String id, String firstName, String lastName, double salary) {
		super(id, firstName, lastName);
		this.salary = salary;
	}

	@Override
	public double getSalary() {
		return salary;
	}

	@Override
	public String toString() {
		return String.format("%sSalary: %.2f%n", super.toString(), this.salary);
	}

}
