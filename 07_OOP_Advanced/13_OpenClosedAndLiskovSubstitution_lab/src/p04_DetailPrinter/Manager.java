package p04_DetailPrinter;

public class Manager extends EmployeeAbstract  {

    private Iterable<String> documents;

    public Manager(String name, Iterable<String> documents) {
        super(name);
        this.documents = documents;
    }

	@Override
	public String getDetails() {
		StringBuilder sb = new StringBuilder();
		sb.append("Manager: ").append(super.getName()).append(System.lineSeparator())
		.append("Documents: ").append(System.lineSeparator());
		int iter = 1;
		for (String document : documents) {
			sb.append(iter++ + ". ").append(document).append(System.lineSeparator());
		}
		return sb.toString();
	}
}
