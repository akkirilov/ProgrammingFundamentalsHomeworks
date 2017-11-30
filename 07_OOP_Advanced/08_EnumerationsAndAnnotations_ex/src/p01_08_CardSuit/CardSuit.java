package p01_08_CardSuit;

@CardAnnotation(type = "Enumeration", 
		category = "Suit", 
		description = "Provides suit constants for a Card class.")
public enum CardSuit {
	
	CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);
	
	private int power;

	private CardSuit(int power) {
		this.power = power;
	}

	public int getPower() {
		return power;
	}
	
}
