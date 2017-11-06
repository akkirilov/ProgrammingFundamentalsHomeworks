package nfs;

import java.io.IOException;

import nfs.controllers.Engine;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Engine engine = new Engine();
		engine.run();
		
	}

}
