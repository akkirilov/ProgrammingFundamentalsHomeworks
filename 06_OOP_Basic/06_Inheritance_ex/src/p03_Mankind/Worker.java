package p03_Mankind;

public class Worker extends Human {

	private double workHoursPerDay;
	private double weekSalary;

	public Worker(String firstName, String lastName, double workHoursPerDay, double weekSalary) {
		super(firstName, lastName);
		setWorkHoursPerDay(workHoursPerDay);
		setWeekSalary(weekSalary);
	}

	private double getWorkHoursPerDay() {
		return workHoursPerDay;
	}

	private void setWorkHoursPerDay(double workHoursPerDay) {
		if (workHoursPerDay < 1 || workHoursPerDay > 12) {
			throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
		}
		this.workHoursPerDay = workHoursPerDay;
	}

	private double getWeekSalary() {
		return weekSalary;
	}

	private void setWeekSalary(double weekSalary) {
		if (weekSalary <= 10) {
			throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
		}
		this.weekSalary = weekSalary;
	}
	
	private Object calculateSalaryPerHour() {
		return this.getWeekSalary() / (this.getWorkHoursPerDay() * 7);
	}

	@Override
	protected void setLastName(String lastName) {
		if (lastName.length() < 3) {
			throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
		}
		super.setLastName(lastName);
	}

	@Override
	public String toString() {
		return String.format("First Name: %s%n" +
							"Last Name: %s%n" +
							"Week Salary: %.2f%n" +
							"Hours per day: %.2f%n" +
							"Salary per hour: %.2f%n",
							super.getFirstName(), 
							super.getLastName(), 
							weekSalary, 
							workHoursPerDay,
							this.calculateSalaryPerHour());
	}

}
