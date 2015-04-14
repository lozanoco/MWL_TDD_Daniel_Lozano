package game;

import java.util.Stack;
import static org.junit.Assert.assertFalse;

public class Foundation {
	
	private Stack<Card> cards;
	private Suit suit;

	public Foundation(int cards, Suit suit) {
		assertFalse(cards > 12);
		this.cards = new Stack<Card>();
		for (int numCard = 1; numCard <= cards; numCard++) {
			this.cards.add(new Card(Score.valueOf(numCard), suit, false));
		}
		this.suit = suit;
	}

}
