package p01_08_CardSuit;

import java.util.Comparator;
import java.util.List;

public class Player {
	
	private String name;
	private Deck deck;

	public Player(String name) {
		this.deck = new Deck();
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public Deck getDeck() {
		return deck;
	}

	public void addCard(Card card) {
		this.deck.addCard(card);
	}
	
	public Card getMostPowerfullCard() {
		List<Card> cards = this.deck.getCardDeck();
		cards.sort(Comparator.reverseOrder());
		return cards.get(0);
	}
	
}
