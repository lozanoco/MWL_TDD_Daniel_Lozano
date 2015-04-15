package game;

import java.util.Stack;

public class Deck {
	
	private Stack<Card> cards;

	public Deck(int i) {
		// TODO Auto-generated constructor stub
	}

	public int size() {
		return this.cards.size();
	}

	public Stack<Card> getCards() {		
		return this.cards;
	}

}
