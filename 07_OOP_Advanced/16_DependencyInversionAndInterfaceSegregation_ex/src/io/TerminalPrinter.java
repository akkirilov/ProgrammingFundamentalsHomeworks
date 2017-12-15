package io;

import contracts.Printer;

public class TerminalPrinter implements Printer {

	@Override
	public void printLine(String str) {
		System.out.println(str);
	}

	@Override
	public void print(String str) {
		System.out.print(str);
	}

}
