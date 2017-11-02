package nfs.factories;

import nfs.entities.race.CasualRace;
import nfs.entities.race.DragRace;
import nfs.entities.race.DriftRace;
import nfs.entities.race.Race;

public class RaceFactory {
	public static Race getRace (String type, int length, String route, int prizePool) {
		
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
