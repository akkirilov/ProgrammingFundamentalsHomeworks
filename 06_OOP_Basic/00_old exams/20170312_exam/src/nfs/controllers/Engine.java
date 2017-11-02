package nfs.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine {
	
	private CarManager cm = new CarManager();
	
	public void run() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String input = reader.readLine();
		while (!input.equals("Cops Are Here")) {
			String[] tokens = input.split("\\s+");
			switch (tokens[0]) {
			case "open":
				cm.open(Integer.parseInt(tokens[1]), tokens[2], Integer.parseInt(tokens[3]), tokens[4], Integer.parseInt(tokens[5]));
				break;
			case "register":
				cm.register(Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4], Integer.parseInt(tokens[5]), Integer.parseInt(tokens[6]), 
						Integer.parseInt(tokens[7]), Integer.parseInt(tokens[8]), Integer.parseInt(tokens[9]));
				break;
			case "participate":
				cm.participate(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
				break;
			case "check":
				System.out.print(cm.check(Integer.parseInt(tokens[1])));
				break;
			case "start":
				System.out.print(cm.start(Integer.parseInt(tokens[1])));
				break;
			case "tune":
				cm.tune(Integer.parseInt(tokens[1]), tokens[2]);
				break;
			case "park":
				cm.park(Integer.parseInt(tokens[1]));
				break;
			case "unpark":
				cm.unpark(Integer.parseInt(tokens[1]));
				break;
			default:
				break;
			}
			input = reader.readLine();
		}
		
		reader.close();
    }
}
