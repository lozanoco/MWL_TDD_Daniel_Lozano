package game;

import java.util.Stack;

public class Game {
	
	private Waste waste;

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

}
