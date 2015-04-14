package game;

public class Card {
	
	private Score score;
	private Suit suit;

	public Card(Score score, Suit suit, boolean covered) {
		this.score=score;
		this.suit=suit;
	}

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}
}
