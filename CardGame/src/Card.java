/**
 * Program Name:  Card.java
 * Purpose:
 * Coder:         Tung (Leonardo) Hoang, 0828717
 * Date:          Feb 6, 2018     
 */

/**
 *
 */
public class Card
{
	//Instance variables
	private Suit suit;
	private int rank;
	
	public Card() {
		suit = suit.CLUBS;
		rank = 1;
	}
	
	public Card(Suit suit) {
		this.suit = suit;
		rank = 1;
	}
	
	public Card(Suit suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * Gets the suit of the object
	 * @return the suit
	 */
	public Suit getSuit()
	{
		return suit;
	}

	/**
	 * Sets the suit of this object
	 * @param suit - value to set
	 */
	public void setSuit(Suit suit)
	{
		this.suit = suit;
	}

	/**
	 * Gets the rank of the object
	 * @return the rank
	 */
	public int getRank()
	{
		return rank;
	}

	/**
	 * Sets the rank of this object
	 * @param rank - value to set
	 */
	public void setRank(int rank)
	{
		this.rank = rank;
	}
	
	public boolean isSameSuit(Card c) {
		boolean same = false;
		if(this.suit.equals(c.suit)) {
			same = true;
		}else {
			same = false;
		}
		return same;
	}
	
	public String findFaceValue() {
		String faceValue = "";
		switch(this.rank) {
		case 1: 
			faceValue = "Ace";
			break;
		case 2: 
			faceValue = "Two";
			break;
		case 3: 
			faceValue = "Three";
			break;
		case 4:
			faceValue = "Four";
		    break;
		case 5:
			faceValue = "Five";
			break;
		case 6:
			faceValue = "Six";
			break;
		case 7: 
			faceValue = "Seven";
			break;
		case 8: 
			faceValue = "Eight";
			break;
		case 9: 
			faceValue = "Nine";
			break;
		case 10:
			faceValue = "Ten";
			break;
		case 11: 
			faceValue = "Jack";
			break;
		case 12: 
			faceValue = "Queen";
			break;
		case 13: 
			faceValue = "King";
			break;
		}
		return faceValue;
	}
	
	public int findCardValue() {
		int value = 0;
		
		if(this.rank >= 1 && this.rank <= 10) {
			value = this.rank;
		}else {
			value = 10;
		}
		return value;
	}
	
	public boolean isGreaterThan(Card c) {
		boolean greater = false;
		if(this.rank > c.rank) {
			greater = true;
		}else {
			greater = false;
		}
		return greater;
	}
	
	public boolean equals(Card c) {
		boolean equal = false;
		if(this.rank == c.rank) {
			equal = true;
		}else {
			equal = false;
		}
		return equal;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String output = "";
		//the value of rank()
		output += findFaceValue() + " of " + suit;
		
		return output;
	}
	
}//End of class