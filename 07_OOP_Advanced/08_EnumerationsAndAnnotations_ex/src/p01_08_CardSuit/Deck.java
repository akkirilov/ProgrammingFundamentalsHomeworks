package p01_08_CardSuit;

import java.util.ArrayList;
import java.util.List;

public class Deck {
	
	private List<Card> cardDeck;

	public Deck() {
		cardDeck = new ArrayList<>();
	}

	public static List<Card> getDefaultCardDeck() {
		List<Card> defaultDeck = new ArrayList<>();
		CardSuit[] cardSuits = CardSuit.values();
		CardRank[] cardRanks = CardRank.values();
		for (CardSuit cardSuit : cardSuits) {
			for (CardRank cardRank : cardRanks) {
				defaultDeck.add(new Card(cardRank, cardSuit));
			}
		}
		return defaultDeck;
	}

}
