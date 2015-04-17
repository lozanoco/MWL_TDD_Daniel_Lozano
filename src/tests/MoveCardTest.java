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
import game.Tableau;
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
		
		//All cards in Deck, no cards in Waste
		moveCardController = new MoveCardController(new Game(new Deck(24), new Waste(0)));
		moveCardController.moveFromDeckToWaste();
		assertEquals(21, this.moveCardController.getGame().getDeck().size());
		assertEquals(3, this.moveCardController.getGame().getWaste().size());
		for (Card card : this.moveCardController.getGame().getDeck().getCards()) {
			assertTrue(card.covered());
		}
		for (Card card : this.moveCardController.getGame().getWaste().getCards()) {
			assertFalse(card.covered());
		}
		
		//All cards in Waste, no cards in Deck
		moveCardController = new MoveCardController(new Game(new Deck(0), new Waste(24)));
		moveCardController.moveFromDeckToWaste();
		assertEquals(0, this.moveCardController.getGame().getDeck().size());
		assertEquals(24, this.moveCardController.getGame().getWaste().size());
		for (Card card : this.moveCardController.getGame().getDeck().getCards()) {
			assertTrue(card.covered());
		}
		for (Card card : this.moveCardController.getGame().getWaste().getCards()) {
			assertFalse(card.covered());
		}
		
		//One card in Deck, rest in Waste
		moveCardController = new MoveCardController(new Game(new Deck(1), new Waste(23)));
		moveCardController.moveFromDeckToWaste();
		assertEquals(0, this.moveCardController.getGame().getDeck().size());
		assertEquals(24, this.moveCardController.getGame().getWaste().size());
		for (Card card : this.moveCardController.getGame().getDeck().getCards()) {
			assertTrue(card.covered());
		}
		for (Card card : this.moveCardController.getGame().getWaste().getCards()) {
			assertFalse(card.covered());
		}
		
		//Two cards in Deck, rest in Waste
		moveCardController = new MoveCardController(new Game(new Deck(2), new Waste(22)));
		moveCardController.moveFromDeckToWaste();
		assertEquals(0, this.moveCardController.getGame().getDeck().size());
		assertEquals(24, this.moveCardController.getGame().getWaste().size());
		for (Card card : this.moveCardController.getGame().getDeck().getCards()) {
			assertTrue(card.covered());
		}
		for (Card card : this.moveCardController.getGame().getWaste().getCards()) {
			assertFalse(card.covered());
		}
		
		//Three cards in Deck, rest in Waste
		moveCardController = new MoveCardController(new Game(new Deck(3), new Waste(21)));
		moveCardController.moveFromDeckToWaste();
		assertEquals(0, this.moveCardController.getGame().getDeck().size());
		assertEquals(24, this.moveCardController.getGame().getWaste().size());
		for (Card card : this.moveCardController.getGame().getDeck().getCards()) {
			assertTrue(card.covered());
		}
		for (Card card : this.moveCardController.getGame().getWaste().getCards()) {
			assertFalse(card.covered());
		}
		
		//More than Three cards in Deck, rest in Waste		
		moveCardController = new MoveCardController(new Game(new Deck(4), new Waste(20)));
		moveCardController.moveFromDeckToWaste();
		assertEquals(1, this.moveCardController.getGame().getDeck().size());
		assertEquals(23, this.moveCardController.getGame().getWaste().size());
		for (Card card : this.moveCardController.getGame().getDeck().getCards()) {
			assertTrue(card.covered());
		}
		for (Card card : this.moveCardController.getGame().getWaste().getCards()) {
			assertFalse(card.covered());
		}
	}
	
	@Test
	public void moveFromWasteToTableauTest(){
		
		//No cards in Waste
		moveCardController=new MoveCardController(new Game(new Deck(0), new Waste(21)));
		Stack<Card> cardsWaste = new Stack<Card>();
		moveCardController.getGame().setWaste(cardsWaste);
		this.moveCardController.getGame().setFoundation(Suit.DIAMONDS, new Foundation(4, Suit.DIAMONDS));
		assertFalse(this.moveCardController.moveFromWasteToFoundation(Suit.DIAMONDS));

		//No cards in Tableau, score card different to ROI in Waste
		cardsWaste = new Stack<Card>();
		Card card = new Card(Score.FOUR, Suit.DIAMONDS, false);
		cardsWaste.add(card);
		this.moveCardController = new MoveCardController(new Game(new Deck(3), new Waste(cardsWaste)));
		int nTableau=0;
		this.moveCardController.getGame().setTableau(nTableau,new Tableau());
		assertTrue(this.moveCardController.moveFromWasteToFoundationTableau(0));
		
		//No cards in Tableau,  card ROI in Waste
		cardsWaste = new Stack<Card>();
		card = new Card(Score.ROI, Suit.DIAMONDS, false);
		cardsWaste.add(card);
		this.moveCardController = new MoveCardController(new Game(new Deck(3), new Waste(cardsWaste)));
		nTableau=0;
		this.moveCardController.getGame().setTableau(nTableau,new Tableau());
		assertTrue(this.moveCardController.moveFromWasteToFoundationTableau(0));
		
		//One score lower card in Waste that tableau (same color)	
		cardsWaste = new Stack<Card>();
		card = new Card(Score.FOUR, Suit.DIAMONDS, false);
		cardsWaste.add(card);
		this.moveCardController = new MoveCardController(new Game(new Deck(3), new Waste(cardsWaste)));
		nTableau=0;
		Tableau tableau = new Tableau();
		tableau.addCard(Score.FIVE, Suit.DIAMONDS, false);
		this.moveCardController.getGame().setTableau(nTableau,tableau);
		assertFalse(this.moveCardController.moveFromWasteToFoundationTableau(0));

		//One score lower card in Waste that tableau (different color)
		cardsWaste = new Stack<Card>();
		card = new Card(Score.FOUR, Suit.SPADES, false);
		cardsWaste.add(card);
		this.moveCardController = new MoveCardController(new Game(new Deck(3), new Waste(cardsWaste)));
		nTableau=0;
		tableau = new Tableau();
		tableau.addCard(Score.FIVE, Suit.DIAMONDS, false);
		this.moveCardController.getGame().setTableau(nTableau,tableau);
		assertTrue(this.moveCardController.moveFromWasteToFoundationTableau(0));
		
	}

}
