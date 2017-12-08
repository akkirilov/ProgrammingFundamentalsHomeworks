package p03_IteratorTest;

import p03_IteratorTest.engines.Engine;
import p03_IteratorTest.io.TerminalReader;
import p03_IteratorTest.io.TerminalWriter;

public class Main {

	public static void main(String[] args) {
		
		TerminalReader reader = new TerminalReader();
		TerminalWriter writer = new TerminalWriter();
		
		Engine engine = new Engine(reader, writer);
		engine.run();

	}

}
