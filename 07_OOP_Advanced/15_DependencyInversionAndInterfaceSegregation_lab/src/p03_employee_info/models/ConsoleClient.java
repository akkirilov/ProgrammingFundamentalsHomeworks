package p03_employee_info.models;

import p03_employee_info.interfaces.Formatter;
import p03_employee_info.interfaces.InfoProvider;
import p03_employee_info.interfaces.Printer;

public class ConsoleClient {

	private InfoProvider infoProvider;
	private Printer printer;
	private Formatter formatter;
	
	public ConsoleClient(InfoProvider infoProvider, Printer printer, Formatter formatter) {
		super();
		this.infoProvider = infoProvider;
		this.printer = printer;
		this.formatter = formatter;
	}

	public void printEmloyees() {
		String result = this.formatter.format(this.infoProvider.getEmployeesByName());
		this.printer.printLine(result);
	}
	
}
