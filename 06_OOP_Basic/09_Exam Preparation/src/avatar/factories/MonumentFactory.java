package avatar.factories;

import avatar.entities.monuments.*;

public class MonumentFactory {

	public Monument create(String type, String name, int affinity) {
		switch (type) {
		case "Air":
			return new AirMonument(name, affinity);
		case "Water":
			return new WaterMonument(name, affinity);
		case "Earth":
			return new EarthMonument(name, affinity);
		case "Fire":
			return new FireMonument(name, affinity);
		default:
			return null;
		}
	}
	
}
