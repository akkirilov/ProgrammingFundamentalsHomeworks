package mankind;

public class Worker extends Human {

	Double weekSalary;
	Double workHoursPerDay;
	
	public Worker(String firstName, String lastName, Double weekSalary, Double workHoursPerDay) {
		super(firstName, lastName);
		this.weekSalary = weekSalary;
		this.workHoursPerDay = workHoursPerDay;
	}

	public Double getWeekSalary() {
		return this.weekSalary;
	}

	public Double getWorkHoursPerDay() {
		return this.workHoursPerDay;
	}
	
	public Double getSalaryPerHour() {
		return this.weekSalary / (this.workHoursPerDay * 7);
	}

}
