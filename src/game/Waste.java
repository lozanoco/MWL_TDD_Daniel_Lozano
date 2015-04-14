package game;

import java.util.Stack;

public class Waste {	
	
	Stack<Card> cards;

	public Waste(Stack<Card> cards) {
		this.cards = cards;
	}
	public Waste(int numCards) {
		this.cards = this.setStackCardRandom(numCards, false);
	}
	
	private Stack<Card> setStackCardRandom(int sizeDeck, boolean covered) {
		Stack<Card> cards = new Stack<Card>();
		for (int num = 0; num < sizeDeck; num++) {
			cards.add(new Card(Score.AS, Suit.HEARTS, covered));
		}
		return cards;
	}

}
