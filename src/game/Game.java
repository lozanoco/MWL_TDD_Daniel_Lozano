package game;

import java.util.ArrayList;
import java.util.Stack;

public class Game {
	
	private Waste waste;
	private ArrayList<Foundation> foundations;

	public Game(Waste waste) {
		this.waste=waste;
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

}
