package p04_DetailPrinter;

public abstract class EmployeeAbstract implements Employee {
	
	private String name;
	
	protected EmployeeAbstract(String name) {
        this.name = name;
    }
	
	public String getName() {
        return name;
    }

}
