package p03_employee_info.models;

import p03_employee_info.interfaces.Printer;

public class TerminalPrinter implements Printer {

	@Override
	public void print(String string) {
		System.out.print(string);
	}

	@Override
	public void printLine(String string) {
		System.out.println(string);
	}

}
