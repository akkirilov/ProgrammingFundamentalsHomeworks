package p01_08_CardSuit;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
//		Problem 1. Card Suit
//		CardSuit[] cardSuits = CardSuit.values();
//		System.out.println("Card Suits:");
//		for (CardSuit cs : cardSuits) {
//			System.out.println(String.format("Ordinal value: %d; Name value: %s", cs.ordinal(), cs.toString()));
//		}
		
//		Problem 2. Card Rank
//		CardRank[] cardRanks = CardRank.values();
//		System.out.println("Card Ranks:");
//		for (CardRank cr : cardRanks) {
//			System.out.println(String.format("Ordinal value: %d; Name value: %s", cr.ordinal(), cr.toString()));
//		}
		
//		Problem 3. Cards with Power
//		CardRank cardRank = CardRank.valueOf(scanner.nextLine().trim().toUpperCase());
//		CardSuit cardSuit = CardSuit.valueOf(scanner.nextLine().trim().toUpperCase());
//		System.out.println(String.format("Card name: %s of %s; Card power: %d",
//				cardRank, cardSuit, (cardRank.getPower() + cardSuit.getPower())));
		
//		Problem 4. Card toString()
//		CardRank cardRank = CardRank.valueOf(scanner.nextLine().trim().toUpperCase());
//		CardSuit cardSuit = CardSuit.valueOf(scanner.nextLine().trim().toUpperCase());
//		Card card = new Card(cardRank, cardSuit);
//		System.out.println(card);
		
//		Problem 5. Card compareTo()
//		CardRank cardRank = CardRank.valueOf(scanner.nextLine().trim().toUpperCase());
//		CardSuit cardSuit = CardSuit.valueOf(scanner.nextLine().trim().toUpperCase());
//		Card cardOne = new Card(cardRank, cardSuit);
//		
//		cardRank = CardRank.valueOf(scanner.nextLine().trim().toUpperCase());
//		cardSuit = CardSuit.valueOf(scanner.nextLine().trim().toUpperCase());
//		Card cardTwo = new Card(cardRank, cardSuit);
//		
//		if (cardOne.compareTo(cardTwo) > 0) {
//			System.out.println(cardOne);
//		} else {
//			System.out.println(cardTwo);
//		}
		
//		Problem 6. Custom Enum Annotation
//		String rank = scanner.nextLine();
//		Class<CardRank> CardRankClass = CardRank.class;
//		Class<CardSuit> CardSuitClass = CardSuit.class;
//		if (rank.equalsIgnoreCase("Rank")) {
//			Annotation[] annotations = CardRankClass.getAnnotations();
//			for (Annotation a : annotations) {
//				if (a instanceof CardAnnotation) {
//					CardAnnotation cardAnnotation = (CardAnnotation) a;
//					System.out.println(String.format("Type = %s, Description = %s", cardAnnotation.type(), cardAnnotation.description()));
//				}
//			}
//		} else if (rank.equalsIgnoreCase("Suit")) {
//			Annotation[] annotations = CardSuitClass.getAnnotations();
//			for (Annotation a : annotations) {
//				if (a instanceof CardAnnotation) {
//					CardAnnotation cardAnnotation = (CardAnnotation) a;
//					System.out.println(String.format("Type = %s, Description = %s", cardAnnotation.type(), cardAnnotation.description()));
//				}
//			}
//		}
		
//		Problem 7. Deck of Cards
//		List<Card> defaultDeck = Deck.getDefaultCardDeck();
//		for (Card card : defaultDeck) {
//			System.out.println(card.getCardRankAndSuit());
//		}
		
//		Problem 8. Card Game
		List<Card> gameDeck = Deck.getDefaultCardDeck();
		Player playerOne = new Player(scanner.nextLine());
		Player playerTwo = new Player(scanner.nextLine());
		
		while (true) {
			String[] tokens = scanner.nextLine().split("\\s+of\\s+");
			CardRank cardRank = null;
			CardSuit cardSuit = null;
			try {
				cardRank = CardRank.valueOf(tokens[0]);
				cardSuit = CardSuit.valueOf(tokens[1]);
			} catch (Exception e) {
				System.out.println("No such card exists.");
				continue;
			}
			
			Card card = new Card(cardRank, cardSuit);
			if (!gameDeck.contains(card)) {
				System.out.println("Card is not in the deck.");
				continue;
			}
			
			int index = gameDeck.indexOf(card);
			
			if (playerOne.getDeck().getCardDeck().size() < 5) {
				playerOne.addCard(gameDeck.remove(index));
			} else {
				playerTwo.addCard(gameDeck.remove(index));
			}
			
			if (playerOne.getDeck().getCardDeck().size() == 5 
					&& playerTwo.getDeck().getCardDeck().size() == 5) {
				break;
			}
		}
		
		if (playerOne.getMostPowerfullCard().compareTo(playerTwo.getMostPowerfullCard()) > 0) {
			System.out.println(String.format("%s wins with %s.", 
					playerOne.getName(), 
					playerOne.getMostPowerfullCard().getCardRankAndSuit()));
		} else {
			System.out.println(String.format("%s wins with %s.", 
					playerTwo.getName(), 
					playerTwo.getMostPowerfullCard().getCardRankAndSuit()));
		}
		
		scanner.close();
		
	}

}
