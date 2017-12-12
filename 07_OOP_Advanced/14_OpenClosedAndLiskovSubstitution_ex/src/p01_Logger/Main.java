package p01_Logger;

import p01_Logger.io.Reader;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import p01_Logger.controllers.LoggerController;
import p01_Logger.engines.Engine;

public class Main {
	
	public static void main(String[] args) {
		
		Reader reader = new Reader(new BufferedReader(new InputStreamReader(System.in)));
		LoggerController loggerController = new LoggerController();
		Engine engine = new Engine(reader, loggerController);
		
		engine.run();
		
	}

}
