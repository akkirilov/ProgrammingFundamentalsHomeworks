package p01_system_resources.models;

import p01_system_resources.interfaces.WriterInterface;

public class ConsoleWriter implements WriterInterface {

	@Override
	public void print(String string) {
		System.out.print(string);
	}

	@Override
	public void printLine(String string) {
		System.out.println(string);
	}

}
