package p04_DetailPrinter;

public class EmployeeBase extends EmployeeAbstract {

    public EmployeeBase(String name) {
        super(name);
    }

	@Override
	public String getDetails() {
		return "EmployeeBase: " + super.getName() + System.lineSeparator();
	}
}
