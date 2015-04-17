package game;

import java.util.Stack;

public class Tableau {
	
	private Stack<Card> cards;
	
	public Tableau(){
		this.setCards(new Stack<Card>());
	}

	public Stack<Card> getCards() {
		return cards;
	}

	public void setCards(Stack<Card> cards) {
		this.cards = cards;
	}

	public void addCard(Score four, Suit diamonds, boolean b) {
		// TODO Auto-generated method stub
		
	}


}
