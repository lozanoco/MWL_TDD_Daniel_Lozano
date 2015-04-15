package tests;

//Pruebas para Mover: Baraja-descarte, descarte-palo, descarte-trabajo

import static org.junit.Assert.*;
import game.Card;
import game.Deck;
import game.Foundation;
import game.Game;
import game.MoveCardController;
import game.Score;
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
		moveCardController=new MoveCardController(new Game(new Deck(0), new Waste(21)));
		Stack<Card> cardsWaste = new Stack<Card>();
		moveCardController.getGame().setWaste(cardsWaste);
		this.moveCardController.getGame().setFoundation(Suit.DIAMONDS, new Foundation(4, Suit.DIAMONDS));
		assertFalse(this.moveCardController.moveFromWasteToFoundation(Suit.DIAMONDS));

		//No cards in foundation & A in waste (exist Foundation suit)
		moveCardController=new MoveCardController(new Game(new Deck(0),new Waste(21)));
		cardsWaste = new Stack<Card>();
		cardsWaste.add(new Card(Score.AS, Suit.HEARTS, true));
		moveCardController.getGame().setWaste(cardsWaste);
		moveCardController.getGame().setFoundation(Suit.HEARTS, new Foundation(0, Suit.HEARTS));
		assertTrue(this.moveCardController.moveFromWasteToFoundation(Suit.HEARTS));

		//No cards in foundation & A in waste (no exist Foundation suit)
		moveCardController=new MoveCardController(new Game(new Deck(0),new Waste(21)));
		cardsWaste = new Stack<Card>();
		cardsWaste.add(new Card(Score.AS, Suit.CLUBS, true));
		moveCardController.getGame().setWaste(cardsWaste);
		moveCardController.getGame().setFoundation(Suit.HEARTS, new Foundation(0, Suit.HEARTS));
		assertFalse(this.moveCardController.moveFromWasteToFoundation(Suit.HEARTS));

		//No cards in foundation & no A in waste
		moveCardController=new MoveCardController(new Game(new Deck(0),new Waste(21)));
		cardsWaste = new Stack<Card>();
		cardsWaste.add(new Card(Score.FIVE, Suit.HEARTS, true));
		moveCardController.getGame().setWaste(cardsWaste);
		moveCardController.getGame().setFoundation(Suit.HEARTS, new Foundation(0, Suit.HEARTS));
		assertFalse(this.moveCardController.moveFromWasteToFoundation(Suit.HEARTS));

		//Waste card consecutive to Foundation card
		moveCardController=new MoveCardController(new Game(new Deck(0),new Waste(21)));
		cardsWaste = new Stack<Card>();
		cardsWaste.add(new Card(Score.FIVE, Suit.HEARTS, true));
		moveCardController.getGame().setWaste(cardsWaste);
		moveCardController.getGame().setFoundation(Suit.HEARTS, new Foundation(4, Suit.HEARTS));
		assertTrue(this.moveCardController.moveFromWasteToFoundation(Suit.HEARTS));

		//Waste card  no consecutive to Foundation card
		moveCardController=new MoveCardController(new Game(new Deck(0),new Waste(21)));
		cardsWaste = new Stack<Card>();
		cardsWaste.add(new Card(Score.DAME, Suit.HEARTS, true));
		moveCardController.getGame().setWaste(cardsWaste);
		moveCardController.getGame().setFoundation(Suit.HEARTS, new Foundation(4, Suit.HEARTS));
		assertFalse(this.moveCardController.moveFromWasteToFoundation(Suit.HEARTS));

		//Waste card consecutive to Foundation card but different suit
		moveCardController=new MoveCardController(new Game(new Deck(0),new Waste(21)));
		cardsWaste = new Stack<Card>();
		cardsWaste.add(new Card(Score.FIVE, Suit.SPADES, true));
		moveCardController.getGame().setWaste(cardsWaste);
		moveCardController.getGame().setFoundation(Suit.HEARTS, new Foundation(4, Suit.HEARTS));
		assertFalse(this.moveCardController.moveFromWasteToFoundation(Suit.HEARTS));

	}
	
	@Test
	public void moveFromDeckToWasteTest(){
		this.moveCardController = new MoveCardController(new Game(new Deck(24), new Waste(0)));
		//All cards in Waste, no cards in Deck
		
		//All cards in Deck, no cards in Waste
		
		//One card in Deck, rest in Waste
		
		//Two cards in Deck, rest in Waste
		
		//Three cards in Deck, rest in Waste
		
		//More than Three cards in Deck, rest in Waste
		
	}

}
