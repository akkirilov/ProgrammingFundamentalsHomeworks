package paw.factories;

import paw.entities.centers.AdoptionCenter;
import paw.entities.centers.CastrationCenter;
import paw.entities.centers.CleansingCenter;

public class CenterFactory {

	public static AdoptionCenter createAdoptionCenter(String name) {
		return new AdoptionCenter(name);
	}

	public static CleansingCenter createCleansingCenter(String name) {
		return new CleansingCenter(name);
	}

	public static CastrationCenter createCastrationCenter(String name) {
		return new CastrationCenter(name);
	}

}
