/**
 * Program Name:  Hand.java
 * Purpose:		  
 * Coder:         Tung (Leonardo) Hoang, 0828717
 * Date:          Feb 27, 2018     
 */

public class Hand extends CardSet
{
	private String playerName;
	
	public Hand(String playerName) {
		super();
		this.playerName = playerName;
	}

	/**
	 * Gets the playerName of the object
	 * @return the playerName
	 */
	public String getPlayerName()
	{
		return playerName;
	}

	/**
	 * Sets the playerName of this object
	 * @param playerName - value to set
	 */
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}
	/**
	 * Adds a Card object to a Player's hand
	 *
	 * @param Card
	 */
	public void hit(Card c) {
	    
		super.cards.add(c);
	}
	
	public void discard(int index) {
		super.cards.remove(index);
	}
	
	public void discard(int beginIndex, int endIndex) {
		for(int i = beginIndex; i < endIndex; i++) {
			super.cards.remove(i);
		}
	}
	/**
	 * finds the total value of a Player's hand based on the CardSet's values. 
	 * This method also checks if a Card is an Ace and, if it is, calls the findAceValue()
	 *
	 * @return total of cards of Player
	 */
	public int totalHand() {
		int total = 0;
		int cardRank;
		for(int i = 0; i < super.cards.size(); i++) {
			cardRank = super.cards.get(i).getRank();
			
			//check if card is Ace
			if(cardRank == 1) {
				total += findAceValue(total);
			}else{
				total += super.cards.get(i).findCardValue();
			}
		}
		return total;
	}
	/**
	 * This method retunrs the total of the cards that are visible. It ignores the first card that is face
	 * down. This method also checks if a Card is an Ace and, if it is, calls the findAceValue()
	 *
	 * @return total of cards that are visible
	 */
	public int totalVisibleHand() {
		int total = 0;
		int cardRank;
		for(int i = 1; i < super.cards.size(); i++) {
			cardRank = super.cards.get(i).getRank();
			
			//check if card is Ace
			if(cardRank == 1) {
				total += findAceValue(total);
			}else{
				total += super.cards.get(i).findCardValue();
			}
		}
		return total;
	}
	/**
	 * Check if the Player's current hand total plus 11 goes over 21, then returns ace as 1,
	 * otherwise returns ace as 11.
	 * @param total
	 * @return
	 */
	private int findAceValue(int total) {
		total += 11;
		if(total > 21) {
			return 1;
		}else {
			return 11;
		}
	}
	/**
	 * Empty the Card on Player's hand
	 */
	public void emptyHand() {
		super.cards.clear();
	}
	
	private void displayCards(int start) {
		if(start == 0) {
			System.out.printf("\n%s has %d cards:\n", playerName, super.cards.size());
			for(int i = 0; i < super.cards.size(); i++) {
				System.out.printf("%d) %s\n" ,i+1, super.cards.get(i).toString());
			}
		}else if(start == 1){
			System.out.printf("\n%s has %d cards:\n", playerName, super.cards.size());
			for(int i = 1; i < super.cards.size();i++) {
				System.out.printf("%d) %s\n" ,i+1, super.cards.get(i).toString());
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