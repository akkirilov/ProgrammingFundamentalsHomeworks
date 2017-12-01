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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cardRank == null) ? 0 : cardRank.hashCode());
		result = prime * result + ((cardSuit == null) ? 0 : cardSuit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cardRank != other.cardRank)
			return false;
		if (cardSuit != other.cardSuit)
			return false;
		return true;
	}
	
}
