package game;

import java.util.ArrayList;
import java.util.Stack;

public class Game {
	
	private Waste waste;
	private Deck deck;
	private ArrayList<Foundation> foundations;
	private ArrayList<Tableau> tableaus;

	public Game(Deck deck, Waste waste) {
		this.waste=waste;
		this.setDeck(deck);
	}

	public Waste getWaste() {
		return waste;
	}

	public void setWaste(Waste waste) {
		this.waste = waste;
	}
	
	public void setWaste(Stack<Card> cardsWaste) {
		this.waste = new Waste(cardsWaste);
	}

	public void setFoundation(Suit suit, Foundation foundation) {
		switch(suit){
		case HEARTS:
			this.foundations.set(0, foundation);
			break;
		case DIAMONDS:
			this.foundations.set(1, foundation);
			break;
		case CLUBS:
			this.foundations.set(2, foundation);
			break;
		case SPADES:
			this.foundations.set(3, foundation);
			break;
		default:
			assert false;
		}
		
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public void setTableau(int nTableau, Tableau tableau) {
		this.tableaus.set(nTableau, tableau);
		
	}

}
