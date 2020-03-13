import java.util.Collections;

/**
 * Program Name:  Deck.java
 * Purpose:		  Subclass of CardSet and an aggregate class for GameOf21 class.
 * Coder:         Tung (Leonardo) Hoang, 0828717
 * Date:          Feb 24, 2018     
 */

public class Deck extends CardSet
{
	public static final int SIZE = 52;
	public Deck() {
		super(SIZE);
		populateDeck();
		shuffle();
		
	}
	
	public void populateDeck() {
		
		
		for(int suit = 0; suit < 4; suit++) {
			for(int rankNum = 1; rankNum <= 13; rankNum++) {
				Card c = new Card(Suit.values()[suit], rankNum);
				super.cards.add(c);
			}
		}
	}
	
	public void shuffle() {
		
		Collections.shuffle(super.cards);
	}
	
	public Card dealCard() {	
		return super.cards.remove(0);
	}
	
	public int size() {
	 	return super.cards.size();
	}
	
	private void displayCards(int start) {
		if(start == 0) {
			for(int i = 0; i < super.cards.size(); i++) {
				System.out.println(super.cards.get(i).toString());
			}
		}else if(start == 1){
			for(int i = 1; i < super.cards.size();i++) {
				System.out.println(super.cards.get(i).toString());
			}
		}
	}
	
	public void displayAllCards() {
		displayCards(0);
	}
	
	public void displayVisibleCards() {
		displayCards(1);
	}
	
}//End of class