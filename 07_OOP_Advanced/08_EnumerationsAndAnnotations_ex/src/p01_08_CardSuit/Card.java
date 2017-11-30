package p01_08_CardSuit;

public class Card implements Comparable<Card> {
	
	private CardRank cardRank;
	private CardSuit cardSuit;
	
	public Card(CardRank cardRank, CardSuit cardSuit) {
		this.cardRank = cardRank;
		this.cardSuit = cardSuit;
	}

	public CardRank getCardRank() {
		return cardRank;
	}

	public CardSuit getCardSuit() {
		return cardSuit;
	}
	
	public int getCardPower() {
		return cardRank.getPower() + cardSuit.getPower();
	}
	
	public String getCardRankAndSuit() {
		return String.format("%s of %s",
				this.cardRank, this.cardSuit);
	}

	@Override
	public String toString() {
		return String.format("Card name: %s of %s; Card power: %d",
				this.cardRank, this.cardSuit, this.getCardPower());
	}

	@Override
	public int compareTo(Card c) {
		return Integer.compare(this.getCardPower(), c.getCardPower());
	}
	
}
