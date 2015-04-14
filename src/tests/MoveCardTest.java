package tests;

//Pruebas para Mover: Baraja-descarte, descarte-palo, descarte-trabajo

import static org.junit.Assert.*;
import game.Card;
import game.Foundation;
import game.Game;
import game.MoveCardController;
import game.Suit;
import game.Waste;

import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

public class MoveCardTest {
	
	private MoveCardController moveCardController;
	
	@Test
	public void moveFromWasteToFoundationTest(){
		
		//No cards in waste
		moveCardController=new MoveCardController(new Game(new Waste(21)));
		Stack<Card> cardsWaste = new Stack<Card>();
		moveCardController.getGame().setWaste(cardsWaste);
		this.moveCardController.getGame().setFoundation(Suit.DIAMONDS, new Foundation(4, Suit.DIAMONDS));
		assertFalse(this.moveCardController.moveFromWasteToFoundation(Suit.DIAMONDS));
		
		//No cards in foundation & A in waste
		
		//No cards in foundation & no A in waste
		
		//Waste card consecutive to Foundation card
		
		//Waste card no consecutive to Foundation card
		
		//Waste card consecutive to Foundation card but different type
		
	}

}
