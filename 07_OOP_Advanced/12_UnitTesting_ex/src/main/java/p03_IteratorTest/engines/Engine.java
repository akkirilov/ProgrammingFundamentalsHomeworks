package p03_IteratorTest.engines;

import javax.naming.OperationNotSupportedException;

import p03_IteratorTest.entities.ListIteratorImpl;
import p03_IteratorTest.interafces.ListIterator;
import p03_IteratorTest.io.TerminalReader;
import p03_IteratorTest.io.TerminalWriter;

public class Engine {
	
	private TerminalReader reader;
	private TerminalWriter writer;
	private ListIterator listIterator;
	
	public Engine(TerminalReader reader, TerminalWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	
	public void run() {
		
		String[] tokens;
		while (true) {
			tokens = reader.readInput();
			if (tokens[0].equalsIgnoreCase("END")) {
				break;
			}
			
			switch (tokens[0]) {
			case "Create":
				this.setListIterator(tokens);
				break;
			case "HasNext":
				writer.writeLine(this.listIterator.hasNext().toString());
				break;
			case "Move":
				writer.writeLine(this.listIterator.move().toString());
				break;
			case "Print":
				try {
					writer.writeLine(this.listIterator.print());
				} catch (OperationNotSupportedException e) {
					writer.writeLine(e.getMessage());
				}
				break;
			default:
				break;
			}
		}
		
	}

	private void setListIterator(String[] strings) {
		this.listIterator = new ListIteratorImpl(strings);
	}
	
	

}
