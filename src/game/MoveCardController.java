package game;

public class MoveCardController {
	
	private Game game;

	public MoveCardController(Game game) {
		this.game=game;
	}

	public Game getGame() {
		return this.game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public boolean moveFromWasteToFoundation(Suit suit) {
		// TODO Auto-generated method stub
		return false;
	}

}
