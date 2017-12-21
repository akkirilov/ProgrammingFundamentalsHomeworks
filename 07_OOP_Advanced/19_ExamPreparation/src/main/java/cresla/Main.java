package cresla;

import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

import cresla.core.*;
import cresla.interfaces.*;
import cresla.io.*;
import cresla.utils.CommandParser;

public class Main {
    public static void main(String[] args) {
    	
    	Map<Integer, Reactor> reactors = new LinkedHashMap<>();
    	Map<Integer, Module> modules = new LinkedHashMap<>();
    	Manager manager = new ReactorManager(reactors, modules);
    	
    	InputStreamReader is = new InputStreamReader(System.in);
    	InputReader reader =  new Reader(is);
    	OutputWriter writer = new Writer();
    	CommandParser commandParser = new CommandParser();
    	
    	Engine engine = new Engine(manager, reader, writer);
    	
    	engine.run();
    	
    }
}
