package p10_InfernoInfinity.factories;

import p10_InfernoInfinity.enums.Gem;

public class GemFactory {

	public static Gem create(String type) {
		switch (type) {
		case "RUBY":
			return Gem.RUBY;
		case "EMERALD":
			return Gem.EMERALD;
		case "AMETHYST":
			return Gem.AMETHYST;
		default:
			return null;
		}
	}
	
}
