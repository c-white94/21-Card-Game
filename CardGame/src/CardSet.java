import java.util.ArrayList;

/**
 * Program Name:  CardSet.java
 * Purpose:		  Abstract superclass
 * Coder:         Tung (Leonardo) Hoang, 0828717
 * Date:          Feb 24, 2018     
 */

public abstract class CardSet
{
	protected ArrayList<Card> cards;
	
	public CardSet() {
		cards = new ArrayList<Card>();
	}
	
	public CardSet(int numberOfCards) {
		cards = new ArrayList<Card>(numberOfCards);
	}
	
	public abstract void displayAllCards();
	
	public abstract void displayVisibleCards();
}//End of class