package nfs.factories;

import nfs.entities.race.*;

public class RaceFactory {
	public static Race getRace (String[] tokens) {
		
		String type = tokens[2];
		int length = Integer.parseInt(tokens[3]);
		String route = tokens[4];
		int prizePool = Integer.parseInt(tokens[5]);
		int extraParam = 0;
		if (tokens.length > 6) {
			extraParam = Integer.parseInt(tokens[6]);
		}
		switch (type) {
		case "Drag":
			return new DragRace(length, route, prizePool);
		case "Drift":
			return new DriftRace(length, route, prizePool);
		case "Casual":
			return new CasualRace(length, route, prizePool);
		case "TimeLimit":
			return new TimeLimitRace(length, route, prizePool, extraParam);
		case "Circuit":
			return new CircuitRace(length, route, prizePool, extraParam);
		}
		
		return null;
	}

	public static Race getRace(String type, int length, String route, int prizePool) {
		switch (type) {
		case "Drag":
			return new DragRace(length, route, prizePool);
		case "Drift":
			return new DriftRace(length, route, prizePool);
		case "Casual":
			return new CasualRace(length, route, prizePool);
		}
		
		return null;
	}
}
